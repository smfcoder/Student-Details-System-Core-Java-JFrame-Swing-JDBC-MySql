-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 12, 2021 at 06:14 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `student`
--

-- --------------------------------------------------------

--
-- Table structure for table `admintbl`
--

CREATE TABLE `admintbl` (
  `id` int(11) NOT NULL,
  `username` text NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admintbl`
--

INSERT INTO `admintbl` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `Name` text NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` text NOT NULL,
  `DOB_DAY` int(11) NOT NULL,
  `DOB_MONTH` text NOT NULL,
  `DOB_YEAR` int(11) NOT NULL,
  `Gender` text NOT NULL,
  `Address` text NOT NULL,
  `Nationality` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `Name`, `Email`, `Password`, `DOB_DAY`, `DOB_MONTH`, `DOB_YEAR`, `Gender`, `Address`, `Nationality`) VALUES
(1, 'Shreyas', 'smf@gmail.com', 'sf12345', 27, 'Aug', 1999, 'male', '16,Laxman nagar, Jalgaon', ''),
(3, 'smfcoder', 'sf@gmail.com', '12345sf', 1, 'Jan', 1995, 'male', 'NH-6,GCOEJ,infront of ITI Jalgaon', 'INDIAN'),
(12, 'Shreyas Fegade', 'shreyas@gmail.com', '12345', 27, 'Aug', 1999, 'male', 'Plotno.16,laxman nagar,Jalgaon.', 'INDIAN'),
(13, 'Shreya M. Fegade', 'shreya@gmail.com', 'qwerty', 22, 'Mar', 1998, 'female', '16,laxman nagar,Jalgaon', 'INDIAN'),
(15, 'Alan Walker', 'alan@gmail.com', 'alan', 21, 'feb', 1996, 'male', 'New York, USA', 'INDIAN'),
(17, 'Shreyas Fegade', 'smfegade2799@gmail.com', '12345', 27, 'Aug', 1999, 'male', '16,Laxman nagar,Jalgaon,Maharashtra.', 'INDIAN'),
(19, 'abc', 'abc@gmail.com', 'abc', 1, 'Jan', 1995, 'male', 'abc abc', 'INDIAN'),
(20, 'Shreyas M. Fegade', 'shreyasf@gmail.com', '12345', 27, 'Aug', 1999, 'male', 'Jalgaon, Maharashtra - 425001', 'INDIAN');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admintbl`
--
ALTER TABLE `admintbl`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admintbl`
--
ALTER TABLE `admintbl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
