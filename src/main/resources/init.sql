-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.2.15-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for smg
CREATE DATABASE IF NOT EXISTS `smg` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `smg`;

-- Dumping structure for table smg.activities
CREATE TABLE IF NOT EXISTS `activities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `organizer` int(11) NOT NULL,
  `alternate` int(11) NOT NULL,
  `name` text NOT NULL,
  `description` text NOT NULL,
  `datetime` text NOT NULL,
  `archive` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table smg.activities: ~0 rows (approximately)
DELETE FROM `activities`;
/*!40000 ALTER TABLE `activities` DISABLE KEYS */;
INSERT INTO `activities` (`id`, `organizer`, `alternate`, `name`, `description`, `datetime`, `archive`) VALUES
	(1, 1, 2, 'SMG Open Mind', 'SMG Open Mind is a conference for everybody', '26 April 2019', b'0');
/*!40000 ALTER TABLE `activities` ENABLE KEYS */;

-- Dumping structure for table smg.clubs
CREATE TABLE IF NOT EXISTS `clubs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `organizer` int(11) NOT NULL,
  `alternate` int(11) NOT NULL,
  `name` text NOT NULL,
  `description` text NOT NULL,
  `datetime` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table smg.clubs: ~0 rows (approximately)
DELETE FROM `clubs`;
/*!40000 ALTER TABLE `clubs` DISABLE KEYS */;
/*!40000 ALTER TABLE `clubs` ENABLE KEYS */;

-- Dumping structure for table smg.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `telephone` text NOT NULL,
  `custom` text NOT NULL,
  `password` text NOT NULL,
  `role` text NOT NULL DEFAULT 'Student',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table smg.users: ~0 rows (approximately)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `name`, `telephone`, `custom`, `password`, `role`) VALUES
	(1, 'Lili Panaiotova', '+123456789', '<a style="color: white; text-decoration: underline;" href="mailto:lili@panaitova.com">lili@panaitova.com</a>', 'nqmam', 'Student'),
	(2, 'Alex Tsvetanov', '+123456789', '<a style="color: white; text-decoration: underline;" href="mailto:alex@tsalex.tk">alex@tsalex.tk</a>', 'nqmam', 'Student');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
