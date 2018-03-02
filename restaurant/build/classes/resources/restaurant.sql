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
 
-- ----------------------------
-- 新建数据库表--餐表  
-- ----------------------------
DROP TABLE IF EXISTS `cuisinetable`;
-- ----------------------------
-- --主建    --菜桌名称  预定时间   状态 0 有效 1 失效 --创建日期 创建日期一经赋值，不再修改 --创建时间  --最后修改日期   后续修改该数据，同时记录时间   --最后修改时间
-- ----------------------------
CREATE TABLE `cuisinetable` (
  `ID` int(11) NOT NULL,  
 
  `cuisinetablename` varchar(300) not NULL,
  
   `scheduledflag` varchar(300), 
  `scheduledtime` varchar(300)  ,

   `flag` int(11) DEFAULT NULL,     
  
  `makedate` date DEFAULT NULL, 
  
  `maketime` varchar(20) DEFAULT NULL,
 
  `modifydate` date DEFAULT NULL,

  `modifytime` varchar(20) DEFAULT NULL,

   PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `cuisinetable` VALUES (1, '1号桌','预定',  '2017-12-25 12:31:12', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `cuisinetable` VALUES (2, '2号桌','预定','2017-12-25 12:31:12', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `cuisinetable` VALUES (3, '3号桌', '','', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `cuisinetable` VALUES (4, '4号桌','','', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
 INSERT INTO `cuisinetable` VALUES (5, '5号桌','','', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `cuisinetable` VALUES (6, '6号桌','','', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `cuisinetable` VALUES (7, '7号桌','','', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `cuisinetable` VALUES (8, '8号桌','','', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `cuisinetable` VALUES (9, '9号桌','','', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `cuisinetable` VALUES (10, '10号桌','','', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');

-- ---------------------------- 
-- 预订单表   --餐桌ID   --下单人  --联系电话 --下单时间    --总金额     --状态     0未结账   1 结账，默认下单状态为1
-- ----------------------------
DROP TABLE IF EXISTS `preorder`;
CREATE TABLE `preorder` (
  `ID` int(11) NOT NULL,  
  `tablename`   varchar(20)   references `cuisinetable`(cuisinetablename), 
     `ordername`  varchar(20) not NULL,   
    `mobile` varchar(20) not NULL, 
   `ordertime`  varchar(20) not NULL,   
   `countprice` varchar(20) not NULL, 
   `flag` int(11) DEFAULT NULL,   
  `makedate` date DEFAULT NULL, 
   `maketime` varchar(20) DEFAULT NULL,
   `modifydate` date DEFAULT NULL,
   `modifytime` varchar(20) DEFAULT NULL,
    PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `preorder` VALUES (2017001, '1号桌','小明','13200001111','2017-12-25 12:31:12','223', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `preorder` VALUES (2017002, '2号桌','小红','13200001112','2017-12-25 12:31:12','123', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `preorder` VALUES (2017003, '3号桌','小红','13200001112','2017-12-25 12:31:12','123', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `preorder` VALUES (2017004, '4号桌','小红','13200001112','2017-12-25 12:31:12','123', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `preorder` VALUES (2017005, '5号桌','小红','13200001112','2017-12-25 12:31:12','123', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `preorder` VALUES (2017006, '6号桌','小红','13200001112','2017-12-25 12:31:12','123', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `preorder` VALUES (2017007, '7号桌','小红','13200001112','2017-12-25 12:31:12','123', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `preorder` VALUES (2017008, '8号桌','小红','13200001112','2017-12-25 12:31:12','123', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `preorder` VALUES (2017008, '9号桌','小红','13200001112','2017-12-25 12:31:12','123', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `preorder` VALUES (2017008, '10号桌','小红','13200001112','2017-12-25 12:31:12','123', '0','2017-12-24','12:00:00','2017-12-24','12:00:00');

-- ---------------------------- 
--   订单详情表   --餐桌ID   --菜名id    --实际单价     --数量      --状态  0：未结算，1：已结算。 1个订单对应存在多条详情数据
-- ----------------------------
DROP TABLE IF EXISTS `orderdetails`;
CREATE TABLE `orderdetails` (
  `ID` int(20) NOT NULL,  
  `preorderID`  int(20)  references `preorder`(ID), 
   `dishesname`  varchar(20) references `dishes`(ID) , 
   `price` varchar(20) not NULL, 
    `dcount` int(20) not null, 
   `flag` int(11) DEFAULT NULL,   
  `makedate` date DEFAULT NULL, 
   `maketime` varchar(20) DEFAULT NULL,
   `modifydate` date DEFAULT NULL,
   `modifytime` varchar(20) DEFAULT NULL,
    PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `orderdetails` VALUES (1, 2017001,'白灼虾','23', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `orderdetails` VALUES (2, 2017001,'白切鸡 ','50', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `orderdetails` VALUES (3, 2017001,'烤乳猪 ','50', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `orderdetails` VALUES (4, 2017001,'烧鹅  ','50', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `orderdetails` VALUES (5, 2017001,'酱猪蹄','50', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');

INSERT INTO `orderdetails` VALUES (6, 2017002,'白灼虾','23', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `orderdetails` VALUES (7, 2017002,'白切鸡 ','50', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `orderdetails` VALUES (8, 2017002,'烤乳猪 ','50', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');

INSERT INTO `orderdetails` VALUES (9, 2017003,'白灼虾','23', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `orderdetails` VALUES (10, 2017003,'白切鸡 ','50', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `orderdetails` VALUES (11, 2017003,'烤乳猪 ','50', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');

INSERT INTO `orderdetails` VALUES (12, 2017004,'白灼虾','23', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `orderdetails` VALUES (13, 2017004,'白切鸡 ','50', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `orderdetails` VALUES (14, 2017004,'烤乳猪 ','50', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');

INSERT INTO `orderdetails` VALUES (15, 2017005,'白灼虾','23', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `orderdetails` VALUES (16, 2017005,'白切鸡 ','50', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `orderdetails` VALUES (17, 2017005,'烤乳猪 ','50', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');

INSERT INTO `orderdetails` VALUES (18, 2017006,'白灼虾','23', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `orderdetails` VALUES (19, 2017006,'白切鸡 ','50', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `orderdetails` VALUES (20, 2017006,'烤乳猪 ','50', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');

INSERT INTO `orderdetails` VALUES (21, 2017007,'白灼虾','23', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `orderdetails` VALUES (22, 2017007,'白切鸡 ','50', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `orderdetails` VALUES (23, 2017007,'烤乳猪 ','50', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');

INSERT INTO `orderdetails` VALUES (24, 2017008,'白灼虾','23', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `orderdetails` VALUES (25, 2017008,'白切鸡 ','50', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `orderdetails` VALUES (26, 2017008,'烤乳猪 ','50', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');

INSERT INTO `orderdetails` VALUES (27, 2017009,'白灼虾','23', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `orderdetails` VALUES (28, 2017009,'白切鸡 ','50', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `orderdetails` VALUES (29, 2017009,'烤乳猪 ','50', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');

INSERT INTO `orderdetails` VALUES (30, 2017010,'白灼虾','23', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `orderdetails` VALUES (31, 2017010,'白切鸡 ','50', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');
INSERT INTO `orderdetails` VALUES (32, 2017010,'烤乳猪 ','50', '1','0','2017-12-24','12:00:00','2017-12-24','12:00:00');

-- ---------------------------- 
--   完 以上数据为基础数据，项目必须有以上数据方可正常运行，请勿删除。如需要测试系统，请新增数据进行测试。
-- ----------------------------

-- ---------------------------- 
--注： 该表结构容易造成数据的不完整性
-- ----------------------------