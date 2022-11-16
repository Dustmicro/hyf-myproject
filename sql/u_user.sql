/*
 Navicat Premium Data Transfer

 Source Server         : hyf
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : localhost:3306
 Source Schema         : supperpj

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 17/11/2022 00:23:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for u_user
-- ----------------------------
DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '成员id',
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '成员id',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '名称',
  `age` int(0) NOT NULL COMMENT '年龄',
  `tel` int(0) NOT NULL COMMENT '电话',
  `size` double(2, 0) NOT NULL COMMENT '性别：1女；2男',
  `account` int(0) NOT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
  `permissions` int(0) NOT NULL DEFAULT 0 COMMENT '权限：0游客；1队长；2副队长；3教练；4队员',
  `college_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '0' COMMENT '学院编号',
  `college_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '达摩学院' COMMENT '学院名称',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '住址',
  `e_mail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '邮箱',
  `u_mark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '描述',
  `status_cd` int(0) NULL DEFAULT 0 COMMENT '成员状态：0有效；1失效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '成员表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
