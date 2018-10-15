-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Oct 15, 2018 at 07:43 AM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Agenda`
--

-- --------------------------------------------------------

--
-- Table structure for table `citas`
--

CREATE TABLE `citas` (
  `c_id` int(11) NOT NULL COMMENT 'identificador de la cita',
  `id` int(11) NOT NULL,
  `c_hora` time NOT NULL,
  `c_fecha` date NOT NULL,
  `c_asunto` varchar(150) NOT NULL,
  `c_lugar` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `citas`
--

INSERT INTO `citas` (`c_id`, `id`, `c_hora`, `c_fecha`, `c_asunto`, `c_lugar`) VALUES
(1, 8, '06:00:00', '2018-10-04', 'Clase de programacion', 'Universidad Distrital Fac. Ingenieria'),
(2, 1, '14:00:00', '2018-10-19', 'Consulta en la biblioteca', 'Universidad javeriana Biblioteca Principal'),
(3, 19, '13:40:00', '2018-10-10', 'Comprar memoria ram', 'Unilago'),
(4, 12, '15:00:00', '2018-10-26', 'Reunion de Negocios', 'Distripizza'),
(5, 3, '17:40:00', '2018-10-10', 'Apoyo marcha', 'Universidad Distrital Muro de escalar');

-- --------------------------------------------------------

--
-- Table structure for table `contactos`
--

CREATE TABLE `contactos` (
  `id` int(11) NOT NULL COMMENT 'identificador del contacto',
  `nombre` varchar(30) NOT NULL COMMENT 'nombre del contacto',
  `apellido` varchar(30) NOT NULL COMMENT 'apellido del contacto',
  `celular` varchar(15) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `telefono_oficina` varchar(15) NOT NULL,
  `correo` varchar(150) NOT NULL COMMENT 'email personal',
  `direccion` varchar(30) NOT NULL,
  `direccion_trabajo` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='tabla con los nombres de conocidos';

--
-- Dumping data for table `contactos`
--

INSERT INTO `contactos` (`id`, `nombre`, `apellido`, `celular`, `telefono`, `telefono_oficina`, `correo`, `direccion`, `direccion_trabajo`) VALUES
(1, 'Nicolas', 'Gutierrez Morales', '3106010259', '4974320', '', 'ndgutierrezm@corre.udistrital.edu.co', '', ''),
(2, 'Jose', 'Diaz Aguilar', '3143364257', '4610710', '', 'nikolazbotwe@hotmail.com', '', ''),
(3, 'Cristian', 'Yara Pardo', '3204231096', '5701252', '', 'cmyarp@corre.udistrital.edu.co', '', ''),
(4, 'Juan Felipe', 'Herrera Poveda', '3188419339', '8285065', '', 'jfherrerap@corre.udistrital.edu.co', '', ''),
(5, 'Kevin Santiago', 'Garcia Cuellar', '3204231096', '5701252', '', 'cmyarp@corre.udistrital.edu.co', '', ''),
(6, 'Fabia Enrique', 'Leon', '3207649016', '4516130', '', 'feleon@corre.udistrital.edu.co', '', ''),
(7, 'Esteban', 'Norato Triana', '3193398040', '2517629', '', 'fenoratot@corre.udistrital.edu.co', '', ''),
(8, 'Juan Santiago', 'Chauta Gaviria', '3506632164', '3528102', '', 'santiagochauta@gmail.com', '', ''),
(9, 'Kevin', 'Forero Guastero', '3204178898', '4178898', '', 'kevinandresforero@hotmail.com', '', ''),
(10, 'Alex H', 'Rodriguez', '3138040642', '7156701', '', 'alexho2401@hotmail.com', '', ''),
(11, 'Vivian', 'Peña Hurtado', '3114612307', '7417353', '', 'pavipehu1@gmail.com', '', ''),
(12, 'Alejandro', 'Gonzalez', '3173881033', '7033212', '', 'diegobermu1003@gmail.com', '', ''),
(13, 'Nicolas', 'Valderrama', '3143155135', '4022153', '', 'expectopatrom@gmail.com', '', ''),
(14, 'Camilo Andres', 'Caiman', '3005931246', '4610589', '', 'caimanco8@gmail.com', '', ''),
(15, 'Kevin Duvan', 'Bernal Ortiz', '3132248033', '7782636', '', 'kevinduvanbernalortiz@gmail.com', '', ''),
(16, 'Julian', 'Torres', '3202882648', '4381237', '', 'julianfelipeotxd@outlook.es', '', ''),
(17, 'Leider', 'Chaverra Correa', '3205366740', '7367012', '', 'leiderre14@gmail.com', '', ''),
(18, 'Jefferson Manuel', 'Bojaca Jaimes', '3204333497', '2981148', '', 'manuel.bojaca@outlook.co', '', ''),
(19, 'Johan', 'Rincon Amaya', '3007879469', '8932066', '5467654', 'johanrimena@hotmail.com', 'cra 123 # 17 f 38', 'cra 40 # 8 7');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `citas`
--
ALTER TABLE `citas`
  ADD PRIMARY KEY (`c_id`);

--
-- Indexes for table `contactos`
--
ALTER TABLE `contactos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `citas`
--
ALTER TABLE `citas`
  MODIFY `c_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'identificador de la cita', AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `contactos`
--
ALTER TABLE `contactos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'identificador del contacto', AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
