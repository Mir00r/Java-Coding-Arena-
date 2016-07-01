-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: shop_online
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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `cat_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(45) NOT NULL,
  `cat_desc` varchar(200) NOT NULL,
  PRIMARY KEY (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Samsung Galaxy S7 Edge','Android Smart phone , ver 6.0'),(2,'Laptop','Lenovo yoga 2 pro, 8GB RAM, 128BG SSD HD'),(3,'Watch','Samsung Gear S7 Watch'),(4,'Laptop','Apple'),(5,'Watch','Rollex'),(6,'Mobile','Samsung'),(7,'Mobile','Apple');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivary_cost`
--

DROP TABLE IF EXISTS `delivary_cost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivary_cost` (
  `delivary_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `zone_name` varchar(45) NOT NULL,
  `delivary_cost` double NOT NULL,
  PRIMARY KEY (`delivary_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivary_cost`
--

LOCK TABLES `delivary_cost` WRITE;
/*!40000 ALTER TABLE `delivary_cost` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivary_cost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pro_order`
--

DROP TABLE IF EXISTS `pro_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pro_order` (
  `order_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `pro_id` int(10) unsigned NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  `order_date` date NOT NULL,
  `order_qty` int(10) unsigned NOT NULL,
  `total_price` double NOT NULL,
  `order_status` varchar(45) NOT NULL DEFAULT '"N"',
  `delivary_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FK_pro_order_user_id_idx` (`user_id`),
  KEY `FK_pro_order_del_id_idx` (`delivary_id`),
  CONSTRAINT `FK_pro_order_del_id` FOREIGN KEY (`delivary_id`) REFERENCES `delivary_cost` (`delivary_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_pro_order_user_id` FOREIGN KEY (`user_id`) REFERENCES `shop_user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pro_order`
--

LOCK TABLES `pro_order` WRITE;
/*!40000 ALTER TABLE `pro_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `pro_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pro_order_details`
--

DROP TABLE IF EXISTS `pro_order_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pro_order_details` (
  `order_details_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` int(10) unsigned NOT NULL,
  `pro_id` int(10) unsigned NOT NULL,
  `pro_qty` int(10) unsigned NOT NULL,
  PRIMARY KEY (`order_details_id`),
  KEY `FK_pro_order_details_order_id_idx` (`order_id`),
  KEY `FK_pro_order_details_pro_id_idx` (`pro_id`),
  CONSTRAINT `FK_pro_order_details_order_id` FOREIGN KEY (`order_id`) REFERENCES `pro_order` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_pro_order_details_pro_id` FOREIGN KEY (`pro_id`) REFERENCES `product` (`pro_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pro_order_details`
--

LOCK TABLES `pro_order_details` WRITE;
/*!40000 ALTER TABLE `pro_order_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `pro_order_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `pro_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sub_cat_id` int(10) unsigned NOT NULL,
  `pro_name` varchar(45) NOT NULL,
  `pro_qty` int(10) unsigned NOT NULL,
  `pro_price` double NOT NULL,
  `pro_url` varchar(45) NOT NULL,
  `pro_desc` varchar(200) NOT NULL,
  PRIMARY KEY (`pro_id`),
  KEY `FK_product_sub_cat_id_idx` (`sub_cat_id`),
  CONSTRAINT `FK_product_sub_cat_id` FOREIGN KEY (`sub_cat_id`) REFERENCES `sub_category` (`sub_cat_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,1,'Lenovo',1,80,'lenovo-yoga-2-pro.jpg','good laptop'),(2,1,'Lenovo',2,16,'lenovo-yoga-2-pro.jpg','good ultra laptop'),(3,3,'Samsung',1,60,'samsung-galaxy-s7-usa1.jpg','Very good mobile phone '),(4,2,'Apple6',1,70,'apple6.jpg','Very good mobile phone ');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_user`
--

DROP TABLE IF EXISTS `shop_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop_user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `reg_date` date NOT NULL,
  `contact_no` varchar(15) NOT NULL,
  `role_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK_shop_user_role_id_idx` (`role_id`),
  CONSTRAINT `FK_shop_user_role_id` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_user`
--

LOCK TABLES `shop_user` WRITE;
/*!40000 ALTER TABLE `shop_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sub_category`
--

DROP TABLE IF EXISTS `sub_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sub_category` (
  `sub_cat_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cat_id` int(10) unsigned NOT NULL,
  `sub_cat_name` varchar(45) NOT NULL,
  `sub_cat_desc` varchar(200) NOT NULL,
  PRIMARY KEY (`sub_cat_id`),
  KEY `FK_sub_category_cat_id_idx` (`cat_id`),
  CONSTRAINT `FK_sub_category_cat_id` FOREIGN KEY (`cat_id`) REFERENCES `category` (`cat_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_category`
--

LOCK TABLES `sub_category` WRITE;
/*!40000 ALTER TABLE `sub_category` DISABLE KEYS */;
INSERT INTO `sub_category` VALUES (1,2,'Lenovo','yoga 2 pro'),(2,2,'Apple','Macbook Pro Ratina Display '),(3,6,'Samsung','Samsung S7 Edge '),(4,6,'Apple','Apple 6 ');
/*!40000 ALTER TABLE `sub_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `role_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-02  2:45:46
