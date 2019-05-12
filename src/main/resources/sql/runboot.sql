/*
Navicat MySQL Data Transfer

Source Server         : mysql5.7 3306
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : runboot

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-05-09 16:27:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for util_common_jdbcutils_user
-- ----------------------------
DROP TABLE IF EXISTS `util_common_jdbcutils_user`;
CREATE TABLE `util_common_jdbcutils_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '名字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
