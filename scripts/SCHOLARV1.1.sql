-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.16-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for scholar-backoffice
CREATE DATABASE IF NOT EXISTS `scholar-backoffice` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `scholar-backoffice`;

-- Dumping structure for table scholar-backoffice.addresses
CREATE TABLE IF NOT EXISTS `addresses` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL,
  `parent_type` varchar(255) DEFAULT NULL,
  `address_type` varchar(255) DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `status` enum('ACTIVE','ARCHIVED') DEFAULT 'ACTIVE',
  `date_created` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table scholar-backoffice.addresses: ~0 rows (approximately)
DELETE FROM `addresses`;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;

-- Dumping structure for table scholar-backoffice.contacts
CREATE TABLE IF NOT EXISTS `contacts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_type` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `contact_type` varchar(255) DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `status` enum('ACTIVE','ARCHIVED') DEFAULT 'ACTIVE',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table scholar-backoffice.contacts: ~0 rows (approximately)
DELETE FROM `contacts`;
/*!40000 ALTER TABLE `contacts` DISABLE KEYS */;
/*!40000 ALTER TABLE `contacts` ENABLE KEYS */;

-- Dumping structure for table scholar-backoffice.general_accounts
CREATE TABLE IF NOT EXISTS `general_accounts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_type` enum('NORMAL','ORGANISATION','COMPANY','SCHOLAR') DEFAULT NULL,
  `status` enum('ACTIVE','PENDING','APPROVED','REJECTED','UNDER_INVESTIGATION') DEFAULT NULL,
  `externalid` varchar(45) DEFAULT NULL,
  `date_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- Dumping data for table scholar-backoffice.general_accounts: ~9 rows (approximately)
DELETE FROM `general_accounts`;
/*!40000 ALTER TABLE `general_accounts` DISABLE KEYS */;
INSERT INTO `general_accounts` (`id`, `account_type`, `status`, `externalid`, `date_created`) VALUES
	(4, 'NORMAL', 'ACTIVE', '6IUKIMGR', '2017-11-21 01:05:13'),
	(5, 'NORMAL', 'ACTIVE', '6IUKKT4O', '2017-11-21 01:06:55'),
	(6, 'NORMAL', 'ACTIVE', '6IUKWMDG', '2017-11-21 01:16:06'),
	(7, 'NORMAL', 'ACTIVE', '6IUL0ILM', '2017-11-21 01:19:08'),
	(8, 'NORMAL', 'ACTIVE', '6IUO3WGG', '2017-11-21 02:45:45'),
	(9, 'NORMAL', 'ACTIVE', '6IUO935Q', '2017-11-21 02:49:47'),
	(10, 'NORMAL', 'ACTIVE', '6IUOSXA0', '2017-11-21 03:05:12'),
	(11, 'NORMAL', 'ACTIVE', '6IUOV5OF', '2017-11-21 03:06:56'),
	(12, 'NORMAL', 'ACTIVE', '6IUOYJFS', '2017-11-21 03:09:34');
/*!40000 ALTER TABLE `general_accounts` ENABLE KEYS */;

-- Dumping structure for table scholar-backoffice.permissions
CREATE TABLE IF NOT EXISTS `permissions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table scholar-backoffice.permissions: ~2 rows (approximately)
DELETE FROM `permissions`;
/*!40000 ALTER TABLE `permissions` DISABLE KEYS */;
INSERT INTO `permissions` (`id`, `name`, `code`) VALUES
	(1, '_ALL_FUNCTIONS', 'SC1'),
	(2, '_ACCOUNT_FUNCTIONS', 'SC2');
/*!40000 ALTER TABLE `permissions` ENABLE KEYS */;

-- Dumping structure for table scholar-backoffice.person
CREATE TABLE IF NOT EXISTS `person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `gender` enum('MALE','FEMALE') DEFAULT NULL,
  `marital_status` enum('SINGLE','MARRIED','OTHER') DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table scholar-backoffice.person: ~0 rows (approximately)
DELETE FROM `person`;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
/*!40000 ALTER TABLE `person` ENABLE KEYS */;

-- Dumping structure for table scholar-backoffice.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `isSystem` enum('Y','N') DEFAULT 'Y',
  `date_created` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `author_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table scholar-backoffice.roles: ~2 rows (approximately)
DELETE FROM `roles`;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`id`, `name`, `code`, `description`, `isSystem`, `date_created`, `author_id`) VALUES
	(1, 'ADMIN', 'ADMIN', 'ACCOUNT ADMINISTRATOR', 'Y', '2017-11-20 12:56:23', NULL),
	(2, 'SUPERADMIN', 'SUPERADMIN', 'FULLSYSTEMADMIN', 'Y', '2017-11-20 12:56:49', NULL);
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;

-- Dumping structure for table scholar-backoffice.role_permission
CREATE TABLE IF NOT EXISTS `role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_role_permission_1_idx` (`role_id`),
  KEY `fk_role_permission_2_idx` (`permission_id`),
  CONSTRAINT `FK2xn8qv4vw30i04xdxrpvn3bdi` FOREIGN KEY (`permission_id`) REFERENCES `permissions` (`id`),
  CONSTRAINT `FKtfgq8q9blrp0pt1pvggyli3v9` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `fk_role_permission_1` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_permission_2` FOREIGN KEY (`permission_id`) REFERENCES `permissions` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table scholar-backoffice.role_permission: ~2 rows (approximately)
DELETE FROM `role_permission`;
/*!40000 ALTER TABLE `role_permission` DISABLE KEYS */;
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES
	(1, 2, 1),
	(2, 1, 2);
/*!40000 ALTER TABLE `role_permission` ENABLE KEYS */;

-- Dumping structure for table scholar-backoffice.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_id` bigint(20) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `date_created` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` enum('ACTIVE','PENDING','ARCHIVED') DEFAULT 'ACTIVE',
  PRIMARY KEY (`id`),
  KEY `USER_general_account_idx` (`account_id`),
  KEY `fk_users_1_idx` (`person_id`),
  CONSTRAINT `USER_account` FOREIGN KEY (`account_id`) REFERENCES `general_accounts` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `USER_person` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Dumping data for table scholar-backoffice.users: ~6 rows (approximately)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `account_id`, `person_id`, `username`, `password`, `date_created`, `status`) VALUES
	(1, 7, NULL, 'Khalid mpovfgrt', 'kolpoiu', NULL, 'ACTIVE'),
	(2, 8, NULL, 'Khalid mpovfgrt', 'kolpoiu', NULL, 'ACTIVE'),
	(3, 9, NULL, 'Khalid mpovfgrt', 'kolpoiu', NULL, 'ACTIVE'),
	(4, 10, NULL, 'Khalid mpovfgrt', 'kolpoiu', NULL, 'ACTIVE'),
	(5, 11, NULL, 'Khalid mpovfgrt', 'kolpoiu', NULL, 'ACTIVE'),
	(6, 12, NULL, 'Khalid mpovfgrt', 'kolpoiu', NULL, 'ACTIVE');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Dumping structure for table scholar-backoffice.user_role
CREATE TABLE IF NOT EXISTS `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_role_1_idx` (`user_id`),
  KEY `fk_user_role_2_idx` (`role_id`),
  CONSTRAINT `fk_user_role_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_role_2` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table scholar-backoffice.user_role: ~1 rows (approximately)
DELETE FROM `user_role`;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`id`, `user_id`, `role_id`) VALUES
	(1, 6, 1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
