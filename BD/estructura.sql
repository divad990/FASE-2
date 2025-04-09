-- David Gonzalez

-- Creación del servidor Oracle en Ubuntu 22.04 (Maquina Virtual)

-- Instalación de docker dada por hecha.

    -- docker run --name oracle-db -p 1521:1521 -p 5500:5500 -e ORACLE_PWD=Oracle123 -e ORACLE_CHARACTERSET=AL32UTF8 -v /opt/oracle/oradata:/opt/oracle/oradata container-registry.oracle.com/database/express:21.3.0-xe

-- Conexión a PDBS

    -- docker exec -it oracle-db sqlplus system/Oracle123@XE
    -- ALTER SESSION SET CONTAINER = XEPDB1;

-- Creación de usuarios con schemas y establecimiento de cuotas

/*
    CREATE USER (usuario) IDENTIFIED BY "(contraseña)";
    GRANT CONNECT, RESOURCE TO equipoDavid; 
    ALTER USER (usuario) QUOTA 100M ON USERS;
*/

-- Datos conexión: jdbc:oracle:thin:@//localhost:1521/XEPDB1

-- Creación de tablas

CREATE TABLE Equipo (
    id number(5) primary key,
    nombre varchar(50) not null,
    fecha_fundacion date not null);

CREATE TABLE Jornada (
    id number(5) primary key,
    numero_jornada NUMBER(2) not null,
    fecha date not null);

CREATE TABLE Enfrentamiento (
    id number(5) PRIMARY KEY,
    id_jornada NUMBER(5) not null,
    hora TIMESTAMP not null,
    CONSTRAINT fk_id_jornada foreign key (id_jornada) references Jornada(id));

CREATE TABLE Jugador (dni VARCHAR(9), nombre VARCHAR(50) NOT NULL, rol VARCHAR(25), nickname VARCHAR(50) NOT NULL UNIQUE,
                      apellido VARCHAR(50) NOT NULL, nacionalidad VARCHAR(50), fecha_nacimiento DATE NOT NULL,
                      sueldo NUMBER(6,2) NOT NULL, id_equipo NUMBER(5),
                    CONSTRAINT pk_dni PRIMARY KEY (dni),
                    CONSTRAINT fk_jugador_id_equipo FOREIGN KEY (id_equipo) REFERENCES equipo (id));

CREATE TABLE Partidos (id_equipo NUMBER(5), id_enfrentamiento NUMBER(5), resultado VARCHAR(5) NOT NULL,
                    CONSTRAINT pk_enfrentamientos_equipos PRIMARY KEY (id_equipo,id_enfrentamiento),
                    CONSTRAINT fk_enfrentamientos_id_equipo FOREIGN KEY (id_equipo) REFERENCES equipo(id),
                    CONSTRAINT fk_enfrentamientos_id_enfrentamiento FOREIGN KEY (id_enfrentamiento) REFERENCES Enfrentamiento(id));

CREATE TABLE Competicion (id NUMBER(5) PRIMARY KEY, nombre VARCHAR(50) NOT NULL UNIQUE, estado NUMBER(1) NOT NULL);

CREATE TABLE Usuario (id NUMBER(5) PRIMARY KEY, username VARCHAR2(25), passwd VARCHAR(50), admin NUMBER(1) NOT NULL UNIQUE);
