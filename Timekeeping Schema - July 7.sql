CREATE DATABASE  IF NOT EXISTS `timekeep` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `timekeep`;
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'jet','jet','123');
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
  `emp_id` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `time_in` time NOT NULL,
  `time_out` time NOT NULL,
  `compute_salary` double unsigned DEFAULT '0',
  `paid` int(1) unsigned DEFAULT '0',
  `leave` int(1) unsigned DEFAULT '0',
  PRIMARY KEY (`entry_num`),
  UNIQUE KEY `index2` (`date`,`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES (4,'400','1970-01-01','19:24:09','21:24:00',NULL,NULL,NULL),(6,'400','2016-06-27','19:25:56','21:25:00',NULL,NULL,NULL),(7,'400','2016-06-28','15:53:20','15:53:20',NULL,NULL,NULL),(8,'400','2016-06-06','15:56:58','17:56:00',NULL,NULL,NULL),(9,'321','2016-06-09','17:14:34','19:14:00',NULL,NULL,NULL),(10,'0','2016-07-01','18:59:46','16:59:00',NULL,NULL,NULL),(11,'0','2017-06-08','19:00:52','19:00:52',NULL,NULL,NULL),(12,'321','2017-06-07','19:01:06','19:01:06',NULL,NULL,NULL),(13,'321','2016-07-01','19:20:59','20:20:00',NULL,NULL,NULL),(14,'321','2016-08-01','19:38:00','19:38:00',NULL,NULL,NULL),(15,'321','2016-09-01','19:38:00','19:38:00',0,0,0),(16,'321','2016-07-02','21:15:21','22:15:00',4076620,0,0),(17,'321','2016-07-03','21:16:18','23:16:00',210,0,0),(18,'321','2016-07-04','21:19:53','22:19:00',220,0,0),(19,'321','2016-07-06','21:35:51','22:35:00',10,0,0),(20,'321','2016-07-08','21:41:44','21:41:44',0,0,0),(21,'321','2016-07-13','21:46:03','21:46:03',0,0,0),(22,'321','2016-07-10','21:46:37','21:46:37',0,0,0),(23,'321','2016-07-15','21:55:30','23:55:00',20,0,0),(24,'321','2016-07-09','21:56:43','22:56:00',10,0,0),(25,'400','2016-07-01','22:00:19','23:00:00',200,0,0);
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `middle_name` varchar(45) NOT NULL,
  `salary` double NOT NULL,
  `project_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=911 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (321,'Jet','Virtusio','Cor',10,NULL),(400,'Jet','2nd','2nd',200,NULL),(901,'Firstname','Lastname','woah',10,NULL),(902,'Firstname','Lastname','woah',100,NULL),(903,'arren1','arren','arren',100,NULL),(904,'arren2','arren','arren',100,NULL),(905,'arren3','arren','arren',100,NULL),(906,'arren4','arren','arren',100,NULL),(907,'arren5','arren','arren',100,NULL),(908,'arren6','arren','arren',100,NULL),(909,'arren7','arren','arren',100,NULL),(910,'arren8','arren','arren',100,NULL);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payroll`
--

DROP TABLE IF EXISTS `payroll`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payroll` (
  `id` int(11) NOT NULL,
  `date_now` date DEFAULT NULL,
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
  `id` int(11) NOT NULL,
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
  `projectID` int(11) NOT NULL,
  `projectName` varchar(45) NOT NULL,
  `dateStarted` date NOT NULL,
  `dateDue` date NOT NULL,
  PRIMARY KEY (`projectID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
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

-- Dump completed on 2016-07-06 17:01:41
