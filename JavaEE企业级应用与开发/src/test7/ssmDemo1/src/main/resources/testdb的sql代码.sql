/*
SQLyog Professional v12.08 (64 bit)
MySQL - 5.7.35 : Database - testdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`testdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `testdb`;

/*Table structure for table `battle` */

DROP TABLE IF EXISTS `battle`;

CREATE TABLE `battle` (
  `id` int(11) NOT NULL COMMENT '战役id',
  `name` varchar(60) DEFAULT NULL COMMENT '战役名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `battle` */

insert  into `battle`(`id`,`name`) values (901,'官渡之战'),(902,'赤壁之战');

/*Table structure for table `character_battle` */

DROP TABLE IF EXISTS `character_battle`;

CREATE TABLE `character_battle` (
  `cid` int(11) DEFAULT NULL COMMENT '角色id',
  `bid` int(11) DEFAULT NULL COMMENT '战役id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `character_battle` */

insert  into `character_battle`(`cid`,`bid`) values (101,901),(201,901),(101,902),(201,902),(301,902);

/*Table structure for table `country` */

DROP TABLE IF EXISTS `country`;

CREATE TABLE `country` (
  `id` int(11) NOT NULL COMMENT '国家id',
  `name` varchar(60) DEFAULT NULL COMMENT '国家名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `country` */

insert  into `country`(`id`,`name`) values (801,'蜀汉'),(802,'魏'),(803,'吴');

/*Table structure for table `horse` */

DROP TABLE IF EXISTS `horse`;

CREATE TABLE `horse` (
  `id` int(11) NOT NULL COMMENT '坐骑id',
  `name` varchar(60) DEFAULT NULL COMMENT '坐骑名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `horse` */

insert  into `horse`(`id`,`name`) values (501,'的卢'),(502,'赤兔'),(503,'玉追'),(504,'绝影'),(505,'惊帆');

/*Table structure for table `t_character` */

DROP TABLE IF EXISTS `t_character`;

CREATE TABLE `t_character` (
  `id` int(11) NOT NULL COMMENT '角色id',
  `name` varchar(60) DEFAULT NULL COMMENT '角色名称',
  `cid` int(11) DEFAULT NULL COMMENT '国家id',
  `hid` int(11) DEFAULT NULL COMMENT '坐骑id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_character` */

insert  into `t_character`(`id`,`name`,`cid`,`hid`) values (101,'刘备',801,501),(102,'关羽',801,502),(103,'张飞',801,503),(201,'曹操',802,504),(301,'孙权',803,505);

/*Table structure for table `t_customer` */

DROP TABLE IF EXISTS `t_customer`;

CREATE TABLE `t_customer` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `jobs` varchar(20) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `t_customer` */

insert  into `t_customer`(`id`,`username`,`jobs`,`phone`) values (1,'tom','IT民工','22222'),(15,'zyd','古惑仔','123456'),(16,'zyd','古惑仔','123456'),(17,'lucy','教师','123456'),(18,'李四','manager','13233334444'),(19,'王二','学生','1322434444'),(20,'zhangsan2','manager','13233334444');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`password`,`age`) values (1,'Tom','123',20),(3,'Lucy','abc',16),(4,'Lily','bcd',16),(5,'张三2','123',20);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
