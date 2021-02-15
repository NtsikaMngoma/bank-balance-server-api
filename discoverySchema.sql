-- MySQL dump 10.13  Distrib 8.0.23, for Linux (x86_64)
--
-- Host: localhost    Database: discovery_bank_schema
-- ------------------------------------------------------
-- Server version	8.0.23-0ubuntu0.20.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account_type`
--

DROP TABLE IF EXISTS `account_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_type` (
  `ACCOUNT_TYPE_CODE` varchar(10) NOT NULL,
  `DESCRIPTION` varchar(50) NOT NULL,
  `TRANSACTIONAL` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ACCOUNT_TYPE_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_type`
--

LOCK TABLES `account_type` WRITE;
/*!40000 ALTER TABLE `account_type` DISABLE KEYS */;
INSERT INTO `account_type` VALUES ('CCRD','Credit Card',_binary ''),('CFCA','Customer Foreign Currency Account',_binary '\0'),('CHQ','Cheque Account',_binary ''),('HLOAN','Home Loan Account',_binary '\0'),('PLOAN','Personal Loan Account',_binary '\0'),('SVGS','Savings Account',_binary '');
/*!40000 ALTER TABLE `account_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atm`
--

DROP TABLE IF EXISTS `atm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atm` (
  `ATM_ID` int NOT NULL AUTO_INCREMENT,
  `NAME` varchar(10) NOT NULL,
  `LOCATION` varchar(255) NOT NULL,
  PRIMARY KEY (`ATM_ID`),
  UNIQUE KEY `NAME` (`NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atm`
--

LOCK TABLES `atm` WRITE;
/*!40000 ALTER TABLE `atm` DISABLE KEYS */;
INSERT INTO `atm` VALUES (1,'SANDTON1','Sandton City Shopping Centre'),(2,'SANDTON2','Sandton City Shopping Centre'),(3,'SANDTON3','Sandton City Shopping Centre'),(4,'ESTGATE1','Eastgate Shopping Centre'),(5,'ESTGATE2','Eastgate Shopping Centre'),(6,'ESTGATE3','Eastgate Shopping Centre'),(7,'BENMORE1','Benmore Gardens');
/*!40000 ALTER TABLE `atm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atm_allocation`
--

DROP TABLE IF EXISTS `atm_allocation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atm_allocation` (
  `ATM_ALLOCATION_ID` int NOT NULL AUTO_INCREMENT,
  `ATM_ID` int NOT NULL,
  `DENOMINATION_ID` int NOT NULL,
  `COUNT` int NOT NULL,
  `id` int NOT NULL,
  PRIMARY KEY (`ATM_ALLOCATION_ID`),
  KEY `ATM_ID` (`ATM_ID`),
  KEY `DENOMINATION_ID` (`DENOMINATION_ID`),
  CONSTRAINT `atm_allocation_ibfk_1` FOREIGN KEY (`ATM_ID`) REFERENCES `atm` (`ATM_ID`),
  CONSTRAINT `atm_allocation_ibfk_2` FOREIGN KEY (`DENOMINATION_ID`) REFERENCES `denomination` (`DENOMINATION_ID`),
  CONSTRAINT `FKst7i0gc26pa6btr2wpd1js38w` FOREIGN KEY (`ATM_ID`) REFERENCES `atm` (`ATM_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atm_allocation`
--

LOCK TABLES `atm_allocation` WRITE;
/*!40000 ALTER TABLE `atm_allocation` DISABLE KEYS */;
INSERT INTO `atm_allocation` VALUES (1,1,1,50,0),(2,1,2,5,0),(3,1,3,4,0),(4,1,4,3,0),(5,1,5,2,0),(6,2,1,656,0),(7,2,2,193,0),(8,2,3,123,0),(9,2,4,158,0),(10,2,5,123,0),(11,3,1,132,0),(12,3,2,112,0),(13,3,3,5,0),(14,3,4,123,0),(15,3,5,5,0);
/*!40000 ALTER TABLE `atm_allocation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `CLIENT_ID` int NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(10) DEFAULT NULL,
  `NAME` varchar(255) NOT NULL,
  `SURNAME` varchar(100) DEFAULT NULL,
  `DOB` date NOT NULL,
  `CLIENT_SUB_TYPE_CODE` varchar(4) NOT NULL,
  PRIMARY KEY (`CLIENT_ID`),
  KEY `CLIENT_SUB_TYPE_CODE` (`CLIENT_SUB_TYPE_CODE`),
  CONSTRAINT `client_ibfk_1` FOREIGN KEY (`CLIENT_SUB_TYPE_CODE`) REFERENCES `client_sub_type` (`CLIENT_SUB_TYPE_CODE`),
  CONSTRAINT `FKmpby1owv1cey644evpnyid074` FOREIGN KEY (`CLIENT_SUB_TYPE_CODE`) REFERENCES `client_sub_type` (`CLIENT_SUB_TYPE_CODE`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Ms','Marylou','Melcher','1964-01-01','FEM'),(2,'Ms','Arvilla','Alvey','1957-11-22','FEM'),(3,'Mr','Bruno','Bickley','1998-03-15','MAL'),(4,'Ms','Sibyl','Schaller','1950-06-18','FEM'),(5,'Mr','Graig','Goods','1966-01-17','MAL'),(6,'Mrs','Christeen','Clever','1973-07-08','FEM'),(7,'Mr','Rodger','Ragland','1963-08-10','MAL'),(8,'Ms','Pattie','Pop','1997-07-10','FEM'),(9,'Mrs','Eboni','Eis','1996-09-29','FEM'),(10,'Mrs','Debbi','Depaolo','1982-05-24','FEM'),(11,'Mrs','Catrice','Callaghan','1985-11-09','FEM'),(12,'Mrs','Dotty','Dunkley','1954-05-08','FEM'),(13,'Mrs','Maudie','Matthew','1952-08-12','FEM'),(14,'Ms','Natashia','Neeld','1956-03-18','FEM'),(15,'Mr','Irvin','Issa','1957-06-12','MAL'),(16,'Mr','Jules','Joesph','1991-10-25','MAL'),(17,'Prof','Royce','Rehn','1969-01-25','MAL'),(18,'Mr','Keenan','Kibby','1998-03-09','MAL'),(19,'Dr','Shelba','Steadham','1962-11-08','FEM'),(20,'Mrs','Emelda','Espinal','1973-03-17','FEM'),(21,'Mrs','Thomasena','Tijerina','1960-05-17','FEM'),(22,'Rev','Socorro','Stepney','1995-01-05','FEM'),(23,'Ms','Sylvie','Schutte','1967-11-04','FEM'),(24,'Rev','Sam','Shomo','1989-10-23','MAL'),(25,'Mrs','Thuy','Tripoli','1979-11-23','FEM'),(26,'Dr','Wayne','Whorley','1959-10-08','MAL'),(27,'Mrs','Diann','Delcambre','1997-02-13','FEM'),(28,'Mrs','Mana','Monreal','1972-10-03','FEM'),(29,'Ms','Donella','Dearmond','1995-04-22','FEM'),(30,'Ms','Maryalice','Milici','1999-01-04','FEM'),(31,NULL,'Force Indudstrial Engineering',NULL,'1959-05-17','COR'),(32,NULL,'Beacon Indudstrial',NULL,'1992-03-04','COR'),(33,NULL,'Singularity Electronics',NULL,'1958-07-29','SME'),(34,NULL,'Project Electronics',NULL,'1954-07-29','SME'),(35,NULL,'Bootstrap Dynamics',NULL,'1992-08-31','SME'),(36,NULL,'Vision Photography',NULL,'1990-07-24','SME'),(37,NULL,'Village Stone',NULL,'1954-06-26','SME'),(38,NULL,'Mindset Inc',NULL,'1992-04-16','COR'),(39,NULL,'Imagination Inc',NULL,'1986-09-01','COR'),(40,NULL,'Analytics Pty Ltd',NULL,'1965-12-29','COR'),(41,NULL,'Innovations Pty Ltd',NULL,'1963-07-04','COR');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_account`
--

DROP TABLE IF EXISTS `client_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client_account` (
  `CLIENT_ACCOUNT_NUMBER` varchar(10) NOT NULL,
  `CLIENT_ID` int NOT NULL,
  `ACCOUNT_TYPE_CODE` varchar(10) NOT NULL,
  `CURRENCY_CODE` varchar(3) NOT NULL,
  `DISPLAY_BALANCE` decimal(18,3) DEFAULT NULL,
  PRIMARY KEY (`CLIENT_ACCOUNT_NUMBER`),
  KEY `CLIENT_ID` (`CLIENT_ID`),
  KEY `ACCOUNT_TYPE_CODE` (`ACCOUNT_TYPE_CODE`),
  KEY `CURRENCY_CODE` (`CURRENCY_CODE`),
  CONSTRAINT `client_account_ibfk_1` FOREIGN KEY (`CLIENT_ID`) REFERENCES `client` (`CLIENT_ID`),
  CONSTRAINT `client_account_ibfk_2` FOREIGN KEY (`ACCOUNT_TYPE_CODE`) REFERENCES `account_type` (`ACCOUNT_TYPE_CODE`),
  CONSTRAINT `client_account_ibfk_3` FOREIGN KEY (`CURRENCY_CODE`) REFERENCES `currency` (`CURRENCY_CODE`),
  CONSTRAINT `FK3a4ab3fegfl5k8u4upc06ol5o` FOREIGN KEY (`CURRENCY_CODE`) REFERENCES `currency` (`CURRENCY_CODE`),
  CONSTRAINT `FKh1g0g0rgjnu1fmtoja1kreuep` FOREIGN KEY (`ACCOUNT_TYPE_CODE`) REFERENCES `account_type` (`ACCOUNT_TYPE_CODE`),
  CONSTRAINT `FKh7w5b6kuwp7qpf536nsetgxcs` FOREIGN KEY (`CLIENT_ID`) REFERENCES `client` (`CLIENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_account`
--

LOCK TABLES `client_account` WRITE;
/*!40000 ALTER TABLE `client_account` DISABLE KEYS */;
INSERT INTO `client_account` VALUES ('1002222785',10,'SVGS','ZAR',7655.780),('1006500197',8,'SVGS','ZAR',4541.850),('1007666753',12,'SVGS','ZAR',4385.470),('1011426755',7,'SVGS','ZAR',13536.790),('1013810682',5,'SVGS','ZAR',4331.900),('1018033450',13,'SVGS','ZAR',1271.080),('1036822567',11,'SVGS','ZAR',3660.640),('1041444501',2,'SVGS','ZAR',1803.760),('1047254834',9,'SVGS','ZAR',8400.700),('1050430054',3,'SVGS','ZAR',2717.490),('1053664521',1,'SVGS','ZAR',10612.090),('1069291670',4,'SVGS','ZAR',12404.190),('1073616681',14,'SVGS','ZAR',2842.710),('1096063494',6,'SVGS','ZAR',10759.740),('4021868582',14,'CHQ','ZAR',18572.300),('4024183611',7,'CHQ','ZAR',20701.870),('4027669028',3,'CHQ','ZAR',7098.510),('4030026880',4,'CHQ','ZAR',19440.890),('4030838761',2,'CHQ','ZAR',-24830.770),('4040578477',5,'CHQ','ZAR',20637.030),('4045743740',11,'CHQ','ZAR',18923.610),('4055230225',10,'CHQ','ZAR',10791.560),('4060094559',8,'CHQ','ZAR',-8294.070),('4063529324',12,'CHQ','ZAR',11092.030),('4067342946',1,'CHQ','ZAR',8603.550),('4072234155',9,'CHQ','ZAR',7453.310),('4078108908',6,'CHQ','ZAR',22319.080),('4085984640',15,'CHQ','ZAR',-3340.960),('4089401276',13,'CHQ','ZAR',7609.090),('5003989709',7,'CCRD','ZAR',8984.070),('5026312853',6,'CCRD','ZAR',13317.570),('5027913218',1,'CCRD','ZAR',11304.530),('5028920923',3,'CCRD','ZAR',8911.940),('5037524185',2,'CCRD','ZAR',70.780),('5039009899',4,'CCRD','ZAR',4686.030),('5070853116',5,'CCRD','ZAR',15738.970),('5072065355',8,'CCRD','ZAR',4259.830),('6001084980',4,'PLOAN','ZAR',-408614.950),('6011144791',3,'PLOAN','ZAR',-422734.710),('6037788392',5,'PLOAN','ZAR',-183855.930),('6044831301',1,'PLOAN','ZAR',-231444.710),('6077654166',2,'PLOAN','ZAR',-40347.730),('6090889198',6,'PLOAN','ZAR',-430803.200),('7007487986',4,'HLOAN','ZAR',-1629940.230),('7018745794',2,'HLOAN','ZAR',-920470.320),('7089799495',3,'HLOAN','ZAR',-992823.480),('7097074308',1,'HLOAN','ZAR',-269352.690),('9061708597',4,'CFCA','EUR',17634.910),('9080751981',2,'CFCA','USD',39483.360),('9164010053',1,'CFCA','AUD',41693.220),('9755978035',1,'CFCA','GBP',38929.880),('9760793578',1,'CFCA','USD',35938.710);
/*!40000 ALTER TABLE `client_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_sub_type`
--

DROP TABLE IF EXISTS `client_sub_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client_sub_type` (
  `CLIENT_SUB_TYPE_CODE` varchar(4) NOT NULL,
  `CLIENT_TYPE_CODE` varchar(2) NOT NULL,
  `DESCRIPTION` varchar(255) NOT NULL,
  PRIMARY KEY (`CLIENT_SUB_TYPE_CODE`),
  KEY `CLIENT_TYPE_CODE` (`CLIENT_TYPE_CODE`),
  CONSTRAINT `client_sub_type_ibfk_1` FOREIGN KEY (`CLIENT_TYPE_CODE`) REFERENCES `client_type` (`CLIENT_TYPE_CODE`),
  CONSTRAINT `FKawombuwdcd53wgh3q2b7m1ehc` FOREIGN KEY (`CLIENT_TYPE_CODE`) REFERENCES `client_type` (`CLIENT_TYPE_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_sub_type`
--

LOCK TABLES `client_sub_type` WRITE;
/*!40000 ALTER TABLE `client_sub_type` DISABLE KEYS */;
INSERT INTO `client_sub_type` VALUES ('COR','N','Corporate'),('FEM','I','Female'),('MAL','I','Male'),('SME','N','Small to medium enterprise'),('X','X','Inactive');
/*!40000 ALTER TABLE `client_sub_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_type`
--

DROP TABLE IF EXISTS `client_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client_type` (
  `CLIENT_TYPE_CODE` varchar(2) NOT NULL,
  `DESCRIPTION` varchar(255) NOT NULL,
  PRIMARY KEY (`CLIENT_TYPE_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_type`
--

LOCK TABLES `client_type` WRITE;
/*!40000 ALTER TABLE `client_type` DISABLE KEYS */;
INSERT INTO `client_type` VALUES ('I','Individual'),('N','Non-Individual'),('X','Inactive');
/*!40000 ALTER TABLE `client_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credit_card_limit`
--

DROP TABLE IF EXISTS `credit_card_limit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `credit_card_limit` (
  `CLIENT_ACCOUNT_NUMBER` varchar(10) NOT NULL,
  `ACCOUNT_LIMIT` decimal(18,3) NOT NULL,
  PRIMARY KEY (`CLIENT_ACCOUNT_NUMBER`),
  CONSTRAINT `credit_card_limit_ibfk_1` FOREIGN KEY (`CLIENT_ACCOUNT_NUMBER`) REFERENCES `client_account` (`CLIENT_ACCOUNT_NUMBER`),
  CONSTRAINT `FK7ncwynx4ugow22cd2d47e99ax` FOREIGN KEY (`CLIENT_ACCOUNT_NUMBER`) REFERENCES `client_account` (`CLIENT_ACCOUNT_NUMBER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credit_card_limit`
--

LOCK TABLES `credit_card_limit` WRITE;
/*!40000 ALTER TABLE `credit_card_limit` DISABLE KEYS */;
INSERT INTO `credit_card_limit` VALUES ('5003989709',30000.000),('5026312853',10000.000),('5027913218',25000.000),('5028920923',15000.000),('5037524185',12000.000),('5039009899',5500.000),('5070853116',15000.000),('5072065355',25000.000);
/*!40000 ALTER TABLE `credit_card_limit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `currency`
--

DROP TABLE IF EXISTS `currency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `currency` (
  `CURRENCY_CODE` varchar(3) NOT NULL,
  `DECIMAL_PLACES` int NOT NULL,
  `DESCRIPTION` varchar(255) NOT NULL,
  PRIMARY KEY (`CURRENCY_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currency`
--

LOCK TABLES `currency` WRITE;
/*!40000 ALTER TABLE `currency` DISABLE KEYS */;
INSERT INTO `currency` VALUES ('AED',2,'United Arab Emirates dirham'),('AFN',2,'Afghan afghani'),('ALL',2,'Albanian lek'),('AMD',2,'Armenian dram'),('ANG',2,'Netherlands Antillean guilder'),('AOA',2,'Angolan kwanza'),('ARS',2,'Argentine peso'),('AUD',2,'Australian dollar'),('AWG',2,'Aruban florin'),('AZN',2,'Azerbaijani manat'),('BAM',2,'Bosnia and Herzegovina convertible mark'),('BBD',2,'Barbados dollar'),('BDT',2,'Bangladeshi taka'),('BGN',2,'Bulgarian lev'),('BHD',3,'Bahraini dinar'),('BIF',0,'Burundian franc'),('BMD',2,'Bermudian dollar'),('BND',2,'Brunei dollar'),('BOB',2,'Boliviano'),('BOV',2,'Bolivian Mvdol (funds code)'),('BRL',2,'Brazilian real'),('BSD',2,'Bahamian dollar'),('BTN',2,'Bhutanese ngultrum'),('BWP',2,'Botswana pula'),('BYN',2,'Belarusian ruble'),('BZD',2,'Belize dollar'),('CAD',2,'Canadian dollar'),('CDF',2,'Congolese franc'),('CHE',2,'WIR�Euro (complementary currency)'),('CHF',2,'Swiss franc'),('CHW',2,'WIR�Franc (complementary currency)'),('CLF',4,'Unidad de Fomento�(funds code)'),('CLP',0,'Chilean peso'),('CNY',2,'Renminbi (Chinese) yuan[8]'),('COP',2,'Colombian peso'),('CRC',2,'Costa Rican colon'),('CUC',2,'Cuban convertible peso'),('CUP',2,'Cuban peso'),('CVE',0,'Cape Verde escudo'),('CZK',2,'Czech koruna'),('DJF',0,'Djiboutian franc'),('DKK',2,'Danish krone'),('DOP',2,'Dominican peso'),('DZD',2,'Algerian dinar'),('EGP',2,'Egyptian pound'),('ERN',2,'Eritrean nakfa'),('ETB',2,'Ethiopian birr'),('EUR',2,'Euro'),('FJD',2,'Fiji dollar'),('FKP',2,'Falkland Islands pound'),('GBP',2,'Pound sterling'),('GEL',2,'Georgian lari'),('GHS',2,'Ghanaian cedi'),('GIP',2,'Gibraltar pound'),('GMD',2,'Gambian dalasi'),('GNF',0,'Guinean franc'),('GTQ',2,'Guatemalan quetzal'),('GYD',2,'Guyanese dollar'),('HKD',2,'Hong Kong dollar'),('HNL',2,'Honduran lempira'),('HRK',2,'Croatian kuna'),('HTG',2,'Haitian gourde'),('HUF',2,'Hungarian forint'),('IDR',2,'Indonesian rupiah'),('ILS',2,'Israeli new shekel'),('INR',2,'Indian rupee'),('IQD',3,'Iraqi dinar'),('IRR',2,'Iranian rial'),('ISK',0,'Icelandic kr�na'),('JMD',2,'Jamaican dollar'),('JOD',3,'Jordanian dinar'),('JPY',0,'Japanese yen'),('KES',2,'Kenyan shilling'),('KGS',2,'Kyrgyzstani som'),('KHR',2,'Cambodian riel'),('KMF',0,'Comoro franc'),('KPW',2,'North Korean won'),('KRW',0,'South Korean won'),('KWD',3,'Kuwaiti dinar'),('KYD',2,'Cayman Islands dollar'),('KZT',2,'Kazakhstani tenge'),('LAK',2,'Lao kip'),('LBP',2,'Lebanese pound'),('LKR',2,'Sri Lankan rupee'),('LRD',2,'Liberian dollar'),('LSL',2,'Lesotho loti'),('LYD',3,'Libyan dinar'),('MAD',2,'Moroccan dirham'),('MDL',2,'Moldovan leu'),('MKD',2,'Macedonian denar'),('MMK',2,'Myanmar kyat'),('MNT',2,'Mongolian t�gr�g'),('MOP',2,'Macanese pataca'),('MUR',2,'Mauritian rupee'),('MVR',2,'Maldivian rufiyaa'),('MWK',2,'Malawian kwacha'),('MXN',2,'Mexican peso'),('MXV',2,'Mexican Unidad de Inversion�(UDI) (funds code)'),('MYR',2,'Malaysian ringgit'),('MZN',2,'Mozambican metical'),('NAD',2,'Namibian dollar'),('NGN',2,'Nigerian naira'),('NIO',2,'Nicaraguan c�rdoba'),('NOK',2,'Norwegian krone'),('NPR',2,'Nepalese rupee'),('NZD',2,'New Zealand dollar'),('OMR',3,'Omani rial'),('PAB',2,'Panamanian balboa'),('PEN',2,'Peruvian Sol'),('PGK',2,'Papua New Guinean kina'),('PHP',2,'Philippine piso[13]'),('PKR',2,'Pakistani rupee'),('PLN',2,'Polish zloty'),('PYG',0,'Paraguayan guaran�'),('QAR',2,'Qatari riyal'),('RON',2,'Romanian leu'),('RSD',2,'Serbian dinar'),('RUB',2,'Russian ruble'),('RWF',0,'Rwandan franc'),('SAR',2,'Saudi riyal'),('SBD',2,'Solomon Islands dollar'),('SCR',2,'Seychelles rupee'),('SDG',2,'Sudanese pound'),('SEK',2,'Swedish krona/kronor'),('SGD',2,'Singapore dollar'),('SHP',2,'Saint Helena pound'),('SLL',2,'Sierra Leonean leone'),('SOS',2,'Somali shilling'),('SRD',2,'Surinamese dollar'),('SSP',2,'South Sudanese pound'),('SVC',2,'Salvadoran col�n'),('SYP',2,'Syrian pound'),('SZL',2,'Swazi lilangeni'),('THB',2,'Thai baht'),('TJS',2,'Tajikistani somoni'),('TMT',2,'Turkmenistan manat'),('TND',3,'Tunisian dinar'),('TOP',2,'Tongan pa?anga'),('TRY',2,'Turkish lira'),('TTD',2,'Trinidad and Tobago dollar'),('TWD',2,'New Taiwan dollar'),('TZS',2,'Tanzanian shilling'),('UAH',2,'Ukrainian hryvnia'),('UGX',0,'Ugandan shilling'),('USD',2,'United States dollar'),('USN',2,'United States dollar (next day) (funds code)'),('UYI',0,'Uruguay Peso en Unidades Indexadas (URUIURUI) (funds code)'),('UYU',2,'Uruguayan peso'),('UZS',2,'Uzbekistan som'),('VEF',2,'Venezuelan bol�var'),('VND',0,'Vietnamese d?ng'),('VUV',0,'Vanuatu vatu'),('WST',2,'Samoan tala'),('XAF',0,'CFA franc BEAC'),('XCD',2,'East Caribbean dollar'),('XOF',0,'CFA franc BCEAO'),('XPF',0,'CFP franc�(franc Pacifique)'),('YER',2,'Yemeni rial'),('ZAR',2,'South African rand'),('ZMW',2,'Zambian kwacha'),('ZWL',2,'Zimbabwean dollar�A/10');
/*!40000 ALTER TABLE `currency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `currency_conversion_rate`
--

DROP TABLE IF EXISTS `currency_conversion_rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `currency_conversion_rate` (
  `CURRENCY_CODE` varchar(3) NOT NULL,
  `CONVERSION_INDICATOR` varchar(1) NOT NULL,
  `RATE` decimal(18,8) NOT NULL,
  PRIMARY KEY (`CURRENCY_CODE`),
  CONSTRAINT `currency_conversion_rate_ibfk_1` FOREIGN KEY (`CURRENCY_CODE`) REFERENCES `currency` (`CURRENCY_CODE`),
  CONSTRAINT `FK1jrudilolh5y51dnie0cxd7ay` FOREIGN KEY (`CURRENCY_CODE`) REFERENCES `currency` (`CURRENCY_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currency_conversion_rate`
--

LOCK TABLES `currency_conversion_rate` WRITE;
/*!40000 ALTER TABLE `currency_conversion_rate` DISABLE KEYS */;
INSERT INTO `currency_conversion_rate` VALUES ('AED','/',0.31960000),('AUD','/',0.11340000),('BWP','/',0.85820000),('CAD','/',0.11380000),('CHF','/',0.08340000),('CNY','/',0.58070000),('DKK','/',0.54170000),('EUR','*',14.31690000),('GBP','*',16.39070000),('GHS','/',0.39470000),('HKD','/',0.68810000),('ILS','/',0.00000000),('INR','/',5.66450000),('JPY','/',9.32000000),('KES','/',8.72190000),('MUR','/',2.92870000),('MWK','/',0.00000000),('MXN','/',0.00000000),('MZN','/',0.00000000),('NAD','/',1.00000000),('NGN','/',0.00000000),('NOK','/',0.68270000),('NZD','/',0.12180000),('PKR','/',9.91200000),('PLN','/',0.29670000),('QAR','/',0.31910000),('SAR','/',0.32710000),('SCR','/',0.00000000),('SEK','/',0.72190000),('SGD','/',0.11780000),('SZL','/',1.00000000),('UGX','/',334.00000000),('USD','*',11.61670000),('ZAR','/',1.00000000),('ZMW','/',0.83400000);
/*!40000 ALTER TABLE `currency_conversion_rate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `denomination`
--

DROP TABLE IF EXISTS `denomination`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `denomination` (
  `DENOMINATION_ID` int NOT NULL AUTO_INCREMENT,
  `VALUE` decimal(10,0) NOT NULL,
  `DENOMINATION_TYPE_CODE` varchar(1) DEFAULT NULL,
  `id` int NOT NULL,
  PRIMARY KEY (`DENOMINATION_ID`),
  KEY `DENOMINATION_TYPE_CODE` (`DENOMINATION_TYPE_CODE`),
  CONSTRAINT `denomination_ibfk_1` FOREIGN KEY (`DENOMINATION_TYPE_CODE`) REFERENCES `denomination_type` (`DENOMINATION_TYPE_CODE`),
  CONSTRAINT `FK3juv0312hgqv2tnxdaf3lmcj7` FOREIGN KEY (`DENOMINATION_TYPE_CODE`) REFERENCES `denomination_type` (`DENOMINATION_TYPE_CODE`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `denomination`
--

LOCK TABLES `denomination` WRITE;
/*!40000 ALTER TABLE `denomination` DISABLE KEYS */;
INSERT INTO `denomination` VALUES (1,10,'N',0),(2,20,'N',0),(3,50,'N',0),(4,100,'N',0),(5,200,'N',0),(6,0,'C',0),(7,0,'C',0),(8,0,'C',0),(9,1,'C',0),(10,5,'C',0);
/*!40000 ALTER TABLE `denomination` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `denomination_type`
--

DROP TABLE IF EXISTS `denomination_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `denomination_type` (
  `DENOMINATION_TYPE_CODE` varchar(1) NOT NULL,
  `DESCRIPTION` varchar(255) NOT NULL,
  PRIMARY KEY (`DENOMINATION_TYPE_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `denomination_type`
--

LOCK TABLES `denomination_type` WRITE;
/*!40000 ALTER TABLE `denomination_type` DISABLE KEYS */;
INSERT INTO `denomination_type` VALUES ('C','Coin'),('N','Note');
/*!40000 ALTER TABLE `denomination_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-15 10:10:24
