-- phpMyAdmin SQL Dump
-- version 4.7.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 2019-07-14 14:47:54
-- 服务器版本： 8.0.13
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ssm`
--
CREATE DATABASE IF NOT EXISTS `ssm` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `ssm`;

-- --------------------------------------------------------

--
-- 表的结构 `appointment`
--

DROP TABLE IF EXISTS `appointment`;
CREATE TABLE IF NOT EXISTS `appointment` (
  `book_id` bigint(20) NOT NULL COMMENT '图书ID',
  `student_id` bigint(20) NOT NULL COMMENT '学号',
  `appoint_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '预约时间',
  PRIMARY KEY (`book_id`,`student_id`),
  KEY `idx_appoint_time` (`appoint_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='预约图书表';

-- --------------------------------------------------------

--
-- 表的结构 `area`
--

DROP TABLE IF EXISTS `area`;
CREATE TABLE IF NOT EXISTS `area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `priority` int(11) NOT NULL DEFAULT '0' COMMENT '权值',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间戳',
  `last_edit_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `area`
--

INSERT INTO `area` (`id`, `name`, `priority`) VALUES
(1, '东北', 0),
(4, 'chaoge', 2),
(5, '测试区域', 1);

-- --------------------------------------------------------

--
-- 表的结构 `book`
--

DROP TABLE IF EXISTS `book`;
CREATE TABLE IF NOT EXISTS `book` (
  `book_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '图书ID',
  `name` varchar(100) NOT NULL COMMENT '图书名称',
  `number` int(11) NOT NULL COMMENT '馆藏数量',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8 COMMENT='图书表';

--
-- 转存表中的数据 `book`
--

INSERT INTO `book` (`book_id`, `name`, `number`) VALUES
(1000, 'Java程序设计', 10),
(1001, '数据结构', 10),
(1002, '设计模式', 10),
(1003, '编译原理', 10);

-- --------------------------------------------------------

--
-- 表的结构 `girls`
--

DROP TABLE IF EXISTS `girls`;
CREATE TABLE IF NOT EXISTS `girls` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `name` varchar(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='妹子表';

--
-- 转存表中的数据 `girls`
--

INSERT INTO `girls` (`id`, `age`, `name`) VALUES
(1, 12, 'kitty'),
(2, 18, 'hidy'),
(3, 333, 'fsfsfee'),
(4, 14, 'keowws');

-- --------------------------------------------------------

--
-- 表的结构 `person`
--

DROP TABLE IF EXISTS `person`;
CREATE TABLE IF NOT EXISTS `person` (
  `id` varchar(32) NOT NULL,
  `address` varchar(32) NOT NULL,
  `idCard` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `phone` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- 表的结构 `sys_permission`
--

DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE IF NOT EXISTS `sys_permission` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(30) COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `available` tinyint(1) NOT NULL,
  `parent_id` int(10) UNSIGNED NOT NULL COMMENT '父编号',
  `parent_ids` varchar(100) COLLATE utf8mb4_general_ci NOT NULL COMMENT '父编号列表',
  `permission` varchar(245) COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限字符串',
  `resource_type` enum('menu','button') COLLATE utf8mb4_general_ci NOT NULL,
  `url` varchar(245) COLLATE utf8mb4_general_ci NOT NULL COMMENT '资源路径',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='权限表';

--
-- 转存表中的数据 `sys_permission`
--

INSERT INTO `sys_permission` (`id`, `name`, `available`, `parent_id`, `parent_ids`, `permission`, `resource_type`, `url`) VALUES
(1, '用户管理', 0, 0, '0/', 'userInfo:view', 'menu', 'userInfo/userList'),
(2, '用户添加', 0, 1, '0/1', 'userInfo:add', 'button', 'userInfo/userAdd'),
(3, '用户删除', 0, 1, '0/1', 'userInfo:del', 'button', 'userInfo/userDel');

-- --------------------------------------------------------

--
-- 表的结构 `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE IF NOT EXISTS `sys_role` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `available` tinyint(2) UNSIGNED DEFAULT NULL COMMENT '是否可用',
  `description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色描述',
  `role` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色标识',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='角色表';

--
-- 转存表中的数据 `sys_role`
--

INSERT INTO `sys_role` (`id`, `available`, `description`, `role`) VALUES
(1, 0, '管理员', 'admin'),
(2, 0, 'VIP会员', 'vip'),
(3, 1, 'test', 'test');

-- --------------------------------------------------------

--
-- 表的结构 `sys_role_permission`
--

DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE IF NOT EXISTS `sys_role_permission` (
  `permission_id` int(10) UNSIGNED NOT NULL COMMENT '权限id',
  `role_id` int(10) UNSIGNED NOT NULL COMMENT '角色id',
  PRIMARY KEY (`permission_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='角色权限表';

--
-- 转存表中的数据 `sys_role_permission`
--

INSERT INTO `sys_role_permission` (`permission_id`, `role_id`) VALUES
(1, 1),
(2, 1),
(3, 2);

-- --------------------------------------------------------

--
-- 表的结构 `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE IF NOT EXISTS `sys_user_role` (
  `role_id` int(10) UNSIGNED NOT NULL COMMENT '角色id',
  `uid` int(10) UNSIGNED NOT NULL COMMENT '用户id',
  PRIMARY KEY (`uid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户角色表';

--
-- 转存表中的数据 `sys_user_role`
--

INSERT INTO `sys_user_role` (`role_id`, `uid`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- 表的结构 `user_info`
--

DROP TABLE IF EXISTS `user_info`;
CREATE TABLE IF NOT EXISTS `user_info` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) COLLATE utf8mb4_general_ci NOT NULL COMMENT '帐号',
  `name` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '名称',
  `password` char(35) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',
  `salt` char(35) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '加密密码的盐',
  `state` tinyint(3) UNSIGNED DEFAULT NULL COMMENT '用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.',
  PRIMARY KEY (`uid`),
  KEY `user_info_username_index` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户信息表';

--
-- 转存表中的数据 `user_info`
--

INSERT INTO `user_info` (`uid`, `username`, `name`, `password`, `salt`, `state`) VALUES
(1, 'admin', '管理员', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
