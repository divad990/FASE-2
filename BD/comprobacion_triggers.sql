
/* Insert de un equipo para probar a insertar jugadores */

INSERT INTO Equipo (id, nombre, fecha_fundacion) VALUES 
(1, 'Los Tigres', TO_DATE('2005-09-12', 'YYYY-MM-DD'));

/* Insert y update de jugadores para probar el trigger de salario  minimo */

/* INSERT */

/* Si funciona*/
INSERT INTO Jugador 
(dni, nombre, rol, nickname, apellido, nacionalidad, fecha_nacimiento, sueldo,
id_equipo) VALUES 
('12345678B', 'Jorge', 'Delantero', 'Eltrueno', 'Gómez', 'España',
TO_DATE('2000-05-16', 'YYYY-MM-DD'), 1800, 1);


/* Da error por el trigger */
INSERT INTO Jugador 
(dni, nombre, rol, nickname, apellido, nacionalidad, fecha_nacimiento, sueldo,
id_equipo) VALUES 
('12345678B', 'Jorge', 'Delantero', 'Eltrueno', 'Gómez', 'España',
TO_DATE('2000-05-16', 'YYYY-MM-DD'), 1000, 1);


/* UPDATE */

/* Si funciona */
UPDATE Jugador
SET sueldo = 1200
WHERE dni = '12345678A';


/* No funciona por el trigger */
UPDATE Jugador
SET sueldo = 1000
WHERE dni = '12345678A';



/* Insert de un jugador para probar el trigger de maximo 6 jugadores (una vez 
hay ya 6 jugadores insertados en el equipo */

INSERT INTO Jugador 
(dni, nombre, rol, nickname, apellido, nacionalidad,
fecha_nacimiento, sueldo, id_equipo)
VALUES ('12345678F', 'Paco', 'Delantero', 'paquito', 'Oliva', 'España',
TO_DATE('1996-02-18', 'YYYY-MM-DD'), 1430, 1);









