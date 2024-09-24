-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 24, 2024 at 03:31 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `behavioural_command`
--

-- --------------------------------------------------------

--
-- Table structure for table `command_logs`
--

CREATE TABLE `command_logs` (
  `id` int(11) NOT NULL,
  `command_name` varchar(255) NOT NULL,
  `executed_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `command_logs`
--

INSERT INTO `command_logs` (`id`, `command_name`, `executed_at`) VALUES
(1, 'Set Temperature to 22', '2024-09-23 14:03:27'),
(2, 'Lock Door', '2024-09-23 14:03:27'),
(3, 'Unlock Door', '2024-09-23 14:03:27'),
(4, 'Set Temperature to 22', '2024-09-23 14:04:19'),
(5, 'Lock Door', '2024-09-23 14:04:19'),
(6, 'Unlock Door', '2024-09-23 14:04:19'),
(7, 'Set Temperature to 22', '2024-09-23 14:04:45'),
(8, 'Lock Door', '2024-09-23 14:04:45'),
(9, 'Unlock Door', '2024-09-23 14:04:45'),
(10, 'Set Temperature to 22', '2024-09-24 12:52:13'),
(11, 'Lock Door', '2024-09-24 12:52:13'),
(12, 'Unlock Door', '2024-09-24 12:52:13');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `command_logs`
--
ALTER TABLE `command_logs`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `command_logs`
--
ALTER TABLE `command_logs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
