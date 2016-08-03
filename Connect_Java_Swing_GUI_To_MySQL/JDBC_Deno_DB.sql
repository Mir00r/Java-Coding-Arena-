-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: demo
-- ------------------------------------------------------
-- Server version	5.7.12-log

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first` varchar(255) DEFAULT NULL,
  `last` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'Abdur','Razzak'),(2,'Abdur','Razzak'),(3,'Abdur','Razzak'),(4,'Abdur','Razzak'),(5,'Abdur','Razzak'),(6,'Abdur','Razzak');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employeesclob`
--

DROP TABLE IF EXISTS `employeesclob`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employeesclob` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(64) DEFAULT NULL,
  `first_name` varchar(64) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `department` varchar(64) DEFAULT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  `resume` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employeesclob`
--

LOCK TABLES `employeesclob` WRITE;
/*!40000 ALTER TABLE `employeesclob` DISABLE KEYS */;
INSERT INTO `employeesclob` VALUES (1,'Doe','John','john.doe@foo.com','HR',55000.00,'John Doe\nFull Address - City, State, ZIP - Phone Number - E-mail\n\nOBJECTIVE: Design apparel print for an innovative retail company \n\nEDUCATION:\nUNIVERSITY OF MINNESOTA\n- College of Design\n- Bachelor of Science in Graphic Design\n- Cumulative GPA 3.93, Deanâ€™s List\n- Twin cities Iron Range Scholarship\n\nWORK EXPERIENCE:\nAMERICAN EAGLE\nSales Associate\nCity, State May 2011\n- Collaborated with the store merchandiser creating displays to attract clientele \n- Use my trend awareness to assist customers in their shopping experience\n- Thoroughly scan every piece of merchandise for inventory control\n- Process shipment to increase my product knowledge\n\nPLANET BEACH\nSpa Consultant\nCity, State July 2009 - present\n- Sell retail and memberships to meet company sales goals\n- Build organizational skills by single handedly running all operating procedures - Communicate with clients to fulfill their wants and needs\n- Attend promotional events to market our services\n- Handle cash and deposits during opening and closing\n- Received employee of the month award twice\n\nHEARTBREAKER,\nSales Associate\nCity, State Aug. 2008 - present\n- Stocked sales floor with fast fashion inventory\n- Marked down items allowing me to see unsuccessful merchandise in a retail market - Offered advice and assistance to each guest\n\nVICTORIAâ€™S SECRET\nFashion Representative\nCity, State May 2008 â€“ Aug. 2008\n- Applied my leadership skills by assisting in the training of coworkers\n- Set up mannequins and displays in order to entice future customers\n- Provided superior customer service by helping with consumer decisions - Took seasonal inventory\n\nVOLUNTEER EXPERIENCE:\nTARGET CORPORATION\nBrand Ambassador\nCity, State August 2009\n- Represented Periscope Marketing and Target Inc. at a college event\n- Engaged University of Minnesota freshman in the Target brand experience\n'),(2,'Public','Mary','mary.public@foo.com','Engineering',75000.00,NULL),(3,'Queue','Susan','susan.queue@foo.com','Legal',130000.00,NULL),(4,'Williams','David','david.williams@foo.com','HR',120000.00,NULL),(5,'Johnson','Lisa','lisa.johnson@foo.com','Engineering',50000.00,NULL),(6,'Smith','Paul','paul.smith@foo.com','Legal',100000.00,NULL),(7,'Adams','Carl','carl.adams@foo.com','HR',50000.00,NULL),(8,'Brown','Bill','bill.brown@foo.com','Engineering',50000.00,NULL),(9,'Thomas','Susan','susan.thomas@foo.com','Legal',80000.00,NULL),(10,'Davis','John','john.davis@foo.com','HR',45000.00,NULL),(11,'Fowler','Mary','mary.fowler@foo.com','Engineering',65000.00,NULL),(12,'Waters','David','david.waters@foo.com','Legal',90000.00,NULL);
/*!40000 ALTER TABLE `employeesclob` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employeessearch`
--

DROP TABLE IF EXISTS `employeessearch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employeessearch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(64) DEFAULT NULL,
  `first_name` varchar(64) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `department` varchar(64) DEFAULT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employeessearch`
--

LOCK TABLES `employeessearch` WRITE;
/*!40000 ALTER TABLE `employeessearch` DISABLE KEYS */;
INSERT INTO `employeessearch` VALUES (1,'Doe','John','john.doe@foo.com','HR',55000.00),(2,'Public','Mary','mary.public@foo.com','Engineering',75000.00),(3,'Queue','Susan','susan.queue@foo.com','Legal',130000.00),(4,'Williams','David','david.williams@foo.com','HR',120000.00),(5,'Johnson','Lisa','lisa.johnson@foo.com','Engineering',50000.00),(6,'Smith','Paul','paul.smith@foo.com','Legal',100000.00),(7,'Adams','Carl','carl.adams@foo.com','HR',50000.00),(8,'Brown','Bill','bill.brown@foo.com','Engineering',50000.00),(9,'Thomas','Susan','susan.thomas@foo.com','Legal',80000.00),(10,'Davis','John','john.davis@foo.com','HR',45000.00),(11,'Fowler','Mary','mary.fowler@foo.com','Engineering',65000.00),(12,'Waters','David','david.waters@foo.com','Legal',90000.00);
/*!40000 ALTER TABLE `employeessearch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Pname` varchar(255) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `Pprice` int(11) DEFAULT NULL,
  `Sprice` int(11) DEFAULT NULL,
  `Pdate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Mouse',3,150,200,'time'),(2,'Monitor',1,1400,20000,'14-May-2016'),(3,'Keyboard',1,500,1000,'15-May-2016'),(4,'Home Theater',1,10000,20000,'16-May-2016'),(5,'Gaming PC',2,100000,200000,'20-May-2016'),(6,'Gaming PC',2,100000,200000,'20-May-2016');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sample_table`
--

DROP TABLE IF EXISTS `sample_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sample_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sample_table`
--

LOCK TABLES `sample_table` WRITE;
/*!40000 ALTER TABLE `sample_table` DISABLE KEYS */;
INSERT INTO `sample_table` VALUES (1,'Abdur Razzak','Dhaka Bangladesh'),(2,'Shathi Ferdous','Dhanmondi'),(3,'Logic Baba','Kollanpur'),(4,'Munni','Khagan'),(5,'Shuvo','Ansar Camp');
/*!40000 ALTER TABLE `sample_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tablename`
--

DROP TABLE IF EXISTS `tablename`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tablename` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first` varchar(255) DEFAULT NULL,
  `last` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tablename`
--

LOCK TABLES `tablename` WRITE;
/*!40000 ALTER TABLE `tablename` DISABLE KEYS */;
/*!40000 ALTER TABLE `tablename` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-03 21:19:50
