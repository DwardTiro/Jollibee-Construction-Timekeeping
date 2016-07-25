-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: timekeep
-- ------------------------------------------------------
-- Server version	5.6.26-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `user_type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'Jet Virtusio','jet','123','Administrator'),(2,'Robb Stark','robb','123','Encoder');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendance` (
  `entry_num` int(11) NOT NULL AUTO_INCREMENT,
  `emp_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `time_in` time NOT NULL,
  `time_out` time NOT NULL,
  `compute_salary` double unsigned DEFAULT '0',
  `paid` int(1) unsigned DEFAULT '0',
  `leave` int(1) unsigned DEFAULT '0',
  PRIMARY KEY (`entry_num`),
  UNIQUE KEY `index2` (`date`,`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendance_audit_trail`
--

DROP TABLE IF EXISTS `attendance_audit_trail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendance_audit_trail` (
  `attendance_audit_trail_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_id` int(11) NOT NULL,
  `attendance_entry_num` int(11) NOT NULL,
  `attribute` varchar(45) NOT NULL,
  `old_value` varchar(45) NOT NULL,
  `new_value` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `admin_id` int(11) NOT NULL,
  PRIMARY KEY (`attendance_audit_trail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance_audit_trail`
--

LOCK TABLES `attendance_audit_trail` WRITE;
/*!40000 ALTER TABLE `attendance_audit_trail` DISABLE KEYS */;
/*!40000 ALTER TABLE `attendance_audit_trail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `id_number` int(11) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `middle_name` varchar(45) NOT NULL,
  `salary` double NOT NULL,
  `project_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,1997,'Rodrik','Stark','Royce',1200,7),(2,1111,'Brandon','Stark','Flint',1000,7),(3,1234,'Robb','Stark','Tully',1300,NULL),(4,1235,'Sansa','Stark','Tully',1400,NULL),(5,1236,'Arya','Stark','Tully',1500,7),(6,1237,'Bran','Stark','Tully',1700,5),(7,1238,'Rickon','Stark','Tully',1700,NULL),(8,1239,'Catelyn','Stark','Flint',1700,7),(9,1240,'Eddard','Stark','Flint',1700,7),(10,1241,'Benjen','Stark','Flint',1700,7),(11,1242,'Lyarra','Stark','Flint',1700,7),(12,1000,'Rodrigo','Duterte','Obosen',1000,NULL);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_details_audit_trail`
--

DROP TABLE IF EXISTS `employee_details_audit_trail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_details_audit_trail` (
  `employee_details_audit_trail_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_id` int(11) NOT NULL,
  `attribute` varchar(45) NOT NULL,
  `old_value` varchar(45) NOT NULL,
  `new_value` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `admin_id` int(11) NOT NULL,
  PRIMARY KEY (`employee_details_audit_trail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_details_audit_trail`
--

LOCK TABLES `employee_details_audit_trail` WRITE;
/*!40000 ALTER TABLE `employee_details_audit_trail` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_details_audit_trail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payroll`
--

DROP TABLE IF EXISTS `payroll`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payroll` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_now` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payroll`
--

LOCK TABLES `payroll` WRITE;
/*!40000 ALTER TABLE `payroll` DISABLE KEYS */;
/*!40000 ALTER TABLE `payroll` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payroll_entry`
--

DROP TABLE IF EXISTS `payroll_entry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payroll_entry` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `payroll_id` int(11) NOT NULL,
  `attendance_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payroll_entry`
--

LOCK TABLES `payroll_entry` WRITE;
/*!40000 ALTER TABLE `payroll_entry` DISABLE KEYS */;
/*!40000 ALTER TABLE `payroll_entry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `projectID` int(11) NOT NULL AUTO_INCREMENT,
  `projectName` varchar(45) NOT NULL,
  `dateStarted` date NOT NULL,
  `dateDue` date NOT NULL,
  PRIMARY KEY (`projectID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'SM Santa Rosa','2015-07-31','2016-07-31'),(2,'Jollibee Santa Rosa','2015-07-30','2016-07-30'),(3,'Jollibee San Pablo','2015-07-29','2016-07-29'),(4,'SM Calamba','2015-07-28','2016-07-28'),(5,'Jollibee Calamba','2015-07-27','2016-07-27'),(6,'SM Binan','2015-07-26','2016-07-26'),(7,'Jollibee Binan','2015-07-25','2016-07-25'),(8,'Jollibee San Pedro','2015-07-24','2016-07-24'),(9,'SM San Pablo','2015-07-23','2016-07-23'),(10,'SM San Pedro','2015-07-22','2016-07-22');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-25 13:31:35
