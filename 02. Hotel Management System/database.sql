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


-- Dumping database structure for w_project_02
CREATE DATABASE IF NOT EXISTS `w_project_02` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `w_project_02`;

-- Dumping structure for table w_project_02.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `id` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `number` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `name` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `gender` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `country` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `room_number` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `status` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `deposit` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table w_project_02.customer: ~2 rows (approximately)
INSERT INTO `customer` (`id`, `number`, `name`, `gender`, `country`, `room_number`, `status`, `deposit`) VALUES
	('Passport', '2', 'Emily', 'Female', 'Russia', '2', 'Yes', '75'),
	('Passport', '3', 'Tim Burt', 'Male', 'Nepal', '8', 'Yes', '120');

-- Dumping structure for table w_project_02.driver
CREATE TABLE IF NOT EXISTS `driver` (
  `name` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `age` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `gender` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `company` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `brand` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `available` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `location` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table w_project_02.driver: ~2 rows (approximately)
INSERT INTO `driver` (`name`, `age`, `gender`, `company`, `brand`, `available`, `location`) VALUES
	('Paul Willianms', '44', 'Male', 'Peugeot', '207', 'Yes', 'A Park'),
	('Davis Mills', '35', 'Male', 'Audi', 'c3', 'Yes', 'B Park');

-- Dumping structure for table w_project_02.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `name` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `age` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `gender` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `job` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `salary` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `phone` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `aadhar` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `email` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table w_project_02.employee: ~3 rows (approximately)
INSERT INTO `employee` (`name`, `age`, `gender`, `job`, `salary`, `phone`, `aadhar`, `email`) VALUES
	('James Smith', '35', 'male', 'Front Desk Clerks', '2000', '11966301521', '554', 'lucio@gmail.com'),
	('Robert Brown', '30', 'male', 'Manager', '4000', '11966301599', '1231', 'robert@gmail.com'),
	('David Miller', '40', 'male', 'Kitchen Staff', '2500', '+551195540039', '123331', 'david@gmail.com');

-- Dumping structure for table w_project_02.login
CREATE TABLE IF NOT EXISTS `login` (
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table w_project_02.login: ~1 rows (approximately)
INSERT INTO `login` (`username`, `password`) VALUES
	('admin', '12345');

-- Dumping structure for table w_project_02.room
CREATE TABLE IF NOT EXISTS `room` (
  `room_number` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `availability` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `clean_status` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `price` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `bed_type` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table w_project_02.room: ~10 rows (approximately)
INSERT INTO `room` (`room_number`, `availability`, `clean_status`, `price`, `bed_type`) VALUES
	('1', 'Available', 'Used', '100', 'Single Bed'),
	('2', 'Occupied', 'Used', '100', 'Single Bed'),
	('3', 'Available', 'Cleaned', '100', 'Single Bed'),
	('4', 'Available', 'Cleaned', '100', 'Single Bed'),
	('5', 'Available', 'Cleaned', '100', 'Single Bed'),
	('6', 'Available', 'Cleaned', '180', 'Double Bed'),
	('7', 'Available', 'Cleaned', '180', 'Double Bed'),
	('8', 'Occupied', 'Used', '180', 'Double Bed'),
	('9', 'Available', 'Cleaned', '180', 'Double Bed'),
	('10', 'Available', 'Cleaned', '180', 'Double Bed');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
