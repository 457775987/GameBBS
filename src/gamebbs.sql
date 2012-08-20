/*
SQLyog 企业版 - MySQL GUI v7.14 
MySQL - 5.5.17 : Database - fellow
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`fellow` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `fellow`;

/*Table structure for table `tx_board` */

DROP TABLE IF EXISTS `tx_board`;

CREATE TABLE `tx_board` (
  `boardId` int(11) NOT NULL,
  `boardName` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_bin NOT NULL,
  `parentId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tx_board` */

LOCK TABLES `tx_board` WRITE;

UNLOCK TABLES;

/*Table structure for table `tx_login` */

DROP TABLE IF EXISTS `tx_login`;

CREATE TABLE `tx_login` (
  `id` int(40) NOT NULL AUTO_INCREMENT,
  `pwd` varchar(20) NOT NULL,
  `name` varchar(60) NOT NULL,
  `age` int(60) NOT NULL,
  `xb` varchar(60) NOT NULL,
  `tel` int(60) NOT NULL,
  `address` varchar(60) CHARACTER SET gb2312 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12345679 DEFAULT CHARSET=utf8;

/*Data for the table `tx_login` */

LOCK TABLES `tx_login` WRITE;

insert  into `tx_login`(`id`,`pwd`,`name`,`age`,`xb`,`tel`,`address`) values (11,'11','11',11,'11',11,'11'),(22,'22','22',22,'22',22,'22'),(23,'饿额2','啥东东',23,'男',123456,'是的v发v'),(33,'33','33',33,'33',33,'33'),(88,'xiewei','谢伟',80,'男',188888888,'湖南南长沙'),(12345,'123','123',23,'男',654321,'湖南'),(121212,'1111','1111',11111,'1111',111,'11111'),(222222,'2222','222',22,'222',222,'2222'),(2222222,'222','22',222,'2222',222,'2222'),(12345678,'99','99',99,'99',99,'hxgh');

UNLOCK TABLES;

/*Table structure for table `tx_manage` */

DROP TABLE IF EXISTS `tx_manage`;

CREATE TABLE `tx_manage` (
  `Mid` varchar(53) NOT NULL,
  `Mpwd` int(53) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tx_manage` */

LOCK TABLES `tx_manage` WRITE;

UNLOCK TABLES;

/*Table structure for table `tx_notice` */

DROP TABLE IF EXISTS `tx_notice`;

CREATE TABLE `tx_notice` (
  `title` varchar(1000) CHARACTER SET gb2312 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tx_notice` */

LOCK TABLES `tx_notice` WRITE;

insert  into `tx_notice`(`title`) values ('是短发是嘎斯dviuoash'),('是短发是嘎斯gdsgdfsdfgdf');

UNLOCK TABLES;

/*Table structure for table `tx_reply` */

DROP TABLE IF EXISTS `tx_reply`;

CREATE TABLE `tx_reply` (
  `replyId` int(11) NOT NULL,
  `Title` varchar(100) CHARACTER SET gb2312 COLLATE gb2312_bin NOT NULL,
  `Content` text CHARACTER SET gb2312 COLLATE gb2312_bin NOT NULL,
  `publishTime` datetime NOT NULL,
  `modifyTime` datetime NOT NULL,
  `id` int(11) NOT NULL,
  `topicId` int(11) NOT NULL,
  PRIMARY KEY (`replyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tx_reply` */

LOCK TABLES `tx_reply` WRITE;

UNLOCK TABLES;

/*Table structure for table `tx_topic` */

DROP TABLE IF EXISTS `tx_topic`;

CREATE TABLE `tx_topic` (
  `topicId` int(11) NOT NULL,
  `Titlie` varchar(100) CHARACTER SET gb2312 COLLATE gb2312_bin NOT NULL,
  `Content` text CHARACTER SET gb2312 COLLATE gb2312_bin NOT NULL,
  `publishTime` datetime NOT NULL,
  `modifyTime` datetime NOT NULL,
  `id` int(11) NOT NULL,
  `boardId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tx_topic` */

LOCK TABLES `tx_topic` WRITE;

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
