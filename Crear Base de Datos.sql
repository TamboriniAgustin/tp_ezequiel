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
    UNIQUE(nombre, direccion, email)
);

CREATE TABLE tipo_evento(
	codigo INTEGER NOT NULL AUTO_INCREMENT,
    descripcion VARCHAR(10),
    PRIMARY KEY(codigo),
    UNIQUE(descripcion)
);

CREATE TABLE evento(
	cuit_organizacion VARCHAR(11),
	nombre VARCHAR(20) NOT NULL,
    ubicacion VARCHAR(50) NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    fecha_realizacion DATETIME,
    tipo INTEGER,
    PRIMARY KEY(cuit_organizacion, nombre),
    FOREIGN KEY(cuit_organizacion) REFERENCES organizacion(cuit),
    FOREIGN KEY(tipo) REFERENCES tipo_evento(codigo)
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
    clave VARCHAR(40) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(evento_organizacion, evento_nombre) REFERENCES evento(cuit_organizacion, nombre)
);