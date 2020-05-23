CREATE DATABASE  IF NOT EXISTS `rentCompany` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `rentCompany`;
-- MySQL dump 10.13  Distrib 8.0.17, for macos10.14 (x86_64)
--
-- Host: localhost    Database: rentCompany
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Accessory`
--

DROP TABLE IF EXISTS `Accessory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Accessory` (
  `AccessoryID` int(11) NOT NULL,
  `AccessoryName` varchar(50) DEFAULT NULL,
  `PricePerDay` double DEFAULT NULL,
  PRIMARY KEY (`AccessoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Accessory`
--

LOCK TABLES `Accessory` WRITE;
/*!40000 ALTER TABLE `Accessory` DISABLE KEYS */;
/*!40000 ALTER TABLE `Accessory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Address`
--

DROP TABLE IF EXISTS `Address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Address` (
  `AddressID` int(11) NOT NULL AUTO_INCREMENT,
  `Street` varchar(50) DEFAULT NULL,
  `HouseNumber` int(11) DEFAULT NULL,
  `Addition` varchar(50) DEFAULT NULL,
  `PostalCode` varchar(10) DEFAULT NULL,
  `City` varchar(50) DEFAULT NULL,
  `Province` varchar(50) DEFAULT NULL,
  `Country` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`AddressID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Address`
--

LOCK TABLES `Address` WRITE;
/*!40000 ALTER TABLE `Address` DISABLE KEYS */;
INSERT INTO `Address` VALUES (1,'Harpstraat',34,'A','5642RB','Eindhoven','Noord Brabant','Nederland'),(2,'Assepoester',19,'A','5629KE','Eindhoven','Noord brabant','Nederland'),(3,'Bosweg',15,'','1456XY','Appeldoorn','Gelderland','Nederland'),(4,'Heliosstraat',11,'B','1430','Aalsmeer','Noord Holland','Nederland'),(5,'Koningslaan',50,'XYZ','5600','Best','Noord brabant','Nederland'),(6,'Meerzorg',30,'X','5944','Arcen','Limburg','Nederland'),(7,'Zichtweg',122,'','8100NW','Zwolle','Overijsel','Nederland');
/*!40000 ALTER TABLE `Address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (14),(14);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Order`
--

DROP TABLE IF EXISTS `Order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Order` (
  `OrderID` int(11) NOT NULL,
  `Username` varchar(50) DEFAULT NULL,
  `OrderDate` date DEFAULT NULL,
  `ShipDate` datetime DEFAULT NULL,
  `Price` double DEFAULT NULL,
  PRIMARY KEY (`OrderID`),
  KEY `FK` (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Order`
--

LOCK TABLES `Order` WRITE;
/*!40000 ALTER TABLE `Order` DISABLE KEYS */;
/*!40000 ALTER TABLE `Order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Order_Accessory`
--

DROP TABLE IF EXISTS `Order_Accessory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Order_Accessory` (
  `OrderAccessoryID` int(11) NOT NULL,
  `OrderID` int(11) DEFAULT NULL,
  `AccessoryID` int(11) DEFAULT NULL,
  PRIMARY KEY (`OrderAccessoryID`),
  KEY `FK` (`OrderID`,`AccessoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Order_Accessory`
--

LOCK TABLES `Order_Accessory` WRITE;
/*!40000 ALTER TABLE `Order_Accessory` DISABLE KEYS */;
/*!40000 ALTER TABLE `Order_Accessory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Order_Vehicle`
--

DROP TABLE IF EXISTS `Order_Vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Order_Vehicle` (
  `OrderVehicleID` int(11) NOT NULL,
  `OrderID` int(11) DEFAULT NULL,
  `VehicleID` int(11) DEFAULT NULL,
  PRIMARY KEY (`OrderVehicleID`),
  KEY `FK` (`OrderID`,`VehicleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Order_Vehicle`
--

LOCK TABLES `Order_Vehicle` WRITE;
/*!40000 ALTER TABLE `Order_Vehicle` DISABLE KEYS */;
/*!40000 ALTER TABLE `Order_Vehicle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `User` (
  `UserID` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(50) DEFAULT NULL,
  `LastName` varchar(50) DEFAULT NULL,
  `DateOfBirth` date DEFAULT NULL,
  `AddressID` int(11) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(150) NOT NULL,
  `RegisterDate` date DEFAULT NULL,
  `RoleName` varchar(50) DEFAULT NULL,
  `Enabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`UserID`),
  KEY `fk_address_id_idx` (`AddressID`),
  CONSTRAINT `fk_address_id` FOREIGN KEY (`AddressID`) REFERENCES `address` (`AddressID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1,'Zdzislaw','Pietrewicz','1984-11-28',1,'zdzis','123','2020-05-17','ROLE_USER',1),(2,'Dominika','Osuchowska','2020-05-19',2,'domi','{bcrypt}$2a$10$CL9.0tZxX0I3nypZEdBt0.BfLq9XKmPF92/FrZcMEF7f9PhkvRpIm','2020-05-19','ROLE_USER',1),(3,'Sharp','Leo','1990-01-04',3,'Sharp','{bcrypt}$2a$10$nLUnO1bbh2rkazjzFI6.v.pGVKasnS7Z25NN2PL6SJZndF/srsB7W','2020-05-21','ROLE_USER',1),(4,'George','Long','1980-05-04',4,'george','{bcrypt}$2a$10$MzMNH.kMD8zAyB/2D.iq1.zXXRQxmgNu.ruULt1bQpeITDwFGedtu','2020-05-21','ROLE_USER',1),(5,'Maja','Stevens','1972-04-14',5,'maja','{bcrypt}$2a$10$DhIxJlWXb2jr0MgVuxDgVedNxG2Ro5JRqvNj.Br7d71ZgOPefWbem','2020-05-21','ROLE_USER',1),(6,'Sophia','Beckbau','1983-04-15',6,'sophia','{bcrypt}$2a$10$da4qsYL51UN035bCQvf2zuGYnEE.bVLY6Or4LpgLUKP6.w8Ai6b2e','2020-05-21','ROLE_USER',1),(7,'Stefan','de Vries','1978-12-26',7,'stefan','{bcrypt}$2a$10$zZ5dXD4iSP/Gs14ZsDPhk./2HKhQIjthcnmlxWjhZtVv.ICen1x92','2020-05-21','ROLE_USER',1);
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Vehicle`
--

DROP TABLE IF EXISTS `Vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Vehicle` (
  `VehicleID` int(11) NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `TypeOfVehicle` varchar(10) DEFAULT NULL,
  `ClassOfVehicle` varchar(1) DEFAULT NULL,
  `Engine` int(11) DEFAULT NULL,
  `NumberOfSeats` int(11) DEFAULT NULL,
  `PricePerDay` double DEFAULT NULL,
  `FuelType` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`VehicleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Vehicle`
--

LOCK TABLES `Vehicle` WRITE;
/*!40000 ALTER TABLE `Vehicle` DISABLE KEYS */;
/*!40000 ALTER TABLE `Vehicle` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-21 13:10:00
