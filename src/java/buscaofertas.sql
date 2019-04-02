-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-04-2019 a las 19:00:07
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `buscaofertas`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `consultarCategorias` ()  BEGIN
SELECT * FROM categoria ORDER BY nombreCategoria, idCategoria;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultarCiudad` ()  BEGIN
SELECT * FROM ciudad order by departamentoCiudad,nombreCiudad,idCiudad;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultarDetalleProducto` ()  BEGIN
SELECT * FROM detalleproducto;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultarDetalleProductoTieneImagen` ()  BEGIN
SELECT * FROM detalleproducto_tiene_imagen;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultarImagenes` ()  BEGIN
SELECT * FROM imagen;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultarMarcas` ()  BEGIN
SELECT * FROM marca;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultarOfertas` ()  BEGIN
SELECT * FROM oferta;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultarOfertasPorIdOferta` (IN `idOferta1` INT)  BEGIN
SELECT * FROM oferta where idOferta = idOferta1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultarOfertasPorIdUsuario` (IN `idUsuario` INT)  BEGIN
SELECT * FROM oferta where Usuario_idUsuario = idUsuario;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultarOfertaTieneUbicacion` ()  BEGIN
SELECT * FROM oferta_tiene_ubicacion 
order by 
Id_Oferta_tiene_Ubicacion,
Oferta_idOferta,
Ubicacion_idUbicacion;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultarPorIdOfertaTieneUbicacion` (IN `Oferta_idOferta1` INT)  BEGIN
SELECT * FROM oferta_tiene_ubicacion where Oferta_idOferta = Oferta_idOferta1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultarProductos` ()  BEGIN
SELECT * FROM producto
order by
Categoria_idCategoria,
MarcaIdMarca,
nombreProducto,
idProducto;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultarUbicacion` ()  BEGIN
SELECT idUbicacion, nombreTienda, direccion, ciudad 
FROM ubicacion order by ciudad, nombreTienda, direccion, idUbicacion;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultarUsuarios` ()  BEGIN
select * from usuario order by nombreUsuario asc;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarCategoria` (IN `idCategoria1` INT)  BEGIN
DELETE FROM categoria
WHERE 
idCategoria = idCategoria1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarCiudad` (IN `idCiudad1` INT)  BEGIN
DELETE FROM ciudad 
WHERE 
idCiudad = idCiudad1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarDetalleProducto` (IN `Oferta_idOferta1` INT, IN `Producto_idProducto1` INT)  BEGIN
DELETE FROM detalleproducto 
WHERE 
Oferta_idOferta = Oferta_idOferta1
and 
Producto_idProducto = Producto_idProducto1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarDetalleProductoTieneImagen` (IN `Id_DetalleProducto_tiene_Imagen1` INT)  BEGIN
DELETE FROM 
detalleproducto_tiene_imagen 
WHERE 
Id_DetalleProducto_tiene_Imagen = Id_DetalleProducto_tiene_Imagen1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarImagen` (IN `idImagen1` INT)  BEGIN
DELETE FROM imagen WHERE idImagen = idImagen1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarMarca` (IN `idMarca1` INT)  BEGIN
DELETE FROM marca WHERE idMarca = idMarca1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarOferta` (IN `idOferta1` INT)  BEGIN
DELETE FROM oferta WHERE idOferta = idOferta1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarOfertaTieneUbicacion` (IN `Id_Oferta_tiene_Ubicacion1` INT)  BEGIN
delete from oferta_tiene_ubicacion 
WHERE Id_Oferta_tiene_Ubicacion = Id_Oferta_tiene_Ubicacion1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarProducto` (IN `idProducto1` INT)  BEGIN
DELETE FROM producto WHERE idProducto = idProducto1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarUbicacion` (IN `idUbicacion1` INT)  BEGIN
DELETE FROM ubicacion WHERE idUbicacion = idUbicacion1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarUsuario` (IN `idUsuario1` INT)  BEGIN
delete from usuario where  idUsuario = idUsuario1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertCategoria` (IN `nombreCategoria1` VARCHAR(45))  BEGIN
INSERT INTO categoria (
nombreCategoria
) VALUES(
nombreCategoria1
);
SELECT LAST_INSERT_ID();
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertCiudad` (IN `idCiudad1` INT, IN `nombreCiudad1` VARCHAR(255), IN `departamentoCiudad1` VARCHAR(255))  BEGIN
INSERT INTO ciudad ( 
idCiudad,
nombreCiudad,
departamentoCiudad) 
VALUES(
idCiudad1,
nombreCiudad1,
departamentoCiudad1
);
SELECT LAST_INSERT_ID();
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertDetalleProducto` (IN `Oferta_idOferta1` INT, IN `Producto_idProducto1` INT, IN `precio1` DOUBLE)  BEGIN
INSERT INTO detalleproducto (
Oferta_idOferta, 
Producto_idProducto, 
precio
) VALUES
(
Oferta_idOferta1, 
Producto_idProducto1, 
precio1
);
SELECT LAST_INSERT_ID();
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertDetalleProductoTieneImagen` (IN `Imagen_idImagen1` INT, IN `DetalleProducto_Oferta_idOferta1` INT, IN `DetalleProducto_Producto_idProducto1` INT)  BEGIN
INSERT INTO detalleproducto_tiene_imagen (
Imagen_idImagen, 
DetalleProducto_Oferta_idOferta, 
DetalleProducto_Producto_idProducto) 
VALUES(
Imagen_idImagen1, 
DetalleProducto_Oferta_idOferta1, 
DetalleProducto_Producto_idProducto1
);
SELECT LAST_INSERT_ID();
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertImagen` (IN `linkImagen1` VARCHAR(45), IN `foto1` BLOB)  BEGIN
INSERT INTO imagen (linkImagen,foto) VALUES(linkImagen1,foto1);
SELECT LAST_INSERT_ID();
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertMarca` (IN `nombreMarca1` VARCHAR(45))  BEGIN
INSERT INTO marca (nombreMarca) VALUES(nombreMarca1);
SELECT LAST_INSERT_ID();
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertOferta` (IN `Usuario_idUsuario1` INT, IN `nombreOferta1` VARCHAR(45), IN `fechaCreacion1` DATE, IN `fechaInicio1` DATE, IN `fechaFin1` DATE, IN `vecesCompartida1` INT)  BEGIN
INSERT INTO oferta (
Usuario_idUsuario, 
nombreOferta, 
fechaCreacion,
fechaInicio, 
fechaFin, 
vecesCompartida) 
VALUES( 
Usuario_idUsuario1, 
nombreOferta1, 
fechaCreacion1,
fechaInicio1, 
fechaFin1,
vecesCompartida1);
SELECT LAST_INSERT_ID();
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertOfertaTieneUbicacion` (IN `Oferta_idOferta1` INT, IN `Ubicacion_idUbicacion1` INT)  BEGIN
INSERT INTO oferta_tiene_ubicacion (Oferta_idOferta, Ubicacion_idUbicacion) VALUES(Oferta_idOferta1 ,Ubicacion_idUbicacion1);
SELECT LAST_INSERT_ID();
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertProducto` (IN `idCategoria` INT, IN `idMarca` INT, IN `nombreProducto1` VARCHAR(45))  BEGIN
INSERT INTO producto (
Categoria_idCategoria, 
Marca_idMarca, 
nombreProducto) 
VALUES(
idCategoria, 
idMarca, 
nombreProducto1);
SELECT LAST_INSERT_ID();
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertUbicacion` (IN `nombreTienda1` VARCHAR(45), IN `direccion1` VARCHAR(45), IN `ciudad1` VARCHAR(45))  BEGIN
INSERT INTO ubicacion ( nombreTienda, direccion, ciudad) VALUES( nombreTienda1, direccion1, ciudad1);
SELECT LAST_INSERT_ID();
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertUsuario` (IN `Ciudad_idCiudad` INT, IN `nombreUsuario` VARCHAR(45), IN `contrasena` VARCHAR(40), IN `nombre` VARCHAR(45), IN `apellido` VARCHAR(45), IN `telefono` VARCHAR(20), IN `correo` VARCHAR(45), IN `fechaNacimiento` DATE, IN `genero` CHAR(1), IN `rol` VARCHAR(45), OUT `codigo` INT)  BEGIN
insert into usuario (Ciudad_idCiudad, nombreUsuario, contrasena, nombre, apellido, telefono, correo, fechaNacimiento, genero, rol) values(Ciudad_idCiudad, nombreUsuario, contrasena, nombre, apellido, telefono, correo, fechaNacimiento, genero, rol);
SELECT LAST_INSERT_ID() INTO codigo;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarCategoria` (IN `nombreCategoria1` VARCHAR(45), IN `idCategoria1` INT)  BEGIN
UPDATE categoria 
SET 
nombreCategoria = nombreCategoria1
WHERE 
idCategoria = idCategoria1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarCiudad` (IN `idCiudad1` INT, IN `nombreCiudad1` VARCHAR(255), IN `departamentoCiudad1` VARCHAR(255))  BEGIN
UPDATE ciudad 
SET 
nombreCiudad = nombreCiudad1, 
departamentoCiudad = departamentoCiudad1
WHERE 
idCiudad = idCiudad1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarDetalleProducto` (IN `Oferta_idOferta1` INT, IN `Producto_idProducto1` INT, IN `precio1` DOUBLE)  BEGIN
UPDATE detalleproducto 
SET 
precio =  precio1
WHERE 
Oferta_idOferta = Oferta_idOferta1
and 
Producto_idProducto = Producto_idProducto1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarDetalleProductoTieneImagen` (IN `Imagen_idImagen1` INT, IN `DetalleProducto_Oferta_idOferta1` INT, IN `DetalleProducto_Producto_idProducto1` INT, IN `Id_DetalleProducto_tiene_Imagen1` INT)  BEGIN
UPDATE 
detalleproducto_tiene_imagen 
SET 
Imagen_idImagen = Imagen_idImagen1, 
DetalleProducto_Oferta_idOferta = DetalleProducto_Oferta_idOferta1, 
DetalleProducto_Producto_idProducto = DetalleProducto_Producto_idProducto1 
WHERE 
Id_DetalleProducto_tiene_Imagen = Id_DetalleProducto_tiene_Imagen1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarImagen` (IN `linkImagen1` VARCHAR(45), IN `foto1` BLOB, IN `idImagen1` INT)  BEGIN
UPDATE imagen
SET
linkImagen = linkImagen1,
foto = foto1
WHERE
idImagen = idImagen1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarMarca` (IN `nombreMarca1` VARCHAR(45), IN `idMarca1` INT)  BEGIN
UPDATE marca SET nombreMarca = nombreMarca1 WHERE idMarca = idMarca1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarOferta` (IN `Usuario_idUsuario1` INT, IN `nombreOferta1` VARCHAR(45), IN `fechaCreacion1` DATE, IN `fechaInicio1` DATE, IN `fechaFin1` DATE, IN `vecesCompartida1` INT, IN `idOferta1` INT)  BEGIN
UPDATE oferta 
SET Usuario_idUsuario = Usuario_idUsuario1, 
nombreOferta = nombreOferta1, 
fechaCreacion = fechaCreacion1, 
fechaInicio = fechaInicio1, 
fechaFin = fechaFin1, 
vecesCompartida = vecesCompartida1 
WHERE idOferta = idOferta1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarOfertaTieneUbicacion` (IN `Oferta_idOferta1` INT, IN `Ubicacion_idUbicacion1` INT, IN `Id_Oferta_tiene_Ubicacion1` INT)  BEGIN
UPDATE oferta_tiene_ubicacion 
SET Oferta_idOferta = Oferta_idOferta1, 
Ubicacion_idUbicacion = Ubicacion_idUbicacion1 
WHERE Id_Oferta_tiene_Ubicacion = Id_Oferta_tiene_Ubicacion1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarProducto` (IN `idCategoria` INT, IN `idMarca` INT, IN `nombreProducto1` VARCHAR(45), IN `idProducto1` INT)  BEGIN
update producto 
set
Categoria_idCategoria = idCategoria, 
Marca_idMarca = idMarca, 
nombreProducto = nombreProducto1 
where
idProducto = idProducto1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarUbicacion` (IN `nombreTienda1` VARCHAR(45), IN `direccion1` VARCHAR(45), IN `ciudad1` VARCHAR(45), IN `idUbicacion1` INT)  BEGIN
UPDATE ubicacion 
SET nombreTienda = nombreTienda1, 
direccion = direccion1, 
ciudad = ciudad1 
WHERE idUbicacion = idUbicacion1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarUsuario` (IN `Ciudad_idCiudad1` INT, IN `nombreUsuario1` VARCHAR(45), IN `contrasena1` VARCHAR(40), IN `nombre1` VARCHAR(45), IN `apellido1` VARCHAR(45), IN `telefono1` VARCHAR(20), IN `correo1` VARCHAR(45), IN `fechaNacimiento1` DATE, IN `genero1` CHAR(1), IN `rol1` VARCHAR(45), IN `idUsuario1` INT)  BEGIN
UPDATE usuario 
SET Ciudad_idCiudad = Ciudad_idCiudad1, 
nombreUsuario = nombreUsuario1, 
contrasena = contrasena1, 
nombre = nombre1, 
apellido = apellido1, 
telefono = telefono1, 
correo = correo1, 
fechaNacimiento = fechaNacimiento1, 
genero = genero1,
 rol =  rol1
WHERE idUsuario = idUsuario1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `obtenereIdImagen` (IN `idImagen1` INT)  BEGIN
SELECT * FROM imagen where idImagen = idImagen1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `obtenerIdCategoria` (IN `idCategoria1` INT)  BEGIN
SELECT * FROM categoria WHERE
idCategoria = idCategoria1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `obtenerIdCiudad` (IN `nombreCiudad1` VARCHAR(255))  BEGIN
SELECT * FROM ciudad 
WHERE 
nombreCiudad = nombreCiudad1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `obtenerIdConNombreProducto` (IN `nombreProducto1` VARCHAR(45))  BEGIN
SELECT * FROM producto where nombreProducto = nombreProducto1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `obtenerIdDetalleProducto` (IN `Oferta_idOferta1` INT)  BEGIN
SELECT * FROM detalleproducto 
WHERE 
Oferta_idOferta = Oferta_idOferta1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `obtenerIdDetalleProductoTieneImagen` (IN `DetalleProducto_Oferta_idOferta1` INT, IN `DetalleProducto_Producto_idProducto1` INT)  BEGIN
SELECT * FROM 
detalleproducto_tiene_imagen 
where DetalleProducto_Oferta_idOferta = DetalleProducto_Oferta_idOferta1 
and DetalleProducto_Producto_idProducto = DetalleProducto_Producto_idProducto1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `obtenerIdImagen` (IN `idImagen1` INT)  BEGIN
SELECT * FROM imagen where idImagen = idImagen1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `obtenerIdMarca` (IN `idMarca1` INT)  BEGIN
SELECT * FROM marca WHERE idMarca = idMarca1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `obtenerIdOferta` (IN `idOferta1` INT)  BEGIN
SELECT * FROM oferta WHERE idOferta = idOferta1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `obtenerIdOfertaTieneUbicacion` (IN `Oferta_idOferta1` INT)  BEGIN
SELECT * FROM oferta_tiene_ubicacion where Oferta_idOferta = Oferta_idOferta1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `obtenerIdProducto` (IN `idProducto1` INT)  BEGIN
SELECT idProducto, Categoria_idCategoria, Marca_idMarca, nombreProducto FROM producto where idProducto = idProducto1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `obtenerIdUbicacion` (IN `idUbicacion1` INT)  BEGIN
SELECT * FROM ubicacion where idUbicacion = idUbicacion1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `obtenerIdUsuario` (IN `nombreUsuario1` VARCHAR(45))  BEGIN
SELECT idUsuario, Ciudad_idCiudad, nombreUsuario, contrasena, nombre, apellido, telefono, correo, fechaNacimiento, genero, rol 
FROM usuario where nombreUsuario = nombreUsuario1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `validarUsuario` (IN `nombreUsu` VARCHAR(45), IN `clave` VARCHAR(40))  BEGIN
SELECT idUsuario, Ciudad_idCiudad, nombreUsuario, contrasena, 
nombre, apellido, telefono, correo, fechaNacimiento, genero, rol 
FROM usuario where nombreUsuario = nombreUsu and contrasena = clave;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `idCategoria` int(11) UNSIGNED NOT NULL COMMENT 'Identificador único de categoría, generado por el sistema.',
  `nombreCategoria` varchar(45) DEFAULT NULL COMMENT 'Atributo nombreCategoría, ingresado por el administrador.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla en las que se listan las diferentes categorías dentro de las que puede estar un tipo de producto.' PACK_KEYS=0;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`idCategoria`, `nombreCategoria`) VALUES
(1, 'alimentos y bebidas'),
(2, 'papeleria'),
(3, 'zrgrg'),
(4, 'tecnologia'),
(5, 'electrónica'),
(6, 'tttttt'),
(7, 'adorno'),
(8, 'ghj'),
(9, 'dfg'),
(10, 'jkl'),
(11, 'iop'),
(12, 'ghj'),
(13, 'df'),
(14, 'kl');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudad`
--

CREATE TABLE `ciudad` (
  `idCiudad` int(11) UNSIGNED NOT NULL,
  `nombreCiudad` varchar(255) NOT NULL,
  `departamentoCiudad` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ciudad`
--

INSERT INTO `ciudad` (`idCiudad`, `nombreCiudad`, `departamentoCiudad`) VALUES
(1, 'Abriaquí', 'ANTIOQUIA'),
(2, 'Acacías', 'META'),
(3, 'Acandí', 'CHOCÓ'),
(4, 'Acevedo', 'HUILA'),
(5, 'Achí', 'BOLÍVAR'),
(6, 'Agrado', 'HUILA'),
(7, 'Agua de Dios', 'CUNDINAMARCA'),
(8, 'Aguachica', 'CESAR'),
(9, 'Aguada', 'SANTANDER'),
(10, 'Aguadas', 'CALDAS'),
(11, 'Aguazul', 'CASANARE'),
(12, 'Agustín Codazzi', 'CESAR'),
(13, 'Aipe', 'HUILA'),
(14, 'Albania', 'CAQUETÁ'),
(15, 'Albania', 'LA GUAJIRA'),
(16, 'Albania', 'SANTANDER'),
(17, 'Albán', 'CUNDINAMARCA'),
(18, 'Albán (San José)', 'NARIÑO'),
(19, 'Alcalá', 'VALLE DEL CAUCA'),
(20, 'Alejandria', 'ANTIOQUIA'),
(21, 'Algarrobo', 'MAGDALENA'),
(22, 'Algeciras', 'HUILA'),
(23, 'Almaguer', 'CAUCA'),
(24, 'Almeida', 'BOYACÁ'),
(25, 'Alpujarra', 'TOLIMA'),
(26, 'Altamira', 'HUILA'),
(27, 'Alto Baudó (Pie de Pato)', 'CHOCÓ'),
(28, 'Altos del Rosario', 'BOLÍVAR'),
(29, 'Alvarado', 'TOLIMA'),
(30, 'Amagá', 'ANTIOQUIA'),
(31, 'Amalfi', 'ANTIOQUIA'),
(32, 'Ambalema', 'TOLIMA'),
(33, 'Anapoima', 'CUNDINAMARCA'),
(34, 'Ancuya', 'NARIÑO'),
(35, 'Andalucía', 'VALLE DEL CAUCA'),
(36, 'Andes', 'ANTIOQUIA'),
(37, 'Angelópolis', 'ANTIOQUIA'),
(38, 'Angostura', 'ANTIOQUIA'),
(39, 'Anolaima', 'CUNDINAMARCA'),
(40, 'Anorí', 'ANTIOQUIA'),
(41, 'Anserma', 'CALDAS'),
(42, 'Ansermanuevo', 'VALLE DEL CAUCA'),
(43, 'Anzoátegui', 'TOLIMA'),
(44, 'Anzá', 'ANTIOQUIA'),
(45, 'Apartadó', 'ANTIOQUIA'),
(46, 'Apulo', 'CUNDINAMARCA'),
(47, 'Apía', 'RISARALDA'),
(48, 'Aquitania', 'BOYACÁ'),
(49, 'Aracataca', 'MAGDALENA'),
(50, 'Aranzazu', 'CALDAS'),
(51, 'Aratoca', 'SANTANDER'),
(52, 'Arauca', 'ARAUCA'),
(53, 'Arauquita', 'ARAUCA'),
(54, 'Arbeláez', 'CUNDINAMARCA'),
(55, 'Arboleda (Berruecos)', 'NARIÑO'),
(56, 'Arboledas', 'NORTE DE SANTANDER'),
(57, 'Arboletes', 'ANTIOQUIA'),
(58, 'Arcabuco', 'BOYACÁ'),
(59, 'Arenal', 'BOLÍVAR'),
(60, 'Argelia', 'ANTIOQUIA'),
(61, 'Argelia', 'CAUCA'),
(62, 'Argelia', 'VALLE DEL CAUCA'),
(63, 'Ariguaní (El Difícil)', 'MAGDALENA'),
(64, 'Arjona', 'BOLÍVAR'),
(65, 'Armenia', 'ANTIOQUIA'),
(66, 'Armenia', 'QUINDIO'),
(67, 'Armero (Guayabal)', 'TOLIMA'),
(68, 'Arroyohondo', 'BOLÍVAR'),
(69, 'Astrea', 'CESAR'),
(70, 'Ataco', 'TOLIMA'),
(71, 'Atrato (Yuto)', 'CHOCÓ'),
(72, 'Ayapel', 'CÓRDOBA'),
(73, 'Bagadó', 'CHOCÓ'),
(74, 'Bahía Solano (Mútis)', 'CHOCÓ'),
(75, 'Bajo Baudó (Pizarro)', 'CHOCÓ'),
(76, 'Balboa', 'CAUCA'),
(77, 'Balboa', 'RISARALDA'),
(78, 'Baranoa', 'ATLÁNTICO'),
(79, 'Baraya', 'HUILA'),
(80, 'Barbacoas', 'NARIÑO'),
(81, 'Barbosa', 'ANTIOQUIA'),
(82, 'Barbosa', 'SANTANDER'),
(83, 'Barichara', 'SANTANDER'),
(84, 'Barranca de Upía', 'META'),
(85, 'Barrancabermeja', 'SANTANDER'),
(86, 'Barrancas', 'LA GUAJIRA'),
(87, 'Barranco de Loba', 'BOLÍVAR'),
(88, 'Barranquilla', 'ATLÁNTICO'),
(89, 'Becerríl', 'CESAR'),
(90, 'Belalcázar', 'CALDAS'),
(91, 'Bello', 'ANTIOQUIA'),
(92, 'Belmira', 'ANTIOQUIA'),
(93, 'Beltrán', 'CUNDINAMARCA'),
(94, 'Belén', 'BOYACÁ'),
(95, 'Belén', 'NARIÑO'),
(96, 'Belén de Bajirá', 'CHOCÓ'),
(97, 'Belén de Umbría', 'RISARALDA'),
(98, 'Belén de los Andaquíes', 'CAQUETÁ'),
(99, 'Berbeo', 'BOYACÁ'),
(100, 'Betania', 'ANTIOQUIA'),
(101, 'Beteitiva', 'BOYACÁ'),
(102, 'Betulia', 'ANTIOQUIA'),
(103, 'Betulia', 'SANTANDER'),
(104, 'Bituima', 'CUNDINAMARCA'),
(105, 'Boavita', 'BOYACÁ'),
(106, 'Bochalema', 'NORTE DE SANTANDER'),
(107, 'Bogotá D.C.', 'BOGOTÁ, D.C.'),
(108, 'Bojacá', 'CUNDINAMARCA'),
(109, 'Bojayá (Bellavista)', 'CHOCÓ'),
(110, 'Bolívar', 'ANTIOQUIA'),
(111, 'Bolívar', 'CAUCA'),
(112, 'Bolívar', 'SANTANDER'),
(113, 'Bolívar', 'VALLE DEL CAUCA'),
(114, 'Bosconia', 'CESAR'),
(115, 'Boyacá', 'BOYACÁ'),
(116, 'Briceño', 'ANTIOQUIA'),
(117, 'Briceño', 'BOYACÁ'),
(118, 'Bucaramanga', 'SANTANDER'),
(119, 'Bucarasica', 'NORTE DE SANTANDER'),
(120, 'Buenaventura', 'VALLE DEL CAUCA'),
(121, 'Buenavista', 'BOYACÁ'),
(122, 'Buenavista', 'CÓRDOBA'),
(123, 'Buenavista', 'QUINDIO'),
(124, 'Buenavista', 'SUCRE'),
(125, 'Buenos Aires', 'CAUCA'),
(126, 'Buesaco', 'NARIÑO'),
(127, 'Buga', 'VALLE DEL CAUCA'),
(128, 'Bugalagrande', 'VALLE DEL CAUCA'),
(129, 'Burítica', 'ANTIOQUIA'),
(130, 'Busbanza', 'BOYACÁ'),
(131, 'Cabrera', 'CUNDINAMARCA'),
(132, 'Cabrera', 'SANTANDER'),
(133, 'Cabuyaro', 'META'),
(134, 'Cachipay', 'CUNDINAMARCA'),
(135, 'Caicedo', 'ANTIOQUIA'),
(136, 'Caicedonia', 'VALLE DEL CAUCA'),
(137, 'Caimito', 'SUCRE'),
(138, 'Cajamarca', 'TOLIMA'),
(139, 'Cajibío', 'CAUCA'),
(140, 'Cajicá', 'CUNDINAMARCA'),
(141, 'Calamar', 'BOLÍVAR'),
(142, 'Calamar', 'GUAVIARE'),
(143, 'Calarcá', 'QUINDIO'),
(144, 'Caldas', 'ANTIOQUIA'),
(145, 'Caldas', 'BOYACÁ'),
(146, 'Caldono', 'CAUCA'),
(147, 'California', 'SANTANDER'),
(148, 'Calima (Darién)', 'VALLE DEL CAUCA'),
(149, 'Caloto', 'CAUCA'),
(150, 'Calí', 'VALLE DEL CAUCA'),
(151, 'Campamento', 'ANTIOQUIA'),
(152, 'Campo de la Cruz', 'ATLÁNTICO'),
(153, 'Campoalegre', 'HUILA'),
(154, 'Campohermoso', 'BOYACÁ'),
(155, 'Canalete', 'CÓRDOBA'),
(156, 'Candelaria', 'ATLÁNTICO'),
(157, 'Candelaria', 'VALLE DEL CAUCA'),
(158, 'Cantagallo', 'BOLÍVAR'),
(159, 'Cantón de San Pablo', 'CHOCÓ'),
(160, 'Caparrapí', 'CUNDINAMARCA'),
(161, 'Capitanejo', 'SANTANDER'),
(162, 'Caracolí', 'ANTIOQUIA'),
(163, 'Caramanta', 'ANTIOQUIA'),
(164, 'Carcasí', 'SANTANDER'),
(165, 'Carepa', 'ANTIOQUIA'),
(166, 'Carmen de Apicalá', 'TOLIMA'),
(167, 'Carmen de Carupa', 'CUNDINAMARCA'),
(168, 'Carmen de Viboral', 'ANTIOQUIA'),
(169, 'Carmen del Darién (CURBARADÓ)', 'CHOCÓ'),
(170, 'Carolina', 'ANTIOQUIA'),
(171, 'Cartagena', 'BOLÍVAR'),
(172, 'Cartagena del Chairá', 'CAQUETÁ'),
(173, 'Cartago', 'VALLE DEL CAUCA'),
(174, 'Carurú', 'VAUPÉS'),
(175, 'Casabianca', 'TOLIMA'),
(176, 'Castilla la Nueva', 'META'),
(177, 'Caucasia', 'ANTIOQUIA'),
(178, 'Cañasgordas', 'ANTIOQUIA'),
(179, 'Cepita', 'SANTANDER'),
(180, 'Cereté', 'CÓRDOBA'),
(181, 'Cerinza', 'BOYACÁ'),
(182, 'Cerrito', 'SANTANDER'),
(183, 'Cerro San Antonio', 'MAGDALENA'),
(184, 'Chachaguí', 'NARIÑO'),
(185, 'Chaguaní', 'CUNDINAMARCA'),
(186, 'Chalán', 'SUCRE'),
(187, 'Chaparral', 'TOLIMA'),
(188, 'Charalá', 'SANTANDER'),
(189, 'Charta', 'SANTANDER'),
(190, 'Chigorodó', 'ANTIOQUIA'),
(191, 'Chima', 'SANTANDER'),
(192, 'Chimichagua', 'CESAR'),
(193, 'Chimá', 'CÓRDOBA'),
(194, 'Chinavita', 'BOYACÁ'),
(195, 'Chinchiná', 'CALDAS'),
(196, 'Chinácota', 'NORTE DE SANTANDER'),
(197, 'Chinú', 'CÓRDOBA'),
(198, 'Chipaque', 'CUNDINAMARCA'),
(199, 'Chipatá', 'SANTANDER'),
(200, 'Chiquinquirá', 'BOYACÁ'),
(201, 'Chiriguaná', 'CESAR'),
(202, 'Chiscas', 'BOYACÁ'),
(203, 'Chita', 'BOYACÁ'),
(204, 'Chitagá', 'NORTE DE SANTANDER'),
(205, 'Chitaraque', 'BOYACÁ'),
(206, 'Chivatá', 'BOYACÁ'),
(207, 'Chivolo', 'MAGDALENA'),
(208, 'Choachí', 'CUNDINAMARCA'),
(209, 'Chocontá', 'CUNDINAMARCA'),
(210, 'Chámeza', 'CASANARE'),
(211, 'Chía', 'CUNDINAMARCA'),
(212, 'Chíquiza', 'BOYACÁ'),
(213, 'Chívor', 'BOYACÁ'),
(214, 'Cicuco', 'BOLÍVAR'),
(215, 'Cimitarra', 'SANTANDER'),
(216, 'Circasia', 'QUINDIO'),
(217, 'Cisneros', 'ANTIOQUIA'),
(218, 'Ciénaga', 'BOYACÁ'),
(219, 'Ciénaga', 'MAGDALENA'),
(220, 'Ciénaga de Oro', 'CÓRDOBA'),
(221, 'Clemencia', 'BOLÍVAR'),
(222, 'Cocorná', 'ANTIOQUIA'),
(223, 'Coello', 'TOLIMA'),
(224, 'Cogua', 'CUNDINAMARCA'),
(225, 'Colombia', 'HUILA'),
(226, 'Colosó (Ricaurte)', 'SUCRE'),
(227, 'Colón', 'PUTUMAYO'),
(228, 'Colón (Génova)', 'NARIÑO'),
(229, 'Concepción', 'ANTIOQUIA'),
(230, 'Concepción', 'SANTANDER'),
(231, 'Concordia', 'ANTIOQUIA'),
(232, 'Concordia', 'MAGDALENA'),
(233, 'Condoto', 'CHOCÓ'),
(234, 'Confines', 'SANTANDER'),
(235, 'Consaca', 'NARIÑO'),
(236, 'Contadero', 'NARIÑO'),
(237, 'Contratación', 'SANTANDER'),
(238, 'Convención', 'NORTE DE SANTANDER'),
(239, 'Copacabana', 'ANTIOQUIA'),
(240, 'Coper', 'BOYACÁ'),
(241, 'Cordobá', 'QUINDIO'),
(242, 'Corinto', 'CAUCA'),
(243, 'Coromoro', 'SANTANDER'),
(244, 'Corozal', 'SUCRE'),
(245, 'Corrales', 'BOYACÁ'),
(246, 'Cota', 'CUNDINAMARCA'),
(247, 'Cotorra', 'CÓRDOBA'),
(248, 'Covarachía', 'BOYACÁ'),
(249, 'Coveñas', 'SUCRE'),
(250, 'Coyaima', 'TOLIMA'),
(251, 'Cravo Norte', 'ARAUCA'),
(252, 'Cuaspud (Carlosama)', 'NARIÑO'),
(253, 'Cubarral', 'META'),
(254, 'Cubará', 'BOYACÁ'),
(255, 'Cucaita', 'BOYACÁ'),
(256, 'Cucunubá', 'CUNDINAMARCA'),
(257, 'Cucutilla', 'NORTE DE SANTANDER'),
(258, 'Cuitiva', 'BOYACÁ'),
(259, 'Cumaral', 'META'),
(260, 'Cumaribo', 'VICHADA'),
(261, 'Cumbal', 'NARIÑO'),
(262, 'Cumbitara', 'NARIÑO'),
(263, 'Cunday', 'TOLIMA'),
(264, 'Curillo', 'CAQUETÁ'),
(265, 'Curití', 'SANTANDER'),
(266, 'Curumaní', 'CESAR'),
(267, 'Cáceres', 'ANTIOQUIA'),
(268, 'Cáchira', 'NORTE DE SANTANDER'),
(269, 'Cácota', 'NORTE DE SANTANDER'),
(270, 'Cáqueza', 'CUNDINAMARCA'),
(271, 'Cértegui', 'CHOCÓ'),
(272, 'Cómbita', 'BOYACÁ'),
(273, 'Córdoba', 'BOLÍVAR'),
(274, 'Córdoba', 'NARIÑO'),
(275, 'Cúcuta', 'NORTE DE SANTANDER'),
(276, 'Dabeiba', 'ANTIOQUIA'),
(277, 'Dagua', 'VALLE DEL CAUCA'),
(278, 'Dibulla', 'LA GUAJIRA'),
(279, 'Distracción', 'LA GUAJIRA'),
(280, 'Dolores', 'TOLIMA'),
(281, 'Don Matías', 'ANTIOQUIA'),
(282, 'Dos Quebradas', 'RISARALDA'),
(283, 'Duitama', 'BOYACÁ'),
(284, 'Durania', 'NORTE DE SANTANDER'),
(285, 'Ebéjico', 'ANTIOQUIA'),
(286, 'El Bagre', 'ANTIOQUIA'),
(287, 'El Banco', 'MAGDALENA'),
(288, 'El Cairo', 'VALLE DEL CAUCA'),
(289, 'El Calvario', 'META'),
(290, 'El Carmen', 'NORTE DE SANTANDER'),
(291, 'El Carmen', 'SANTANDER'),
(292, 'El Carmen de Atrato', 'CHOCÓ'),
(293, 'El Carmen de Bolívar', 'BOLÍVAR'),
(294, 'El Castillo', 'META'),
(295, 'El Cerrito', 'VALLE DEL CAUCA'),
(296, 'El Charco', 'NARIÑO'),
(297, 'El Cocuy', 'BOYACÁ'),
(298, 'El Colegio', 'CUNDINAMARCA'),
(299, 'El Copey', 'CESAR'),
(300, 'El Doncello', 'CAQUETÁ'),
(301, 'El Dorado', 'META'),
(302, 'El Dovio', 'VALLE DEL CAUCA'),
(303, 'El Espino', 'BOYACÁ'),
(304, 'El Guacamayo', 'SANTANDER'),
(305, 'El Guamo', 'BOLÍVAR'),
(306, 'El Molino', 'LA GUAJIRA'),
(307, 'El Paso', 'CESAR'),
(308, 'El Paujil', 'CAQUETÁ'),
(309, 'El Peñol', 'NARIÑO'),
(310, 'El Peñon', 'BOLÍVAR'),
(311, 'El Peñon', 'SANTANDER'),
(312, 'El Peñón', 'CUNDINAMARCA'),
(313, 'El Piñon', 'MAGDALENA'),
(314, 'El Playón', 'SANTANDER'),
(315, 'El Retorno', 'GUAVIARE'),
(316, 'El Retén', 'MAGDALENA'),
(317, 'El Roble', 'SUCRE'),
(318, 'El Rosal', 'CUNDINAMARCA'),
(319, 'El Rosario', 'NARIÑO'),
(320, 'El Tablón de Gómez', 'NARIÑO'),
(321, 'El Tambo', 'CAUCA'),
(322, 'El Tambo', 'NARIÑO'),
(323, 'El Tarra', 'NORTE DE SANTANDER'),
(324, 'El Zulia', 'NORTE DE SANTANDER'),
(325, 'El Águila', 'VALLE DEL CAUCA'),
(326, 'Elías', 'HUILA'),
(327, 'Encino', 'SANTANDER'),
(328, 'Enciso', 'SANTANDER'),
(329, 'Entrerríos', 'ANTIOQUIA'),
(330, 'Envigado', 'ANTIOQUIA'),
(331, 'Espinal', 'TOLIMA'),
(332, 'Facatativá', 'CUNDINAMARCA'),
(333, 'Falan', 'TOLIMA'),
(334, 'Filadelfia', 'CALDAS'),
(335, 'Filandia', 'QUINDIO'),
(336, 'Firavitoba', 'BOYACÁ'),
(337, 'Flandes', 'TOLIMA'),
(338, 'Florencia', 'CAQUETÁ'),
(339, 'Florencia', 'CAUCA'),
(340, 'Floresta', 'BOYACÁ'),
(341, 'Florida', 'VALLE DEL CAUCA'),
(342, 'Floridablanca', 'SANTANDER'),
(343, 'Florián', 'SANTANDER'),
(344, 'Fonseca', 'LA GUAJIRA'),
(345, 'Fortúl', 'ARAUCA'),
(346, 'Fosca', 'CUNDINAMARCA'),
(347, 'Francisco Pizarro', 'NARIÑO'),
(348, 'Fredonia', 'ANTIOQUIA'),
(349, 'Fresno', 'TOLIMA'),
(350, 'Frontino', 'ANTIOQUIA'),
(351, 'Fuente de Oro', 'META'),
(352, 'Fundación', 'MAGDALENA'),
(353, 'Funes', 'NARIÑO'),
(354, 'Funza', 'CUNDINAMARCA'),
(355, 'Fusagasugá', 'CUNDINAMARCA'),
(356, 'Fómeque', 'CUNDINAMARCA'),
(357, 'Fúquene', 'CUNDINAMARCA'),
(358, 'Gachalá', 'CUNDINAMARCA'),
(359, 'Gachancipá', 'CUNDINAMARCA'),
(360, 'Gachantivá', 'BOYACÁ'),
(361, 'Gachetá', 'CUNDINAMARCA'),
(362, 'Galapa', 'ATLÁNTICO'),
(363, 'Galeras (Nueva Granada)', 'SUCRE'),
(364, 'Galán', 'SANTANDER'),
(365, 'Gama', 'CUNDINAMARCA'),
(366, 'Gamarra', 'CESAR'),
(367, 'Garagoa', 'BOYACÁ'),
(368, 'Garzón', 'HUILA'),
(369, 'Gigante', 'HUILA'),
(370, 'Ginebra', 'VALLE DEL CAUCA'),
(371, 'Giraldo', 'ANTIOQUIA'),
(372, 'Girardot', 'CUNDINAMARCA'),
(373, 'Girardota', 'ANTIOQUIA'),
(374, 'Girón', 'SANTANDER'),
(375, 'Gonzalez', 'CESAR'),
(376, 'Gramalote', 'NORTE DE SANTANDER'),
(377, 'Granada', 'ANTIOQUIA'),
(378, 'Granada', 'CUNDINAMARCA'),
(379, 'Granada', 'META'),
(380, 'Guaca', 'SANTANDER'),
(381, 'Guacamayas', 'BOYACÁ'),
(382, 'Guacarí', 'VALLE DEL CAUCA'),
(383, 'Guachavés', 'NARIÑO'),
(384, 'Guachené', 'CAUCA'),
(385, 'Guachetá', 'CUNDINAMARCA'),
(386, 'Guachucal', 'NARIÑO'),
(387, 'Guadalupe', 'ANTIOQUIA'),
(388, 'Guadalupe', 'HUILA'),
(389, 'Guadalupe', 'SANTANDER'),
(390, 'Guaduas', 'CUNDINAMARCA'),
(391, 'Guaitarilla', 'NARIÑO'),
(392, 'Gualmatán', 'NARIÑO'),
(393, 'Guamal', 'MAGDALENA'),
(394, 'Guamal', 'META'),
(395, 'Guamo', 'TOLIMA'),
(396, 'Guapota', 'SANTANDER'),
(397, 'Guapí', 'CAUCA'),
(398, 'Guaranda', 'SUCRE'),
(399, 'Guarne', 'ANTIOQUIA'),
(400, 'Guasca', 'CUNDINAMARCA'),
(401, 'Guatapé', 'ANTIOQUIA'),
(402, 'Guataquí', 'CUNDINAMARCA'),
(403, 'Guatavita', 'CUNDINAMARCA'),
(404, 'Guateque', 'BOYACÁ'),
(405, 'Guavatá', 'SANTANDER'),
(406, 'Guayabal de Siquima', 'CUNDINAMARCA'),
(407, 'Guayabetal', 'CUNDINAMARCA'),
(408, 'Guayatá', 'BOYACÁ'),
(409, 'Guepsa', 'SANTANDER'),
(410, 'Guicán', 'BOYACÁ'),
(411, 'Gutiérrez', 'CUNDINAMARCA'),
(412, 'Guática', 'RISARALDA'),
(413, 'Gámbita', 'SANTANDER'),
(414, 'Gámeza', 'BOYACÁ'),
(415, 'Génova', 'QUINDIO'),
(416, 'Gómez Plata', 'ANTIOQUIA'),
(417, 'Hacarí', 'NORTE DE SANTANDER'),
(418, 'Hatillo de Loba', 'BOLÍVAR'),
(419, 'Hato', 'SANTANDER'),
(420, 'Hato Corozal', 'CASANARE'),
(421, 'Hatonuevo', 'LA GUAJIRA'),
(422, 'Heliconia', 'ANTIOQUIA'),
(423, 'Herrán', 'NORTE DE SANTANDER'),
(424, 'Herveo', 'TOLIMA'),
(425, 'Hispania', 'ANTIOQUIA'),
(426, 'Hobo', 'HUILA'),
(427, 'Honda', 'TOLIMA'),
(428, 'Ibagué', 'TOLIMA'),
(429, 'Icononzo', 'TOLIMA'),
(430, 'Iles', 'NARIÑO'),
(431, 'Imúes', 'NARIÑO'),
(432, 'Inzá', 'CAUCA'),
(433, 'Inírida', 'GUAINÍA'),
(434, 'Ipiales', 'NARIÑO'),
(435, 'Isnos', 'HUILA'),
(436, 'Istmina', 'CHOCÓ'),
(437, 'Itagüí', 'ANTIOQUIA'),
(438, 'Ituango', 'ANTIOQUIA'),
(439, 'Izá', 'BOYACÁ'),
(440, 'Jambaló', 'CAUCA'),
(441, 'Jamundí', 'VALLE DEL CAUCA'),
(442, 'Jardín', 'ANTIOQUIA'),
(443, 'Jenesano', 'BOYACÁ'),
(444, 'Jericó', 'ANTIOQUIA'),
(445, 'Jericó', 'BOYACÁ'),
(446, 'Jerusalén', 'CUNDINAMARCA'),
(447, 'Jesús María', 'SANTANDER'),
(448, 'Jordán', 'SANTANDER'),
(449, 'Juan de Acosta', 'ATLÁNTICO'),
(450, 'Junín', 'CUNDINAMARCA'),
(451, 'Juradó', 'CHOCÓ'),
(452, 'La Apartada y La Frontera', 'CÓRDOBA'),
(453, 'La Argentina', 'HUILA'),
(454, 'La Belleza', 'SANTANDER'),
(455, 'La Calera', 'CUNDINAMARCA'),
(456, 'La Capilla', 'BOYACÁ'),
(457, 'La Ceja', 'ANTIOQUIA'),
(458, 'La Celia', 'RISARALDA'),
(459, 'La Cruz', 'NARIÑO'),
(460, 'La Cumbre', 'VALLE DEL CAUCA'),
(461, 'La Dorada', 'CALDAS'),
(462, 'La Esperanza', 'NORTE DE SANTANDER'),
(463, 'La Estrella', 'ANTIOQUIA'),
(464, 'La Florida', 'NARIÑO'),
(465, 'La Gloria', 'CESAR'),
(466, 'La Jagua de Ibirico', 'CESAR'),
(467, 'La Jagua del Pilar', 'LA GUAJIRA'),
(468, 'La Llanada', 'NARIÑO'),
(469, 'La Macarena', 'META'),
(470, 'La Merced', 'CALDAS'),
(471, 'La Mesa', 'CUNDINAMARCA'),
(472, 'La Montañita', 'CAQUETÁ'),
(473, 'La Palma', 'CUNDINAMARCA'),
(474, 'La Paz', 'SANTANDER'),
(475, 'La Paz (Robles)', 'CESAR'),
(476, 'La Peña', 'CUNDINAMARCA'),
(477, 'La Pintada', 'ANTIOQUIA'),
(478, 'La Plata', 'HUILA'),
(479, 'La Playa', 'NORTE DE SANTANDER'),
(480, 'La Primavera', 'VICHADA'),
(481, 'La Salina', 'CASANARE'),
(482, 'La Sierra', 'CAUCA'),
(483, 'La Tebaida', 'QUINDIO'),
(484, 'La Tola', 'NARIÑO'),
(485, 'La Unión', 'ANTIOQUIA'),
(486, 'La Unión', 'NARIÑO'),
(487, 'La Unión', 'SUCRE'),
(488, 'La Unión', 'VALLE DEL CAUCA'),
(489, 'La Uvita', 'BOYACÁ'),
(490, 'La Vega', 'CAUCA'),
(491, 'La Vega', 'CUNDINAMARCA'),
(492, 'La Victoria', 'BOYACÁ'),
(493, 'La Victoria', 'CALDAS'),
(494, 'La Victoria', 'VALLE DEL CAUCA'),
(495, 'La Virginia', 'RISARALDA'),
(496, 'Labateca', 'NORTE DE SANTANDER'),
(497, 'Labranzagrande', 'BOYACÁ'),
(498, 'Landázuri', 'SANTANDER'),
(499, 'Lebrija', 'SANTANDER'),
(500, 'Leiva', 'NARIÑO'),
(501, 'Lejanías', 'META'),
(502, 'Lenguazaque', 'CUNDINAMARCA'),
(503, 'Leticia', 'AMAZONAS'),
(504, 'Liborina', 'ANTIOQUIA'),
(505, 'Linares', 'NARIÑO'),
(506, 'Lloró', 'CHOCÓ'),
(507, 'Lorica', 'CÓRDOBA'),
(508, 'Los Córdobas', 'CÓRDOBA'),
(509, 'Los Palmitos', 'SUCRE'),
(510, 'Los Patios', 'NORTE DE SANTANDER'),
(511, 'Los Santos', 'SANTANDER'),
(512, 'Lourdes', 'NORTE DE SANTANDER'),
(513, 'Luruaco', 'ATLÁNTICO'),
(514, 'Lérida', 'TOLIMA'),
(515, 'Líbano', 'TOLIMA'),
(516, 'López (Micay)', 'CAUCA'),
(517, 'Macanal', 'BOYACÁ'),
(518, 'Macaravita', 'SANTANDER'),
(519, 'Maceo', 'ANTIOQUIA'),
(520, 'Machetá', 'CUNDINAMARCA'),
(521, 'Madrid', 'CUNDINAMARCA'),
(522, 'Magangué', 'BOLÍVAR'),
(523, 'Magüi (Payán)', 'NARIÑO'),
(524, 'Mahates', 'BOLÍVAR'),
(525, 'Maicao', 'LA GUAJIRA'),
(526, 'Majagual', 'SUCRE'),
(527, 'Malambo', 'ATLÁNTICO'),
(528, 'Mallama (Piedrancha)', 'NARIÑO'),
(529, 'Manatí', 'ATLÁNTICO'),
(530, 'Manaure', 'LA GUAJIRA'),
(531, 'Manaure Balcón del Cesar', 'CESAR'),
(532, 'Manizales', 'CALDAS'),
(533, 'Manta', 'CUNDINAMARCA'),
(534, 'Manzanares', 'CALDAS'),
(535, 'Maní', 'CASANARE'),
(536, 'Mapiripan', 'META'),
(537, 'Margarita', 'BOLÍVAR'),
(538, 'Marinilla', 'ANTIOQUIA'),
(539, 'Maripí', 'BOYACÁ'),
(540, 'Mariquita', 'TOLIMA'),
(541, 'Marmato', 'CALDAS'),
(542, 'Marquetalia', 'CALDAS'),
(543, 'Marsella', 'RISARALDA'),
(544, 'Marulanda', 'CALDAS'),
(545, 'María la Baja', 'BOLÍVAR'),
(546, 'Matanza', 'SANTANDER'),
(547, 'Medellín', 'ANTIOQUIA'),
(548, 'Medina', 'CUNDINAMARCA'),
(549, 'Medio Atrato', 'CHOCÓ'),
(550, 'Medio Baudó', 'CHOCÓ'),
(551, 'Medio San Juan (ANDAGOYA)', 'CHOCÓ'),
(552, 'Melgar', 'TOLIMA'),
(553, 'Mercaderes', 'CAUCA'),
(554, 'Mesetas', 'META'),
(555, 'Milán', 'CAQUETÁ'),
(556, 'Miraflores', 'BOYACÁ'),
(557, 'Miraflores', 'GUAVIARE'),
(558, 'Miranda', 'CAUCA'),
(559, 'Mistrató', 'RISARALDA'),
(560, 'Mitú', 'VAUPÉS'),
(561, 'Mocoa', 'PUTUMAYO'),
(562, 'Mogotes', 'SANTANDER'),
(563, 'Molagavita', 'SANTANDER'),
(564, 'Momil', 'CÓRDOBA'),
(565, 'Mompós', 'BOLÍVAR'),
(566, 'Mongua', 'BOYACÁ'),
(567, 'Monguí', 'BOYACÁ'),
(568, 'Moniquirá', 'BOYACÁ'),
(569, 'Montebello', 'ANTIOQUIA'),
(570, 'Montecristo', 'BOLÍVAR'),
(571, 'Montelíbano', 'CÓRDOBA'),
(572, 'Montenegro', 'QUINDIO'),
(573, 'Monteria', 'CÓRDOBA'),
(574, 'Monterrey', 'CASANARE'),
(575, 'Morales', 'BOLÍVAR'),
(576, 'Morales', 'CAUCA'),
(577, 'Morelia', 'CAQUETÁ'),
(578, 'Morroa', 'SUCRE'),
(579, 'Mosquera', 'CUNDINAMARCA'),
(580, 'Mosquera', 'NARIÑO'),
(581, 'Motavita', 'BOYACÁ'),
(582, 'Moñitos', 'CÓRDOBA'),
(583, 'Murillo', 'TOLIMA'),
(584, 'Murindó', 'ANTIOQUIA'),
(585, 'Mutatá', 'ANTIOQUIA'),
(586, 'Mutiscua', 'NORTE DE SANTANDER'),
(587, 'Muzo', 'BOYACÁ'),
(588, 'Málaga', 'SANTANDER'),
(589, 'Nariño', 'ANTIOQUIA'),
(590, 'Nariño', 'CUNDINAMARCA'),
(591, 'Nariño', 'NARIÑO'),
(592, 'Natagaima', 'TOLIMA'),
(593, 'Nechí', 'ANTIOQUIA'),
(594, 'Necoclí', 'ANTIOQUIA'),
(595, 'Neira', 'CALDAS'),
(596, 'Neiva', 'HUILA'),
(597, 'Nemocón', 'CUNDINAMARCA'),
(598, 'Nilo', 'CUNDINAMARCA'),
(599, 'Nimaima', 'CUNDINAMARCA'),
(600, 'Nobsa', 'BOYACÁ'),
(601, 'Nocaima', 'CUNDINAMARCA'),
(602, 'Norcasia', 'CALDAS'),
(603, 'Norosí', 'BOLÍVAR'),
(604, 'Novita', 'CHOCÓ'),
(605, 'Nueva Granada', 'MAGDALENA'),
(606, 'Nuevo Colón', 'BOYACÁ'),
(607, 'Nunchía', 'CASANARE'),
(608, 'Nuquí', 'CHOCÓ'),
(609, 'Nátaga', 'HUILA'),
(610, 'Obando', 'VALLE DEL CAUCA'),
(611, 'Ocamonte', 'SANTANDER'),
(612, 'Ocaña', 'NORTE DE SANTANDER'),
(613, 'Oiba', 'SANTANDER'),
(614, 'Oicatá', 'BOYACÁ'),
(615, 'Olaya', 'ANTIOQUIA'),
(616, 'Olaya Herrera', 'NARIÑO'),
(617, 'Onzaga', 'SANTANDER'),
(618, 'Oporapa', 'HUILA'),
(619, 'Orito', 'PUTUMAYO'),
(620, 'Orocué', 'CASANARE'),
(621, 'Ortega', 'TOLIMA'),
(622, 'Ospina', 'NARIÑO'),
(623, 'Otanche', 'BOYACÁ'),
(624, 'Ovejas', 'SUCRE'),
(625, 'Pachavita', 'BOYACÁ'),
(626, 'Pacho', 'CUNDINAMARCA'),
(627, 'Padilla', 'CAUCA'),
(628, 'Paicol', 'HUILA'),
(629, 'Pailitas', 'CESAR'),
(630, 'Paime', 'CUNDINAMARCA'),
(631, 'Paipa', 'BOYACÁ'),
(632, 'Pajarito', 'BOYACÁ'),
(633, 'Palermo', 'HUILA'),
(634, 'Palestina', 'CALDAS'),
(635, 'Palestina', 'HUILA'),
(636, 'Palmar', 'SANTANDER'),
(637, 'Palmar de Varela', 'ATLÁNTICO'),
(638, 'Palmas del Socorro', 'SANTANDER'),
(639, 'Palmira', 'VALLE DEL CAUCA'),
(640, 'Palmito', 'SUCRE'),
(641, 'Palocabildo', 'TOLIMA'),
(642, 'Pamplona', 'NORTE DE SANTANDER'),
(643, 'Pamplonita', 'NORTE DE SANTANDER'),
(644, 'Pandi', 'CUNDINAMARCA'),
(645, 'Panqueba', 'BOYACÁ'),
(646, 'Paratebueno', 'CUNDINAMARCA'),
(647, 'Pasca', 'CUNDINAMARCA'),
(648, 'Patía (El Bordo)', 'CAUCA'),
(649, 'Pauna', 'BOYACÁ'),
(650, 'Paya', 'BOYACÁ'),
(651, 'Paz de Ariporo', 'CASANARE'),
(652, 'Paz de Río', 'BOYACÁ'),
(653, 'Pedraza', 'MAGDALENA'),
(654, 'Pelaya', 'CESAR'),
(655, 'Pensilvania', 'CALDAS'),
(656, 'Peque', 'ANTIOQUIA'),
(657, 'Pereira', 'RISARALDA'),
(658, 'Pesca', 'BOYACÁ'),
(659, 'Peñol', 'ANTIOQUIA'),
(660, 'Piamonte', 'CAUCA'),
(661, 'Pie de Cuesta', 'SANTANDER'),
(662, 'Piedras', 'TOLIMA'),
(663, 'Piendamó', 'CAUCA'),
(664, 'Pijao', 'QUINDIO'),
(665, 'Pijiño', 'MAGDALENA'),
(666, 'Pinchote', 'SANTANDER'),
(667, 'Pinillos', 'BOLÍVAR'),
(668, 'Piojo', 'ATLÁNTICO'),
(669, 'Pisva', 'BOYACÁ'),
(670, 'Pital', 'HUILA'),
(671, 'Pitalito', 'HUILA'),
(672, 'Pivijay', 'MAGDALENA'),
(673, 'Planadas', 'TOLIMA'),
(674, 'Planeta Rica', 'CÓRDOBA'),
(675, 'Plato', 'MAGDALENA'),
(676, 'Policarpa', 'NARIÑO'),
(677, 'Polonuevo', 'ATLÁNTICO'),
(678, 'Ponedera', 'ATLÁNTICO'),
(679, 'Popayán', 'CAUCA'),
(680, 'Pore', 'CASANARE'),
(681, 'Potosí', 'NARIÑO'),
(682, 'Pradera', 'VALLE DEL CAUCA'),
(683, 'Prado', 'TOLIMA'),
(684, 'Providencia', 'NARIÑO'),
(685, 'Providencia', 'ARCHIPIÉLAGO DE SAN ANDRÉS, PROVIDENCIA Y SANTA CATALINA'),
(686, 'Pueblo Bello', 'CESAR'),
(687, 'Pueblo Nuevo', 'CÓRDOBA'),
(688, 'Pueblo Rico', 'RISARALDA'),
(689, 'Pueblorrico', 'ANTIOQUIA'),
(690, 'Puebloviejo', 'MAGDALENA'),
(691, 'Puente Nacional', 'SANTANDER'),
(692, 'Puerres', 'NARIÑO'),
(693, 'Puerto Asís', 'PUTUMAYO'),
(694, 'Puerto Berrío', 'ANTIOQUIA'),
(695, 'Puerto Boyacá', 'BOYACÁ'),
(696, 'Puerto Caicedo', 'PUTUMAYO'),
(697, 'Puerto Carreño', 'VICHADA'),
(698, 'Puerto Colombia', 'ATLÁNTICO'),
(699, 'Puerto Concordia', 'META'),
(700, 'Puerto Escondido', 'CÓRDOBA'),
(701, 'Puerto Gaitán', 'META'),
(702, 'Puerto Guzmán', 'PUTUMAYO'),
(703, 'Puerto Leguízamo', 'PUTUMAYO'),
(704, 'Puerto Libertador', 'CÓRDOBA'),
(705, 'Puerto Lleras', 'META'),
(706, 'Puerto López', 'META'),
(707, 'Puerto Nare', 'ANTIOQUIA'),
(708, 'Puerto Nariño', 'AMAZONAS'),
(709, 'Puerto Parra', 'SANTANDER'),
(710, 'Puerto Rico', 'CAQUETÁ'),
(711, 'Puerto Rico', 'META'),
(712, 'Puerto Rondón', 'ARAUCA'),
(713, 'Puerto Salgar', 'CUNDINAMARCA'),
(714, 'Puerto Santander', 'NORTE DE SANTANDER'),
(715, 'Puerto Tejada', 'CAUCA'),
(716, 'Puerto Triunfo', 'ANTIOQUIA'),
(717, 'Puerto Wilches', 'SANTANDER'),
(718, 'Pulí', 'CUNDINAMARCA'),
(719, 'Pupiales', 'NARIÑO'),
(720, 'Puracé (Coconuco)', 'CAUCA'),
(721, 'Purificación', 'TOLIMA'),
(722, 'Purísima', 'CÓRDOBA'),
(723, 'Pácora', 'CALDAS'),
(724, 'Páez', 'BOYACÁ'),
(725, 'Páez (Belalcazar)', 'CAUCA'),
(726, 'Páramo', 'SANTANDER'),
(727, 'Quebradanegra', 'CUNDINAMARCA'),
(728, 'Quetame', 'CUNDINAMARCA'),
(729, 'Quibdó', 'CHOCÓ'),
(730, 'Quimbaya', 'QUINDIO'),
(731, 'Quinchía', 'RISARALDA'),
(732, 'Quipama', 'BOYACÁ'),
(733, 'Quipile', 'CUNDINAMARCA'),
(734, 'Ragonvalia', 'NORTE DE SANTANDER'),
(735, 'Ramiriquí', 'BOYACÁ'),
(736, 'Recetor', 'CASANARE'),
(737, 'Regidor', 'BOLÍVAR'),
(738, 'Remedios', 'ANTIOQUIA'),
(739, 'Remolino', 'MAGDALENA'),
(740, 'Repelón', 'ATLÁNTICO'),
(741, 'Restrepo', 'META'),
(742, 'Restrepo', 'VALLE DEL CAUCA'),
(743, 'Retiro', 'ANTIOQUIA'),
(744, 'Ricaurte', 'CUNDINAMARCA'),
(745, 'Ricaurte', 'NARIÑO'),
(746, 'Rio Negro', 'SANTANDER'),
(747, 'Rioblanco', 'TOLIMA'),
(748, 'Riofrío', 'VALLE DEL CAUCA'),
(749, 'Riohacha', 'LA GUAJIRA'),
(750, 'Risaralda', 'CALDAS'),
(751, 'Rivera', 'HUILA'),
(752, 'Roberto Payán (San José)', 'NARIÑO'),
(753, 'Roldanillo', 'VALLE DEL CAUCA'),
(754, 'Roncesvalles', 'TOLIMA'),
(755, 'Rondón', 'BOYACÁ'),
(756, 'Rosas', 'CAUCA'),
(757, 'Rovira', 'TOLIMA'),
(758, 'Ráquira', 'BOYACÁ'),
(759, 'Río Iró', 'CHOCÓ'),
(760, 'Río Quito', 'CHOCÓ'),
(761, 'Río Sucio', 'CALDAS'),
(762, 'Río Viejo', 'BOLÍVAR'),
(763, 'Río de oro', 'CESAR'),
(764, 'Ríonegro', 'ANTIOQUIA'),
(765, 'Ríosucio', 'CHOCÓ'),
(766, 'Sabana de Torres', 'SANTANDER'),
(767, 'Sabanagrande', 'ATLÁNTICO'),
(768, 'Sabanalarga', 'ANTIOQUIA'),
(769, 'Sabanalarga', 'ATLÁNTICO'),
(770, 'Sabanalarga', 'CASANARE'),
(771, 'Sabanas de San Angel (SAN ANGEL)', 'MAGDALENA'),
(772, 'Sabaneta', 'ANTIOQUIA'),
(773, 'Saboyá', 'BOYACÁ'),
(774, 'Sahagún', 'CÓRDOBA'),
(775, 'Saladoblanco', 'HUILA'),
(776, 'Salamina', 'CALDAS'),
(777, 'Salamina', 'MAGDALENA'),
(778, 'Salazar', 'NORTE DE SANTANDER'),
(779, 'Saldaña', 'TOLIMA'),
(780, 'Salento', 'QUINDIO'),
(781, 'Salgar', 'ANTIOQUIA'),
(782, 'Samacá', 'BOYACÁ'),
(783, 'Samaniego', 'NARIÑO'),
(784, 'Samaná', 'CALDAS'),
(785, 'Sampués', 'SUCRE'),
(786, 'San Agustín', 'HUILA'),
(787, 'San Alberto', 'CESAR'),
(788, 'San Andrés', 'SANTANDER'),
(789, 'San Andrés Sotavento', 'CÓRDOBA'),
(790, 'San Andrés de Cuerquía', 'ANTIOQUIA'),
(791, 'San Antero', 'CÓRDOBA'),
(792, 'San Antonio', 'TOLIMA'),
(793, 'San Antonio de Tequendama', 'CUNDINAMARCA'),
(794, 'San Benito', 'SANTANDER'),
(795, 'San Benito Abad', 'SUCRE'),
(796, 'San Bernardo', 'CUNDINAMARCA'),
(797, 'San Bernardo', 'NARIÑO'),
(798, 'San Bernardo del Viento', 'CÓRDOBA'),
(799, 'San Calixto', 'NORTE DE SANTANDER'),
(800, 'San Carlos', 'ANTIOQUIA'),
(801, 'San Carlos', 'CÓRDOBA'),
(802, 'San Carlos de Guaroa', 'META'),
(803, 'San Cayetano', 'CUNDINAMARCA'),
(804, 'San Cayetano', 'NORTE DE SANTANDER'),
(805, 'San Cristobal', 'BOLÍVAR'),
(806, 'San Diego', 'CESAR'),
(807, 'San Eduardo', 'BOYACÁ'),
(808, 'San Estanislao', 'BOLÍVAR'),
(809, 'San Fernando', 'BOLÍVAR'),
(810, 'San Francisco', 'ANTIOQUIA'),
(811, 'San Francisco', 'CUNDINAMARCA'),
(812, 'San Francisco', 'PUTUMAYO'),
(813, 'San Gíl', 'SANTANDER'),
(814, 'San Jacinto', 'BOLÍVAR'),
(815, 'San Jacinto del Cauca', 'BOLÍVAR'),
(816, 'San Jerónimo', 'ANTIOQUIA'),
(817, 'San Joaquín', 'SANTANDER'),
(818, 'San José', 'CALDAS'),
(819, 'San José de Miranda', 'SANTANDER'),
(820, 'San José de Montaña', 'ANTIOQUIA'),
(821, 'San José de Pare', 'BOYACÁ'),
(822, 'San José de Uré', 'CÓRDOBA'),
(823, 'San José del Fragua', 'CAQUETÁ'),
(824, 'San José del Guaviare', 'GUAVIARE'),
(825, 'San José del Palmar', 'CHOCÓ'),
(826, 'San Juan de Arama', 'META'),
(827, 'San Juan de Betulia', 'SUCRE'),
(828, 'San Juan de Nepomuceno', 'BOLÍVAR'),
(829, 'San Juan de Pasto', 'NARIÑO'),
(830, 'San Juan de Río Seco', 'CUNDINAMARCA'),
(831, 'San Juan de Urabá', 'ANTIOQUIA'),
(832, 'San Juan del Cesar', 'LA GUAJIRA'),
(833, 'San Juanito', 'META'),
(834, 'San Lorenzo', 'NARIÑO'),
(835, 'San Luis', 'TOLIMA'),
(836, 'San Luís', 'ANTIOQUIA'),
(837, 'San Luís de Gaceno', 'BOYACÁ'),
(838, 'San Luís de Palenque', 'CASANARE'),
(839, 'San Marcos', 'SUCRE'),
(840, 'San Martín', 'CESAR'),
(841, 'San Martín', 'META'),
(842, 'San Martín de Loba', 'BOLÍVAR'),
(843, 'San Mateo', 'BOYACÁ'),
(844, 'San Miguel', 'SANTANDER'),
(845, 'San Miguel', 'PUTUMAYO'),
(846, 'San Miguel de Sema', 'BOYACÁ'),
(847, 'San Onofre', 'SUCRE'),
(848, 'San Pablo', 'BOLÍVAR'),
(849, 'San Pablo', 'NARIÑO'),
(850, 'San Pablo de Borbur', 'BOYACÁ'),
(851, 'San Pedro', 'ANTIOQUIA'),
(852, 'San Pedro', 'SUCRE'),
(853, 'San Pedro', 'VALLE DEL CAUCA'),
(854, 'San Pedro de Cartago', 'NARIÑO'),
(855, 'San Pedro de Urabá', 'ANTIOQUIA'),
(856, 'San Pelayo', 'CÓRDOBA'),
(857, 'San Rafael', 'ANTIOQUIA'),
(858, 'San Roque', 'ANTIOQUIA'),
(859, 'San Sebastián', 'CAUCA'),
(860, 'San Sebastián de Buenavista', 'MAGDALENA'),
(861, 'San Vicente', 'ANTIOQUIA'),
(862, 'San Vicente del Caguán', 'CAQUETÁ'),
(863, 'San Vicente del Chucurí', 'SANTANDER'),
(864, 'San Zenón', 'MAGDALENA'),
(865, 'Sandoná', 'NARIÑO'),
(866, 'Santa Ana', 'MAGDALENA'),
(867, 'Santa Bárbara', 'ANTIOQUIA'),
(868, 'Santa Bárbara', 'SANTANDER'),
(869, 'Santa Bárbara (Iscuandé)', 'NARIÑO'),
(870, 'Santa Bárbara de Pinto', 'MAGDALENA'),
(871, 'Santa Catalina', 'BOLÍVAR'),
(872, 'Santa Fé de Antioquia', 'ANTIOQUIA'),
(873, 'Santa Genoveva de Docorodó', 'CHOCÓ'),
(874, 'Santa Helena del Opón', 'SANTANDER'),
(875, 'Santa Isabel', 'TOLIMA'),
(876, 'Santa Lucía', 'ATLÁNTICO'),
(877, 'Santa Marta', 'MAGDALENA'),
(878, 'Santa María', 'BOYACÁ'),
(879, 'Santa María', 'HUILA'),
(880, 'Santa Rosa', 'BOLÍVAR'),
(881, 'Santa Rosa', 'CAUCA'),
(882, 'Santa Rosa de Cabal', 'RISARALDA'),
(883, 'Santa Rosa de Osos', 'ANTIOQUIA'),
(884, 'Santa Rosa de Viterbo', 'BOYACÁ'),
(885, 'Santa Rosa del Sur', 'BOLÍVAR'),
(886, 'Santa Rosalía', 'VICHADA'),
(887, 'Santa Sofía', 'BOYACÁ'),
(888, 'Santana', 'BOYACÁ'),
(889, 'Santander de Quilichao', 'CAUCA'),
(890, 'Santiago', 'NORTE DE SANTANDER'),
(891, 'Santiago', 'PUTUMAYO'),
(892, 'Santo Domingo', 'ANTIOQUIA'),
(893, 'Santo Tomás', 'ATLÁNTICO'),
(894, 'Santuario', 'ANTIOQUIA'),
(895, 'Santuario', 'RISARALDA'),
(896, 'Sapuyes', 'NARIÑO'),
(897, 'Saravena', 'ARAUCA'),
(898, 'Sardinata', 'NORTE DE SANTANDER'),
(899, 'Sasaima', 'CUNDINAMARCA'),
(900, 'Sativanorte', 'BOYACÁ'),
(901, 'Sativasur', 'BOYACÁ'),
(902, 'Segovia', 'ANTIOQUIA'),
(903, 'Sesquilé', 'CUNDINAMARCA'),
(904, 'Sevilla', 'VALLE DEL CAUCA'),
(905, 'Siachoque', 'BOYACÁ'),
(906, 'Sibaté', 'CUNDINAMARCA'),
(907, 'Sibundoy', 'PUTUMAYO'),
(908, 'Silos', 'NORTE DE SANTANDER'),
(909, 'Silvania', 'CUNDINAMARCA'),
(910, 'Silvia', 'CAUCA'),
(911, 'Simacota', 'SANTANDER'),
(912, 'Simijaca', 'CUNDINAMARCA'),
(913, 'Simití', 'BOLÍVAR'),
(914, 'Sincelejo', 'SUCRE'),
(915, 'Sincé', 'SUCRE'),
(916, 'Sipí', 'CHOCÓ'),
(917, 'Sitionuevo', 'MAGDALENA'),
(918, 'Soacha', 'CUNDINAMARCA'),
(919, 'Soatá', 'BOYACÁ'),
(920, 'Socha', 'BOYACÁ'),
(921, 'Socorro', 'SANTANDER'),
(922, 'Socotá', 'BOYACÁ'),
(923, 'Sogamoso', 'BOYACÁ'),
(924, 'Solano', 'CAQUETÁ'),
(925, 'Soledad', 'ATLÁNTICO'),
(926, 'Solita', 'CAQUETÁ'),
(927, 'Somondoco', 'BOYACÁ'),
(928, 'Sonsón', 'ANTIOQUIA'),
(929, 'Sopetrán', 'ANTIOQUIA'),
(930, 'Soplaviento', 'BOLÍVAR'),
(931, 'Sopó', 'CUNDINAMARCA'),
(932, 'Sora', 'BOYACÁ'),
(933, 'Soracá', 'BOYACÁ'),
(934, 'Sotaquirá', 'BOYACÁ'),
(935, 'Sotara (Paispamba)', 'CAUCA'),
(936, 'Sotomayor (Los Andes)', 'NARIÑO'),
(937, 'Suaita', 'SANTANDER'),
(938, 'Suan', 'ATLÁNTICO'),
(939, 'Suaza', 'HUILA'),
(940, 'Subachoque', 'CUNDINAMARCA'),
(941, 'Sucre', 'CAUCA'),
(942, 'Sucre', 'SANTANDER'),
(943, 'Sucre', 'SUCRE'),
(944, 'Suesca', 'CUNDINAMARCA'),
(945, 'Supatá', 'CUNDINAMARCA'),
(946, 'Supía', 'CALDAS'),
(947, 'Suratá', 'SANTANDER'),
(948, 'Susa', 'CUNDINAMARCA'),
(949, 'Susacón', 'BOYACÁ'),
(950, 'Sutamarchán', 'BOYACÁ'),
(951, 'Sutatausa', 'CUNDINAMARCA'),
(952, 'Sutatenza', 'BOYACÁ'),
(953, 'Suárez', 'CAUCA'),
(954, 'Suárez', 'TOLIMA'),
(955, 'Sácama', 'CASANARE'),
(956, 'Sáchica', 'BOYACÁ'),
(957, 'Tabio', 'CUNDINAMARCA'),
(958, 'Tadó', 'CHOCÓ'),
(959, 'Talaigua Nuevo', 'BOLÍVAR'),
(960, 'Tamalameque', 'CESAR'),
(961, 'Tame', 'ARAUCA'),
(962, 'Taminango', 'NARIÑO'),
(963, 'Tangua', 'NARIÑO'),
(964, 'Taraira', 'VAUPÉS'),
(965, 'Tarazá', 'ANTIOQUIA'),
(966, 'Tarqui', 'HUILA'),
(967, 'Tarso', 'ANTIOQUIA'),
(968, 'Tasco', 'BOYACÁ'),
(969, 'Tauramena', 'CASANARE'),
(970, 'Tausa', 'CUNDINAMARCA'),
(971, 'Tello', 'HUILA'),
(972, 'Tena', 'CUNDINAMARCA'),
(973, 'Tenerife', 'MAGDALENA'),
(974, 'Tenjo', 'CUNDINAMARCA'),
(975, 'Tenza', 'BOYACÁ'),
(976, 'Teorama', 'NORTE DE SANTANDER'),
(977, 'Teruel', 'HUILA'),
(978, 'Tesalia', 'HUILA'),
(979, 'Tibacuy', 'CUNDINAMARCA'),
(980, 'Tibaná', 'BOYACÁ'),
(981, 'Tibasosa', 'BOYACÁ'),
(982, 'Tibirita', 'CUNDINAMARCA'),
(983, 'Tibú', 'NORTE DE SANTANDER'),
(984, 'Tierralta', 'CÓRDOBA'),
(985, 'Timaná', 'HUILA'),
(986, 'Timbiquí', 'CAUCA'),
(987, 'Timbío', 'CAUCA'),
(988, 'Tinjacá', 'BOYACÁ'),
(989, 'Tipacoque', 'BOYACÁ'),
(990, 'Tiquisio (Puerto Rico)', 'BOLÍVAR'),
(991, 'Titiribí', 'ANTIOQUIA'),
(992, 'Toca', 'BOYACÁ'),
(993, 'Tocaima', 'CUNDINAMARCA'),
(994, 'Tocancipá', 'CUNDINAMARCA'),
(995, 'Toguí', 'BOYACÁ'),
(996, 'Toledo', 'ANTIOQUIA'),
(997, 'Toledo', 'NORTE DE SANTANDER'),
(998, 'Tolú', 'SUCRE'),
(999, 'Tolú Viejo', 'SUCRE'),
(1000, 'Tona', 'SANTANDER'),
(1001, 'Topagá', 'BOYACÁ'),
(1002, 'Topaipí', 'CUNDINAMARCA'),
(1003, 'Toribío', 'CAUCA'),
(1004, 'Toro', 'VALLE DEL CAUCA'),
(1005, 'Tota', 'BOYACÁ'),
(1006, 'Totoró', 'CAUCA'),
(1007, 'Trinidad', 'CASANARE'),
(1008, 'Trujillo', 'VALLE DEL CAUCA'),
(1009, 'Tubará', 'ATLÁNTICO'),
(1010, 'Tuchín', 'CÓRDOBA'),
(1011, 'Tulúa', 'VALLE DEL CAUCA'),
(1012, 'Tumaco', 'NARIÑO'),
(1013, 'Tunja', 'BOYACÁ'),
(1014, 'Tunungua', 'BOYACÁ'),
(1015, 'Turbaco', 'BOLÍVAR'),
(1016, 'Turbaná', 'BOLÍVAR'),
(1017, 'Turbo', 'ANTIOQUIA'),
(1018, 'Turmequé', 'BOYACÁ'),
(1019, 'Tuta', 'BOYACÁ'),
(1020, 'Tutasá', 'BOYACÁ'),
(1021, 'Támara', 'CASANARE'),
(1022, 'Támesis', 'ANTIOQUIA'),
(1023, 'Túquerres', 'NARIÑO'),
(1024, 'Ubalá', 'CUNDINAMARCA'),
(1025, 'Ubaque', 'CUNDINAMARCA'),
(1026, 'Ubaté', 'CUNDINAMARCA'),
(1027, 'Ulloa', 'VALLE DEL CAUCA'),
(1028, 'Une', 'CUNDINAMARCA'),
(1029, 'Unguía', 'CHOCÓ'),
(1030, 'Unión Panamericana (ÁNIMAS)', 'CHOCÓ'),
(1031, 'Uramita', 'ANTIOQUIA'),
(1032, 'Uribe', 'META'),
(1033, 'Uribia', 'LA GUAJIRA'),
(1034, 'Urrao', 'ANTIOQUIA'),
(1035, 'Urumita', 'LA GUAJIRA'),
(1036, 'Usiacuri', 'ATLÁNTICO'),
(1037, 'Valdivia', 'ANTIOQUIA'),
(1038, 'Valencia', 'CÓRDOBA'),
(1039, 'Valle de San José', 'SANTANDER'),
(1040, 'Valle de San Juan', 'TOLIMA'),
(1041, 'Valle del Guamuez', 'PUTUMAYO'),
(1042, 'Valledupar', 'CESAR'),
(1043, 'Valparaiso', 'ANTIOQUIA'),
(1044, 'Valparaiso', 'CAQUETÁ'),
(1045, 'Vegachí', 'ANTIOQUIA'),
(1046, 'Venadillo', 'TOLIMA'),
(1047, 'Venecia', 'ANTIOQUIA'),
(1048, 'Venecia (Ospina Pérez)', 'CUNDINAMARCA'),
(1049, 'Ventaquemada', 'BOYACÁ'),
(1050, 'Vergara', 'CUNDINAMARCA'),
(1051, 'Versalles', 'VALLE DEL CAUCA'),
(1052, 'Vetas', 'SANTANDER'),
(1053, 'Viani', 'CUNDINAMARCA'),
(1054, 'Vigía del Fuerte', 'ANTIOQUIA'),
(1055, 'Vijes', 'VALLE DEL CAUCA'),
(1056, 'Villa Caro', 'NORTE DE SANTANDER'),
(1057, 'Villa Rica', 'CAUCA'),
(1058, 'Villa de Leiva', 'BOYACÁ'),
(1059, 'Villa del Rosario', 'NORTE DE SANTANDER'),
(1060, 'Villagarzón', 'PUTUMAYO'),
(1061, 'Villagómez', 'CUNDINAMARCA'),
(1062, 'Villahermosa', 'TOLIMA'),
(1063, 'Villamaría', 'CALDAS'),
(1064, 'Villanueva', 'BOLÍVAR'),
(1065, 'Villanueva', 'LA GUAJIRA'),
(1066, 'Villanueva', 'SANTANDER'),
(1067, 'Villanueva', 'CASANARE'),
(1068, 'Villapinzón', 'CUNDINAMARCA'),
(1069, 'Villarrica', 'TOLIMA'),
(1070, 'Villavicencio', 'META'),
(1071, 'Villavieja', 'HUILA'),
(1072, 'Villeta', 'CUNDINAMARCA'),
(1073, 'Viotá', 'CUNDINAMARCA'),
(1074, 'Viracachá', 'BOYACÁ'),
(1075, 'Vista Hermosa', 'META'),
(1076, 'Viterbo', 'CALDAS'),
(1077, 'Vélez', 'SANTANDER'),
(1078, 'Yacopí', 'CUNDINAMARCA'),
(1079, 'Yacuanquer', 'NARIÑO'),
(1080, 'Yaguará', 'HUILA'),
(1081, 'Yalí', 'ANTIOQUIA'),
(1082, 'Yarumal', 'ANTIOQUIA'),
(1083, 'Yolombó', 'ANTIOQUIA'),
(1084, 'Yondó (Casabe)', 'ANTIOQUIA'),
(1085, 'Yopal', 'CASANARE'),
(1086, 'Yotoco', 'VALLE DEL CAUCA'),
(1087, 'Yumbo', 'VALLE DEL CAUCA'),
(1088, 'Zambrano', 'BOLÍVAR'),
(1089, 'Zapatoca', 'SANTANDER'),
(1090, 'Zapayán (PUNTA DE PIEDRAS)', 'MAGDALENA'),
(1091, 'Zaragoza', 'ANTIOQUIA'),
(1092, 'Zarzal', 'VALLE DEL CAUCA'),
(1093, 'Zetaquirá', 'BOYACÁ'),
(1094, 'Zipacón', 'CUNDINAMARCA'),
(1095, 'Zipaquirá', 'CUNDINAMARCA'),
(1096, 'Zona Bananera (PRADO - SEVILLA)', 'MAGDALENA'),
(1097, 'Ábrego', 'NORTE DE SANTANDER'),
(1098, 'Íquira', 'HUILA'),
(1099, 'Úmbita', 'BOYACÁ'),
(1100, 'Útica', 'CUNDINAMARCA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleproducto`
--

CREATE TABLE `detalleproducto` (
  `Oferta_idOferta` int(11) UNSIGNED NOT NULL COMMENT 'Llave foránea de oferta',
  `Producto_idProducto` int(11) UNSIGNED NOT NULL COMMENT 'Llave foránea de producto',
  `precio` double NOT NULL COMMENT 'Atributo precio de la publicación.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla en la que se detalla el precio de la oferta y se relaciona a una imagen o grupo de imágenes que se encuentran en la web.' PACK_KEYS=0;

--
-- Volcado de datos para la tabla `detalleproducto`
--

INSERT INTO `detalleproducto` (`Oferta_idOferta`, `Producto_idProducto`, `precio`) VALUES
(9, 7, 60000),
(15, 8, 26),
(17, 9, 8),
(19, 10, 1548),
(21, 11, 177777),
(23, 12, 1999),
(25, 13, 1123456),
(27, 14, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleproducto_tiene_imagen`
--

CREATE TABLE `detalleproducto_tiene_imagen` (
  `Id_DetalleProducto_tiene_Imagen` int(11) NOT NULL,
  `Imagen_idImagen` int(11) UNSIGNED NOT NULL,
  `DetalleProducto_Oferta_idOferta` int(11) UNSIGNED NOT NULL,
  `DetalleProducto_Producto_idProducto` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla donde se relacionan las imágenes a sus respectivas ofertas.' PACK_KEYS=0;

--
-- Volcado de datos para la tabla `detalleproducto_tiene_imagen`
--

INSERT INTO `detalleproducto_tiene_imagen` (`Id_DetalleProducto_tiene_Imagen`, `Imagen_idImagen`, `DetalleProducto_Oferta_idOferta`, `DetalleProducto_Producto_idProducto`) VALUES
(6, 5, 9, 7),
(7, 10, 27, 14);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imagen`
--

CREATE TABLE `imagen` (
  `idImagen` int(11) UNSIGNED NOT NULL COMMENT 'Identificador único de imagen en el sistema',
  `linkImagen` varchar(45) DEFAULT NULL COMMENT 'Link web de la imagen del producto',
  `foto` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla para guardar la especificación de cada imagen que se usa en las publicaciones y su link web.' PACK_KEYS=0;

--
-- Volcado de datos para la tabla `imagen`
--

INSERT INTO `imagen` (`idImagen`, `linkImagen`, `foto`) VALUES
(5, '', 0x00),
(6, '', 0x00),
(7, '', 0x00),
(8, '', 0x41),
(9, '', 0x41),
(10, '', 0x41);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marca`
--

CREATE TABLE `marca` (
  `idMarca` int(11) UNSIGNED NOT NULL COMMENT 'Identificador único de marca',
  `nombreMarca` varchar(45) DEFAULT NULL COMMENT 'Atributo nombreMarca, ingresado por el administrador.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla que almacena las marcas de los productos de manera única' PACK_KEYS=0;

--
-- Volcado de datos para la tabla `marca`
--

INSERT INTO `marca` (`idMarca`, `nombreMarca`) VALUES
(1, 'SONY'),
(2, 'Samsung'),
(3, 'Adidas'),
(4, 'Fila'),
(5, 'Ford'),
(6, 'Renault'),
(7, 'Toshiba'),
(8, 'Acer'),
(9, 'Rebook'),
(10, 'Duncan'),
(12, 'Huawei'),
(13, 'Genius'),
(14, 'coca cola'),
(15, 'pelikan'),
(16, 'zsrgzs'),
(17, 'acer'),
(18, 'samsung'),
(19, 'tttttt'),
(20, 'q&q'),
(21, 'ghj'),
(22, 'ghj'),
(23, 'dfg'),
(24, 'dfg'),
(25, 'jkl'),
(26, 'jkl'),
(27, 'iop'),
(28, 'iop'),
(29, 'ghj'),
(30, 'ghj'),
(31, 'df'),
(32, 'df'),
(33, 'kl'),
(34, 'kl');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oferta`
--

CREATE TABLE `oferta` (
  `idOferta` int(11) UNSIGNED NOT NULL COMMENT 'Identificador único de la oferta',
  `Usuario_idUsuario` int(11) UNSIGNED NOT NULL COMMENT 'Llave foránea de usuario',
  `nombreOferta` varchar(45) NOT NULL COMMENT 'Atributo nombre de la oferta',
  `fechaCreacion` datetime NOT NULL COMMENT 'Atributo fecha de creación de la oferta, capturada por el sistema',
  `fechaInicio` datetime NOT NULL COMMENT 'Atributo fecha de inicio de la oferta, ingresado por el usuario.',
  `fechaFin` datetime NOT NULL COMMENT 'Atributo fecha de finalizaciónde la oferta, ingresado por el usuario',
  `vecesCompartida` int(11) UNSIGNED NOT NULL DEFAULT '0' COMMENT 'Atributo veces compartida, actualizado por la plataforma cada vez que se comparte la oferta en redes sociales'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla para guradar los datos principales de la oferta, relacionandola a un usuario que es quien la publlica, las fechas de creación, inicio y fin y las veces que se compartión en redes sociales.' PACK_KEYS=0;

--
-- Volcado de datos para la tabla `oferta`
--

INSERT INTO `oferta` (`idOferta`, `Usuario_idUsuario`, `nombreOferta`, `fechaCreacion`, `fechaInicio`, `fechaFin`, `vecesCompartida`) VALUES
(9, 3, 'reloj q&q', '2019-03-26 00:00:00', '2019-03-26 00:00:00', '2019-03-31 00:00:00', 0),
(10, 3, 'asd', '2019-03-31 00:00:00', '2019-03-31 00:00:00', '2019-03-31 00:00:00', 0),
(11, 3, 'asd', '2019-03-31 00:00:00', '2019-03-31 00:00:00', '2019-03-31 00:00:00', 0),
(12, 3, 'zxc', '2019-04-01 00:00:00', '2019-04-02 00:00:00', '2019-04-17 00:00:00', 0),
(13, 3, 'zxc', '2019-04-01 00:00:00', '2019-04-02 00:00:00', '2019-04-17 00:00:00', 0),
(14, 3, 'hgj', '2019-04-01 00:00:00', '2019-04-17 00:00:00', '2019-04-25 00:00:00', 0),
(15, 3, 'hgj', '2019-04-01 00:00:00', '2019-04-17 00:00:00', '2019-04-25 00:00:00', 0),
(16, 3, 'dfg', '2019-04-01 00:00:00', '2019-04-02 00:00:00', '2019-04-09 00:00:00', 0),
(17, 3, 'dfg', '2019-04-01 00:00:00', '2019-04-02 00:00:00', '2019-04-09 00:00:00', 0),
(18, 3, 'jkl', '2019-04-01 00:00:00', '2019-04-02 00:00:00', '2019-04-09 00:00:00', 0),
(19, 3, 'jkl', '2019-04-01 00:00:00', '2019-04-02 00:00:00', '2019-04-09 00:00:00', 0),
(20, 3, 'iop', '2019-04-01 00:00:00', '2019-04-19 00:00:00', '2019-04-26 00:00:00', 0),
(21, 3, 'iop', '2019-04-01 00:00:00', '2019-04-19 00:00:00', '2019-04-26 00:00:00', 0),
(22, 3, 'ghj', '2019-04-01 00:00:00', '2019-04-12 00:00:00', '2019-04-26 00:00:00', 0),
(23, 3, 'ghj', '2019-04-01 00:00:00', '2019-04-12 00:00:00', '2019-04-26 00:00:00', 0),
(24, 3, 'df', '2019-04-01 00:00:00', '2019-04-02 00:00:00', '2019-04-09 00:00:00', 0),
(25, 3, 'df', '2019-04-01 00:00:00', '2019-04-02 00:00:00', '2019-04-09 00:00:00', 0),
(26, 3, 'kl', '2019-04-01 00:00:00', '2019-04-02 00:00:00', '2019-04-09 00:00:00', 0),
(27, 3, 'kl', '2019-04-01 00:00:00', '2019-04-02 00:00:00', '2019-04-09 00:00:00', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oferta_tiene_ubicacion`
--

CREATE TABLE `oferta_tiene_ubicacion` (
  `Id_Oferta_tiene_Ubicacion` int(11) NOT NULL,
  `Oferta_idOferta` int(11) UNSIGNED NOT NULL,
  `Ubicacion_idUbicacion` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla donde se relaciona cada oferta con una o muchas ubicaciones en las que se puede encontrar' PACK_KEYS=0;

--
-- Volcado de datos para la tabla `oferta_tiene_ubicacion`
--

INSERT INTO `oferta_tiene_ubicacion` (`Id_Oferta_tiene_Ubicacion`, `Oferta_idOferta`, `Ubicacion_idUbicacion`) VALUES
(8, 9, 111),
(9, 15, 116),
(10, 17, 117),
(11, 19, 118),
(12, 21, 119),
(13, 23, 120),
(14, 25, 121),
(15, 27, 122);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) UNSIGNED NOT NULL COMMENT 'Identificador único de producto, generado por el sistema.',
  `Categoria_idCategoria` int(11) UNSIGNED NOT NULL COMMENT 'Llave foránea de tipo de producto.',
  `Marca_idMarca` int(11) UNSIGNED NOT NULL COMMENT 'Llave foránea de marca del producto.',
  `nombreProducto` varchar(45) DEFAULT NULL COMMENT 'Atributo nombreProducto, ingresado por el administrador'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla donde se relacionan las características del producto como nombre, fabricante, modelo y presentación, asi como su tipo y marca.' PACK_KEYS=0;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `Categoria_idCategoria`, `Marca_idMarca`, `nombreProducto`) VALUES
(1, 1, 14, 'coca cola no retornable 400ml'),
(2, 2, 15, 'marcador pelikan'),
(3, 3, 16, 'gzdgrg'),
(4, 4, 17, 'computador acer'),
(5, 5, 18, 'celular samsung'),
(6, 6, 19, 'tttttt'),
(7, 7, 20, 'reloj q&q'),
(8, 8, 22, 'ghj'),
(9, 9, 24, 'dfg'),
(10, 10, 26, 'jkl'),
(11, 11, 28, 'iop'),
(12, 12, 30, 'ghj'),
(13, 13, 32, 'df'),
(14, 14, 34, 'kl');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo`
--

CREATE TABLE `tipo` (
  `idTipo` int(11) UNSIGNED NOT NULL COMMENT 'Identificador único de tipo de producto, generado por el sistema',
  `Categoria_idCategoria` int(11) UNSIGNED NOT NULL COMMENT 'Llave foránea de categoría',
  `nombreTipo` varchar(45) DEFAULT NULL COMMENT 'Atributo nombreTipo, ingresado por el administrador.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla donde se listan los tipos de producto que se pueden seleccionar.' PACK_KEYS=0;

--
-- Volcado de datos para la tabla `tipo`
--

INSERT INTO `tipo` (`idTipo`, `Categoria_idCategoria`, `nombreTipo`) VALUES
(1, 1, 'bebida'),
(2, 2, 'marcador'),
(3, 3, 'dzgzdgz'),
(4, 4, 'computador'),
(5, 5, 'celulares'),
(6, 6, 'ttttt'),
(7, 7, 'adorno');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ubicacion`
--

CREATE TABLE `ubicacion` (
  `idUbicacion` int(11) UNSIGNED NOT NULL COMMENT 'Identificador único de ubicación, generado por el sistema.',
  `nombreTienda` varchar(45) DEFAULT NULL COMMENT 'AtributonombreTienda ingresado por el usuario.',
  `direccion` varchar(45) DEFAULT NULL COMMENT 'Atributo dirección, ingresado por el usuario.',
  `ciudad` varchar(45) DEFAULT NULL COMMENT 'Atributo ciudad, seleccionado por el usuario al registrar la oferta.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla para almacenar las diferentes ubicaciones a las que se pueden relacionar ofertas.\n' PACK_KEYS=0;

--
-- Volcado de datos para la tabla `ubicacion`
--

INSERT INTO `ubicacion` (`idUbicacion`, `nombreTienda`, `direccion`, `ciudad`) VALUES
(3, 'Velit Cras Lorem Ltd', '402-4148 Viverra. Rd.', 'Itzehoe'),
(4, 'Ac Associates', '902-7182 Rhoncus. Rd.', 'Mundare'),
(5, 'Ligula Aliquam Associates', '907-8195 Nec Road', 'Cuglieri'),
(6, 'Nisl Sem Incorporated', 'P.O. Box 587, 3735 Non Street', 'Rochester'),
(7, 'Morbi Sit Amet LLP', 'P.O. Box 545, 7681 Non, St.', 'Pietraroja'),
(8, 'Egestas Corporation', '903-5566 Lorem, Rd.', 'Croydon'),
(9, 'Semper Egestas Consulting', 'Ap #640-7786 Diam. Avenue', 'Chelsea'),
(10, 'Tellus Aenean Egestas Foundation', 'Ap #496-448 Non St.', 'Leuze'),
(11, 'Nisl Arcu Iaculis LLC', 'P.O. Box 210, 1226 Ornare. Avenue', 'Preston'),
(12, 'In Dolor Fusce LLP', 'Ap #242-2683 Nulla Street', 'Juseret'),
(13, 'Donec Dignissim Magna Industries', '7466 Malesuada. Rd.', 'Milano'),
(14, 'Ornare Elit Elit LLC', '6311 Nascetur Road', 'Wood Buffalo'),
(15, 'Auctor Non Feugiat Foundation', '3219 Morbi Street', 'Cassano Spinola'),
(16, 'Interdum Company', 'Ap #158-971 Aliquet Rd.', 'Penicuik'),
(17, 'Justo Sit Amet PC', '2885 Cras Rd.', 'Argyle'),
(18, 'Sed Est Nunc Inc.', 'P.O. Box 351, 7678 Dolor Rd.', 'Rzeszów'),
(19, 'Dui Suspendisse Company', '4681 Neque. Rd.', 'Castri di Lecce'),
(20, 'Quam A Felis PC', 'P.O. Box 112, 3877 Mauris Avenue', 'Palakkad'),
(21, 'Aliquet Magna Inc.', 'Ap #655-4450 Semper Road', 'Bellante'),
(22, 'Eu Odio Phasellus Corporation', 'P.O. Box 198, 1362 Sem Street', 'Wortel'),
(23, 'Sagittis LLP', 'Ap #983-7861 Tempus Avenue', 'Gary'),
(24, 'Sed Institute', 'P.O. Box 505, 8888 Libero. St.', 'Ostra Vetere'),
(25, 'Proin Nisl Associates', '660-3101 Tellus. Av.', 'Merrickville-Wolford'),
(26, 'Ac Sem LLP', '784-2655 Turpis Street', 'Autelbas'),
(27, 'Quis Consulting', '2627 Facilisis Avenue', 'San Zenone degli Ezzelini'),
(28, 'Sem Incorporated', '3089 Lorem Rd.', 'Miranda'),
(29, 'Donec Egestas Aliquam Associates', 'Ap #777-2299 Facilisis Ave', 'Copiapó'),
(30, 'Ut LLP', 'Ap #752-2917 Erat Street', 'Valkenburg aan de Geul'),
(31, 'Est Vitae Sodales LLP', 'Ap #822-9560 Orci. Av.', 'Palombaro'),
(32, 'Donec LLP', '892-9931 Blandit Av.', 'Delhi'),
(33, 'Torquent Corporation', '494-2579 Lacus. St.', 'Morrinsville'),
(34, 'Nunc Sollicitudin Associates', 'P.O. Box 173, 3446 Porttitor Avenue', 'Ham-sur-Sambre'),
(35, 'Neque Venenatis Inc.', 'P.O. Box 961, 1691 Elementum Rd.', 'Taber'),
(36, 'Erat Volutpat Associates', '6936 Ligula Street', 'Curridabat'),
(37, 'Lorem Ipsum Sodales Associates', '792-8911 Ac St.', 'Remscheid'),
(38, 'Risus In Ltd', 'P.O. Box 208, 7359 Mattis Rd.', 'Rouvroy'),
(39, 'Vulputate Dui Incorporated', '292-7385 Ad Rd.', 'Konya'),
(40, 'Non Vestibulum Incorporated', '6743 Nisl Street', 'Long Eaton'),
(41, 'Et Ultrices Posuere Inc.', '2408 Dui Avenue', 'Shipshaw'),
(42, 'Luctus Curabitur Inc.', '9536 In Av.', 'Banda'),
(43, 'Mauris Rhoncus Incorporated', '483-4631 Nullam Av.', 'Acquafondata'),
(44, 'Metus Corp.', 'Ap #889-940 Imperdiet Rd.', 'Chapecó'),
(45, 'Senectus Industries', 'P.O. Box 296, 1512 Tempor Ave', 'Wolfurt'),
(46, 'A LLP', 'P.O. Box 460, 9663 Ut Av.', 'Santa Croce sull\'Arno'),
(47, 'Suspendisse Aliquet Associates', '8711 Nonummy Ave', 'Henley-on-Thames'),
(48, 'Ullamcorper Ltd', 'Ap #727-3307 Mattis St.', 'Grand Rapids'),
(49, 'Sit Amet Company', 'P.O. Box 295, 3365 Consectetuer Ave', 'Heide'),
(50, 'Euismod Mauris Company', 'P.O. Box 687, 8994 Ligula Rd.', 'La Salle'),
(51, 'Adipiscing Institute', '7766 Dolor St.', 'Port Moody'),
(52, 'Luctus Industries', '6026 Tortor Rd.', 'Mellet'),
(53, 'Aliquam Adipiscing Corporation', '5607 Parturient Street', 'Anzegem'),
(54, 'A Feugiat Tellus Corp.', '411-1956 Interdum Street', 'Miami'),
(55, 'Dapibus Foundation', 'P.O. Box 257, 385 Nulla St.', 'Faridabad'),
(56, 'Morbi Inc.', 'Ap #925-221 Metus. Rd.', 'Mandasor'),
(57, 'In Faucibus Institute', '3538 Aliquet St.', 'Cache Creek'),
(58, 'Aliquam Ultrices Iaculis Incorporated', '4089 Duis St.', 'Morkhoven'),
(59, 'Curabitur Sed Tortor Incorporated', '888 Nonummy. Av.', 'Oss'),
(60, 'Ornare Industries', '257-7832 A, Street', 'Moerbeke'),
(61, 'Fermentum Vel Corporation', '119-9575 Nec St.', 'Cardedu'),
(62, 'Nunc Quis Arcu Institute', 'P.O. Box 533, 886 Taciti St.', 'Saint-Georges'),
(63, 'Imperdiet Ullamcorper PC', 'P.O. Box 577, 8100 Mi St.', 'Fort McPherson'),
(64, 'Malesuada Vel Consulting', '322-2998 Eu Street', 'CŽroux-Mousty'),
(65, 'Eu Lacus Quisque Corporation', 'P.O. Box 767, 7267 Sapien. Street', 'Girona'),
(66, 'Dui Foundation', 'Ap #639-2901 Ac, Rd.', 'Dhuy'),
(67, 'Nam Nulla Magna Associates', '452-2235 Mauris Ave', 'Villa Alemana'),
(68, 'Duis Dignissim Company', 'Ap #774-5780 Magna Av.', 'Heidenheim'),
(69, 'Montes Nascetur Industries', 'P.O. Box 258, 3083 Adipiscing Avenue', 'Balen'),
(70, 'Vitae Odio Sagittis Foundation', '9975 Ante Ave', 'Iqaluit'),
(71, 'Hendrerit Inc.', '508 Neque Ave', 'Patos'),
(72, 'Non Egestas Foundation', '4390 Eu Ave', 'Awka'),
(73, 'Interdum Limited', '430-2972 Inceptos Av.', 'Ganshoren'),
(74, 'Fusce Limited', 'P.O. Box 440, 315 Sagittis Ave', 'Fiuminata'),
(75, 'Neque Inc.', '9793 Eget, Rd.', 'Pamplona'),
(76, 'Nam Consequat Institute', '6613 Fermentum Street', 'Renca'),
(77, 'Sapien Imperdiet Ornare Corp.', '189 Semper Road', 'Lac-Serent'),
(78, 'Quisque Imperdiet Institute', '3075 Vitae, Av.', 'Zeist'),
(79, 'Non Inc.', '997-621 Metus Road', 'Hartlepool'),
(80, 'Ornare In LLC', '2828 Turpis. Street', 'San Juan de Dios'),
(81, 'Sem Mollis LLP', '6314 Praesent St.', 'Jhelum'),
(82, 'Quis Corporation', '2820 Sapien Ave', 'Vichy'),
(83, 'Non Enim Incorporated', '5473 Hymenaeos. Road', 'Yaxley'),
(84, 'Sociis Natoque LLC', 'Ap #162-9508 Donec Rd.', 'Machalí'),
(85, 'Donec Corp.', 'Ap #591-3085 Consectetuer St.', 'Certaldo'),
(86, 'Mattis Corporation', 'P.O. Box 272, 1220 Vestibulum St.', 'Rocourt'),
(87, 'In Consectetuer LLP', 'P.O. Box 174, 661 Urna. St.', 'Hallein'),
(88, 'A Scelerisque Sed LLP', 'Ap #458-476 Turpis Street', 'Arbroath'),
(89, 'Magna Ut Consulting', 'Ap #687-610 Non Av.', 'Lamorteau'),
(90, 'Lobortis Quam Corp.', 'Ap #164-5752 Sit St.', 'Gojra'),
(91, 'Mollis Nec Cursus Associates', 'P.O. Box 629, 9237 Pede. Rd.', 'Savannah'),
(92, 'Nulla Tincidunt Neque Company', '624-4183 Elit, Avenue', 'Brugge Bruges'),
(93, 'Et Nunc Incorporated', '7341 Odio Rd.', 'Tulsa'),
(94, 'Odio Industries', '2468 Metus. Rd.', 'Canela'),
(95, 'Non Quam Pellentesque Consulting', 'Ap #632-5970 Aliquet. St.', 'Canberra'),
(96, 'Ornare LLC', 'Ap #422-3980 Eu St.', 'Ongole'),
(97, 'Massa Quisque Associates', 'P.O. Box 395, 8943 Suspendisse Street', 'Onze-Lieve-Vrouw-Lombeek'),
(98, 'Ullamcorper Nisl Arcu PC', 'P.O. Box 406, 7386 Vitae, Rd.', 'Etterbeek'),
(99, 'Mauris Eu Associates', '602-9318 Non Av.', 'Duffel'),
(100, 'Diam Inc.', '827-782 Iaculis Rd.', 'Ganshoren'),
(101, 'Neque Pellentesque Massa PC', '7143 Cras Street', 'Ladispoli'),
(102, 'Elit LLP', '4945 Sed Avenue', 'Essex'),
(103, 'mercar', 'calle 11 cra 4', '16'),
(104, 'justo y bueno', 'cra 82 # 22c-18', '16'),
(105, 'd1', 'cra 100 # 34-50', '39'),
(106, 'panamericana', 'carrera 82 # 23-36', '962'),
(107, 'zsgrzsgs', 'zrsgzsrgr', '16'),
(108, 'unilago', 'cra 15 #85-46', '44'),
(109, 'tigo', 'avenida cali #23-85', '32'),
(110, 'tttttt', 'ttttttt', '10'),
(111, 'kevins', 'carrera 86 # 23-30', '27'),
(112, 'asd', 'asd', '31'),
(113, 'Plaza de Paloquemao', 'cra4 calle 22', 'Bogotá'),
(114, 'Plaza de Paloquemao', 'cra4 calle 22', 'Bogotá'),
(115, 'zxc', 'zxc', '36'),
(116, 'ghj', 'ghj', '57'),
(117, 'dfg', 'dfg', '129'),
(118, 'jkl', 'jkl', '116'),
(119, 'iop', 'iop', '38'),
(120, 'gj', 'ghj', '129'),
(121, 'df', 'df', '31'),
(122, 'kl', 'kl', '37');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) UNSIGNED NOT NULL COMMENT 'Identificador único de usuario, generado por el sistema',
  `Ciudad_idCiudad` int(11) UNSIGNED NOT NULL COMMENT 'Llave foránea de ciudad donde vive el usuario',
  `nombreUsuario` varchar(45) NOT NULL COMMENT 'Atributo nombreUsuario, que identifica la cuenta de usuario.',
  `contrasena` varchar(40) NOT NULL COMMENT 'Atributo contraseña, ingresada por el usuario.',
  `nombre` varchar(45) NOT NULL COMMENT 'Atributo nombre que corresponde al nombre real del usuario.',
  `apellido` varchar(45) NOT NULL COMMENT 'Atributo apellido que corresponde al apellido real del usuario.',
  `telefono` varchar(20) NOT NULL COMMENT 'Atributo teléfono, que corresponde al teléfono fijo o celular del usuario.',
  `correo` varchar(45) NOT NULL COMMENT 'Atributo correo que corresponde al correo electróniico del usuario.',
  `fechaNacimiento` date NOT NULL COMMENT 'Atributo fecha de nacimiento, ingresado por el usuario al momento de registrarse.',
  `genero` char(1) DEFAULT NULL COMMENT 'Atributo género del usuario ''f'' femenino o ''m'' masculino',
  `rol` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla para almacenar todos los datos personales del usuarrio del sistema.' PACK_KEYS=0;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `Ciudad_idCiudad`, `nombreUsuario`, `contrasena`, `nombre`, `apellido`, `telefono`, `correo`, `fechaNacimiento`, `genero`, `rol`) VALUES
(1, 3, 'javier', '8cb2237d0679ca88db6464eac60da96345513964', 'javier', 'hernández navarro', '3142038124', 'jhernandez699@misena.edu.co', '1982-06-10', 'm', NULL),
(3, 7, 'yevi', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'javier', 'hernández navarro', '3142038124', 'jhernandez699@misena.edu.co', '1982-06-10', 'm', NULL),
(37, 2, 'jpizano', '1234', 'jose', 'pizarro', '3214567894', 'jpizarro@misena.edu.co', '1970-11-21', 'm', NULL),
(38, 2, 'ebustos', '1234', 'Edgar', 'bustos', '3126569848', 'ebustos@hotmail.com', '1950-10-10', 'm', NULL),
(39, 8, 'trosebelt', '1234', 'teodor', 'rosebelt', '3216549877', 'trosebelt@hotmail.com', '1912-12-12', 'm', NULL),
(40, 2, 'nlopez', '1234', 'nelson', 'lopez', '32165451589', 'nlopez@misena.edu.co', '1983-03-03', 'm', NULL),
(41, 16, 'rfernandez', '1234', 'rick', 'fernandez', '123456789', 'rfernandez@algo.com', '1950-01-01', 'm', NULL),
(42, 43, 'psantos', '1234', 'pepe', 'santos', '123456789', 'psantos@hotmail.com', '1975-05-05', 'm', NULL),
(43, 107, 'jhernandezg', '1234', 'jose', 'hernandez', '123456789', 'jhernandez@hotmail.com', '1945-03-22', 'm', NULL),
(44, 150, 'g', '1234', 'g', 'g', '987654321', 'g@g.go', '1966-06-06', 'f', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`idCategoria`);

--
-- Indices de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  ADD PRIMARY KEY (`idCiudad`),
  ADD KEY `idCiudad` (`idCiudad`);

--
-- Indices de la tabla `detalleproducto`
--
ALTER TABLE `detalleproducto`
  ADD PRIMARY KEY (`Oferta_idOferta`,`Producto_idProducto`),
  ADD KEY `DetalleProducto_FKIndex1` (`Oferta_idOferta`),
  ADD KEY `DetalleProducto_FKIndex2` (`Producto_idProducto`);

--
-- Indices de la tabla `detalleproducto_tiene_imagen`
--
ALTER TABLE `detalleproducto_tiene_imagen`
  ADD PRIMARY KEY (`Id_DetalleProducto_tiene_Imagen`),
  ADD KEY `fk_DetalleProducto_tiene_Imagen_Imagen1_idx` (`Imagen_idImagen`),
  ADD KEY `fk_DetalleProducto_tiene_Imagen_DetalleProducto1_idx` (`DetalleProducto_Oferta_idOferta`,`DetalleProducto_Producto_idProducto`);

--
-- Indices de la tabla `imagen`
--
ALTER TABLE `imagen`
  ADD PRIMARY KEY (`idImagen`);

--
-- Indices de la tabla `marca`
--
ALTER TABLE `marca`
  ADD PRIMARY KEY (`idMarca`);

--
-- Indices de la tabla `oferta`
--
ALTER TABLE `oferta`
  ADD PRIMARY KEY (`idOferta`),
  ADD KEY `Oferta_FKIndex1` (`Usuario_idUsuario`);

--
-- Indices de la tabla `oferta_tiene_ubicacion`
--
ALTER TABLE `oferta_tiene_ubicacion`
  ADD PRIMARY KEY (`Id_Oferta_tiene_Ubicacion`),
  ADD KEY `fk_Oferta_tiene_Ubicacion_Oferta1_idx` (`Oferta_idOferta`),
  ADD KEY `fk_Oferta_tiene_Ubicacion_Ubicacion1_idx` (`Ubicacion_idUbicacion`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`),
  ADD KEY `Producto_FKIndex2` (`Categoria_idCategoria`),
  ADD KEY `Producto_FKIndex3` (`Marca_idMarca`);

--
-- Indices de la tabla `tipo`
--
ALTER TABLE `tipo`
  ADD PRIMARY KEY (`idTipo`),
  ADD KEY `Tipo_FKIndex1` (`Categoria_idCategoria`);

--
-- Indices de la tabla `ubicacion`
--
ALTER TABLE `ubicacion`
  ADD PRIMARY KEY (`idUbicacion`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`),
  ADD UNIQUE KEY `nombreUsuario` (`nombreUsuario`),
  ADD KEY `Ciudad_idCiudad` (`Ciudad_idCiudad`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `idCategoria` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Identificador único de categoría, generado por el sistema.', AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `detalleproducto_tiene_imagen`
--
ALTER TABLE `detalleproducto_tiene_imagen`
  MODIFY `Id_DetalleProducto_tiene_Imagen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `imagen`
--
ALTER TABLE `imagen`
  MODIFY `idImagen` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Identificador único de imagen en el sistema', AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `marca`
--
ALTER TABLE `marca`
  MODIFY `idMarca` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Identificador único de marca', AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT de la tabla `oferta`
--
ALTER TABLE `oferta`
  MODIFY `idOferta` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Identificador único de la oferta', AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de la tabla `oferta_tiene_ubicacion`
--
ALTER TABLE `oferta_tiene_ubicacion`
  MODIFY `Id_Oferta_tiene_Ubicacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Identificador único de producto, generado por el sistema.', AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `tipo`
--
ALTER TABLE `tipo`
  MODIFY `idTipo` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Identificador único de tipo de producto, generado por el sistema', AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `ubicacion`
--
ALTER TABLE `ubicacion`
  MODIFY `idUbicacion` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Identificador único de ubicación, generado por el sistema.', AUTO_INCREMENT=123;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Identificador único de usuario, generado por el sistema', AUTO_INCREMENT=45;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalleproducto`
--
ALTER TABLE `detalleproducto`
  ADD CONSTRAINT `fk_DetalleProducto_Oferta1` FOREIGN KEY (`Oferta_idOferta`) REFERENCES `oferta` (`idOferta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_DetalleProducto_Producto1` FOREIGN KEY (`Producto_idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `detalleproducto_tiene_imagen`
--
ALTER TABLE `detalleproducto_tiene_imagen`
  ADD CONSTRAINT `fk_DetalleProducto_tiene_Imagen_DetalleProducto1` FOREIGN KEY (`DetalleProducto_Oferta_idOferta`,`DetalleProducto_Producto_idProducto`) REFERENCES `detalleproducto` (`Oferta_idOferta`, `Producto_idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_DetalleProducto_tiene_Imagen_Imagen1` FOREIGN KEY (`Imagen_idImagen`) REFERENCES `imagen` (`idImagen`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `oferta`
--
ALTER TABLE `oferta`
  ADD CONSTRAINT `fk_{0229C1B8-069A-4DF0-B00A-F11333FEE67C}` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `oferta_tiene_ubicacion`
--
ALTER TABLE `oferta_tiene_ubicacion`
  ADD CONSTRAINT `fk_Oferta_tiene_Ubicacion_Oferta1` FOREIGN KEY (`Oferta_idOferta`) REFERENCES `oferta` (`idOferta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Oferta_tiene_Ubicacion_Ubicacion1` FOREIGN KEY (`Ubicacion_idUbicacion`) REFERENCES `ubicacion` (`idUbicacion`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `fk_{E6715E7E-C630-44A7-B763-E3469116FEA8}` FOREIGN KEY (`Marca_idMarca`) REFERENCES `marca` (`idMarca`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`Categoria_idCategoria`) REFERENCES `categoria` (`idCategoria`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`Ciudad_idCiudad`) REFERENCES `ciudad` (`idCiudad`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
