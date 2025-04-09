
-- Trigger salario minimo interprofesional 1134

CREATE OR REPLACE TRIGGER tr_salario_minimo
BEFORE INSERT OR UPDATE ON Jugador
FOR EACH ROW
BEGIN
  IF :NEW.sueldo < 1134 THEN
    RAISE_APPLICATION_ERROR(-20001, 'El salario no puede ser menor al SMI (1.134€)');
  END IF;
END;



-- Trigger máximo 6 jugadores por equipo

CREATE OR REPLACE TRIGGER tr_max_6_jugadores
BEFORE INSERT ON Jugador
FOR EACH ROW
DECLARE
  v_cantidad NUMBER;
BEGIN
  
  SELECT COUNT(*) 
  INTO v_cantidad
  FROM Jugador
  WHERE id_equipo = :NEW.id_equipo;

  
  IF v_cantidad >= 6 THEN
    RAISE_APPLICATION_ERROR(-20003, 'No se pueden insertar más de 6
    jugadores en el equipo');
  END IF;
END;



-- Trigger minimo 2 jugadores por equipo al generar el calendario

CREATE OR REPLACE TRIGGER tr_min_jugadores_competicion
BEFORE UPDATE ON Competicion
FOR EACH ROW
DECLARE
  v_cantidad NUMBER;
BEGIN
  -- Verificamos si el estado está cambiando de "inscripcion abierta" a "inscripcion cerrada"
  IF :OLD.estado = 'inscripcion abierta' AND :NEW.estado = 'inscripcion cerrada' THEN
    -- Verificamos que todos los equipos inscritos tengan al menos 2 jugadores
    FOR v_equipo IN (SELECT DISTINCT id_equipo FROM Jugador) LOOP
      -- Contamos los jugadores por cada equipo
      SELECT COUNT(*)
      INTO v_cantidad
      FROM Jugador
      WHERE id_equipo = v_equipo.id_equipo;
      
      -- Si algún equipo tiene menos de 2 jugadores, lanzamos un error
      IF v_cantidad < 2 THEN
        RAISE_APPLICATION_ERROR(-20005, 'El equipo con ID ' || v_equipo.id_equipo || ' no tiene suficientes jugadores para generar el calendario (mínimo 2 jugadores).');
      END IF;
    END LOOP;
  END IF;
END;



--Trigger para no modificar equipos ni jugadores una vez creado el calendario

CREATE OR REPLACE TRIGGER tr_no_modificar_jugadores
BEFORE UPDATE ON Jugador
FOR EACH ROW
DECLARE
  v_estado VARCHAR2(50);
BEGIN
  -- Obtenemos el estado actual de la competición
  SELECT estado INTO v_estado
  FROM Competicion
  WHERE id_competicion = :NEW.id_competicion;
  
  -- Si el estado es 'inscripcion cerrada', lanzamos un error
  IF v_estado = 'inscripcion cerrada' THEN
    RAISE_APPLICATION_ERROR(-20006, 'No se pueden modificar los jugadores cuando la competición está en inscripción cerrada.');
  END IF;
END;


