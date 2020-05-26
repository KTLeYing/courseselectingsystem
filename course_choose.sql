/*
Navicat MySQL Data Transfer

Source Server         : localsystem
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : course_selection_system

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2020-05-26 23:16:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course_choose
-- ----------------------------
DROP TABLE IF EXISTS `course_choose`;
CREATE TABLE `course_choose` (
  `chooseId` int NOT NULL AUTO_INCREMENT,
  `stuId` int NOT NULL,
  `classId` int NOT NULL,
  `score` int NOT NULL,
  PRIMARY KEY (`chooseId`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_choose
-- ----------------------------
INSERT INTO `course_choose` VALUES ('2', '2018000003', '1002', '85');
INSERT INTO `course_choose` VALUES ('3', '2018000004', '1002', '60');
INSERT INTO `course_choose` VALUES ('15', '2018000002', '1006', '0');
INSERT INTO `course_choose` VALUES ('17', '2018000004', '1005', '0');
INSERT INTO `course_choose` VALUES ('38', '2018000003', '1014', '67');
INSERT INTO `course_choose` VALUES ('39', '2018000004', '1014', '80');
INSERT INTO `course_choose` VALUES ('41', '2018000002', '1015', '89');
INSERT INTO `course_choose` VALUES ('43', '2018000001', '1005', '0');
INSERT INTO `course_choose` VALUES ('44', '2018000001', '1002', '0');
INSERT INTO `course_choose` VALUES ('46', '2018000001', '1017', '78');
INSERT INTO `course_choose` VALUES ('47', '2018000002', '1018', '0');
