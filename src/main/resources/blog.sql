/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-26 17:59:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `title` text CHARACTER SET utf8 NOT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8,
  `uid` int(25) DEFAULT NULL,
  `type_code` int(11) NOT NULL DEFAULT '0' COMMENT '文章类型',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `ts` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `dr` int(11) DEFAULT '1',
  `c_like` int(11) DEFAULT '0' COMMENT '点赞数',
  PRIMARY KEY (`aid`,`type_code`),
  KEY `FK_Reference_2` (`type_code`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`type_code`) REFERENCES `t_article_type` (`type_code`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='文章表';

-- ----------------------------
-- Records of t_article
-- ----------------------------
INSERT INTO `t_article` VALUES ('1', '真正的勇士', '敢于直面惨淡的人生', '4', '0', '2017-09-07 10:43:01', '2017-12-26 16:05:40', '1', '100');
INSERT INTO `t_article` VALUES ('2', '帅哥', '真正的帅哥，都是平头', '4', '0', '2017-10-13 11:29:38', '2017-12-26 16:10:06', '1', '0');
INSERT INTO `t_article` VALUES ('3', '震惊', '这一天，全世界都震惊了', '4', '0', '2017-12-26 03:59:00', '2017-12-26 16:05:43', '1', '0');
INSERT INTO `t_article` VALUES ('4', '真的震惊', '这一天，全世界都真的震惊了', '5', '0', '2017-12-26 04:01:00', '2017-12-26 16:06:28', '0', '0');

-- ----------------------------
-- Table structure for t_article_type
-- ----------------------------
DROP TABLE IF EXISTS `t_article_type`;
CREATE TABLE `t_article_type` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(10) DEFAULT NULL,
  `type_code` int(11) DEFAULT NULL,
  PRIMARY KEY (`tid`),
  UNIQUE KEY `AK_Key_2` (`type_code`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='文章类型表';

-- ----------------------------
-- Records of t_article_type
-- ----------------------------
INSERT INTO `t_article_type` VALUES ('1', 'JavaEE', '1');
INSERT INTO `t_article_type` VALUES ('2', 'Android', '2');
INSERT INTO `t_article_type` VALUES ('3', 'Python', '3');
INSERT INTO `t_article_type` VALUES ('4', 'All', '0');

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(0) DEFAULT '' COMMENT '用户名',
  `content` text COMMENT '内容',
  `create_time` datetime DEFAULT NULL COMMENT '评论时间',
  `aid` int(11) DEFAULT NULL COMMENT '文章id',
  `dr` int(11) DEFAULT '1' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `FK_fk_article_comment` (`aid`),
  CONSTRAINT `FK_fk_article_comment` FOREIGN KEY (`aid`) REFERENCES `t_article` (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='评论表';

-- ----------------------------
-- Records of t_comment
-- ----------------------------

-- ----------------------------
-- Table structure for t_photo
-- ----------------------------
DROP TABLE IF EXISTS `t_photo`;
CREATE TABLE `t_photo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` text COMMENT '标题',
  `content` text COMMENT '详细信息',
  `src` varchar(40) DEFAULT '' COMMENT '地址',
  `type_code` int(11) NOT NULL COMMENT '类型',
  `create_time` datetime DEFAULT NULL,
  `ts` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `dr` int(11) DEFAULT '1',
  PRIMARY KEY (`id`,`type_code`),
  KEY `FK_Reference_3` (`type_code`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`type_code`) REFERENCES `t_photo_type` (`type_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='相片';

-- ----------------------------
-- Records of t_photo
-- ----------------------------

-- ----------------------------
-- Table structure for t_photo_type
-- ----------------------------
DROP TABLE IF EXISTS `t_photo_type`;
CREATE TABLE `t_photo_type` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `type_code` int(11) NOT NULL,
  `type_name` varchar(8) DEFAULT '',
  `ts` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`tid`),
  UNIQUE KEY `AK_Key_2` (`type_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='图片类型';

-- ----------------------------
-- Records of t_photo_type
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) DEFAULT '' COMMENT '用户名',
  `password` varchar(25) DEFAULT '123456' COMMENT '密码',
  `nickname` varchar(25) DEFAULT '' COMMENT '真实姓名',
  `email` varchar(25) DEFAULT '' COMMENT '邮箱',
  `age` int(11) DEFAULT '0' COMMENT '年龄',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `ts` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `lv` int(8) DEFAULT '0' COMMENT '用户等级',
  `dr` int(11) DEFAULT '1' COMMENT '标记（0.已删除 1,未删除）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('4', 'wfx', '333333', 'wei', '101@email.com', '0', '2017-12-26 00:00:00', '2017-12-26 11:24:44', '0', '1');
INSERT INTO `user` VALUES ('5', 'huiwings', '111111', '龚慧文', 'huiwings@email.com', '23', '2017-12-26 10:55:00', '2017-12-26 11:22:57', '3', '1');
INSERT INTO `user` VALUES ('6', 'yuan', '111111', '袁康', 'yuan@email.com', '23', '2017-12-26 11:25:00', '2017-12-26 11:25:00', '1', '1');

-- ----------------------------
-- Table structure for user_entity
-- ----------------------------
DROP TABLE IF EXISTS `user_entity`;
CREATE TABLE `user_entity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `createtime` varchar(255) DEFAULT NULL,
  `dr` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `timestamp` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user_entity
-- ----------------------------

-- ----------------------------
-- View structure for v_article
-- ----------------------------
DROP VIEW IF EXISTS `v_article`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_article` AS select `t_article`.`aid` AS `aid`,`t_article`.`title` AS `title`,`t_article`.`uid` AS `uid`,`t_article`.`type_code` AS `type_code`,`t_article`.`create_time` AS `create_time`,`t_article`.`ts` AS `ts`,`t_article`.`dr` AS `dr`,`user`.`username` AS `username`,`user`.`email` AS `email`,`user`.`nickname` AS `nickname`,`t_article`.`c_like` AS `c_like`,`t_article`.`content` AS `content` from (`t_article` join `user` on(((`t_article`.`uid` = `user`.`id`) and (`t_article`.`uid` = `user`.`id`)))) ;
