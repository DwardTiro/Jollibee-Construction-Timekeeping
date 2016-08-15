CREATE DATABASE  IF NOT EXISTS `timekeep` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `timekeep`;
-- MySQL dump 10.13  Distrib 5.7.14, for Win64 (x86_64)
--
-- Host: localhost    Database: timekeep
-- ------------------------------------------------------
-- Server version	5.7.14-log

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
  `password` varchar(256) NOT NULL,
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
INSERT INTO `admin` VALUES (1,'Jet Virtusio','jet','db4ff451c343bfe65d6d184d42bcb7aa9ae3e41a7fafe5f8f7c42a784a9bebbe','Administrator'),(2,'Robb Stark','robb','db4ff451c343bfe65d6d184d42bcb7aa9ae3e41a7fafe5f8f7c42a784a9bebbe','Encoder');
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
) ENGINE=InnoDB AUTO_INCREMENT=189 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES (1,3,'2016-07-20','08:00:00','16:00:00',10400,0,0),(2,3,'2016-07-21','08:00:00','16:00:00',10400,0,0),(3,3,'2016-07-22','08:00:00','15:00:00',9100,0,0),(4,3,'2016-07-23','08:00:00','18:00:00',13650,0,0),(5,3,'2016-07-24','08:00:00','17:00:00',12025,0,0),(6,3,'2016-07-25','08:00:00','16:00:00',10400,0,0),(7,3,'2016-07-26','08:00:00','16:00:00',10400,0,0),(8,3,'2016-07-27','08:00:00','16:00:00',10400,0,0),(9,3,'2016-07-28','08:00:00','16:00:00',10400,0,0),(10,3,'2016-07-29','08:00:00','16:00:00',10400,0,0),(11,3,'2016-07-30','08:00:00','17:00:00',12025,0,0),(12,3,'2016-07-31','08:00:00','17:00:00',12025,0,0),(13,3,'2016-08-01','08:00:00','17:00:00',12025,0,0),(14,3,'2016-08-02','08:00:00','17:00:00',12025,0,0),(15,3,'2016-08-03','08:00:00','17:00:00',12025,0,0),(16,3,'2016-08-04','08:00:00','17:00:00',12025,0,0),(17,3,'2016-08-05','08:00:00','17:00:00',12025,0,0),(18,3,'2016-08-06','08:00:00','17:00:00',12025,0,0),(19,3,'2016-08-07','08:00:00','17:00:00',12025,0,0),(20,3,'2016-08-08','08:00:00','16:00:00',10400,0,0),(21,3,'2016-08-09','08:00:00','16:00:00',10400,0,0),(22,3,'2016-08-10','08:00:00','16:00:00',10400,0,0),(23,3,'2016-08-11','08:00:00','16:00:00',10400,0,0),(24,3,'2016-08-12','08:00:00','17:00:00',12025,0,0),(25,3,'2016-08-13','08:00:00','17:00:00',12025,0,0),(26,3,'2016-08-14','08:00:00','17:00:00',12025,0,0),(27,4,'2016-07-21','08:00:00','16:00:00',11200,0,0),(28,4,'2016-07-22','08:00:00','16:00:00',11200,0,0),(29,4,'2016-07-23','08:00:00','16:00:00',11200,0,0),(30,4,'2016-07-24','08:00:00','16:00:00',11200,0,0),(31,4,'2016-07-25','08:00:00','16:00:00',11200,0,0),(32,4,'2016-07-26','08:00:00','16:00:00',11200,0,0),(33,4,'2016-07-27','08:00:00','16:00:00',11200,0,0),(34,4,'2016-07-28','08:00:00','16:00:00',11200,0,0),(35,4,'2016-07-29','08:00:00','17:00:00',12950,0,0),(36,4,'2016-07-30','08:00:00','17:00:00',12950,0,0),(37,4,'2016-07-31','08:00:00','17:00:00',12950,0,0),(38,4,'2016-08-01','08:00:00','16:00:00',11200,0,0),(39,4,'2016-08-02','08:00:00','16:00:00',11200,0,0),(40,4,'2016-08-03','08:00:00','15:00:00',9800,0,0),(41,4,'2016-08-04','08:00:00','15:00:00',9800,0,0),(42,4,'2016-08-05','08:00:00','15:00:00',9800,0,0),(43,4,'2016-08-06','08:00:00','17:00:00',12950,0,1),(44,4,'2016-08-07','08:00:00','17:00:00',12950,0,1),(45,4,'2016-08-08','08:00:00','17:00:00',12950,0,1),(46,4,'2016-08-09','08:00:00','17:00:00',12950,0,1),(47,4,'2016-08-10','08:00:00','16:00:00',11200,0,0),(48,4,'2016-08-11','08:00:00','16:00:00',11200,0,0),(49,4,'2016-08-12','08:00:00','16:00:00',11200,0,0),(50,4,'2016-08-13','08:00:00','16:00:00',11200,0,0),(51,4,'2016-08-14','08:00:00','17:00:00',12950,0,1),(52,6,'2016-07-21','08:00:00','17:00:00',15725,0,0),(53,6,'2016-07-22','08:00:00','17:00:00',15725,0,0),(54,6,'2016-07-23','08:00:00','17:00:00',15725,0,0),(55,6,'2016-07-24','08:00:00','17:00:00',15725,0,0),(56,6,'2016-07-25','08:00:00','17:00:00',15725,0,0),(57,6,'2016-07-26','08:00:00','17:00:00',15725,0,0),(58,6,'2016-07-27','08:00:00','17:00:00',15725,0,0),(59,6,'2016-07-28','08:00:00','17:00:00',15725,0,0),(60,6,'2016-07-29','08:00:00','17:00:00',15725,0,0),(61,6,'2016-07-30','08:00:00','16:00:00',13600,0,0),(62,6,'2016-07-31','08:00:00','16:00:00',13600,0,0),(63,6,'2016-08-01','08:00:00','16:00:00',13600,0,0),(64,6,'2016-08-02','08:00:00','16:00:00',13600,0,0),(65,6,'2016-08-03','08:00:00','16:00:00',13600,0,0),(66,6,'2016-08-04','08:00:00','16:00:00',13600,0,0),(67,6,'2016-08-05','08:00:00','16:00:00',13600,0,0),(68,6,'2016-08-06','08:00:00','15:00:00',11900,0,0),(69,6,'2016-08-07','08:00:00','15:00:00',11900,0,0),(70,6,'2016-08-08','08:00:00','15:00:00',11900,0,0),(71,6,'2016-08-09','08:00:00','15:00:00',11900,0,0),(72,6,'2016-08-10','08:00:00','15:00:00',11900,0,0),(73,6,'2016-08-11','08:00:00','15:00:00',11900,0,0),(74,6,'2016-08-12','08:00:00','15:00:00',11900,0,0),(75,6,'2016-08-13','08:00:00','17:00:00',15725,0,0),(76,6,'2016-08-14','08:00:00','17:00:00',15725,0,0),(77,5,'2016-07-21','08:00:00','16:00:00',12000,0,0),(78,5,'2016-07-22','08:00:00','16:00:00',12000,0,0),(79,5,'2016-07-23','08:00:00','16:00:00',12000,0,0),(80,5,'2016-07-24','08:00:00','16:00:00',12000,0,0),(81,5,'2016-07-25','08:00:00','16:00:00',12000,0,0),(82,5,'2016-07-26','08:00:00','16:00:00',12000,0,0),(83,5,'2016-07-27','08:00:00','16:00:00',12000,0,0),(84,5,'2016-07-28','08:00:00','17:00:00',13875,0,0),(85,5,'2016-07-29','08:00:00','17:00:00',13875,0,0),(86,5,'2016-07-30','08:00:00','17:00:00',13875,0,0),(87,5,'2016-07-31','08:00:00','17:00:00',13875,0,0),(88,5,'2016-08-01','08:00:00','17:00:00',13875,0,1),(89,5,'2016-08-02','08:00:00','17:00:00',13875,0,1),(90,5,'2016-08-03','08:00:00','17:00:00',13875,0,1),(91,5,'2016-08-04','08:00:00','17:00:00',13875,0,0),(92,5,'2016-08-05','08:00:00','17:00:00',13875,0,0),(93,5,'2016-08-06','08:00:00','17:00:00',13875,0,0),(94,5,'2016-08-07','08:00:00','15:00:00',10500,0,0),(95,5,'2016-08-08','08:00:00','15:00:00',10500,0,0),(96,5,'2016-08-09','08:00:00','15:00:00',10500,0,0),(97,5,'2016-08-10','08:00:00','17:00:00',13875,0,0),(98,5,'2016-08-11','08:00:00','16:00:00',12000,0,0),(99,5,'2016-08-12','08:00:00','16:00:00',12000,0,0),(100,5,'2016-08-13','08:00:00','16:00:00',12000,0,0),(101,5,'2016-08-14','08:00:00','16:00:00',12000,0,0),(102,7,'2016-07-21','08:00:00','17:00:00',15725,0,0),(103,7,'2016-07-22','08:00:00','17:00:00',15725,0,0),(104,7,'2016-07-23','08:00:00','17:00:00',15725,0,0),(105,7,'2016-07-24','08:00:00','17:00:00',15725,0,0),(106,7,'2016-07-25','08:00:00','17:00:00',15725,0,0),(107,7,'2016-07-26','08:00:00','17:00:00',15725,0,0),(108,7,'2016-07-27','08:00:00','17:00:00',15725,0,0),(109,7,'2016-07-28','08:00:00','17:00:00',15725,0,0),(110,7,'2016-07-29','08:00:00','17:00:00',15725,0,0),(111,7,'2016-07-30','08:00:00','17:00:00',15725,0,0),(112,7,'2016-07-31','08:00:00','17:00:00',15725,0,0),(113,7,'2016-08-02','08:00:00','17:00:00',15725,0,0),(114,7,'2016-08-01','08:00:00','17:00:00',15725,0,0),(115,7,'2016-08-03','08:00:00','17:00:00',15725,0,0),(116,7,'2016-08-04','08:00:00','17:00:00',15725,0,0),(117,7,'2016-08-05','08:00:00','17:00:00',15725,0,0),(118,7,'2016-08-06','08:00:00','17:00:00',15725,0,0),(119,7,'2016-08-07','08:00:00','17:00:00',15725,0,0),(120,7,'2016-08-08','08:00:00','17:00:00',15725,0,0),(121,7,'2016-08-09','08:00:00','17:00:00',15725,0,0),(122,7,'2016-08-10','08:00:00','17:00:00',15725,0,0),(123,7,'2016-08-11','08:00:00','17:00:00',15725,0,0),(124,7,'2016-08-12','08:00:00','17:00:00',15725,0,0),(125,7,'2016-08-13','08:00:00','17:00:00',15725,0,0),(126,7,'2016-08-14','08:00:00','17:00:00',15725,0,0),(127,1,'2016-07-15','08:00:00','17:00:00',11100,0,0),(128,1,'2016-07-16','08:00:00','17:00:00',11100,0,0),(129,1,'2016-07-17','08:00:00','17:00:00',11100,0,0),(130,1,'2016-07-18','08:00:00','17:00:00',11100,0,0),(131,1,'2016-07-19','08:00:00','17:00:00',11100,0,0),(132,1,'2016-07-20','08:00:00','15:00:00',8400,0,0),(133,1,'2016-07-21','08:00:00','15:00:00',8400,0,0),(134,1,'2016-07-22','08:00:00','17:00:00',11100,0,0),(135,1,'2016-07-23','08:00:00','16:00:00',9600,0,0),(136,1,'2016-07-24','08:00:00','16:00:00',9600,0,0),(137,1,'2016-07-25','08:00:00','16:00:00',9600,0,0),(138,1,'2016-07-26','08:00:00','16:00:00',9600,0,0),(139,1,'2016-07-27','08:00:00','16:00:00',9600,0,0),(140,1,'2016-07-28','08:00:00','16:00:00',9600,0,0),(141,1,'2016-07-29','08:00:00','17:00:00',11100,0,0),(142,1,'2016-07-30','08:00:00','17:00:00',11100,0,0),(143,1,'2016-07-31','08:00:00','17:00:00',11100,0,0),(144,1,'2016-08-01','08:00:00','17:00:00',11100,0,1),(145,1,'2016-08-02','08:00:00','17:00:00',11100,0,1),(146,1,'2016-08-03','08:00:00','17:00:00',11100,0,1),(147,1,'2016-08-04','08:00:00','17:00:00',11100,0,1),(148,1,'2016-08-05','08:00:00','17:00:00',11100,0,1),(149,1,'2016-08-06','08:00:00','17:00:00',11100,0,1),(150,1,'2016-08-07','08:00:00','17:00:00',11100,0,0),(151,1,'2016-08-08','08:00:00','17:00:00',11100,0,0),(152,1,'2016-08-09','08:00:00','17:00:00',11100,0,0),(153,1,'2016-08-10','08:00:00','17:00:00',11100,0,0),(154,1,'2016-08-11','08:00:00','17:00:00',11100,0,1),(155,1,'2016-08-12','08:00:00','17:00:00',11100,0,0),(156,1,'2016-08-13','08:00:00','17:00:00',11100,0,0),(157,1,'2016-08-14','08:00:00','17:00:00',11100,0,0),(158,2,'2016-07-15','08:00:00','17:00:00',9250,0,0),(159,2,'2016-07-16','08:00:00','17:00:00',9250,0,0),(160,2,'2016-07-17','08:00:00','17:00:00',9250,0,0),(161,2,'2016-07-18','08:00:00','17:00:00',9250,0,0),(162,2,'2016-07-19','08:00:00','17:00:00',9250,0,0),(163,2,'2016-07-20','08:00:00','17:00:00',9250,0,0),(164,2,'2016-07-21','08:00:00','17:00:00',9250,0,0),(165,2,'2016-07-22','08:00:00','17:00:00',9250,0,0),(166,2,'2016-07-23','08:00:00','17:00:00',9250,0,0),(167,2,'2016-07-24','08:00:00','16:00:00',8000,0,0),(168,2,'2016-07-25','08:00:00','16:00:00',8000,0,0),(169,2,'2016-07-26','08:00:00','16:00:00',8000,0,0),(170,2,'2016-07-27','08:00:00','16:00:00',8000,0,0),(171,2,'2016-07-28','08:00:00','16:00:00',8000,0,0),(172,2,'2016-07-29','08:00:00','16:00:00',8000,0,0),(173,2,'2016-07-30','08:00:00','15:00:00',7000,0,0),(174,2,'2016-07-31','08:00:00','15:00:00',7000,0,0),(175,2,'2016-08-01','08:00:00','17:00:00',9250,0,1),(176,2,'2016-08-02','08:00:00','16:00:00',8000,0,0),(177,2,'2016-08-03','08:00:00','16:00:00',8000,0,0),(178,2,'2016-08-04','08:00:00','16:00:00',8000,0,0),(179,2,'2016-08-05','08:00:00','17:00:00',9250,0,1),(180,2,'2016-08-06','08:00:00','17:00:00',9250,0,1),(181,2,'2016-08-07','08:00:00','17:00:00',9250,0,1),(182,2,'2016-08-08','08:00:00','17:00:00',9250,0,1),(183,2,'2016-08-09','08:00:00','17:00:00',9250,0,0),(184,2,'2016-08-10','08:00:00','17:00:00',9250,0,0),(185,2,'2016-08-11','08:00:00','17:00:00',9250,0,0),(186,2,'2016-08-12','08:00:00','17:00:00',9250,0,0),(187,2,'2016-08-13','08:00:00','17:00:00',9250,0,0),(188,2,'2016-08-14','08:00:00','17:00:00',9250,0,0);
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
  PRIMARY KEY (`emp_id`),
  UNIQUE KEY `id_number_UNIQUE` (`id_number`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,1997,'Rodrik','Stark','Royce',1200,1),(2,1111,'Brandon','Stark','Flint',1000,1),(3,1234,'Robb','Stark','Tully',1300,3),(4,1235,'Sansa','Stark','Tully',1400,4),(5,1236,'Arya','Stark','Tully',1500,4),(6,1237,'Bran','Stark','Tully',1700,4),(7,1238,'Rickon','Stark','Tully',1700,4),(8,1239,'Catelyn','Stark','Flint',1700,NULL),(9,1240,'Eddard','Stark','Flint',1700,NULL),(10,1241,'Benjen','Stark','Flint',1700,NULL),(11,1242,'Lyarra','Stark','Flint',1700,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_details_audit_trail`
--

LOCK TABLES `employee_details_audit_trail` WRITE;
/*!40000 ALTER TABLE `employee_details_audit_trail` DISABLE KEYS */;
INSERT INTO `employee_details_audit_trail` VALUES (1,1,'Project','-1','1','2016-07-15','17:00:00',1),(2,2,'Project','-1','1','2016-07-15','17:00:00',1),(3,3,'Project','-1','3','2016-07-20','17:00:00',1),(4,4,'Project','-1','4','2016-07-21','17:00:00',1),(5,5,'Project','-1','4','2016-07-21','17:00:00',1),(6,6,'Project','-1','4','2016-07-21','17:00:00',1),(7,7,'Project','-1','4','2016-07-21','17:00:00',1);
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
INSERT INTO `project` VALUES (1,'Castle Black','2016-07-01','2016-08-14'),(2,'The Wall','2015-07-02','2016-08-15'),(3,'The Twins','2015-07-03','2016-08-16'),(4,'Winterfell','2015-07-04','2016-08-17'),(5,'Red Keep','2015-07-05','2016-08-18'),(6,'Riverrun','2015-07-06','2016-08-19'),(7,'Casterly Rock','2015-07-07','2016-08-20'),(8,'Harrenhal','2015-07-08','2016-08-21'),(9,'Dragonstone','2015-07-09','2016-08-22'),(10,'The Eyrie','2015-07-10','2016-08-23');
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

-- Dump completed on 2016-08-15 23:06:39
