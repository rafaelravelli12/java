-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.32 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.4.0.6659
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for w_project_03
CREATE DATABASE IF NOT EXISTS `w_project_03` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `w_project_03`;

-- Dumping structure for table w_project_03.cancellation
CREATE TABLE IF NOT EXISTS `cancellation` (
  `pnr_no` varchar(50) DEFAULT NULL,
  `cancellation_no` varchar(50) DEFAULT NULL,
  `cancellation_date` varchar(50) DEFAULT NULL,
  `fli_code` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table w_project_03.cancellation: ~0 rows (approximately)

-- Dumping structure for table w_project_03.flight
CREATE TABLE IF NOT EXISTS `flight` (
  `f_code` varchar(50) DEFAULT NULL,
  `f_name` varchar(50) DEFAULT NULL,
  `src` varchar(50) DEFAULT NULL,
  `dst` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table w_project_03.flight: ~0 rows (approximately)
INSERT INTO `flight` (`f_code`, `f_name`, `src`, `dst`) VALUES
	('AI266', 'AIR INDIA-9', 'PATNA', 'DELHI'),
	('AI267', 'AIR INDIA-10', 'PATNA', 'DELHI');

-- Dumping structure for table w_project_03.flight_info
CREATE TABLE IF NOT EXISTS `flight_info` (
  `company` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `source` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `destination` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `date` varchar(50) DEFAULT NULL,
  `time` varchar(50) DEFAULT NULL,
  `code` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `remaining_executive_chairs` varchar(50) DEFAULT NULL,
  `remaining_popular_chairs` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table w_project_03.flight_info: ~2 rows (approximately)
INSERT INTO `flight_info` (`company`, `source`, `destination`, `date`, `time`, `code`, `remaining_executive_chairs`, `remaining_popular_chairs`) VALUES
	('TAM', 'São Paulo - Congonhas', 'Rio de Janeiro - Santos Dummont', '25/05/2023', '07:00', 'A001', NULL, NULL),
	('TAM', 'São Paulo - Guarulhos', 'Rio de Janeiro - Santos Dummont', '25/05/2023', '07:00', 'A001', NULL, NULL);

-- Dumping structure for table w_project_03.login
CREATE TABLE IF NOT EXISTS `login` (
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table w_project_03.login: ~0 rows (approximately)
INSERT INTO `login` (`username`, `password`) VALUES
	('admin', '12345');

-- Dumping structure for table w_project_03.passenger
CREATE TABLE IF NOT EXISTS `passenger` (
  `pnr_no` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `nationality` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `ph_no` varchar(50) DEFAULT NULL,
  `passport_no` varchar(50) DEFAULT NULL,
  `fl_code` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table w_project_03.passenger: ~0 rows (approximately)
INSERT INTO `passenger` (`pnr_no`, `address`, `nationality`, `name`, `gender`, `ph_no`, `passport_no`, `fl_code`) VALUES
	('a500', 'Joaquim Tàvora', 'Brasil', 'Rafael', 'male', '458893872', '1000', '1');

-- Dumping structure for table w_project_03.payment
CREATE TABLE IF NOT EXISTS `payment` (
  `pnr_no` varchar(50) DEFAULT NULL,
  `ph_no` varchar(50) DEFAULT NULL,
  `cheque_no` varchar(50) DEFAULT NULL,
  `card_no` varchar(50) DEFAULT NULL,
  `paid_amt` varchar(50) DEFAULT NULL,
  `pay_date` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table w_project_03.payment: ~0 rows (approximately)

-- Dumping structure for table w_project_03.plane
CREATE TABLE IF NOT EXISTS `plane` (
  `model` varchar(50) DEFAULT NULL,
  `executive_class_capacity` varchar(50) DEFAULT NULL,
  `popular_class_capacity` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table w_project_03.plane: ~0 rows (approximately)
INSERT INTO `plane` (`model`, `executive_class_capacity`, `popular_class_capacity`) VALUES
	('BOEING 777-200ER/LR', '100', '190'),
	('BOEING 747-400', '150', '220'),
	('BOEING 737-800', '50', '110');

-- Dumping structure for table w_project_03.reservation
CREATE TABLE IF NOT EXISTS `reservation` (
  `pnr_no` varchar(50) DEFAULT NULL,
  `ticket_id` varchar(50) DEFAULT NULL,
  `f_code` varchar(50) DEFAULT NULL,
  `jny_date` varchar(50) DEFAULT NULL,
  `jny_time` varchar(50) DEFAULT NULL,
  `src` varchar(50) DEFAULT NULL,
  `dst` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table w_project_03.reservation: ~0 rows (approximately)
INSERT INTO `reservation` (`pnr_no`, `ticket_id`, `f_code`, `jny_date`, `jny_time`, `src`, `dst`) VALUES
	('1', '1', '1', '1', '1', 'PATNA', 'BANGALORE'),
	('2', '2', '2', '2', '2', 'BANGALORE', 'MUMBAI'),
	('a', 'a', 'a', 'a', 'a', 'a', 'a'),
	('12345', 'ID01', 'AI266', '01/01/2021', '20:10', 'PATNA', 'DELHI');

-- Dumping structure for table w_project_03.sector
CREATE TABLE IF NOT EXISTS `sector` (
  `f_code` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `capacity` varchar(50) DEFAULT NULL,
  `class_code` varchar(50) DEFAULT NULL,
  `class_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table w_project_03.sector: ~0 rows (approximately)
INSERT INTO `sector` (`f_code`, `capacity`, `class_code`, `class_name`) VALUES
	('AI266', '20', 'A', 'First Class'),
	('AI267', '20', 'A', 'First Class');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
