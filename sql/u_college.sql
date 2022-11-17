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

 Date: 18/11/2022 00:57:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for u_college
-- ----------------------------
DROP TABLE IF EXISTS `u_college`;
CREATE TABLE `u_college`  (
  `college_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '学院编号',
  `college_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '学院名称',
  `main_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '负责人名称',
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '负责人编号',
  `tel` bigint(0) NOT NULL COMMENT '负责人电话',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '地址',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `status_cd` int(0) NULL DEFAULT 0 COMMENT '数据状态：0有效；1失效',
  PRIMARY KEY (`college_num`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '学院表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of u_college
-- ----------------------------
INSERT INTO `u_college` VALUES ('XX000', '信息技术学院', '黄弋峰', 'XX00', 18781166142, '四川省绵阳市游仙区', '2022-11-17 23:48:44', NULL, 0);

SET FOREIGN_KEY_CHECKS = 1;
