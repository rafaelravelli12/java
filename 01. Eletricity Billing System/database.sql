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


-- Dumping database structure for w_project_01
CREATE DATABASE IF NOT EXISTS `w_project_01` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `w_project_01`;

-- Dumping structure for table w_project_01.bill
CREATE TABLE IF NOT EXISTS `bill` (
  `meter` varchar(20) DEFAULT NULL,
  `month` varchar(20) DEFAULT NULL,
  `units` varchar(20) DEFAULT NULL,
  `total_bill` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table w_project_01.bill: ~0 rows (approximately)
INSERT INTO `bill` (`meter`, `month`, `units`, `total_bill`, `status`) VALUES
	('551604', 'January', '80', '870', 'Not Paid');

-- Dumping structure for table w_project_01.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `name` varchar(30) DEFAULT NULL,
  `meter` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table w_project_01.customer: ~0 rows (approximately)
INSERT INTO `customer` (`name`, `meter`, `address`, `city`, `state`, `email`, `phone`) VALUES
	('customer1', '551604', 'Av. Paulista', 'São paulo', 'SP', 'customer@gmail.com', '+5511966301500');

-- Dumping structure for table w_project_01.login
CREATE TABLE IF NOT EXISTS `login` (
  `meter_no` varchar(20) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `user` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table w_project_01.login: ~2 rows (approximately)
INSERT INTO `login` (`meter_no`, `username`, `name`, `password`, `user`) VALUES
	('', 'admin1', 'admin1_name', 'admin1', 'Admin'),
	('551604', 'customer1', 'customer1', 'customer1', 'Customer');

-- Dumping structure for table w_project_01.meter_info
CREATE TABLE IF NOT EXISTS `meter_info` (
  `meter_number` varchar(20) DEFAULT NULL,
  `meter_location` varchar(20) DEFAULT NULL,
  `meter_type` varchar(20) DEFAULT NULL,
  `phase_code` varchar(20) DEFAULT NULL,
  `bill_type` varchar(20) DEFAULT NULL,
  `days` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table w_project_01.meter_info: ~0 rows (approximately)
INSERT INTO `meter_info` (`meter_number`, `meter_location`, `meter_type`, `phase_code`, `bill_type`, `days`) VALUES
	('551604', 'Inside', 'Solar Meter', '022', 'Normal', '30');

-- Dumping structure for table w_project_01.tax
CREATE TABLE IF NOT EXISTS `tax` (
  `cost_per_unit` varchar(20) DEFAULT NULL,
  `meter_rent` varchar(20) DEFAULT NULL,
  `service_charge` varchar(20) DEFAULT NULL,
  `service_tax` varchar(20) DEFAULT NULL,
  `swacch_bharat_cess` varchar(20) DEFAULT NULL,
  `fixed_tax` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table w_project_01.tax: ~0 rows (approximately)
INSERT INTO `tax` (`cost_per_unit`, `meter_rent`, `service_charge`, `service_tax`, `swacch_bharat_cess`, `fixed_tax`) VALUES
	('9', '47', '22', '57', '6', '18');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
