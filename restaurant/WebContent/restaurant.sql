-- ----------------------------
-- 新建数据库 
-- ----------------------------
DROP DATABASE IF EXISTS restaurant;
CREATE DATABASE restaurant ;
USE restaurant ;

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- 新建数据库表--菜系表  
-- ----------------------------
DROP TABLE IF EXISTS `cuisine`;
-- ----------------------------
-- --主建    --菜系名称   状态 0 有效 1 失效 --创建日期 创建日期一经赋值，不再修改 --创建时间  --最后修改日期   后续修改该数据，同时记录时间   --最后修改时间
-- ----------------------------
CREATE TABLE `cuisine` (
  `ID` int(11) NOT NULL,  
 
  `cuisinename` varchar(20) not NULL,

   `flag` int(11) DEFAULT NULL,     
  
  `makedate` date DEFAULT NULL, 
  
  `maketime` varchar(20) DEFAULT NULL,
 
  `modifydate` date DEFAULT NULL,

  `modifytime` varchar(20) DEFAULT NULL,

   PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `cuisine` VALUES ('1', '粤菜',  '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `cuisine` VALUES ('2', '川菜', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `cuisine` VALUES ('3', '湘菜',  '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `cuisine` VALUES ('4', '东北菜', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
 INSERT INTO `cuisine` VALUES ('5', '东北菜2', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `cuisine` VALUES ('6', '东北菜3', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `cuisine` VALUES ('7', '东北菜4', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `cuisine` VALUES ('8', '东北菜5', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `cuisine` VALUES ('9', '东北菜6', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `cuisine` VALUES ('10', '东北菜7', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `cuisine` VALUES ('11', '东北菜8', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `cuisine` VALUES ('12', '东北菜9', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `cuisine` VALUES ('13', '东北菜0', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `cuisine` VALUES ('14', '东北菜01', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
-- ---------------------------- 
-- 菜品表   --主建   --菜品名称    --所属菜系     --菜品价格     --VIP价格    --状态 0 有效 1 失效
-- ----------------------------
DROP TABLE IF EXISTS `dishes`;
CREATE TABLE `dishes` (
  `ID` int(11) NOT NULL,  

  `dishesname` varchar(20) not NULL, 

   `theircuisine` varchar(20) references `cuisine`(cuisinename)  ,

    `price` varchar(20) not NULL, 

    `vipprice` varchar(20) not NULL,

   `flag` int(11) DEFAULT NULL,   

  `makedate` date DEFAULT NULL, 
   `maketime` varchar(20) DEFAULT NULL,
   `modifydate` date DEFAULT NULL,
   `modifytime` varchar(20) DEFAULT NULL,
    PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `dishes` VALUES ('1', '白灼虾 ','粤菜 ' ,'36','23','0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `dishes` VALUES ('2', '白切鸡 ','粤菜 ' ,'68','50','0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `dishes` VALUES ('3', '烤乳猪 ','粤菜 ' ,'68','50','0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `dishes` VALUES ('4', '烧鹅 ','粤菜 ' ,'68','50','0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `dishes` VALUES ('5', '	酱猪蹄','川菜  ' ,'68','50','0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `dishes` VALUES ('6', '饶汁豆腐 	 ','川菜 ' ,'68','50','0','2017-12-24','12:00:00','2017-12-24','12:00:00');
 