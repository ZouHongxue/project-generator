/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50703
 Source Host           : localhost:3306
 Source Schema         : graduated_design

 Target Server Type    : MySQL
 Target Server Version : 50703
 File Encoding         : 65001

 Date: 27/07/2018 17:27:56
*/


-- ----------------------------
-- 创建数据库
-- ----------------------------
--  Create Database If Not Exists graduated_design Character Set UTF8; 
--  建库语句直接和建表一起执行有点问题，还没建库，就执行了建表，发生错误，建表失败。暂时先手动执行建库

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;


-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `graduated_design`.`user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '邹洪学|用户唯一主键|2018-07-27',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邹洪学|用户姓名|2018-07-27',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邹洪学|用户密码|2018-07-27',
  `status` int(2) NULL DEFAULT NULL COMMENT '@0正常 @other 异常|邹洪学|用户状态标识|2018-07-27',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '邹洪学|创建时间|2018-07-27',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '邹洪学|更新时间|2018-07-27',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
