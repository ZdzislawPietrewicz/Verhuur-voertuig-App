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
  `FirstName` varchar(50) DEFAULT NULL,
  `LastName` varchar(50) DEFAULT NULL,
  `DateOfBirth` date DEFAULT NULL,
  `Street` varchar(50) DEFAULT NULL,
  `HouseNumber` int(11) DEFAULT NULL,
  `Addition` varchar(5) DEFAULT NULL,
  `PostalCode` varchar(6) DEFAULT NULL,
  `Province` varchar(50) DEFAULT NULL,
  `Country` varchar(50) DEFAULT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(100) DEFAULT NULL,
  `RegisterDate` date DEFAULT NULL,
  `RoleName` varchar(50) DEFAULT NULL,
  `Enabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES ('jan','de Wit','1960-10-09','Paradijslaan',20,'B','1020XY','Noord Holland','Nederland','jan','{bcrypt}$2a$10$ENvLB7p3ngv4sGHHKkcaFOZG02bXAeRqIH5i3yehUo5r9MomCDHma','2020-05-16','ROLE_USER',1),('zdzislaw','pietrewicz','1980-01-19','Molenstraat',3,'A','5644AB','Noord Brabant','Nederland','zdzis','{bcrypt}$2a$10$mB44pDbZy0XwXxsf7FxaE.QLUtDzzN6PzFLKwqDyBV0JMALYZ4zFi','2020-05-16','ROLE_USER',1);
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

-- Dump completed on 2020-05-17 15:43:28
