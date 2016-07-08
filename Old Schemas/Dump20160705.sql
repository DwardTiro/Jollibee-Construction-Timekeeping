-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 04, 2016 at 05:17 PM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 7.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `timekeep`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `name`, `username`, `password`) VALUES
(1, 'jet', 'jet', '123');

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `entry_num` int(11) NOT NULL,
  `emp_id` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `time_in` time NOT NULL,
  `time_out` time NOT NULL,
  `compute_salary` double UNSIGNED DEFAULT '0',
  `paid` int(1) UNSIGNED DEFAULT '0',
  `leave` int(1) UNSIGNED DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`entry_num`, `emp_id`, `date`, `time_in`, `time_out`, `compute_salary`, `paid`, `leave`) VALUES
(4, '400', '1970-01-01', '19:24:09', '21:24:00', NULL, NULL, NULL),
(6, '400', '2016-06-27', '19:25:56', '21:25:00', NULL, NULL, NULL),
(7, '400', '2016-06-28', '15:53:20', '15:53:20', NULL, NULL, NULL),
(8, '400', '2016-06-06', '15:56:58', '17:56:00', NULL, NULL, NULL),
(9, '321', '2016-06-09', '17:14:34', '19:14:00', NULL, NULL, NULL),
(10, '0', '2016-07-01', '18:59:46', '16:59:00', NULL, NULL, NULL),
(11, '0', '2017-06-08', '19:00:52', '19:00:52', NULL, NULL, NULL),
(12, '321', '2017-06-07', '19:01:06', '19:01:06', NULL, NULL, NULL),
(13, '321', '2016-07-01', '19:20:59', '20:20:00', NULL, NULL, NULL),
(14, '321', '2016-08-01', '19:38:00', '19:38:00', NULL, NULL, NULL),
(15, '321', '2016-09-01', '19:38:00', '19:38:00', 0, 0, 0),
(16, '321', '2016-07-02', '21:15:21', '22:15:00', 4076620, 0, 0),
(17, '321', '2016-07-03', '21:16:18', '23:16:00', 210, 0, 0),
(18, '321', '2016-07-04', '21:19:53', '22:19:00', 220, 0, 0),
(19, '321', '2016-07-06', '21:35:51', '22:35:00', 10, 0, 0),
(20, '321', '2016-07-08', '21:41:44', '21:41:44', 0, 0, 0),
(21, '321', '2016-07-13', '21:46:03', '21:46:03', 0, 0, 0),
(22, '321', '2016-07-10', '21:46:37', '21:46:37', 0, 0, 0),
(23, '321', '2016-07-15', '21:55:30', '23:55:00', 20, 0, 0),
(24, '321', '2016-07-09', '21:56:43', '22:56:00', 10, 0, 0),
(25, '400', '2016-07-01', '22:00:19', '23:00:00', 200, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `middle_name` varchar(45) NOT NULL,
  `salary` double NOT NULL,
  `project_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `first_name`, `last_name`, `middle_name`, `salary`, `project_id`) VALUES
(321, 'Jet', 'Virtusio', 'Cor', 10, NULL),
(400, 'Jet', '2nd', '2nd', 200, NULL),
(901, 'Firstname', 'Lastname', 'woah', 10, NULL),
(902, 'Firstname', 'Lastname', 'woah', 100, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `payroll`
--

CREATE TABLE `payroll` (
  `id` int(11) NOT NULL,
  `date_now` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `payroll_entry`
--

CREATE TABLE `payroll_entry` (
  `id` int(11) NOT NULL,
  `payroll_id` int(11) NOT NULL,
  `attendance_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE `project` (
  `proj_id` int(11) NOT NULL,
  `proj_name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username_UNIQUE` (`username`);

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`entry_num`),
  ADD UNIQUE KEY `index2` (`date`,`emp_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `payroll`
--
ALTER TABLE `payroll`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `payroll_entry`
--
ALTER TABLE `payroll_entry`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`proj_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `attendance`
--
ALTER TABLE `attendance`
  MODIFY `entry_num` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=903;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
