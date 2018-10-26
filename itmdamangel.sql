-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 27-10-2018 a las 00:03:19
-- Versión del servidor: 8.0.13
-- Versión de PHP: 7.2.10-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `itmdamangel`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Alumno`
--

CREATE TABLE `Alumno` (
  `id_facebookAlumno` varchar(17) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `Alumno`
--

INSERT INTO `Alumno` (`id_facebookAlumno`) VALUES
('11111111111111111');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Asesor`
--

CREATE TABLE `Asesor` (
  `id_facebookAsesor` varchar(17) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Nombre` varchar(25) NOT NULL,
  `Apellido` varchar(25) NOT NULL,
  `HorarioInicio` time NOT NULL,
  `HorarioFin` time NOT NULL,
  `fotografia` varchar(50) NOT NULL DEFAULT 'https://www.clt-lana.org/images/default-user.png',
  `id_Materia` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `Asesor`
--

INSERT INTO `Asesor` (`id_facebookAsesor`, `Nombre`, `Apellido`, `HorarioInicio`, `HorarioFin`, `fotografia`, `id_Materia`) VALUES
('10217107372454364', 'Angel', 'Lopez', '00:11:00', '00:12:00', 'https://www.clt-lana.org/images/default-user.png', 'm003');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Materia`
--

CREATE TABLE `Materia` (
  `id_Materia` varchar(10) NOT NULL,
  `Nombre` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `Materia`
--

INSERT INTO `Materia` (`id_Materia`, `Nombre`) VALUES
('m001', 'Cálculo Integral'),
('m002', 'Cálculo diferencial'),
('m003', 'Álgebra');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Valoracion`
--

CREATE TABLE `Valoracion` (
  `id_valoracion` varchar(10) NOT NULL,
  `Estrellas` tinyint(5) NOT NULL DEFAULT '3',
  `texto` text NOT NULL,
  `id_facebookAsesor` varchar(17) NOT NULL,
  `id_facebookAlumno` varchar(17) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `Valoracion`
--

INSERT INTO `Valoracion` (`id_valoracion`, `Estrellas`, `texto`, `id_facebookAsesor`, `id_facebookAlumno`) VALUES
('v000000000', 4, 'Lorem ipsum dolor sit amet', '10217107372454364', '1111111111');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Alumno`
--
ALTER TABLE `Alumno`
  ADD PRIMARY KEY (`id_facebookAlumno`);

--
-- Indices de la tabla `Asesor`
--
ALTER TABLE `Asesor`
  ADD PRIMARY KEY (`id_facebookAsesor`);

--
-- Indices de la tabla `Materia`
--
ALTER TABLE `Materia`
  ADD PRIMARY KEY (`id_Materia`);

--
-- Indices de la tabla `Valoracion`
--
ALTER TABLE `Valoracion`
  ADD PRIMARY KEY (`id_valoracion`),
  ADD UNIQUE KEY `id_facebookAlumno` (`id_facebookAlumno`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
