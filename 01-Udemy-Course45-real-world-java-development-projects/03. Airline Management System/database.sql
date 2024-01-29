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

-- Dumping structure for table w_project_03.flight_info
CREATE TABLE IF NOT EXISTS `flight_info` (
  `company` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `source` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `destination` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `date` varchar(50) DEFAULT NULL,
  `time` varchar(50) DEFAULT NULL,
  `code` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `plane_model` varchar(50) DEFAULT NULL,
  `remaining_executive_chairs` varchar(50) DEFAULT NULL,
  `remaining_popular_chairs` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table w_project_03.flight_info: ~2 rows (approximately)
INSERT INTO `flight_info` (`company`, `source`, `destination`, `date`, `time`, `code`, `plane_model`, `remaining_executive_chairs`, `remaining_popular_chairs`) VALUES
	('TAM', 'São Paulo - Guarulhos', 'Rio de Janeiro - Santos Dummont', '25/05/2023', '07:00', 'A001', 'BOEING 777-200ER/LR', '99', '189'),
	('TAM', 'São Paulo - Congonhas', 'Rio de Janeiro - Santos Dummont', '25/05/2023', '07:00', 'A002', 'BOEING 747-400', '150', '220');

-- Dumping structure for table w_project_03.login
CREATE TABLE IF NOT EXISTS `login` (
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table w_project_03.login: ~1 rows (approximately)
INSERT INTO `login` (`username`, `password`) VALUES
	('admin', '12345');

-- Dumping structure for table w_project_03.plane
CREATE TABLE IF NOT EXISTS `plane` (
  `model` varchar(50) DEFAULT NULL,
  `executive_class_capacity` varchar(50) DEFAULT NULL,
  `popular_class_capacity` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table w_project_03.plane: ~3 rows (approximately)
INSERT INTO `plane` (`model`, `executive_class_capacity`, `popular_class_capacity`) VALUES
	('BOEING 777-200ER/LR', '100', '190'),
	('BOEING 747-400', '150', '220'),
	('BOEING 737-800', '50', '110');

-- Dumping structure for table w_project_03.ticket
CREATE TABLE IF NOT EXISTS `ticket` (
  `passenger_name` varchar(50) DEFAULT NULL,
  `fight_code` varchar(50) DEFAULT NULL,
  `chair_class` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table w_project_03.ticket: ~2 rows (approximately)
INSERT INTO `ticket` (`passenger_name`, `fight_code`, `chair_class`) VALUES
	('Dale Nelson', 'A001', 'Executive'),
	('Britney Jordan', 'A001', 'Popular');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
