-- Crear la base de datos
CREATE DATABASE bdgigantografia;
-- Usar la base de datos creada
USE bdgigantografia;


CREATE TABLE IF NOT EXISTS bdgigantografia.rol (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(20) NOT NULL,
  activo BIT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table bdordenesservicio.usuario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS bdgigantografia.usuario (
  id INT NOT NULL AUTO_INCREMENT,
  rol_id INT NOT NULL,
  nombres VARCHAR(40) NOT NULL,
  apellidos VARCHAR(50) NOT NULL,
  ci VARCHAR(20) NOT NULL,
  email VARCHAR(50) NOT NULL,
  clave VARCHAR(128) NOT NULL,
  fechanacimiento DATE NOT NULL,
  foto VARCHAR(70) NULL,
  activo BIT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (id),
  UNIQUE INDEX ci_UNIQUE (ci ASC) ,
  UNIQUE INDEX email_UNIQUE (email ASC) ,
  INDEX fk_rol_usuario_idx (rol_id ASC) ,
  CONSTRAINT fk_rol_usuario
    FOREIGN KEY (rol_id)
    REFERENCES bdgigantografia.rol (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
-- insertar rol
INSERT INTO rol (id, nombre, activo) VALUES
(1, 'Administrador', b'1'),
(2, 'Encargado', b'1'),
(3, 'Empleado', b'1');
-- insertar usuario
INSERT INTO usuario (id, rol_id, nombres, apellidos, ci, email, clave, fechanacimiento, foto, activo) VALUES
(1, 1, 'Cristian', 'Aguilar', '531434351', 'user@gmail.com', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '2002-05-19', 'foto.jgp', b'1');

-- Crear la tabla Cliente
CREATE TABLE Cliente (
    ClienteID INT AUTO_INCREMENT NOT NULL,
    NombreCliente VARCHAR(100),
    Direccion VARCHAR(255),
    Telefono VARCHAR(20),
    Activo BIT(1) NOT NULL DEFAULT 1,
    PRIMARY KEY (ClienteID)
) ENGINE=InnoDB;

-- Crear la tabla DetalleVenta
CREATE TABLE DetalleVenta (
    DetalleVentaID INT AUTO_INCREMENT NOT NULL,
    VentaID INT,
    servicio VARCHAR(200) NULL,
    Cantidad INT,
    PrecioUnitario DECIMAL(10, 2),
    PRIMARY KEY (DetalleVentaID)
) ENGINE=InnoDB;

-- Crear la tabla Producto
CREATE TABLE Producto (
    ProductoID INT AUTO_INCREMENT NOT NULL,
    NombreProducto VARCHAR(100),
    PrecioUnitario DECIMAL(10, 2),
    Stock INT,
    Activo BIT(1) NOT NULL DEFAULT 1,
    PRIMARY KEY (ProductoID)
) ENGINE=InnoDB;

-- Crear la tabla TransaccionFinancieraa
CREATE TABLE TransaccionFinancieraa (
    TransaccionID INT AUTO_INCREMENT NOT NULL,
    TipoTransaccion VARCHAR(50),
    Descripcion VARCHAR(255),
    Monto DECIMAL(10, 2),
    FechaTransaccion DATE,
    VentaID INT,
    PRIMARY KEY (TransaccionID)
) ENGINE=InnoDB;

-- Crear la tabla Venta
CREATE TABLE Venta (
    VentaID INT AUTO_INCREMENT NOT NULL,
    usuario_id INT NOT NULL,
    ClienteID INT,
    ProductoID INT,
    num_comprobante VARCHAR(15) NOT NULL,
    FechaVenta DATE,
    situacion VARCHAR(50) NOT NULL,
	total DECIMAL(11,2) NULL,
    Estado VARCHAR(20) NOT NULL DEFAULT 'Aceptado',
    PRIMARY KEY (VentaID),
    INDEX fk_usuario_Venta_idx (usuario_id ASC) ,
     FOREIGN KEY (usuario_id)
    REFERENCES bdgigantografia.usuario (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE=InnoDB;

-- Agregar llaves foráneas
ALTER TABLE Venta ADD FOREIGN KEY (ProductoID) REFERENCES Producto (ProductoID);
ALTER TABLE DetalleVenta ADD FOREIGN KEY (VentaID) REFERENCES Venta (VentaID);
ALTER TABLE TransaccionFinancieraa ADD FOREIGN KEY (VentaID) REFERENCES Venta (VentaID);
ALTER TABLE Venta ADD FOREIGN KEY (ClienteID) REFERENCES Cliente (ClienteID);