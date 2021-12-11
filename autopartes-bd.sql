-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 10, 2021 at 02:03 AM
-- Server version: 8.0.26
-- PHP Version: 7.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `autopartes`
--

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `id_category` int NOT NULL,
  `code_category` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `name_category` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `status_category` varchar(50) COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'Activo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`id_category`, `code_category`, `name_category`, `status_category`) VALUES
(1, 'CAT-001', 'Filtros', 'Activo'),
(2, 'CAT-002', 'Baterías', 'Activo'),
(3, 'CAT-003', 'Aditivos', 'Activo'),
(4, 'CAT-004', 'Bujías', 'Activo'),
(5, 'CAT-005', 'Cuidado Automotriz', 'Activo'),
(6, 'CAT-006', 'Faros', 'Activo'),
(7, 'CAT-006', 'DGDFGgg', 'Activo');

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int NOT NULL,
  `name_cliente` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `lastname_cliente` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `dni_cliente` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone_cliente` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address_cliente` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status_cliente` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'Activo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `name_cliente`, `lastname_cliente`, `dni_cliente`, `phone_cliente`, `address_cliente`, `status_cliente`) VALUES
(1, 'prueba', 'prueba', '123456789', '123456789', 'Prueba123', 'Activo'),
(2, 'prueba1', 'prueba1', 'prueba1', 'prueba1', 'prueba1', 'Activo'),
(3, 'Nicolas', 'gdgdfg', 'dfgdfg', 'dfgdfgd', 'dggfd', 'Activo'),
(4, 'prueba7', 'prueba6', '1234567897', '5123456789', 'Prueba1237', 'Activo');

-- --------------------------------------------------------

--
-- Table structure for table `comprobante`
--

CREATE TABLE `comprobante` (
  `id_comprobante` int NOT NULL,
  `id_cliente` int NOT NULL,
  `id_empleado` int NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `detalle_comprobante`
--

CREATE TABLE `detalle_comprobante` (
  `id_detalle_comprobante` int NOT NULL,
  `id_comprobante` int NOT NULL,
  `id_product` int NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `quantity` int NOT NULL,
  `subtotal` decimal(10,2) NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `empleado`
--

CREATE TABLE `empleado` (
  `id_empleado` int NOT NULL,
  `name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `phone` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `address` text COLLATE utf8mb4_general_ci NOT NULL,
  `status` varchar(20) COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'Activo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id_product` int NOT NULL,
  `code_product` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description_product` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `purchase_price` decimal(10,2) NOT NULL,
  `sale_price` decimal(10,2) NOT NULL,
  `quantity` int NOT NULL DEFAULT '0',
  `id_provider` int NOT NULL,
  `id_category` int NOT NULL,
  `status_product` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'Activo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id_product`, `code_product`, `description_product`, `purchase_price`, `sale_price`, `quantity`, `id_provider`, `id_category`, `status_product`) VALUES
(53, 'gdgd', 'dfgdg', '45.00', '545.00', 267, 2, 3, 'Activo'),
(54, 'PROD-0001', 'Llantas Goodyear', '53.00', '65.00', 35, 1, 6, 'Activo'),
(55, 'PROD-0002', 'Faros Nissan', '150.00', '230.00', 7, 2, 6, 'Activo'),
(56, 'PROD-0003', 'Bujías Nissan ', '450.00', '530.00', 6, 2, 4, 'Activo');

-- --------------------------------------------------------

--
-- Table structure for table `providers`
--

CREATE TABLE `providers` (
  `id_provider` int NOT NULL,
  `ruc_provider` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name_provider` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone_provider` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email_provider` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address_provider` varchar(250) COLLATE utf8mb4_general_ci NOT NULL,
  `status_provider` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'Activo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `providers`
--

INSERT INTO `providers` (`id_provider`, `ruc_provider`, `name_provider`, `phone_provider`, `email_provider`, `address_provider`, `status_provider`) VALUES
(1, '20602078672', 'BOSCH REXROTH ', '920158469', 'bosch@gmail.com', 'AV. ARGENTINA NRO. 3618- CALLAO', 'Activo'),
(2, '20459754e', 'AUTOMOTORES DIESEL E.I.R.L', '998573651', 'automotoresdiesel@gmail.com', 'AV. SAN JUAN NRO. 603 LIMA - LIMA - SAN LUIS', 'Activo'),
(3, '345345', 'TETERT', '345345', 'SDFSDF', 'SDFSDSD', 'Activo');

-- --------------------------------------------------------

--
-- Table structure for table `purchase`
--

CREATE TABLE `purchase` (
  `id_purchase` int NOT NULL,
  `id_provider` int NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `purchase`
--

INSERT INTO `purchase` (`id_purchase`, `id_provider`, `total`, `date`) VALUES
(1, 2, '500.32', '2021-12-09 03:50:49'),
(2, 1, '500.32', '2021-12-09 03:53:46'),
(3, 2, '62.54', '2021-12-09 03:55:54'),
(4, 3, '1250.80', '2021-12-09 04:02:42'),
(5, 1, '500.32', '2021-12-09 04:19:51'),
(6, 1, '625.40', '2021-12-09 04:20:38'),
(7, 3, '437.78', '2021-12-09 04:25:01'),
(8, 3, '187.62', '2021-12-09 05:59:42'),
(9, 1, '125.08', '2021-12-09 16:49:39'),
(10, 2, '125.08', '2021-12-09 16:52:31'),
(11, 3, '125.08', '2021-12-09 16:53:25'),
(12, 2, '312.70', '2021-12-09 17:10:58'),
(13, 2, '125.08', '2021-12-09 18:17:32'),
(14, 2, '3502.24', '2021-12-09 18:17:52'),
(15, 1, '250.16', '2021-12-09 18:18:35'),
(16, 1, '312.70', '2021-12-09 18:19:44'),
(17, 1, '250.16', '2021-12-09 18:20:20'),
(18, 2, '312.70', '2021-12-09 19:58:35'),
(19, 2, '312.70', '2021-12-09 21:12:58'),
(20, 2, '318.60', '2021-12-09 21:41:46'),
(21, 3, '1250.80', '2021-12-09 21:45:24'),
(22, 2, '125.08', '2021-12-09 21:48:22'),
(23, 1, '127.44', '2021-12-09 21:52:29'),
(24, 1, '312.70', '2021-12-09 22:00:16'),
(25, 1, '127.44', '2021-12-09 22:04:13'),
(26, 2, '318.60', '2021-12-09 22:08:03'),
(27, 2, '125.08', '2021-12-09 22:11:06'),
(28, 2, '312.70', '2021-12-09 22:12:59'),
(29, 2, '254.88', '2021-12-09 22:27:16'),
(30, 2, '129.80', '2021-12-09 22:29:12'),
(31, 2, '318.60', '2021-12-09 22:30:46'),
(32, 3, '312.70', '2021-12-09 22:49:01'),
(33, 2, '324.50', '2021-12-09 22:53:42'),
(34, 2, '318.60', '2021-12-09 22:55:41'),
(35, 2, '132.16', '2021-12-09 22:58:07'),
(36, 2, '132.16', '2021-12-09 22:59:19'),
(37, 1, '127.44', '2021-12-09 23:01:23'),
(38, 2, '132.16', '2021-12-09 23:08:32'),
(39, 1, '318.60', '2021-12-10 01:27:46');

-- --------------------------------------------------------

--
-- Table structure for table `purchase_detail`
--

CREATE TABLE `purchase_detail` (
  `id_purchase_detail` int NOT NULL,
  `id_purchase` int NOT NULL,
  `id_product` int NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `quantity` int NOT NULL,
  `igv` decimal(10,2) NOT NULL,
  `subtotal` decimal(10,2) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `purchase_detail`
--

INSERT INTO `purchase_detail` (`id_purchase_detail`, `id_purchase`, `id_product`, `price`, `quantity`, `igv`, `subtotal`, `date`) VALUES
(27, 16, 53, '53.00', 5, '53.00', '265.00', '2021-12-09 18:19:44'),
(31, 20, 54, '54.00', 5, '54.00', '270.00', '2021-12-09 21:41:46'),
(41, 30, 55, '55.00', 2, '55.00', '110.00', '2021-12-09 22:29:12'),
(46, 35, 56, '56.00', 2, '56.00', '112.00', '2021-12-09 22:58:07');

-- --------------------------------------------------------

--
-- Table structure for table `sede`
--

CREATE TABLE `sede` (
  `id_sede` int NOT NULL,
  `ruc` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `name_sede` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `phone_sede` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `address_sede` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `message_sede` varchar(200) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sede`
--

INSERT INTO `sede` (`id_sede`, `ruc`, `name_sede`, `phone_sede`, `address_sede`, `message_sede`) VALUES
(1, '20733145152', 'Sede Lima', '123456789', 'Jr.Los jazmines 216', 'Sede Lima Autopartes Mayuri');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id_user` int NOT NULL,
  `nick_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `last_name` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'Activo',
  `dni` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id_user`, `nick_user`, `name`, `last_name`, `email`, `phone`, `role`, `status`, `dni`, `password`) VALUES
(1, 'Pedro', 'Pedro', 'Holguín', '123456789', 'pedro@gmail.com', 'Administrador', 'Activo', '12345678', '123456789'),
(12, 'sdfsdf', 'fsdfsf', 'sdfsdf', 'sdfsf', '4234234', 'Administrador', 'Activo', '42342', 'sdfsdf'),
(13, 'Pedro3', 'Pedro', 'Holguín', '123456789', 'pedro@gmail.com', 'Administrador', 'Activo', '12345678', '123456789'),
(14, 'admin', 'Admin', 'Admin', 'admin@gmail.com', '123456789', 'Administrador', 'Activo', '123456789', 'admin'),
(15, 'Enoc', 'Enoc', 'Enoc', 'prueba@gmail.com', '123456', 'Empleado', 'Activo', '1203456', 'enoc');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id_category`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indexes for table `comprobante`
--
ALTER TABLE `comprobante`
  ADD PRIMARY KEY (`id_comprobante`),
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `id_user` (`id_empleado`),
  ADD KEY `id_empleado` (`id_empleado`);

--
-- Indexes for table `detalle_comprobante`
--
ALTER TABLE `detalle_comprobante`
  ADD PRIMARY KEY (`id_detalle_comprobante`),
  ADD KEY `id_comprobante` (`id_comprobante`),
  ADD KEY `id_product` (`id_product`);

--
-- Indexes for table `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`id_empleado`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id_product`),
  ADD KEY `id_provider` (`id_provider`),
  ADD KEY `id_category` (`id_category`);

--
-- Indexes for table `providers`
--
ALTER TABLE `providers`
  ADD PRIMARY KEY (`id_provider`);

--
-- Indexes for table `purchase`
--
ALTER TABLE `purchase`
  ADD PRIMARY KEY (`id_purchase`),
  ADD KEY `id_provider` (`id_provider`);

--
-- Indexes for table `purchase_detail`
--
ALTER TABLE `purchase_detail`
  ADD PRIMARY KEY (`id_purchase_detail`),
  ADD UNIQUE KEY `id_product` (`id_product`),
  ADD UNIQUE KEY `id_purchase` (`id_purchase`);

--
-- Indexes for table `sede`
--
ALTER TABLE `sede`
  ADD PRIMARY KEY (`id_sede`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `id_category` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `comprobante`
--
ALTER TABLE `comprobante`
  MODIFY `id_comprobante` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `detalle_comprobante`
--
ALTER TABLE `detalle_comprobante`
  MODIFY `id_detalle_comprobante` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `empleado`
--
ALTER TABLE `empleado`
  MODIFY `id_empleado` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id_product` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT for table `providers`
--
ALTER TABLE `providers`
  MODIFY `id_provider` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `purchase`
--
ALTER TABLE `purchase`
  MODIFY `id_purchase` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT for table `purchase_detail`
--
ALTER TABLE `purchase_detail`
  MODIFY `id_purchase_detail` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT for table `sede`
--
ALTER TABLE `sede`
  MODIFY `id_sede` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `comprobante`
--
ALTER TABLE `comprobante`
  ADD CONSTRAINT `comprobante_ibfk_1` FOREIGN KEY (`id_comprobante`) REFERENCES `detalle_comprobante` (`id_comprobante`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `comprobante_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `comprobante_ibfk_3` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `detalle_comprobante`
--
ALTER TABLE `detalle_comprobante`
  ADD CONSTRAINT `detalle_comprobante_ibfk_1` FOREIGN KEY (`id_product`) REFERENCES `products` (`id_product`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_ibfk_1` FOREIGN KEY (`id_provider`) REFERENCES `providers` (`id_provider`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `products_ibfk_2` FOREIGN KEY (`id_category`) REFERENCES `categories` (`id_category`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `purchase`
--
ALTER TABLE `purchase`
  ADD CONSTRAINT `purchase_ibfk_1` FOREIGN KEY (`id_provider`) REFERENCES `providers` (`id_provider`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `purchase_detail`
--
ALTER TABLE `purchase_detail`
  ADD CONSTRAINT `purchase_detail_ibfk_1` FOREIGN KEY (`id_purchase`) REFERENCES `purchase` (`id_purchase`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `purchase_detail_ibfk_2` FOREIGN KEY (`id_product`) REFERENCES `products` (`id_product`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
