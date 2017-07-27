/*
Navicat MySQL Data Transfer

Source Server         : mybatis
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-07-27 23:53:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `bname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', 'SQL技术');
INSERT INTO `book` VALUES ('2', 'SSM+MySQL详解');
INSERT INTO `book` VALUES ('3', 'C++和java对比');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', 'java');
INSERT INTO `category` VALUES ('2', 'c++');
INSERT INTO `category` VALUES ('3', 'mysql');
INSERT INTO `category` VALUES ('4', 'java');
INSERT INTO `category` VALUES ('5', 'c++');
INSERT INTO `category` VALUES ('6', 'mysql');

-- ----------------------------
-- Table structure for middle
-- ----------------------------
DROP TABLE IF EXISTS `middle`;
CREATE TABLE `middle` (
  `m_bid` int(11) DEFAULT NULL,
  `m_cid` int(11) DEFAULT NULL,
  KEY `fk_bid` (`m_bid`),
  KEY `fk_cid` (`m_cid`),
  CONSTRAINT `fk_bid` FOREIGN KEY (`m_bid`) REFERENCES `book` (`bid`),
  CONSTRAINT `fk_cid` FOREIGN KEY (`m_cid`) REFERENCES `category` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of middle
-- ----------------------------
INSERT INTO `middle` VALUES ('1', '3');
INSERT INTO `middle` VALUES ('2', '1');
INSERT INTO `middle` VALUES ('2', '3');
INSERT INTO `middle` VALUES ('3', '2');
INSERT INTO `middle` VALUES ('3', '1');
INSERT INTO `middle` VALUES ('1', '3');
INSERT INTO `middle` VALUES ('2', '1');
INSERT INTO `middle` VALUES ('2', '3');
INSERT INTO `middle` VALUES ('3', '2');
INSERT INTO `middle` VALUES ('3', '1');
