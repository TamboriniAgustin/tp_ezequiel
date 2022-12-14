USE api_rest_turnos;
SET foreign_key_checks = 0;

DROP TABLE IF EXISTS organizacion;
DROP TABLE IF EXISTS tipo_evento;  
DROP TABLE IF EXISTS evento;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS turno;

CREATE TABLE organizacion(
	nombre VARCHAR(20) NOT NULL,
    cuit VARCHAR(11) NOT NULL,
    direccion VARCHAR(50) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    email VARCHAR(30) NOT NULL,
    fecha_alta DATE NOT NULL,
    clave VARCHAR(60) NOT NULL,
    PRIMARY KEY(cuit),
    UNIQUE(nombre),
	UNIQUE(direccion),
	UNIQUE(email)
);

CREATE TABLE evento(
	cuit_organizacion VARCHAR(11),
	nombre VARCHAR(20) NOT NULL,
    ubicacion VARCHAR(50) NOT NULL,
    fecha_creacion DATE NOT NULL,
    fecha_realizacion DATETIME NOT NULL,
    tipo INTEGER NOT NULL,
    PRIMARY KEY(cuit_organizacion, nombre),
    FOREIGN KEY(cuit_organizacion) REFERENCES organizacion(cuit)
);

CREATE TABLE usuario(
	nombre VARCHAR(40) NOT NULL,
    apellido VARCHAR(40) NOT NULL,
    dni VARCHAR(8) NOT NULL,
    clave VARCHAR(60) NOT NULL,
    activo BOOLEAN DEFAULT(1),
    PRIMARY KEY(dni)
);

CREATE TABLE turno(
	id VARCHAR(40) NOT NULL,
    evento_organizacion VARCHAR(11) NOT NULL,
    evento_nombre VARCHAR(20) NOT NULL,
    fecha DATETIME,
    dni_persona VARCHAR(8) NOT NULL,
	nombre_persona VARCHAR(40) NOT NULL,
	apellido_persona VARCHAR(40) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(evento_organizacion, evento_nombre) REFERENCES evento(cuit_organizacion, nombre),
	UNIQUE(evento_organizacion, evento_nombre, fecha);
);