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

 Date: 17/11/2022 00:23:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for u_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `u_dictionary`;
CREATE TABLE `u_dictionary`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `dic_dictionary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '字典值',
  `dic_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '字典值编号',
  `status_cd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '字典值状态：0有效；1失效',
  `create_time` timestamp(6) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '创建时间',
  `mark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '字典值表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of u_dictionary
-- ----------------------------
INSERT INTO `u_dictionary` VALUES (1, 'XP00', '00', '0', '2022-11-17 00:20:47.414095', '游客');
INSERT INTO `u_dictionary` VALUES (2, 'XP00', '01', '0', '2022-11-17 00:19:34.783017', '队长');

SET FOREIGN_KEY_CHECKS = 1;
