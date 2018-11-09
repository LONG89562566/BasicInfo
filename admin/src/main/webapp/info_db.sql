/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : info_db

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 09/11/2018 17:40:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for area
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键，自动增加ID',
  `area_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区域名称',
  `sequence` int(11) NOT NULL COMMENT '排序',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父类ID，0表示第一级',
  `level` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '层级',
  `status` int(1) NOT NULL COMMENT '状态，1为可用，-1为不可用',
  `remark` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `sending_price` decimal(5, 2) NULL DEFAULT 0.00 COMMENT '起送价',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '区域信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of area
-- ----------------------------
INSERT INTO `area` VALUES (1, '湖北省', 1, 0, 1, 1, NULL, 0.00, '2017-07-04 09:28:17');
INSERT INTO `area` VALUES (2, '武汉市', 1, 1, 2, 1, NULL, 0.00, '2017-07-04 10:12:02');
INSERT INTO `area` VALUES (3, '佛祖岭区', 1, 2, 3, -1, NULL, 958.00, '2017-07-04 10:13:23');
INSERT INTO `area` VALUES (4, '徐东区', 1, 2, 3, 1, NULL, 100.00, '2017-08-23 13:35:12');
INSERT INTO `area` VALUES (5, '武泰闸', 1, 2, 3, -1, NULL, 58.00, '2017-10-17 14:05:33');
INSERT INTO `area` VALUES (8, '街道口', 1, 2, 3, -1, NULL, 88.00, '2017-12-07 08:59:53');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键（自增ID）',
  `menu_code` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编码',
  `menu_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `menu_href` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '链接',
  `menu_icon` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '父级ID',
  `menu_level` tinyint(4) NULL DEFAULT NULL COMMENT '层级',
  `menu_seq` int(11) NULL DEFAULT NULL,
  `is_end` tinyint(4) NULL DEFAULT NULL COMMENT '是否末级;1,是；2，否',
  `menu_status` tinyint(4) NULL DEFAULT NULL COMMENT '状态(1在用，2停用)',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `type` tinyint(2) NULL DEFAULT NULL COMMENT '类型:1.菜单资源，2.数据资源3.按钮资源',
  `percode` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源标识符',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 118 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '01', '信息管理', NULL, 'glyphicon glyphicon-cog', 0, 1, 1, 2, 1, '2017-09-11 15:13:08', 1, NULL);
INSERT INTO `sys_menu` VALUES (5, '01.04', '区域维护', '', '', 1, 2, 4, 2, 1, '2017-09-11 15:31:38', 1, NULL);
INSERT INTO `sys_menu` VALUES (41, '08', '系统管理', '', 'glyphicon glyphicon-cog', 0, 1, 8, 2, 1, '2017-09-11 15:51:30', 1, NULL);
INSERT INTO `sys_menu` VALUES (42, '08.01', '用户管理', '/admin/sysUser/list', '', 41, 2, 1, 2, 1, '2017-09-11 15:51:53', 2, 'sysUser:query');
INSERT INTO `sys_menu` VALUES (43, '08.02', '角色管理', '/admin/role/list', '', 41, 2, 2, 2, 1, '2017-09-11 15:52:13', 2, 'role:query');
INSERT INTO `sys_menu` VALUES (44, '08.03', '菜单管理', '/admin/menu/list', '', 41, 2, 3, 2, 1, '2017-09-11 15:52:36', 2, 'menu:query');
INSERT INTO `sys_menu` VALUES (88, '15', '权限资源管理', '', 'glyphicon glyphicon-cog', 0, 1, 15, 2, 1, '2017-12-13 13:39:25', 3, NULL);
INSERT INTO `sys_menu` VALUES (104, '15.04', '商品资源', '', '', 88, 2, 4, 2, 1, '2017-12-13 15:04:55', 3, NULL);
INSERT INTO `sys_menu` VALUES (106, '15.04.02', '商品复制', '', '', 104, 3, 2, 1, 1, '2017-12-13 15:06:19', 3, 'goods:copy');
INSERT INTO `sys_menu` VALUES (107, '15.04.03', '商品上下架', '', '', 104, 3, 3, 1, 1, '2017-12-13 15:07:03', 3, 'goods:upAndDown');
INSERT INTO `sys_menu` VALUES (108, '15.04.04', '商品修改', '', '', 104, 3, 4, 1, 1, '2017-12-13 15:08:00', 3, 'goods:update');

-- ----------------------------
-- Table structure for sys_office
-- ----------------------------
DROP TABLE IF EXISTS `sys_office`;
CREATE TABLE `sys_office`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编号',
  `parent_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所有父级编号',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `sort` decimal(10, 0) NOT NULL COMMENT '排序',
  `area_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '归属区域',
  `code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区域编码',
  `type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机构类型',
  `grade` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机构等级',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `zip_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮政编码',
  `master` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `phone` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `fax` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '传真',
  `email` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `USEABLE` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否启用',
  `PRIMARY_PERSON` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主负责人',
  `DEPUTY_PERSON` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '副负责人',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建者',
  `create_date` datetime(0) NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '更新者',
  `update_date` datetime(0) NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `sys_office_parent_id`(`parent_id`) USING BTREE,
  INDEX `sys_office_del_flag`(`del_flag`) USING BTREE,
  INDEX `sys_office_type`(`type`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '机构表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role_desc` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '英文名称',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `status` tinyint(64) NULL DEFAULT NULL COMMENT '是否可用,1为可用，-1为不可用',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `sys_role_enname`(`role_desc`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '管理员', '管理员', '管理员', 1, '2017-09-11 16:03:18');
INSERT INTO `sys_role` VALUES (2, '人事行政', '人事行政', '人事行政', 1, '2017-11-09 15:57:58');
INSERT INTO `sys_role` VALUES (3, '技术管理员', '后台技术支持', '', 1, '2017-11-14 09:59:30');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL COMMENT '角色编号',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4144 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色-菜单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (2242, 3, 1);
INSERT INTO `sys_role_menu` VALUES (2247, 3, 5);
INSERT INTO `sys_role_menu` VALUES (2301, 3, 41);
INSERT INTO `sys_role_menu` VALUES (2302, 3, 42);
INSERT INTO `sys_role_menu` VALUES (2303, 3, 43);
INSERT INTO `sys_role_menu` VALUES (2304, 3, 44);
INSERT INTO `sys_role_menu` VALUES (4028, 1, 1);
INSERT INTO `sys_role_menu` VALUES (4033, 1, 5);
INSERT INTO `sys_role_menu` VALUES (4087, 1, 41);
INSERT INTO `sys_role_menu` VALUES (4088, 1, 42);
INSERT INTO `sys_role_menu` VALUES (4089, 1, 43);
INSERT INTO `sys_role_menu` VALUES (4090, 1, 44);
INSERT INTO `sys_role_menu` VALUES (4111, 1, 88);
INSERT INTO `sys_role_menu` VALUES (4123, 1, 104);
INSERT INTO `sys_role_menu` VALUES (4125, 1, 106);
INSERT INTO `sys_role_menu` VALUES (4126, 1, 107);
INSERT INTO `sys_role_menu` VALUES (4127, 1, 108);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自动增加ID',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录名',
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'md5后的密码',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '状态，1为可用，-1为不可用',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后一次更新时间',
  `salt` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加密的盐',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'test', '501abde45dc0d5d72f0e663eec71f6e9', '系统管理员', '834645893@qq.com', '18123343965', 1, '', '2018-11-08 10:05:11', '2018-11-09 17:20:30', '21NDnj');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自动增加ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `role_id` bigint(20) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (41, 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
