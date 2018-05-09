/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2018-03-09 20:49:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` varchar(225) NOT NULL,
  `name` varchar(225) DEFAULT NULL,
  `press` timestamp NULL DEFAULT NULL,
  `publication` varchar(225) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `quantity` int(36) DEFAULT NULL,
  `status` int(36) NOT NULL DEFAULT '1' COMMENT '是否已借(0表示无库存，1表示有库存)',
  `cover` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '数据结构与算法', null, '仲恺智慧农业出版社', '39.5', '3', '1', null);

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(225) NOT NULL,
  `name` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '系统管理员');
INSERT INTO `role` VALUES ('2', '借阅者');
INSERT INTO `role` VALUES ('3', '图书管理员');
INSERT INTO `role` VALUES ('4', '系统、图书管理员');
INSERT INTO `role` VALUES ('5', '系统管理员、借阅者');
INSERT INTO `role` VALUES ('6', '图书管理员、借阅者');
INSERT INTO `role` VALUES ('7', '系统、图书管理员、借阅者');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(225) NOT NULL,
  `name` varchar(225) DEFAULT NULL,
  `sex` varchar(225) DEFAULT NULL,
  `entry` timestamp NULL DEFAULT NULL,
  `role_id` varchar(225) NOT NULL,
  `password` varchar(225) DEFAULT NULL,
  `phone` int(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_role_id` (`role_id`),
  CONSTRAINT `FK_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '卓文智', '女', '2018-03-08 21:59:12', '7', '1234', null);
INSERT INTO `user` VALUES ('2', '钱伟健', '男', '2018-03-09 11:20:55', '1', '1234', null);
INSERT INTO `user` VALUES ('3', '叶超', '男', '2018-03-09 11:21:31', '2', '1234', null);
INSERT INTO `user` VALUES ('4', '江伟龙', '男', '2018-03-09 11:21:52', '3', '1234', null);

-- ----------------------------
-- Table structure for `user_book`
-- ----------------------------
DROP TABLE IF EXISTS `user_book`;
CREATE TABLE `user_book` (
  `user_id` varchar(225) NOT NULL,
  `book_id` varchar(225) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `operate` varchar(225) NOT NULL COMMENT '借阅或者归还',
  `id` varchar(225) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user_id` (`user_id`),
  KEY `FK_book_id` (`book_id`),
  CONSTRAINT `FK_book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_book
-- ----------------------------
