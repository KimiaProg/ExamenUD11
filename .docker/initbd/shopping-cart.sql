SET CHARACTER SET 'utf8';

DROP TABLE IF EXISTS Users;
CREATE TABLE Users(
  username VARCHAR(20) PRIMARY  KEY,
  passwd VARCHAR(10)
);

INSERT INTO Users VALUES ('Sandra','1234');
INSERT INTO Users VALUES ('Juan','1234');
INSERT INTO Users VALUES ('Leonardo','1234');
INSERT INTO Users VALUES ('Pilar','1234');

DROP TABLE IF EXISTS Personas;
CREATE TABLE Personas(
	nombre VARCHAR(20) NOT NULL,
	dni VARCHAR(10) NOT NULL PRIMARY KEY,
	fecha_nacimiento DATE NOT NULL,
	peso DECIMAL(5,2) NOT NULL,
	titulado BOOLEAN NOT NULL
);

INSERT INTO Personas VALUES ('Juan','54898652L',CURDATE(),65.44,TRUE);
INSERT INTO Personas VALUES ('Pepe','39292715G',CURDATE(),75,TRUE);
INSERT INTO Personas VALUES ('Filomena','16657984Z',CURDATE(),45.25,FALSE);
INSERT INTO Personas VALUES ('Martina','13658947A',CURDATE(),95.99,TRUE);


DROP TABLE IF EXISTS Tienda;
CREATE TABLE Tienda (
  idTienda INT,
  nombre VARCHAR(45),
  direccion VARCHAR(45),
  PRIMARY KEY (idTienda)
  );


DROP TABLE IF EXISTS Especialidad;
CREATE TABLE Especialidad (
  idEspecialidad VARCHAR(1),
  especialidad VARCHAR(45) NOT NULL,
  PRIMARY KEY (idEspecialidad),
  UNIQUE (especialidad)
  );


DROP TABLE IF EXISTS Empleado;
CREATE TABLE Empleado (
  idEmpleado INT,
  nombre VARCHAR(45) NOT NULL,
  sueldo DECIMAL(8,2) DEFAULT 1000,
  idTienda INT NOT NULL,
  idEspecialidad VARCHAR(1) NOT NULL,
  PRIMARY KEY (idEmpleado),
  FOREIGN KEY (idTienda) REFERENCES Tienda (idTienda)
     ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (idEspecialidad) REFERENCES Especialidad (idEspecialidad)
     ON DELETE RESTRICT ON UPDATE CASCADE
  );

INSERT INTO Tienda VALUES
  (1, "Eco-Pepe", "C/Larga 23"),
  (2, "Super Ahorro", "C/Corta 18"),
  (3, "Ofertas 24h", "C/Siete revueltas 21"),
  (4, "Mercado Pepa", "C/Ancha 1");
  
  
INSERT INTO Especialidad VALUES 
  ('P', 'Pescadería'),
  ('F', 'Frutería'),
  ('C', 'Carnicería');
  
INSERT INTO Empleado VALUES
  (100, "Ana Almirez",    1100, 1, 'P'),
  (101, "Bea Boniato",    1150, 1, 'F'),
  (102, "Cristi Cristal", 1200, 1, 'C'),
  (103, "David Dado",     1250, 2, 'P'),
  (104, "Enrique Erial",  1300, 2, 'F'),
  (105, "Francisco Frio", 1350, 2, 'C'),
  (106, "Ginés Gato",     1400, 3, 'P'),
  (107, "Helena Huerto",  1200, 3, 'F'),
  (108, "Inma Italia",    1200, 3, 'C'),
  (109, "José Jiménez",   1000, 4, 'P'),
  (110, "Killo Kiko",     1200, 4, 'F'),
  (111, "Lara Lirón",     1200, 4, 'F'),
  (112, "María Martín",   1200, 4, 'F'),
  (113, "Noelia Nada",     800, 1, 'P'),
  (114, "Ñu Ñapa",         900, 1, 'P'),
  (115, "Oscar Oro",      1100, 1, 'F'),
  (116, "Pedro Pino",      650, 1, 'C'),
  (117, "Quino Queso",     759, 2, 'F'),
  (118, "Ramón Ramos",     900, 2, 'F'),
  (119, "Sandy Sevilla",   600, 2, 'C'),
  (120, "Toribio Toro",    500, 2, 'P');

