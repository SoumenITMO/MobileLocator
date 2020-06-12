-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 11, 2020 at 10:02 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db1`
--

-- --------------------------------------------------------

--
-- Table structure for table `basestation`
--

CREATE TABLE `basestation` (
  `id` int(8) NOT NULL,
  `name` varchar(50) NOT NULL,
  `x` float NOT NULL,
  `y` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `basestation`
--

INSERT INTO `basestation` (`id`, `name`, `x`, `y`) VALUES
(1, 'BS 1', 154.98, 212.45),
(2, 'BS 2', 140.02, 99.78);

-- --------------------------------------------------------

--
-- Table structure for table `mobilestation`
--

CREATE TABLE `mobilestation` (
  `id` int(4) NOT NULL,
  `last_x` float NOT NULL,
  `last_y` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mobilestation`
--

INSERT INTO `mobilestation` (`id`, `last_x`, `last_y`) VALUES
(1, 154.54, 212.54),
(2, 147.22, 220.12),
(3, 220.45, 185.12),
(4, 257.44, 198.63),
(5, 159.78, 219.08);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `basestation`
--
ALTER TABLE `basestation`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mobilestation`
--
ALTER TABLE `mobilestation`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `basestation`
--
ALTER TABLE `basestation`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `mobilestation`
--
ALTER TABLE `mobilestation`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
