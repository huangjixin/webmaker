/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50625
Source Host           : 127.0.0.1:3306
Source Database       : webmaker

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2021-04-13 10:04:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `status` int(11) DEFAULT '1' COMMENT '状态，是否可用，1可用，0不可用',
  `decription` varchar(120) DEFAULT NULL COMMENT '描述',
  `type` varchar(40) DEFAULT NULL COMMENT '类型',
  `en_name` varchar(50) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `channel_id` bigint(20) DEFAULT NULL,
  `content` mediumtext COMMENT '文章',
  PRIMARY KEY (`id`),
  KEY `fk_artile_to_chanel` (`channel_id`),
  CONSTRAINT `fk_artile_to_chanel` FOREIGN KEY (`channel_id`) REFERENCES `channel` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '1', '1', null, null, null, null, null, null, null, '10', null);
INSERT INTO `article` VALUES ('2', '2', '1', null, null, null, null, '2021-04-12 01:35:44', null, null, '10', '&lt;p style=&quot;text-align: center;&quot;&gt;&lt;em&gt;qweqewqeqweqweewwwwweweweeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee&lt;/em&gt;&lt;/p&gt;&lt;p style=&quot;text-align: center;&quot;&gt;&lt;em&gt;&lt;/em&gt;&lt;/p&gt;&lt;table border=&quot;1&quot; width=&quot;200&quot; cellspacing=&quot;1&quot; cellpadding=&quot;1&quot;&gt;&lt;tbody&gt;&lt;tr&gt;&lt;td&gt;wew&lt;/td&gt;&lt;td&gt;ewew&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;ewew&lt;/td&gt;&lt;td&gt;weew&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;ewewe&lt;/td&gt;&lt;td&gt;weeweweweeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee&lt;/td&gt;&lt;/tr&gt;&lt;/tbody&gt;&lt;/table&gt;&lt;br /&gt;&lt;p&gt;&lt;/p&gt;&lt;p&gt;&lt;/p&gt;&lt;div style=&quot;text-align: center;&quot;&gt;&lt;em&gt;ewwewewewe&lt;/em&gt;&lt;/div&gt;&lt;em&gt;&lt;/em&gt;&lt;table border=&quot;1&quot; width=&quot;400&quot; cellspacing=&quot;1&quot; cellpadding=&quot;1&quot; style=&quot;text-align: center;&quot;&gt;&lt;tbody&gt;&lt;tr&gt;&lt;td style=&quot;text-align: center;&quot;&gt;sdfdsfdsf&lt;/td&gt;&lt;td style=&quot;text-align: center;&quot;&gt;dsfdsfds&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td style=&quot;text-align: center;&quot;&gt;&amp;nbsp;&lt;/td&gt;&lt;td style=&quot;text-align: center;&quot;&gt;&amp;nbsp;&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td style=&quot;text-align: center;&quot;&gt;&amp;nbsp;&lt;/td&gt;&lt;td style=&quot;text-align: center;&quot;&gt;&amp;nbsp;&lt;/td&gt;&lt;/tr&gt;&lt;/tbody&gt;&lt;/table&gt;&lt;p&gt;&lt;/p&gt;');
INSERT INTO `article` VALUES ('3', 'af', null, null, null, null, '2021-04-11 10:13:53', '2021-04-11 10:27:27', null, null, '10', 'aaaaaaaaaaaaa');

-- ----------------------------
-- Table structure for attachment
-- ----------------------------
DROP TABLE IF EXISTS `attachment`;
CREATE TABLE `attachment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `status` int(11) DEFAULT '1' COMMENT '状态，是否可用，1可用，0不可用',
  `decription` varchar(120) DEFAULT NULL COMMENT '描述',
  `type` varchar(40) DEFAULT NULL COMMENT '类型',
  `en_name` varchar(50) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL COMMENT '连接',
  `icon` varchar(50) DEFAULT NULL,
  `path` varchar(50) DEFAULT NULL COMMENT '路径',
  `article_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_attachment_to_article` (`article_id`),
  CONSTRAINT `fk_attachment_to_article` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of attachment
-- ----------------------------

-- ----------------------------
-- Table structure for channel
-- ----------------------------
DROP TABLE IF EXISTS `channel`;
CREATE TABLE `channel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `status` int(11) DEFAULT '1' COMMENT '状态，是否可用，1可用，0不可用',
  `decription` varchar(120) DEFAULT NULL COMMENT '描述',
  `type` varchar(40) DEFAULT NULL COMMENT '类型',
  `en_name` varchar(50) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父类ID',
  `title` varchar(120) DEFAULT NULL COMMENT '标题',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `url` varchar(200) DEFAULT NULL COMMENT '连接',
  `icon` varchar(50) DEFAULT NULL,
  `path` varchar(50) DEFAULT NULL COMMENT '路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of channel
-- ----------------------------
INSERT INTO `channel` VALUES ('10', '机构', null, null, null, '机构', null, null, null, null, '0', '机构', null, '机构', null, null);
INSERT INTO `channel` VALUES ('11', '新闻', null, null, null, 'new', null, null, null, null, '0', '新闻', null, '', null, null);
INSERT INTO `channel` VALUES ('12', '公开', null, null, null, 'gongkai', '2021-04-11 04:29:21', null, null, null, '0', '公开', null, '', null, null);
INSERT INTO `channel` VALUES ('13', '服务', null, null, null, 'fuwu', '2021-04-11 04:29:48', null, null, null, '0', '服务', null, '', null, null);
INSERT INTO `channel` VALUES ('14', '互动', null, null, null, 'hudong', '2021-04-11 04:30:12', null, null, null, '0', '互动', null, '', null, null);
INSERT INTO `channel` VALUES ('15', '专题', null, null, null, 'zhuanti', '2021-04-11 04:30:40', null, null, null, '0', '专题', null, '', null, null);
INSERT INTO `channel` VALUES ('16', '领导介绍', null, null, null, 'leaders', '2021-04-11 04:31:38', null, null, null, '10', '领导介绍', null, '', null, null);
INSERT INTO `channel` VALUES ('17', '机构职能', null, null, null, 'jigouzhineng', '2021-04-11 04:32:09', null, null, null, '10', '机构职能', null, '', null, null);
INSERT INTO `channel` VALUES ('18', '内设机构', null, null, null, 'neishejigou', '2021-04-11 04:32:37', null, null, null, '10', '内设机构', null, '', null, null);
INSERT INTO `channel` VALUES ('19', '办公地址', null, null, null, 'bangongdizhi', '2021-04-11 04:33:08', null, null, null, '10', '办公地址', null, '', null, null);
INSERT INTO `channel` VALUES ('20', '123213', null, null, null, '3213123', '2021-04-11 06:05:09', null, null, null, '15', '3213123', null, '21312', null, null);
