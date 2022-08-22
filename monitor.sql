/*
Navicat MySQL Data Transfer

Source Server         : 数据监测
Source Server Version : 80024
Source Host           : 47.114.81.63:3306
Source Database       : monitor

Target Server Type    : MYSQL
Target Server Version : 80024
File Encoding         : 65001

Date: 2022-08-22 15:52:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for node
-- ----------------------------
DROP TABLE IF EXISTS `node`;
CREATE TABLE `node` (
  `id` int NOT NULL AUTO_INCREMENT,
  `number` varchar(255) DEFAULT NULL,
  `airWet` double DEFAULT NULL,
  `airTemperature` double DEFAULT NULL,
  `CO2` double DEFAULT NULL,
  `light` double DEFAULT NULL,
  `soilWet` double DEFAULT NULL,
  `soilTemperature` double DEFAULT NULL,
  `control` bit(1) DEFAULT b'0',
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of node
-- ----------------------------
INSERT INTO `node` VALUES ('1', '001', '2.6', '27', '23.6', '26.9', '10', '12.6', '', '2022-05-16');
INSERT INTO `node` VALUES ('2', 'bxde', '6.3', '29', '25.6', '25', '11.3', '13.9', '\0', '2022-05-15');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `telephone` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '150', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES ('2', '151', 'e10adc3949ba59abbe56e057f20f883e');
