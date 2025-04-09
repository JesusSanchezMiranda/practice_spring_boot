CREATE TABLE Usuarios (
    id_usuario INT PRIMARY KEY IDENTITY,
    tipo_documento CHAR(3) NOT NULL,
    numero_documento VARCHAR(20) NOT NULL,
    nombre VARCHAR(200) NOT NULL,
    apellido VARCHAR(200) NOT NULL,
    celular CHAR(9) NOT NULL,
    email VARCHAR(200) NOT NULL,
    rol CHAR(1) NOT NULL,
    registro_actual TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    estado CHAR(1) NOT NULL
);