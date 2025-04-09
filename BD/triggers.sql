
-- Trigger salario minimo interprofesional 1134

CREATE OR REPLACE TRIGGER tr_salario_minimo
BEFORE INSERT OR UPDATE ON Jugador
FOR EACH ROW
BEGIN
  IF :NEW.sueldo < 1134 THEN
    RAISE_APPLICATION_ERROR(-20001, 'El salario no puede ser menor 
    al SMI (1.134€)');
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
  IF :OLD.estado = 0 AND :NEW.estado = 1 THEN
    -- Verificamos que todos los equipos inscritos tengan al menos 2 jugadores
    FOR v_equipo IN (SELECT DISTINCT id_equipo FROM Jugador) LOOP
      -- Contamos los jugadores por cada equipo
      SELECT COUNT(*)
      INTO v_cantidad
      FROM Jugador
      WHERE id_equipo = v_equipo.id_equipo;
      
      -- Si algún equipo tiene menos de 2 jugadores, lanzamos un error
      IF v_cantidad < 2 THEN
        RAISE_APPLICATION_ERROR(-20005, 'El equipo con 
        ID ' || v_equipo.id_equipo || ' no tiene suficientes jugadores para
        generar el calendario (mínimo 2 jugadores).');
      END IF;
    END LOOP;
  END IF;
END;



--Triggers para no modificar equipos ni jugadores una vez creado el calendario

--Jugador
CREATE OR REPLACE TRIGGER tr_no_modificar_jugadores
BEFORE UPDATE ON Jugador
FOR EACH ROW
DECLARE
  v_estado NUMBER(1);
BEGIN
  
  SELECT estado INTO v_estado
  FROM Competicion;

  IF v_estado = 1 THEN
    RAISE_APPLICATION_ERROR(-20006, 'No se pueden modificar jugadores porque
    la competición está cerrada.');
  END IF;
END;



--Equipo
CREATE OR REPLACE TRIGGER tr_no_modificar_equipos
BEFORE UPDATE ON Equipo
FOR EACH ROW
DECLARE
  v_estado NUMBER(1);
BEGIN
  
  SELECT estado INTO v_estado
  FROM Competicion;

  IF v_estado = 1 THEN
    RAISE_APPLICATION_ERROR(-20006, 'No se pueden modificar equipos porque
    la competición está cerrada.');
  END IF;
END;


/* Triggers para usar una secuencia para dar valores a los id */

--equipo

CREATE OR REPLACE TRIGGER trg_equipo_inc
BEFORE INSERT ON equipo
FOR EACH ROW
BEGIN
  IF :new.id IS NULL THEN
    SELECT incremental_seq.NEXTVAL INTO :new.id FROM dual;
  END IF;
END;

--enfrentamiento

CREATE OR REPLACE TRIGGER trg_enfrentamiento_inc
BEFORE INSERT ON enfrentamiento
FOR EACH ROW
BEGIN
  IF :new.id IS NULL THEN
    SELECT incremental_seq.NEXTVAL INTO :new.id FROM dual;
  END IF;
END;

--competicion

CREATE OR REPLACE TRIGGER trg_competicion_inc
BEFORE INSERT ON competicion
FOR EACH ROW
BEGIN
  IF :new.id IS NULL THEN
    SELECT incremental_seq.NEXTVAL INTO :new.id FROM dual;
  END IF;
END;

--usuario

CREATE OR REPLACE TRIGGER trg_usuario_inc
BEFORE INSERT ON usuario
FOR EACH ROW
BEGIN
  IF :new.id IS NULL THEN
    SELECT incremental_seq.NEXTVAL INTO :new.id FROM dual;
  END IF;
END;

--jornada

CREATE OR REPLACE TRIGGER trg_jornada_inc
BEFORE INSERT ON jornada
FOR EACH ROW
BEGIN
  IF :new.id IS NULL THEN
    SELECT incremental_seq.NEXTVAL INTO :new.id FROM dual;
  END IF;
END;


