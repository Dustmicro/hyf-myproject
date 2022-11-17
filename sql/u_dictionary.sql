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

 Date: 18/11/2022 00:57:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for u_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `u_dictionary`;
CREATE TABLE `u_dictionary`  (
  `dic_id` int(0) NOT NULL AUTO_INCREMENT,
  `dic_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '字典值',
  `dic_type_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '字典值编号',
  `status_cd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '字典值状态：0有效；1失效',
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `mark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '描述',
  PRIMARY KEY (`dic_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '字典值表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of u_dictionary
-- ----------------------------
INSERT INTO `u_dictionary` VALUES (1, 'XP00', '0', '0', NULL, '2022-11-17 00:20:47', '游客');
INSERT INTO `u_dictionary` VALUES (2, 'XP00', '1', '0', NULL, '2022-11-17 00:19:35', '队长');
INSERT INTO `u_dictionary` VALUES (3, 'XP00', '2', '0', NULL, '2022-11-17 19:32:47', '副队长');
INSERT INTO `u_dictionary` VALUES (4, 'XP00', '3', '0', NULL, '2022-11-17 19:33:13', '教练');
INSERT INTO `u_dictionary` VALUES (5, 'XP00', '4', '0', NULL, '2022-11-17 19:33:39', '队员');

SET FOREIGN_KEY_CHECKS = 1;
