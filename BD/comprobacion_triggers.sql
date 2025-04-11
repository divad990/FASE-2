
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



/* Comprobacion del trigger de minimo 2 jugadores al generar el calendario */

--prueba con los equipos formados correctamente
update competicion set estado = 1;

--el estado vuelve a 0 y creamos un equipo de 1 jugador
update competicion set estado = 0;

INSERT INTO Equipo (nombre, fecha_fundacion) VALUES 
('Los leones', TO_DATE('2004-09-12', 'YYYY-MM-DD'));

INSERT INTO Jugador 
(dni, nombre, rol, nickname, apellido, nacionalidad,
fecha_nacimiento, sueldo, id_equipo)
VALUES ('12345678G', 'Lucas', 'Delantero', 'luquitas', 'Olmo', 'España',
TO_DATE('1996-02-18', 'YYYY-MM-DD'), 1470, 8);

--prueba con los equipos mal formados

update competicion set estado = 1;

--da error


/* Comprobacion de trigger para que no se puedan modificar equipos ni 
jugadores una vez creado el calendario */

/*poner en 1 el estado de la competicion e intentar modificar un equipo 
y un jugador*/

update competicion set estado = 1;

--Jugador
update Jugador set rol = 'Defensor' where dni = '12345678G';

--Equipo
update Equipo set nombre = 'Los topos' where nombre = 'Los Tigres';

--dan error si el estado está en 1


/* Comprobacion de los triggers que utilizan la secuencia */

--competicion

insert into competicion (nombre, estado)
values ('compe1', 0);

select * from competicion;

--equipo

insert into equipo (nombre, fecha_fundacion)
values ('equipo1', TO_DATE('2000-02-18', 'YYYY-MM-DD'));

select * from equipo;

--jornada

insert into jornada (numero_jornada, fecha)
values (2, TO_DATE('2002-02-18', 'YYYY-MM-DD'));

select * from jornada;

--enfrentamiento

insert into enfrentamiento (id_jornada, hora, fecha)
values (4, current_timestamp, TO_DATE('2001-02-18', 'YYYY-MM-DD'));

select * from enfrentamiento;

--usuario

insert into usuario (username, passwd, admin)
values ('tigreuno', 'contratigre', 1);

select * from usuario;