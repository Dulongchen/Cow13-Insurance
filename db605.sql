/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : db605

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2021-01-05 10:59:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_business
-- ----------------------------
DROP TABLE IF EXISTS `t_business`;
CREATE TABLE `t_business` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shopname` varchar(100) NOT NULL,
  `loginname` varchar(100) NOT NULL,
  `password` varchar(20) NOT NULL,
  `regDate` datetime NOT NULL,
  `state` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `shopname` (`shopname`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=100005 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_business
-- ----------------------------
INSERT INTO `t_business` VALUES ('100000', '财产险', '001', '111111', '2020-05-06 17:41:24', '1');
INSERT INTO `t_business` VALUES ('100001', '寿险', '002', '111111', '2020-05-06 17:49:09', '1');
INSERT INTO `t_business` VALUES ('100002', '车险', '003', '111111', '2020-05-06 17:49:34', '1');
INSERT INTO `t_business` VALUES ('100003', '意外险', '004', '111111', '2020-05-06 17:49:58', '1');
INSERT INTO `t_business` VALUES ('100004', '医疗保险', '005', '111111', '2020-05-06 17:50:31', '1');

-- ----------------------------
-- Table structure for t_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_cart`;
CREATE TABLE `t_cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customid` int(11) DEFAULT NULL,
  `goodsid` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_customid_goosid` (`customid`,`goodsid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cart
-- ----------------------------
INSERT INTO `t_cart` VALUES ('1', '1', '100000', '28');
INSERT INTO `t_cart` VALUES ('6', '1', '100001', '19');
INSERT INTO `t_cart` VALUES ('40', '1', '100002', '3');
INSERT INTO `t_cart` VALUES ('43', '1', '100004', '2');
INSERT INTO `t_cart` VALUES ('44', '1', '100005', '2');
INSERT INTO `t_cart` VALUES ('45', '1', '100007', '1');
INSERT INTO `t_cart` VALUES ('51', '1', '180110910', '4');

-- ----------------------------
-- Table structure for t_custom
-- ----------------------------
DROP TABLE IF EXISTS `t_custom`;
CREATE TABLE `t_custom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(20) NOT NULL,
  `states` varchar(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_custom
-- ----------------------------
INSERT INTO `t_custom` VALUES ('1', 'dlc', '111111', '1');

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `itemname` varchar(100) NOT NULL,
  `businessid` int(11) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `details` varchar(500) DEFAULT NULL,
  `itemimg` varchar(100) DEFAULT NULL,
  `states` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=180110916 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO `t_goods` VALUES ('180110910', '顾彧', '100000', '409', '财产险', '20200510220902791.jpg', '1');
INSERT INTO `t_goods` VALUES ('180110911', '凡树', '100000', '308', '寿险', '20200511105345580.jpg', '1');
INSERT INTO `t_goods` VALUES ('180110912', '程长生', '100000', '501', '车险', '20200511105553675.jpg', '1');
INSERT INTO `t_goods` VALUES ('180110914', '付豪', '100000', '103', '意外险', '20200511105856628.jpg', '1');
INSERT INTO `t_goods` VALUES ('180110915', '万维', '100001', '401', '医疗保险', '20200511115631171.jpg', '1');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` varchar(50) NOT NULL,
  `customId` int(11) NOT NULL,
  `sum` decimal(11,2) DEFAULT NULL,
  `phone` varchar(20) NOT NULL,
  `contacts` varchar(20) NOT NULL,
  `address` varchar(100) NOT NULL,
  `orderTime` datetime NOT NULL,
  `states` int(5) NOT NULL DEFAULT '0',
  `payTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('20201209165202154696', '1', '560.00', '13242429473', '已受理', '杭州', '2020-12-09 16:52:05', '0', null);
INSERT INTO `t_order` VALUES ('20201209165346367445', '1', '330.00', '13242429746', '已受理', '杭州', '2020-12-09 16:53:49', '0', null);
INSERT INTO `t_order` VALUES ('2020120916562070297', '1', '4824.00', '13242464738', '已受理', '杭州', '2020-12-09 16:56:23', '0', null);
INSERT INTO `t_order` VALUES ('20201209165845914242', '1', '4824.00', '13242439265', '已受理', '杭州', '2020-12-09 16:58:50', '0', null);
INSERT INTO `t_order` VALUES ('20201209166873287329', '1', '330.00', '13242420746', '未受理', '杭州', '2020-12-09 17:41:07', '0', null);
INSERT INTO `t_order` VALUES ('20201209174822306848', '1', '5888.00', '13242448596', '已受理', '杭州', '2020-12-09 17:48:28', '0', null);
INSERT INTO `t_order` VALUES ('20201209175025957377', '1', '4824.00', '13242429453', '已受理', '杭州', '2020-12-09 17:50:29', '0', null);
INSERT INTO `t_order` VALUES ('20201209180046324936', '1', '4824.00', '13242312535', '未受理', '杭州', '2020-12-09 18:00:57', '0', null);
INSERT INTO `t_order` VALUES ('20201209180406936815', '1', '4824.00', '13242402845', '已受理', '杭州', '2020-12-09 18:04:11', '0', null);
