/*
 Navicat Premium Data Transfer

 Source Server         : hyf
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : supperpj

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 17/11/2022 19:45:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for u_college
-- ----------------------------
DROP TABLE IF EXISTS `u_college`;
CREATE TABLE `u_college`  (
  `college_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学院名称',
  `college_member` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学院成员',
  `college_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学院编号',
  `membe_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '成员编号',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '地址',
  `tel` bigint(0) NOT NULL COMMENT '电话',
  `status_cd` int(0) NULL DEFAULT 0 COMMENT '数据状态：0有效；1失效',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`college_num`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of u_college
-- ----------------------------
INSERT INTO `u_college` VALUES ('信息技术学院', '黄弋峰', 'XX000', 'XX00', '四川省绵阳市游仙区', 1, 0, '2022-11-17 19:39:53');

SET FOREIGN_KEY_CHECKS = 1;
