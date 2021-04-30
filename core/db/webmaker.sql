/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50625
Source Host           : 127.0.0.1:3306
Source Database       : webmaker

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2021-04-30 17:05:14
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '1', '1', null, null, null, null, '2021-04-13 10:08:31', null, null, '10', 'teststete');
INSERT INTO `article` VALUES ('2', '2', '1', null, null, null, null, '2021-04-12 01:35:44', null, null, '10', '&lt;p style=&quot;text-align: center;&quot;&gt;&lt;em&gt;qweqewqeqweqweewwwwweweweeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee&lt;/em&gt;&lt;/p&gt;&lt;p style=&quot;text-align: center;&quot;&gt;&lt;em&gt;&lt;/em&gt;&lt;/p&gt;&lt;table border=&quot;1&quot; width=&quot;200&quot; cellspacing=&quot;1&quot; cellpadding=&quot;1&quot;&gt;&lt;tbody&gt;&lt;tr&gt;&lt;td&gt;wew&lt;/td&gt;&lt;td&gt;ewew&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;ewew&lt;/td&gt;&lt;td&gt;weew&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;ewewe&lt;/td&gt;&lt;td&gt;weeweweweeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee&lt;/td&gt;&lt;/tr&gt;&lt;/tbody&gt;&lt;/table&gt;&lt;br /&gt;&lt;p&gt;&lt;/p&gt;&lt;p&gt;&lt;/p&gt;&lt;div style=&quot;text-align: center;&quot;&gt;&lt;em&gt;ewwewewewe&lt;/em&gt;&lt;/div&gt;&lt;em&gt;&lt;/em&gt;&lt;table border=&quot;1&quot; width=&quot;400&quot; cellspacing=&quot;1&quot; cellpadding=&quot;1&quot; style=&quot;text-align: center;&quot;&gt;&lt;tbody&gt;&lt;tr&gt;&lt;td style=&quot;text-align: center;&quot;&gt;sdfdsfdsf&lt;/td&gt;&lt;td style=&quot;text-align: center;&quot;&gt;dsfdsfds&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td style=&quot;text-align: center;&quot;&gt;&amp;nbsp;&lt;/td&gt;&lt;td style=&quot;text-align: center;&quot;&gt;&amp;nbsp;&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td style=&quot;text-align: center;&quot;&gt;&amp;nbsp;&lt;/td&gt;&lt;td style=&quot;text-align: center;&quot;&gt;&amp;nbsp;&lt;/td&gt;&lt;/tr&gt;&lt;/tbody&gt;&lt;/table&gt;&lt;p&gt;&lt;/p&gt;');
INSERT INTO `article` VALUES ('3', 'af', null, null, null, null, '2021-04-11 10:13:53', '2021-04-11 10:27:27', null, null, '10', 'aaaaaaaaaaaaa');
INSERT INTO `article` VALUES ('4', '机构', null, null, null, null, '2021-04-13 09:18:17', null, null, null, null, '&amp;lt;div style=&amp;quot;text-align: center;&amp;quot;&amp;gt;&amp;lt;img src=&amp;quot;/upload/images/test/20210413_171705_9923.png&amp;quot; align=&amp;quot;middle&amp;quot; alt=&amp;quot;&amp;quot; /&amp;gt;&amp;lt;br /&amp;gt;&amp;lt;br /&amp;gt;&amp;lt;br /&amp;gt;&amp;lt;br /&amp;gt;&amp;lt;div style=&amp;quot;text-align: left;&amp;quot;&amp;gt;wrwerewrwerwerwereweeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee&amp;lt;/div&amp;gt;&amp;lt;/div&amp;gt;');
INSERT INTO `article` VALUES ('5', 'test', null, null, null, null, '2021-04-13 09:37:52', null, null, null, null, '');
INSERT INTO `article` VALUES ('6', 'test', null, null, null, null, '2021-04-13 09:38:14', null, null, null, null, '');
INSERT INTO `article` VALUES ('7', 'test', null, null, null, null, '2021-04-13 09:39:18', null, null, null, null, '');
INSERT INTO `article` VALUES ('8', 'test', null, null, null, null, '2021-04-13 09:39:43', null, null, null, null, '');
INSERT INTO `article` VALUES ('9', 'test', null, null, null, null, '2021-04-13 09:42:36', null, null, null, '11', '&amp;lt;div align=&amp;quot;center&amp;quot;&amp;gt;test&amp;lt;img src=&amp;quot;/upload/images/test/20210413_174137_81366.png&amp;quot; align=&amp;quot;middle&amp;quot; alt=&amp;quot;&amp;quot; /&amp;gt;&amp;lt;/div&amp;gt;');
INSERT INTO `article` VALUES ('10', 'test', null, null, null, null, '2021-04-13 09:44:35', null, null, null, null, '');
INSERT INTO `article` VALUES ('11', '机构', null, null, null, null, '2021-04-13 09:49:16', null, null, null, null, '');
INSERT INTO `article` VALUES ('12', 'test', null, null, null, null, null, '2021-04-19 02:37:08', null, null, '10', '&lt;img src=&quot;/upload/images/test/20210419_103619_85563.png?id=44&quot; alt=&quot;&quot; /&gt;&lt;img src=&quot;/upload/images/test/20210419_103641_21513.png?id=45&quot; alt=&quot;&quot; /&gt;');
INSERT INTO `article` VALUES ('13', '广东省困难退役军人帮扶援助办法', null, null, null, null, '2021-04-13 09:55:15', '2021-04-16 09:16:23', null, null, '10', '&lt;p style=&quot;text-align: center;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;&lt;strong&gt;第一章&amp;nbsp; 总&amp;nbsp; 则&lt;/strong&gt;&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　第一条&amp;nbsp; 为加强困难退役军人帮扶援助工作，更好地服务军地改革发展、促进社会和谐稳定、体现社会尊崇优待，根据《退役军人事务部等5部门关于加强困难退役军人帮扶援助工作的意见》及有关法律、法规，结合我省实际，制定本办法。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　第二条&amp;nbsp; 帮助退役军人摆脱困境，加快建立突出协同性、体现优待性、注重时效性、调动积极性的工作格局，不断提高救急济难水平，增强困难退役军人安全感、获得感和荣誉感。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　第三条&amp;nbsp; 立足济难解困。对因军事职业特殊性造成重残重病、长期失业或遭遇突发性、临时性事件等导致生活陷入困境的退役军人，按照保基本、救急难、求实效的要求，给予及时帮扶援助。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　第四条&amp;nbsp; 体现尊崇优待。充分体现退役军人为国防和军队建设作出的牺牲贡献，对其面临的工作生活等方面的实际困难，在保障其享有公民普惠待遇的基础上，由地方人民政府退役军人事务部门给予临时性、过渡性的帮扶援助，把党和国家对困难退役军人的关心关爱落到实处。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　第五条&amp;nbsp; 创新方式方法。立足退役军人特点诉求，结合管理服务需要，坚持政府主导、社会参与，统筹利用现有资金渠道，充分调动社会力量，为困难退役军人提供多主体供给、多渠道保障的帮扶援助。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　第六条&amp;nbsp; 帮扶援助工作坚持公开、公平、公正的原则，接受社会监督。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: center;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;&lt;strong&gt;第二章&amp;nbsp; 职责分工&lt;/strong&gt;&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　第七条&amp;nbsp; 各级各有关部门要把困难退役军人帮扶援助工作摆上重要位置，切实强化政治责任和使命担当。要建立健全在政府统一领导下，退役军人事务部门统筹协调，民政、财政、住房城乡建设、医疗保障等部门各司其职、密切配合的工作机制。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　第八条&amp;nbsp; 各相关部门要不断创新服务形式，优化服务流程，提升服务效能。各级退役军人事务部门要进一步树立主管主责意识，主动作为，因人施策，切实做到应帮尽帮、应援尽援、帮援及时。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　第九条&amp;nbsp; 各地在充分用好广东省退役军人应急救助资金的基础上，确需设立帮扶援助资金的，同级财政可给予一定保障。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　鼓励通过社会捐赠等多种方式筹集资金用于帮扶援助工作。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　有条件的地方可设立困难退役军人关爱帮扶基金，拓宽资金保障渠道。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: center;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;&lt;strong&gt;第三章&amp;nbsp; 帮扶援助对象&lt;/strong&gt;&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　第十条&amp;nbsp; 帮扶援助对象为广东省户籍的退役军人和其他优抚对象。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: center;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;&lt;strong&gt;第四章&amp;nbsp; 帮扶援助情形&lt;/strong&gt;&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　第十一条&amp;nbsp; 按照&ldquo;普惠加优待&rdquo;的原则，符合条件的退役军人和其他优抚对象在充分享受社会救助政策的同时，对因以下五种情形导致生活陷入困境的，根据困难程度和现实表现，可以按规定申请帮扶援助。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　（一）退役军人因服役期间致残或因患有严重疾病等原因造成退役后本人就业困难，医疗和康复等必需支出突然增加超出家庭承受能力，导致生活出现严重困难的；&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　（二）退役军人因服役时间长、市场就业能力弱等原因造成长期失业或突然下岗，导致生活出现严重困难的；&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　（三）退役军人因旧伤复发、残情病情加重等原因，导致生活出现严重困难的；&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　（四）退役军人和其他优抚对象因火灾水灾、交通事故、重大疾病、人身伤害、见义勇为等突发事件，导致生活出现严重困难的；&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　（五）遭遇其他特殊情况导致生活出现严重困难的。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　第十二条&amp;nbsp; 申请帮扶援助人员在申请之日前2年内有下列情形之一的，不予帮扶援助：&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　（一）因违法犯罪被追究刑事责任的；&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　（二）因不当行为被纳入失信联合惩戒对象名单的；&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　（三）组织煽动、串联聚集、缠访闹访、滞留滋事、网上恶意炒作或造谣、多次参加聚集上访的；&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　（四）不支持不配合管理服务工作造成恶劣影响的；&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　（五）法律法规规定的其他不应给予帮扶援助的。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: center;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;&lt;strong&gt;第五章&amp;nbsp; 帮扶援助方式&lt;/strong&gt;&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　第十三条&amp;nbsp; 对符合条件的帮扶援助对象，各地应当根据帮扶援助标准和对象基本需要，采取以下一种或多种方式予以帮扶援助。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　（一）提供资金援助。按照专款专用、科学公正、加强监管的原则，全面推行社会化发放，确保资金发放安全、及时、便捷、足额。必要时，可直接发放现金。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　（二）提供实物援助。包括发放衣被、食品、饮用水、医药等生活必需品，部分生产资料，以及提供临时住所等。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　（三）提供社会化服务援助。鼓励和引导公益慈善组织、社会工作服务机构、企业等社会力量，通过纳入慈善项目、发动社会募捐、提供专业服务、开展志愿服务等形式，给予多元化、个性化帮扶援助。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: center;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;&lt;strong&gt;第六章&amp;nbsp; 帮扶援助标准&lt;/strong&gt;&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　第十四条&amp;nbsp; 各地要着力提高帮扶援助力度，做到既尽力而为，又量力而行；根据帮扶援助对象的困难情形和程度、当地经济社会发展和救助保障水平等因素，合理确定困难退役军人帮扶援助标准，并适时调整，推动逐步形成相对统一的区域帮扶援助标准体系。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: center;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;&lt;strong&gt;第七章&amp;nbsp; 帮扶援助程序&lt;/strong&gt;&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　第十五条&amp;nbsp; 帮扶援助工作实行一事一批，按照个人申请、乡镇（街道）审核、县级审批的程序办理。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　（一）个人申请。一般由符合条件的对象本人书面向本人户籍所在地乡镇人民政府（街道办事处）退役军人服务站提出申请，填写《广东省困难退役军人帮扶援助申请表》（见附件）。没有单独建立服务站的，可向负责退役军人工作的工作人员提出申请。本人因行动不便、精神障碍等原因不能自行申请的，其监护人、家属、所在村（居）可代为提出申请。申请时应当按规定如实提交身份证、退役证件或移交政府安置证明等相关资料。无正当理由，申请人不得因同一事由重复提出申请。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　（二）乡镇（街道）审核。乡镇人民政府（街道办事处）退役军人服务站应当在村（居）民委员会协助下，对申请人身份、家庭经济状况、困难情形程度、各类救助情况等逐一调查，提出审核意见，并视情在申请人所居住的村（居）公示后，报县级人民政府退役军人事务部门审批。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　（三）县级审批。县级人民政府退役军人事务部门受理后，可委托县级退役军人服务中心开展信息核实等工作，并应当及时作出审批决定，不予批准的应当书面说明理由。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　申请人无正当理由以同一事由重复申请的，不予批准。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　申请人对审批结果有异议的，可向县级人民政府或上一级人民政府退役军人事务部门申请复核。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　第十六条&amp;nbsp; 遇有紧急情况，各相关单位可先行帮扶援助再按规定补齐审核审批手续。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　第十七条&amp;nbsp; 困难退役军人生活、医疗和住房等救助工作按现行相关规定办理，退役军人服务中心（站）应当给予积极协助。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　符合《广东省退役军人应急救助资金管理暂行办法》和本办法有关规定条件的，可叠加享受。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: center;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;&lt;strong&gt;第八章&amp;nbsp; 法律责任&lt;/strong&gt;&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　第十八条&amp;nbsp; 审核审批机关工作人员要严守纪律规矩，依法依规做好帮扶援助工作。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　行政机关、退役军人服务保障机构及其工作人员存在滥用职权、玩忽职守、徇私舞弊行为的，按照国家和省的有关规定处理。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　第十九条&amp;nbsp; 退役军人应当做到诚实守信，确保提供的材料真实准确。对申请人骗取帮扶援助的，应当追回已享受的相应待遇；情节严重的，依法依规追究责任。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　第二十条&amp;nbsp; 本办法由省退役军人事务厅商有关部门负责解释。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　第二十一条&amp;nbsp; 本办法自2021年3月4日起施行。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;text-align: justify;&quot;&gt;&lt;span style=&quot;font-size:18px;&quot;&gt;　　各地要根据本办法，结合实际制定具体实施细则，切实做好本地区困难退役军人帮扶援助工作。&lt;/span&gt;&lt;/p&gt;');

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
  `path` varchar(200) DEFAULT NULL COMMENT '路径',
  `article_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_attachment_to_article` (`article_id`),
  CONSTRAINT `fk_attachment_to_article` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of attachment
-- ----------------------------
INSERT INTO `attachment` VALUES ('1', '20210413_112858_7094.png', '1', null, null, null, '2021-04-13 03:28:58', null, 'test', null, '/upload/images/test/20210413_112858_7094.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210413_112858_7094.png', null);
INSERT INTO `attachment` VALUES ('2', '20210413_161104_66027.png', '1', null, null, null, '2021-04-13 08:11:04', null, 'test', null, '/upload/images/test/20210413_161104_66027.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210413_161104_66027.png', null);
INSERT INTO `attachment` VALUES ('3', '20210413_161439_95697.png', '1', null, null, null, '2021-04-13 08:14:39', null, 'test', null, '/upload/images/test/20210413_161439_95697.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210413_161439_95697.png', null);
INSERT INTO `attachment` VALUES ('4', '20210413_162104_87840.png', '1', null, null, null, '2021-04-13 08:21:05', null, 'test', null, '/upload/images/test/20210413_162104_87840.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210413_162104_87840.png', null);
INSERT INTO `attachment` VALUES ('5', '20210413_162500_27860.png', '1', null, null, null, '2021-04-13 08:25:00', null, 'test', null, '/upload/images/test/20210413_162500_27860.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210413_162500_27860.png', null);
INSERT INTO `attachment` VALUES ('6', '20210413_162651_78523.png', '1', null, null, null, '2021-04-13 08:26:51', null, 'test', null, '/upload/images/test/20210413_162651_78523.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210413_162651_78523.png', null);
INSERT INTO `attachment` VALUES ('7', '20210413_165617_76091.png', '1', null, null, null, '2021-04-13 08:56:17', null, 'test', null, '/upload/images/test/20210413_165617_76091.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210413_165617_76091.png', null);
INSERT INTO `attachment` VALUES ('8', '20210413_170205_29300.png', '1', null, null, null, '2021-04-13 09:02:05', null, 'test', null, '/upload/images/test/20210413_170205_29300.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210413_170205_29300.png', null);
INSERT INTO `attachment` VALUES ('9', '20210413_170530_48820.png', '1', null, null, null, '2021-04-13 09:05:31', null, 'test', null, '/upload/images/test/20210413_170530_48820.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210413_170530_48820.png', null);
INSERT INTO `attachment` VALUES ('10', '20210413_170633_20459.png', '1', null, null, null, '2021-04-13 09:06:34', null, 'test', null, '/upload/images/test/20210413_170633_20459.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210413_170633_20459.png', null);
INSERT INTO `attachment` VALUES ('11', '20210413_170843_50572.png', '1', null, null, null, '2021-04-13 09:08:43', null, 'test', null, '/upload/images/test/20210413_170843_50572.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210413_170843_50572.png', null);
INSERT INTO `attachment` VALUES ('12', '20210413_170925_82744.png', '1', null, null, null, '2021-04-13 09:09:25', null, 'test', null, '/upload/images/test/20210413_170925_82744.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210413_170925_82744.png', null);
INSERT INTO `attachment` VALUES ('13', '20210413_171257_46978.png', '1', null, null, null, '2021-04-13 09:12:57', null, 'test', null, '/upload/images/test/20210413_171257_46978.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210413_171257_46978.png', null);
INSERT INTO `attachment` VALUES ('14', '20210413_171705_9923.png', '1', null, null, null, '2021-04-13 09:17:06', null, 'test', null, '/upload/images/test/20210413_171705_9923.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210413_171705_9923.png', null);
INSERT INTO `attachment` VALUES ('15', '20210413_174137_81366.png', '1', null, null, null, '2021-04-13 09:41:38', null, 'test', null, '/upload/images/test/20210413_174137_81366.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210413_174137_81366.png', null);
INSERT INTO `attachment` VALUES ('16', '20210413_174940_61644.png', '1', null, null, null, '2021-04-13 09:49:41', null, 'test', null, '/upload/images/test/20210413_174940_61644.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210413_174940_61644.png', null);
INSERT INTO `attachment` VALUES ('17', '20210413_180855_57159.png', '1', null, null, null, '2021-04-13 10:08:56', null, 'test', null, '/upload/images/test/20210413_180855_57159.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210413_180855_57159.png', null);
INSERT INTO `attachment` VALUES ('18', '20210415_084546_4468.png', '1', null, null, null, '2021-04-15 00:45:46', null, 'test', null, '/upload/images/test/20210415_084546_4468.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210415_084546_4468.png', null);
INSERT INTO `attachment` VALUES ('19', '20210416_105317_40750.png', '1', null, null, null, '2021-04-16 02:53:17', null, 'test', null, '/upload/images/test/20210416_105317_40750.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210416_105317_40750.png', null);
INSERT INTO `attachment` VALUES ('20', '20210416_143240_30969.png', '1', null, null, null, '2021-04-16 06:32:41', null, 'test', null, '/upload/images/test/20210416_143240_30969.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210416_143240_30969.png', null);
INSERT INTO `attachment` VALUES ('21', '20210416_143558_94538.png', '1', null, null, null, '2021-04-16 06:35:58', null, 'test', null, '/upload/images/test/20210416_143558_94538.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210416_143558_94538.png', null);
INSERT INTO `attachment` VALUES ('22', '20210416_144116_74423.png', '1', null, null, null, '2021-04-16 06:41:17', null, 'test', null, '/upload/images/test/20210416_144116_74423.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210416_144116_74423.png', null);
INSERT INTO `attachment` VALUES ('23', '20210416_144146_53620.png', '1', null, null, null, '2021-04-16 06:41:46', null, 'test', null, '/upload/images/test/20210416_144146_53620.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210416_144146_53620.png', null);
INSERT INTO `attachment` VALUES ('24', '20210416_145052_83916.png', '1', null, null, null, '2021-04-16 06:50:53', null, 'test', null, '/upload/images/test/20210416_145052_83916.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210416_145052_83916.png', null);
INSERT INTO `attachment` VALUES ('25', '20210416_145218_22510.png', '1', null, null, null, '2021-04-16 06:52:18', null, 'test', null, '/upload/images/test/20210416_145218_22510.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210416_145218_22510.png', null);
INSERT INTO `attachment` VALUES ('26', '20210416_145316_270.png', '1', null, null, null, '2021-04-16 06:53:16', null, 'test', null, '/upload/images/test/20210416_145316_270.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210416_145316_270.png', null);
INSERT INTO `attachment` VALUES ('27', '20210416_145430_76606.png', '1', null, null, null, '2021-04-16 06:54:31', null, 'test', null, '/upload/images/test/20210416_145430_76606.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210416_145430_76606.png', null);
INSERT INTO `attachment` VALUES ('28', '20210416_145631_64276.png', '1', null, null, null, '2021-04-16 06:56:31', null, 'test', null, '/upload/images/test/20210416_145631_64276.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210416_145631_64276.png', null);
INSERT INTO `attachment` VALUES ('29', '20210416_153953_97053.png', '1', null, null, null, '2021-04-16 07:39:54', null, 'test', null, '/upload/images/test/20210416_153953_97053.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210416_153953_97053.png', null);
INSERT INTO `attachment` VALUES ('32', '20210416_155659_83792.png', '1', null, null, null, '2021-04-16 07:56:59', null, 'test', null, '/upload/images/test/20210416_155659_83792.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210416_155659_83792.png', '13');
INSERT INTO `attachment` VALUES ('33', '20210416_160123_41196.png', '1', null, null, null, '2021-04-16 08:01:24', null, 'test', null, '/upload/images/test/20210416_160123_41196.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210416_160123_41196.png', '13');
INSERT INTO `attachment` VALUES ('34', '20210419_090836_28489.png', '1', null, null, null, '2021-04-19 01:08:37', null, 'test', null, '/upload/images/test/20210419_090836_28489.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210419_090836_28489.png', null);
INSERT INTO `attachment` VALUES ('35', '20210419_095536_32024.png', '1', null, null, null, '2021-04-19 01:55:36', null, 'test', null, '/upload/images/test/20210419_095536_32024.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210419_095536_32024.png', null);
INSERT INTO `attachment` VALUES ('36', '20210419_100906_49235.png', '1', null, null, null, '2021-04-19 02:09:07', null, 'test', null, '/upload/images/test/20210419_100906_49235.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210419_100906_49235.png', null);
INSERT INTO `attachment` VALUES ('37', '20210419_101002_41724.png', '1', null, null, null, '2021-04-19 02:10:03', null, 'test', null, '/upload/images/test/20210419_101002_41724.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210419_101002_41724.png', null);
INSERT INTO `attachment` VALUES ('38', '20210419_101040_57831.png', '1', null, null, null, '2021-04-19 02:10:41', null, 'test', null, '/upload/images/test/20210419_101040_57831.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210419_101040_57831.png', null);
INSERT INTO `attachment` VALUES ('39', '20210419_102427_22038.png', '1', null, null, null, '2021-04-19 02:24:28', null, 'test', null, '/upload/images/test/20210419_102427_22038.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210419_102427_22038.png', null);
INSERT INTO `attachment` VALUES ('40', '20210419_103155_40275.png', '1', null, null, null, '2021-04-19 02:31:56', null, 'test', null, '/upload/images/test/20210419_103155_40275.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210419_103155_40275.png', null);
INSERT INTO `attachment` VALUES ('41', '20210419_103242_19711.png', '1', null, null, null, '2021-04-19 02:32:42', null, 'test', null, '/upload/images/test/20210419_103242_19711.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210419_103242_19711.png', null);
INSERT INTO `attachment` VALUES ('42', '20210419_103324_97712.png', '1', null, null, null, '2021-04-19 02:33:25', null, 'test', null, '/upload/images/test/20210419_103324_97712.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210419_103324_97712.png', null);
INSERT INTO `attachment` VALUES ('43', '20210419_103422_58443.png', '1', null, null, null, '2021-04-19 02:34:23', null, 'test', null, '/upload/images/test/20210419_103422_58443.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210419_103422_58443.png', null);
INSERT INTO `attachment` VALUES ('44', '20210419_103619_85563.png', '1', null, null, null, '2021-04-19 02:36:20', null, 'test', null, '/upload/images/test/20210419_103619_85563.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210419_103619_85563.png', '12');
INSERT INTO `attachment` VALUES ('45', '20210419_103641_21513.png', '1', null, null, null, '2021-04-19 02:36:41', null, 'test', null, '/upload/images/test/20210419_103641_21513.png', null, 'E:\\workspace\\parent\\core\\target\\classes\\static\\upload\\images\\test\\20210419_103641_21513.png', '12');

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

-- ----------------------------
-- Table structure for sys_login_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_log`;
CREATE TABLE `sys_login_log` (
  `ID` varchar(32) NOT NULL,
  `NAME` varchar(32) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LOGIN_TIMES` int(11) DEFAULT NULL,
  `USER_ID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_SYS_LOGIN_LOG_TO_USER` (`USER_ID`) USING BTREE,
  KEY `NAME_INDEX` (`NAME`),
  CONSTRAINT `FK_SYS_LOGIN_LOG_TO_USER` FOREIGN KEY (`USER_ID`) REFERENCES `sys_user` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统登录日志表';

-- ----------------------------
-- Records of sys_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `ID` varchar(32) NOT NULL,
  `NAME` varchar(32) DEFAULT NULL,
  `IS_EXPIRED` tinyint(4) DEFAULT '0',
  `IS_LOCKED` tinyint(4) DEFAULT '0',
  `IS_ENABLED` tinyint(4) DEFAULT '1',
  `TYPE` int(11) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `EN_NAME` varchar(32) DEFAULT NULL,
  `PARENT_ID` varchar(32) DEFAULT '0' COMMENT '父类ID',
  `CODE` varchar(255) DEFAULT NULL COMMENT '权限表达式',
  `IS_MENU` tinyint(4) DEFAULT '1',
  `URL` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `NAME_INDEX` (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('10', '系统管理-角色管理-添加', '0', '0', '1', null, null, null, '2019-09-03 20:00:16', null, '2020-11-28 14:03:34', null, '8', 'system:role:add', '0', null);
INSERT INTO `sys_permission` VALUES ('11', '系统管理-角色管理-修改', '0', '0', '1', null, null, null, '2019-09-03 20:00:16', null, '2020-11-28 14:03:34', null, '8', 'system:role:update', '0', null);
INSERT INTO `sys_permission` VALUES ('11b26ef41d914bcc96d45d8a3eb6166a', '规则管理', '0', '0', '1', null, null, null, '2020-12-28 14:22:03', null, '2020-12-28 15:43:10', null, 'da8c32c126e7401d8dafab90bb33a827', 'act:rule:url', '1', '/admin/act/rule');
INSERT INTO `sys_permission` VALUES ('12', '系统管理-角色管理-删除', '0', '0', '1', null, null, null, '2019-09-03 20:00:16', null, '2020-11-28 14:03:34', null, '8', 'system:role:delete', '0', null);
INSERT INTO `sys_permission` VALUES ('13', '权限管理', '0', '0', '1', '1', null, null, '2019-09-03 20:00:16', null, '2020-11-30 16:18:49', null, '2', 'system:permission:select', '1', '/admin/sys/permission');
INSERT INTO `sys_permission` VALUES ('14', '权限管理-查询', '0', '0', '1', null, null, null, '2019-09-03 20:00:16', null, '2020-12-01 16:03:12', null, '13', 'system:permission:select', '0', '/admin/sys/permission/tree');
INSERT INTO `sys_permission` VALUES ('15', '权限管理-添加', '0', '0', '1', null, null, null, '2019-09-03 20:00:16', null, '2020-12-01 19:24:45', null, '13', 'system:permission:add', '0', '/admin/sys/permission/create');
INSERT INTO `sys_permission` VALUES ('16', '权限管理-修改', '0', '0', '1', null, null, null, '2019-09-03 20:00:16', null, '2020-12-01 19:26:19', null, '13', 'system:permission:update', '0', '/admin/sys/permission/edit');
INSERT INTO `sys_permission` VALUES ('17', '权限管理-删除', '0', '0', '1', null, null, null, '2019-09-03 20:00:16', null, '2020-11-28 14:03:34', null, '13', 'system:permission:delete', '1', null);
INSERT INTO `sys_permission` VALUES ('2', '系统管理', '0', '0', '1', '1', null, null, '2019-09-03 20:00:16', null, '2020-12-01 14:37:06', null, '0', 'sys', '1', null);
INSERT INTO `sys_permission` VALUES ('23', '操作日志', '0', '0', '1', null, null, '', '2020-01-21 17:20:01', '', '2020-12-01 19:45:06', '', '2', 'opelog', '1', '/admin/sys/opeLog');
INSERT INTO `sys_permission` VALUES ('24', '个人中心', '0', '0', '1', '1', null, null, '2020-11-28 15:21:30', null, '2021-04-21 08:41:59', null, '0', 'test', '1', '');
INSERT INTO `sys_permission` VALUES ('25', '密码重置', '0', '0', '1', '1', null, null, '2020-11-28 15:21:30', null, '2020-12-04 09:37:52', null, '24', '', '1', '/admin/person/info');
INSERT INTO `sys_permission` VALUES ('26', '借阅历史', '0', '0', '1', '1', null, null, '2020-11-28 15:23:48', null, '2020-11-28 15:23:48', null, '24', null, '1', null);
INSERT INTO `sys_permission` VALUES ('27', '个人信息', '0', '0', '1', '1', null, null, '2020-11-28 15:23:48', null, '2020-11-28 15:23:48', null, '24', null, '1', null);
INSERT INTO `sys_permission` VALUES ('28', '逾期查询', '0', '0', '1', '1', null, null, '2020-11-28 15:23:48', null, '2020-11-28 15:23:48', null, '24', null, '1', null);
INSERT INTO `sys_permission` VALUES ('29', '我的文档（借阅/归还）', '0', '0', '1', '1', null, null, '2020-11-28 15:23:48', null, '2020-11-28 15:23:48', null, '24', null, '1', null);
INSERT INTO `sys_permission` VALUES ('3', '用户管理', '0', '0', '1', '1', null, null, '2019-09-03 20:00:16', null, '2020-11-29 16:42:20', null, '2', 'system:user:select', '1', '/admin/sys/user');
INSERT INTO `sys_permission` VALUES ('30', '文档申请借阅', '0', '0', '1', '1', null, null, '2020-11-28 15:23:48', null, '2020-11-28 15:23:48', null, '24', null, '1', null);
INSERT INTO `sys_permission` VALUES ('31', '文档管理', '0', '0', '1', '1', null, null, '2020-11-28 15:35:45', null, '2020-11-28 15:35:45', null, '0', null, '1', null);
INSERT INTO `sys_permission` VALUES ('32', '文档查询', '0', '0', '1', null, null, null, '2020-11-28 15:35:45', null, '2020-11-28 15:35:45', null, '31', null, '1', null);
INSERT INTO `sys_permission` VALUES ('33', '文档登记', '0', '0', '1', null, null, null, '2020-11-28 15:35:45', null, '2020-11-28 15:35:45', null, '31', null, '1', null);
INSERT INTO `sys_permission` VALUES ('34', '文档借出申请', '0', '0', '1', null, null, null, '2020-11-28 15:35:45', null, '2020-11-28 15:35:45', null, '31', null, '1', null);
INSERT INTO `sys_permission` VALUES ('35', '文档借出管理', '0', '0', '1', null, null, null, '2020-11-28 15:35:45', null, '2020-11-28 15:35:45', null, '31', null, '1', null);
INSERT INTO `sys_permission` VALUES ('36', '文档归还管理', '0', '0', '1', null, null, null, '2020-11-28 15:35:45', null, '2020-11-28 15:35:45', null, '31', null, '1', null);
INSERT INTO `sys_permission` VALUES ('36b2dac96f0840918b0d6e4a8c97e5f6', '登录日志', '0', '0', '1', null, null, null, '2020-12-01 19:57:18', null, '2020-12-01 19:57:18', null, '2', 'sys:loginLog', '1', '/admin/sys/loginLog');
INSERT INTO `sys_permission` VALUES ('37', '文档逾期查询', '0', '0', '1', null, null, null, '2020-11-28 15:35:45', null, '2020-11-28 15:35:45', null, '31', null, '1', null);
INSERT INTO `sys_permission` VALUES ('4', '用户管理-查询', '0', '0', '1', null, null, null, '2019-09-03 20:00:16', null, '2020-11-28 14:03:34', null, '3', 'system:user:select', '1', null);
INSERT INTO `sys_permission` VALUES ('5', '用户管理-添加', '0', '0', '1', null, null, null, '2019-09-03 20:00:16', null, '2020-11-28 14:03:34', null, '3', 'system:user:add', '1', null);
INSERT INTO `sys_permission` VALUES ('55f8178f0bc040909f7b81a15c04b064', '活动详情-添加', '0', '0', '1', null, null, null, '2020-12-27 16:58:50', null, '2020-12-27 16:58:50', null, 'a652e65f9be542c1a00c22c2c8783f44', 'act:activity:add', '1', '/admin/act/activity/create');
INSERT INTO `sys_permission` VALUES ('6', '用户管理-修改', '0', '0', '1', null, null, null, '2019-09-03 20:00:16', null, '2020-11-28 14:03:34', null, '3', 'system:user:update', '1', null);
INSERT INTO `sys_permission` VALUES ('65e96eb6496e43f2908ccccaceedf2cf', '奖品管理-添加', '0', '0', '1', null, null, null, '2020-12-28 14:30:09', null, '2020-12-28 14:30:09', null, 'a18616757bc544b684cdac365c17a169', 'act:prise:create', '1', '/admin/act/prise/create');
INSERT INTO `sys_permission` VALUES ('7', '用户管理-删除', '0', '0', '1', null, null, null, '2019-09-03 20:00:16', null, '2020-11-28 14:03:34', null, '3', 'system:user:delete', '1', null);
INSERT INTO `sys_permission` VALUES ('75173f0fc06f4505bfae5cea8a1b49b8', '活动详情-修改', '0', '0', '1', null, null, null, '2020-12-27 17:00:51', null, '2020-12-27 17:00:51', null, 'a652e65f9be542c1a00c22c2c8783f44', 'act:activity:update', '1', '/admin/act/activity/edit');
INSERT INTO `sys_permission` VALUES ('76e8bcf0f23b49e48839889de64f916f', '活动模板-添加', '0', '0', '1', null, null, null, '2020-12-27 17:05:10', null, '2020-12-27 17:05:10', null, 'ed3df8b9a88144b3bf548a2c917202b3', 'act:template:add', '1', '/admin/act/template/create');
INSERT INTO `sys_permission` VALUES ('8', '角色管理', '0', '0', '1', '1', null, null, '2019-09-03 20:00:16', null, '2020-11-30 16:18:49', null, '2', '', '1', '/admin/sys/role');
INSERT INTO `sys_permission` VALUES ('86379374f067489483a143f6f86d68cc', '规则管理-添加', '0', '0', '1', null, null, null, '2020-12-28 14:23:56', null, '2020-12-28 15:43:24', null, '11b26ef41d914bcc96d45d8a3eb6166a', 'act:rule:add', '1', '/admin/act/rule/create');
INSERT INTO `sys_permission` VALUES ('9', '角色管理-查询', '0', '0', '1', null, null, null, '2019-09-03 20:00:16', null, '2020-11-28 14:03:34', null, '8', 'system:role:select', '1', null);
INSERT INTO `sys_permission` VALUES ('a142aea23d614bde97b175d5f60c3c02', '奖品管理-编辑', '0', '0', '1', null, null, null, '2020-12-28 14:31:01', null, '2020-12-28 14:31:01', null, 'a18616757bc544b684cdac365c17a169', 'act:prise:edit', '1', '/admin/act/prise/edit');
INSERT INTO `sys_permission` VALUES ('a18616757bc544b684cdac365c17a169', '奖品管理', '0', '0', '1', null, null, null, '2020-12-28 14:20:45', null, '2020-12-28 14:20:45', null, 'da8c32c126e7401d8dafab90bb33a827', 'act:prise:url', '1', '/admin/act/prise');
INSERT INTO `sys_permission` VALUES ('a652e65f9be542c1a00c22c2c8783f44', '活动管理', '0', '0', '1', null, null, null, '2020-12-27 16:53:06', null, '2020-12-28 11:03:04', null, 'da8c32c126e7401d8dafab90bb33a827', 'act:activity:url', '1', '/admin/act/activity');
INSERT INTO `sys_permission` VALUES ('da8c32c126e7401d8dafab90bb33a827', '营销管理', '0', '0', '1', null, null, null, '2020-12-27 16:50:49', null, '2020-12-28 11:02:01', null, '0', 'act', '1', '');
INSERT INTO `sys_permission` VALUES ('de2b3b776e1344a7bc91c2624e877b07', '规则管理-修改', '0', '0', '1', null, null, null, '2020-12-28 14:25:11', null, '2020-12-28 15:43:56', null, '11b26ef41d914bcc96d45d8a3eb6166a', 'act:rule:add', '1', 'act:rule:edit');
INSERT INTO `sys_permission` VALUES ('e5d86fb5139f45209ce26b28165274cb', '活动模板-修改', '0', '0', '1', null, null, null, '2020-12-27 17:06:21', null, '2020-12-27 17:06:21', null, 'ed3df8b9a88144b3bf548a2c917202b3', 'act:template:edit', '1', 'act:template:edit');
INSERT INTO `sys_permission` VALUES ('ed3df8b9a88144b3bf548a2c917202b3', '模板管理', '0', '0', '1', null, null, null, '2020-12-27 17:04:05', null, '2020-12-27 17:04:05', null, 'da8c32c126e7401d8dafab90bb33a827', 'act:template', '1', '/admin/act/template');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `ID` varchar(32) NOT NULL,
  `NAME` varchar(32) DEFAULT NULL,
  `IS_EXPIRED` tinyint(4) DEFAULT '0',
  `IS_LOCKED` tinyint(4) DEFAULT '0',
  `IS_ENABLED` tinyint(4) DEFAULT '1',
  `TYPE` int(11) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `EN_NAME` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'ADMIN_ROLE', null, null, null, null, null, null, null, 'admin', '2020-02-28 09:06:57', '超级管理员');
INSERT INTO `sys_role` VALUES ('2', 'PUBLISH_ROLE', null, null, null, null, null, null, null, 'admin', '2020-02-27 16:13:34', '发布员');
INSERT INTO `sys_role` VALUES ('7c1d836539f0437885faf10df8862e8e', 'testtreew', '0', '0', '1', null, null, null, '2020-11-30 17:36:28', null, '2021-04-28 08:16:51', 'wttwt');
INSERT INTO `sys_role` VALUES ('8bc2762de3554d90b9422ad8d37a5158', 'abc', '0', '0', '1', null, null, null, '2021-04-28 08:19:29', null, '2021-04-28 08:26:05', null);
INSERT INTO `sys_role` VALUES ('d599cf97267447e38b24199df76f32c1', 'aa', '0', '0', '1', null, null, null, '2021-04-28 08:26:55', null, '2021-04-28 08:37:36', null);

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `ID` varchar(32) NOT NULL,
  `PERMISSION_ID` varchar(32) NOT NULL,
  `ROLE_ID` varchar(32) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `SYS_ROLE_PERMISSION_TO_PERMISSION` (`PERMISSION_ID`) USING BTREE,
  KEY `SYS_ROLE_PERMISSION_TO_ROLE` (`ROLE_ID`) USING BTREE,
  CONSTRAINT `FK_PERMISSTION_ID_TO_PERMISSTION` FOREIGN KEY (`PERMISSION_ID`) REFERENCES `sys_permission` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('000a2c8f5f594efcbf10ca958966eb13', '28', 'f65479d2f4c8429f995b3db809b0cecd');
INSERT INTO `sys_role_permission` VALUES ('01caefca20314ca18d258e8e65c15341', 'e5d86fb5139f45209ce26b28165274cb', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('01f9893924bf4b75a4fd0eb5a111c9f8', '33', '1');
INSERT INTO `sys_role_permission` VALUES ('028ca53647ac4b14934c77ff68f66777', '33', '2');
INSERT INTO `sys_role_permission` VALUES ('0441b8a0806d4d9dbbbe9cc685c5d7d9', '8', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('051de920e83147fcb7dcfa1ffb189814', '32', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('05a8da7dfc0144499c3873e6a9a08d42', '12', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('062a3c60ac70449c957379f1cf83d0df', '24', '262cfe46ec0f43e1a780da247c382def');
INSERT INTO `sys_role_permission` VALUES ('066947b2b51c49019adc129395e6958a', '33', 'd599cf97267447e38b24199df76f32c1');
INSERT INTO `sys_role_permission` VALUES ('07eaa56c58a34a93bf2bf5b243dca353', '8', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('0837846c2eb242c3bd941f00e16eeb3b', '13', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('088a008fdb66429d97bae57cbcdaf322', '8', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('08c39cc1e11147589c97c78e62bd1fa0', 'a652e65f9be542c1a00c22c2c8783f44', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('096e558d4fcb49cf8121104b1b9aa88e', '75173f0fc06f4505bfae5cea8a1b49b8', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('0c339868ecbb4bd3a1b82834aba97734', '26', '7c1d836539f0437885faf10df8862e8e');
INSERT INTO `sys_role_permission` VALUES ('0c6110e62741453bbca3ea86282ba40e', '25', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('0ce333944ce8456f883a6c52c9b6128a', '11', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('0e44aab07c584692ae0cd39581682a26', '17', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('0fbefa38624b41b59e073ffcea5681df', '4', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('11855abfe95e42c8aae5b7e2fcad719e', '28', '7c1d836539f0437885faf10df8862e8e');
INSERT INTO `sys_role_permission` VALUES ('11e0863cb9e74cf09eba4c7ab6e09e00', '28', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('1263be83b9fc45f7823645114fa050c6', 'de2b3b776e1344a7bc91c2624e877b07', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('12df2a60ae844a32a319298c1fdfd056', 'a142aea23d614bde97b175d5f60c3c02', '1');
INSERT INTO `sys_role_permission` VALUES ('1418883b3b7a472aa78c1914c37d750b', '3', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('14e0ba5490234a85aaee7014a7073764', '28', '1');
INSERT INTO `sys_role_permission` VALUES ('153bdec4e81e4692a0ada3aba89ae326', '17', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('1598f772088c4243988a8b1410c3a789', '9', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('17a4ff95861c48198d86c716ac25f8e8', '3', '1');
INSERT INTO `sys_role_permission` VALUES ('181317397f7945d0866568cf0a5088c0', '6', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('184efb2a18ee4b579665ec7a902894b1', 'a142aea23d614bde97b175d5f60c3c02', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('193ee22de2b24bab92bc3c29bee4c345', '5', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('1a3abddbbc4c456d9613953d9879792d', '12', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('1b1db8a936d9488790cd45002d9c20e9', '30', '262cfe46ec0f43e1a780da247c382def');
INSERT INTO `sys_role_permission` VALUES ('1b5933b1d64748ea8ffaf75bfc24e271', '6', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('1cc5e626ff9748ab96f0617380c51879', '7', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('1dac85444eea48c2b1f4bba3c839ceca', '17', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('1e66e78cc75c4fa3ae062b81f520cea4', '26', '2');
INSERT INTO `sys_role_permission` VALUES ('1e8c36dd035746feb6baf642c53fa51b', '2', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('1f3050b948d34894aa05b4f8c8c7b24f', '30', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('1fc644134f5a4add80b391c8c4fec96c', '35', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('204246205c4a470f81fa1c213605c55f', '2', '1');
INSERT INTO `sys_role_permission` VALUES ('2308d2c716104632a7e2b001eaa01e32', '12', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('230af5fdd1e242998e9ff63695705745', '76e8bcf0f23b49e48839889de64f916f', '1');
INSERT INTO `sys_role_permission` VALUES ('2413aeaeed8e47a394e58d4f6b56d89d', '7', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('2530a59920684fc09b28392289abd272', '13', '1');
INSERT INTO `sys_role_permission` VALUES ('269ea47ad9e64143b4245ad42c87946c', '6', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('26d9c0842a6d4c869c63949ce391a207', '23', '1');
INSERT INTO `sys_role_permission` VALUES ('26fe99f872ff4e62988de165eb577479', '34', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('2771f939809a44dbad5e9e9dae15abcd', '37', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('2889c0e6ffc549fb898592ba47088c52', '30', '1');
INSERT INTO `sys_role_permission` VALUES ('2896816b0e60408b8490079e5b0d7e31', '65e96eb6496e43f2908ccccaceedf2cf', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('2bdf36c7f038428587021df46bde755f', '26', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('2d8759806c9a4877af95d5dbbdb14623', '86379374f067489483a143f6f86d68cc', '1');
INSERT INTO `sys_role_permission` VALUES ('2e061c0a60ce42c8a5f58f3bf423e2d2', '36', 'd599cf97267447e38b24199df76f32c1');
INSERT INTO `sys_role_permission` VALUES ('2e49247aae0b4a65a84f8d6629837988', '13', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('2f3ee2f5cd0f466ba5762fac0b2cf5e8', '16', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('2f823b7dfc35474f8fd6307f6358992f', 'da8c32c126e7401d8dafab90bb33a827', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('2fed9950f2564b8488e2340953b58bf0', '75173f0fc06f4505bfae5cea8a1b49b8', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('3041ce7e92f0465c8bfb54dd2de49cc3', '11', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('314807307a7b49eca2554d131c83ebdf', '2', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('3272c075eb92401eb8a23a69e9061b61', '14', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('33cd24c45ed2421b9596bd92fe1d1aab', '14', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('3425a4b5651c400499e1c564140a21db', '30', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('346aabdf47c64825bc4e4513aead0cca', '15', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('34d8921653344652aee3553a78db30ff', '5', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('3a9b0f5852914b48b9d0678c45b40d2c', 'a18616757bc544b684cdac365c17a169', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('3ba78e4e15a4492fb6d594dd34c4b89b', '35', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('3d8dbd6e3a514a1e894a6f0f6d645cb2', '23', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('3df76e00c6174ab588467c141ffd9b5f', '14', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('3e5ea3df409648bb981fa218019f1c93', 'a142aea23d614bde97b175d5f60c3c02', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('3f2457b2f39e4aa7b6cdc5d2ff1b3d6d', '28', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('40b84bc52025488f9439da6d568e512f', '36', '1');
INSERT INTO `sys_role_permission` VALUES ('40d70a19675c48e48874ca5d96fd8823', '32', 'd599cf97267447e38b24199df76f32c1');
INSERT INTO `sys_role_permission` VALUES ('4182fc81cfd54130b8370206724d813e', '4', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('4428d2c8c85d421593f02ba77afb54f1', '3', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('44b77bc9f94349e9b0dfaa628b3d06a2', '34', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('467faa97c2ae4cc0af8b88753a785924', '11', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('46bf3f8de9fb4ffe949d78f2b0915b03', '28', '2');
INSERT INTO `sys_role_permission` VALUES ('46dd5170231f48abaa9c62074d886f6a', '25', '7c1d836539f0437885faf10df8862e8e');
INSERT INTO `sys_role_permission` VALUES ('4721a26445b14dcfbc1100dcd1127970', '35', 'd599cf97267447e38b24199df76f32c1');
INSERT INTO `sys_role_permission` VALUES ('4777461a14984eb58dcc6f7331782457', '25', '1');
INSERT INTO `sys_role_permission` VALUES ('484d062d0f1344d995936b62792e78b0', '15', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('4a3118a3a0964eb3af2e60b205f35755', '55f8178f0bc040909f7b81a15c04b064', '1');
INSERT INTO `sys_role_permission` VALUES ('4a4403802b8748f0a4be0ce1cd01a639', '27', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('4bf34a3c3af544bdad6fe9930e772110', '15', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('4f2a8617bc2b408ea44d1659cbd25675', '37', '1');
INSERT INTO `sys_role_permission` VALUES ('503541a2bb1a45ddbb7b287cfba2c46b', '4', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('50f60604ea8741d9954d1c86b387fdec', '76e8bcf0f23b49e48839889de64f916f', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('52467c7cc78748a597c4046821d354b6', '36b2dac96f0840918b0d6e4a8c97e5f6', '1');
INSERT INTO `sys_role_permission` VALUES ('55c3228072c94cb58ae39b2c70fa7397', '7', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('563d764312fc46fea8f58813dcb677fb', '29', 'f65479d2f4c8429f995b3db809b0cecd');
INSERT INTO `sys_role_permission` VALUES ('566506630f00421390e16a25698f9854', '24', '2');
INSERT INTO `sys_role_permission` VALUES ('57a3ceb828d0414b85a5af94f174b4fe', 'de2b3b776e1344a7bc91c2624e877b07', '1');
INSERT INTO `sys_role_permission` VALUES ('58ec344fd58345bda1537c2ea65ce8ee', 'a18616757bc544b684cdac365c17a169', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('594b87b3fa0a41a59f29a96a3b0e1397', '30', '2');
INSERT INTO `sys_role_permission` VALUES ('5c97e52458be4ca49b57b15ad16a43a3', '2', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('5e11464a41e6404a9c58bad6c5eab288', '2', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('5f0ece2bca5f43afa1accaf29389543d', '14', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('618e904056354e339387a1164a4175f5', '14', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('621464ab93f44d27a588ca44ec435099', '13', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('626966d378a448ef8fffaedfdfd85d4b', '8', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('62a9bdfa032f40de8d3b0f636778cb09', '11', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('62f679a6244a4eaa960b8c97f035ed9e', '29', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('63d6a9afb1094ffa8e5a8b98adf4ef88', '16', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('6408ae2bb9da409dbc9702f5862af4eb', '37', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('675152060a5e4961ad948b5bc929a4db', '34', 'd599cf97267447e38b24199df76f32c1');
INSERT INTO `sys_role_permission` VALUES ('6813ce10b9d24f7780fcbabf03c5df87', '34', '2');
INSERT INTO `sys_role_permission` VALUES ('682a3de40f294c60bc813457b5a673f8', '32', '1');
INSERT INTO `sys_role_permission` VALUES ('6849b4b6f2544fc29c660d3aa0c149be', '14', '262cfe46ec0f43e1a780da247c382def');
INSERT INTO `sys_role_permission` VALUES ('6bdeb620c5a346c8897f53d131a213c1', '13', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('6ccfde02fc3f46ae863eda7c2ff88490', '75173f0fc06f4505bfae5cea8a1b49b8', '1');
INSERT INTO `sys_role_permission` VALUES ('6cef0f9908cc42e3a2aa4a576e5786e0', '7', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('6fe4fffcb8be4a1681e24888fdd870a3', '26', '1');
INSERT INTO `sys_role_permission` VALUES ('6fff7db135ec4a91a38b45ad20592f7c', '3', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('70787576c1664f0297013e05ac7e91ad', '27', '7c1d836539f0437885faf10df8862e8e');
INSERT INTO `sys_role_permission` VALUES ('71373fb2848744168100448b0023e9be', '17', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('73a48e2d7e2d41a9a1c0e741d6516f83', '86379374f067489483a143f6f86d68cc', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('756acd69c401469ca4819ade09b87156', '3', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('7594b307eef4461c8d3f65ba9325c9f1', '24', 'f65479d2f4c8429f995b3db809b0cecd');
INSERT INTO `sys_role_permission` VALUES ('76ea22f280584a7fa7a68b5e3672e00e', '36b2dac96f0840918b0d6e4a8c97e5f6', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('77ae592031c44c7b9ee37dd2fa1f6b48', '55f8178f0bc040909f7b81a15c04b064', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('77bea22d7e524038ad283e8e08f488dd', '33', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('783db8d2e52d462bb659efdd35b46b87', '26', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('7a01ff5f307d4fe7b8f4032732465d6d', '12', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('7bfe1ae5bb684b7cbbc08cb24b2a38ff', '24', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('7db01ee7b36b4954911f0d1fb77ba0ab', '14', '262cfe46ec0f43e1a780da247c382def');
INSERT INTO `sys_role_permission` VALUES ('7de21d0189f842168b3e6e889e29966b', '26', 'f65479d2f4c8429f995b3db809b0cecd');
INSERT INTO `sys_role_permission` VALUES ('7de66d26d5a74995b50a20c25da67b56', '2', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('7e113136f59641a6b3c5998909b4aede', '8', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('7fa14ae6cb5a4523b0ecb0a8b510f3e3', '6', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('84f6a59fdf414894bd238fb6f279c7d6', '32', '2');
INSERT INTO `sys_role_permission` VALUES ('85c6210111784b60aaeb2f1df320e7c3', '86379374f067489483a143f6f86d68cc', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('86681d6a395d454e86df3b1389b73d60', '25', '262cfe46ec0f43e1a780da247c382def');
INSERT INTO `sys_role_permission` VALUES ('86a712ea407243d5b8137b39da228cf3', '13', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('875e7d19e3c2413d8586c4dce31a54b6', '7', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('882f692945a54d3b9c86c324795fc7bf', '10', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('88ab6ac1450d4dcf9332904af4efe0d7', 'e5d86fb5139f45209ce26b28165274cb', '1');
INSERT INTO `sys_role_permission` VALUES ('88ed141cf6b145b39577319c1529ec27', '25', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('8a824e439386438b834570f90e34ab14', '35', '1');
INSERT INTO `sys_role_permission` VALUES ('8bb13282af434621b930909007fcb8e3', '34', '1');
INSERT INTO `sys_role_permission` VALUES ('8cfa7f37da7344d4905c5c1c18925181', '31', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('8d6d3399778249b8bd6ea9bd04020191', '4', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('8d88e6cfe9bf453e846dd6b2ffe486e6', '27', '2');
INSERT INTO `sys_role_permission` VALUES ('8d9dde9a712e4b65b8781890a7318c70', 'da8c32c126e7401d8dafab90bb33a827', '1');
INSERT INTO `sys_role_permission` VALUES ('8e653b29d0284fc581b25474b867da47', '29', '1');
INSERT INTO `sys_role_permission` VALUES ('8e9fdfca8b9e4015acb173a65c8136d7', '5', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('8fde13a4a04142919f212e3b72d4c0cb', '23', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('91fd1f1cf61a47e691f9d38f74243c40', '23', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('9275954c4b9f4c7eb8b587d9d60cfadf', '8', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('93b9d01aa0774f5a8de981ab0eedf457', '7', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('951dba2fdebd491b9005f704bcb36aba', '10', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('95f5e45ecac04e70ae6b0d54d23f4612', '27', '262cfe46ec0f43e1a780da247c382def');
INSERT INTO `sys_role_permission` VALUES ('96e7194cc92345d3abf019bfd2ce7256', 'ed3df8b9a88144b3bf548a2c917202b3', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('9741775f0cd24f3e8d3f30ab61934738', '2', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('9870d97b54c440ff878d60a0260d8202', '6', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('9ada5f1d1a024863ab8b9b1358ba02e3', '24', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('9b0929b1843c4f57a3dd7f931ee34b2a', '29', '2');
INSERT INTO `sys_role_permission` VALUES ('9c5898958db64c94bc9299afb69872ca', '15', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('a0225b32b1244245b42821d819ac5878', '30', '7c1d836539f0437885faf10df8862e8e');
INSERT INTO `sys_role_permission` VALUES ('a074e0c6e2e74867a6f98a4d7955c347', '65e96eb6496e43f2908ccccaceedf2cf', '1');
INSERT INTO `sys_role_permission` VALUES ('a1d6089da6df423dac51441b69f590c4', '36', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('a25d5c4b66114e808f00784b87116597', '9', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('a2f1f09a45c54e6f89a2f8af98f651d9', '9', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('a3ec2adc576e449b84252728668b6414', '10', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('a546a0196c5b4b92ba45d4770fa327dd', '36b2dac96f0840918b0d6e4a8c97e5f6', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('a58b795acd7f42209b45f44ea8dcf99d', '8', '1');
INSERT INTO `sys_role_permission` VALUES ('a736920ae7444caaa84fbb6af3f5e80f', '27', 'f65479d2f4c8429f995b3db809b0cecd');
INSERT INTO `sys_role_permission` VALUES ('aa9ceabf83b64c2faeaea6364111994f', '35', '2');
INSERT INTO `sys_role_permission` VALUES ('adc68785caa348f59c3fa2120114281b', '36', '2');
INSERT INTO `sys_role_permission` VALUES ('afb14442e5a04ad496f93b63c6e875cb', '30', 'f65479d2f4c8429f995b3db809b0cecd');
INSERT INTO `sys_role_permission` VALUES ('b13b5568510547d687e4e344238a909b', '31', '1');
INSERT INTO `sys_role_permission` VALUES ('b1bc65e2a5474ff69a93fc148e0c2ef1', '31', 'd599cf97267447e38b24199df76f32c1');
INSERT INTO `sys_role_permission` VALUES ('b1c5d815f0ad4fb3945d68b246033520', '17', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('b3c3ee82985a4d9b89c36c3feed6a9cd', '10', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('b527393b70ed450da0aef45ce92314df', '5', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('b7842ed00bc346da9dce64379ecabd27', '14', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('ba9520f9da254e36836573fd982e3610', '9', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('baf8fd013074416899b396876aa97c4e', '23', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('bd4a252b07434efab3265f51c9930b2f', 'e5d86fb5139f45209ce26b28165274cb', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('bd4ae91f33f347c0bcfb406c436acfe3', 'a652e65f9be542c1a00c22c2c8783f44', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('be1631b109bc41c39e0e98b539c4d472', '11b26ef41d914bcc96d45d8a3eb6166a', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('be50e0ec81e8447a87d9b53a7a2fca8a', '28', '262cfe46ec0f43e1a780da247c382def');
INSERT INTO `sys_role_permission` VALUES ('bf1bcd3205304ab4a1bf9f09ad0aedb2', '33', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('bf3b0f73db774a5d905ddc327f5755b3', 'ed3df8b9a88144b3bf548a2c917202b3', '1');
INSERT INTO `sys_role_permission` VALUES ('c129975d14bb4f19983ba7856b1e4e4b', '5', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('c1330ca536764a469830308e74493dc3', '24', '7c1d836539f0437885faf10df8862e8e');
INSERT INTO `sys_role_permission` VALUES ('c600b6ae2c374d83ae7536c182608a39', '26', '262cfe46ec0f43e1a780da247c382def');
INSERT INTO `sys_role_permission` VALUES ('c75e0dc81c4741f882c3baa632e1dc7e', '11b26ef41d914bcc96d45d8a3eb6166a', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('c785784a131b412f920b14f5fa080194', '31', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('c855ae63cd7340d4bd22bfdf127a70fa', '12', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('c9646d67c6e441f1bde74f81ef97d085', '16', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('c9ea8e2a5a6d47d2ad2bfff623e43407', 'de2b3b776e1344a7bc91c2624e877b07', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('cb9261c3ea9f43349d3b2b3ab3e08f15', 'ed3df8b9a88144b3bf548a2c917202b3', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('cbf786691e994d369b6d504c84ea697f', '15', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('cee1c9ac3ed94174abe4a33bc09b1ca6', '55f8178f0bc040909f7b81a15c04b064', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('cf2dc2ba4b9c43b1b484f8af4f53c273', '37', '2');
INSERT INTO `sys_role_permission` VALUES ('d02b277c3d344f2caac74da448edd6bc', '13', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('d160a125d31e43b188d6cb2364db2ed0', '16', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('d3cef5da91ab4a13a00fac09acdc3b0b', '36', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('d5120dfea077494596721b8ca006cf11', '23', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('d6f600bbac2f4fc0b3fca143e70345ad', '29', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('d72d7f8aad8a4c22af33ae3e929c71e3', '15', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('d98a87a99ede469985fe15b384741ec2', '4', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('d9ba2760ee074189b72bccfae795e077', '32', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('da29b09c194541149ef639c37fa6b543', '76e8bcf0f23b49e48839889de64f916f', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('da43364a0a2d4e77a4afa31e4a9a18aa', '36b2dac96f0840918b0d6e4a8c97e5f6', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('db1bbdf3ab7d4431b07fea77443c79a6', '65e96eb6496e43f2908ccccaceedf2cf', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('e09992d77ddf4fb2bf223521df411d47', '24', '1');
INSERT INTO `sys_role_permission` VALUES ('e28563007b1a41d4b0351714d19846d6', 'a652e65f9be542c1a00c22c2c8783f44', '1');
INSERT INTO `sys_role_permission` VALUES ('e2d8279f0cdf402099e9ef607ef4e827', '16', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('e458a091fdb74d6580d81059a04cbc4a', '9', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('e50b3bda80d642a1959a80d60d303d9e', '25', 'f65479d2f4c8429f995b3db809b0cecd');
INSERT INTO `sys_role_permission` VALUES ('e59309f0916845208a8edc0de1889d11', 'a18616757bc544b684cdac365c17a169', '1');
INSERT INTO `sys_role_permission` VALUES ('e7880055098842d39bbb37bbb0feaa2e', '10', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('e80e4da68fb1431492b9e2b9ada5d060', '37', 'd599cf97267447e38b24199df76f32c1');
INSERT INTO `sys_role_permission` VALUES ('e9b9916145ab4d8889e24d62685e8833', '11', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('e9f8c97218f241fbb55e21c92dafe3a7', '27', '1');
INSERT INTO `sys_role_permission` VALUES ('ea74d1825ca24cf58f7bab0e6f2250ab', '36b2dac96f0840918b0d6e4a8c97e5f6', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('ec10c1327dd748288ea4169bb1512483', '9', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('ed6150e7edd54ad68c4b1ab4093fc88c', '31', '2');
INSERT INTO `sys_role_permission` VALUES ('edfda37418e84d4d8c76c9e25a406e1f', '25', '2');
INSERT INTO `sys_role_permission` VALUES ('f0180feb3247430caaffb247f8c1884c', '3', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('f173ab32f4c740fd90df5512beff1c79', '3', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('f25d0bb582684e668fa7c03408729707', '29', '7c1d836539f0437885faf10df8862e8e');
INSERT INTO `sys_role_permission` VALUES ('f33d7acfa064441a872f6a551f4a729f', '23', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('f3d33098089c4e8f85c97306694306a9', '11', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('f42173fbe78940278827b15fdfba0f20', '17', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('f4db6db6eefc458e9b31286e0fbdf891', '12', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('f632e50d81fc40feb0044e03faf7568b', '4', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('f98b9fa17dc044a7899982ee26855df0', '10', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('faf9c05d94714c42a819d9f847242ef4', '5', 'a2e809f7005844aeaaaaa60f73c6c7fe');
INSERT INTO `sys_role_permission` VALUES ('fb5b3038ed1e4564869eb1c4b303370e', '11b26ef41d914bcc96d45d8a3eb6166a', '1');
INSERT INTO `sys_role_permission` VALUES ('fcb8e3e6d91f4013a11ba573dca4768a', '29', '262cfe46ec0f43e1a780da247c382def');
INSERT INTO `sys_role_permission` VALUES ('fd18089d7e2e44e180186d79e4aa62b7', '16', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('fd93046117f24c4bbb9622a957f4c386', '27', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_role_permission` VALUES ('feddbff40deb42fa960750ced4215065', '6', 'a915a384ef394857b2aea91b8c039942');
INSERT INTO `sys_role_permission` VALUES ('ffc4da9ce8bc474e9070d8d18e39d5b9', 'da8c32c126e7401d8dafab90bb33a827', '8bc2762de3554d90b9422ad8d37a5158');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `ID` varchar(32) NOT NULL,
  `LOGIN_NAME` varchar(32) DEFAULT NULL,
  `PASSWORD` varchar(128) DEFAULT NULL,
  `REAL_NAME` varchar(32) DEFAULT NULL,
  `IS_EXPIRED` tinyint(4) DEFAULT '0',
  `IS_LOCKED` tinyint(4) DEFAULT '0',
  `IS_ENABLED` tinyint(4) DEFAULT '1',
  `TYPE` int(11) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `EN_NAME` varchar(32) DEFAULT NULL,
  `EMAIL` varchar(64) DEFAULT NULL,
  `SEX` tinyint(1) DEFAULT NULL,
  `MOBILE` varchar(15) DEFAULT NULL,
  `SORT` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`),
  KEY `SYS_USER_LOGIN_NAME_INDEX` (`LOGIN_NAME`) USING BTREE,
  KEY `SYS_USER_EMAIL_INDEX` (`EMAIL`) USING BTREE,
  KEY `SYS_USER_MOBILE_INDEX` (`MOBILE`) USING BTREE,
  KEY `SYS_USER_SORT_INDEX` (`SORT`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('0abf3a2ee79541c2be2f97ea990fd4a2', '12322', '{bcrypt}$2a$10$aivUv2AYRTZTL2EsL64hVuvs4rwKp3UbGnXv8SGrmfF.RRg6H0D0m', '123', '0', '0', '1', null, null, null, '2019-10-22 15:29:27', null, '2020-12-25 14:57:58', null, '13', null, null, '31');
INSERT INTO `sys_user` VALUES ('100', 'admin', '{bcrypt}$2a$10$aivUv2AYRTZTL2EsL64hVuvs4rwKp3UbGnXv8SGrmfF.RRg6H0D0m', '', '0', '0', '1', null, null, '', '2019-05-04 01:59:06', '', '2021-04-29 08:20:31', '', '13926205227', null, '', '1');
INSERT INTO `sys_user` VALUES ('28', 'ziliaoyuan', '{bcrypt}$2a$10$aivUv2AYRTZTL2EsL64hVuvs4rwKp3UbGnXv8SGrmfF.RRg6H0D0m', '资料员', '0', '0', '1', null, null, null, '2019-09-03 21:20:35', null, '2020-12-18 10:11:05', 'ziliaoyuan', 'abc@qq.com', null, '13926205227', '16');
INSERT INTO `sys_user` VALUES ('6df113b027be40269a775af6a424ae34', 'admintest', 'e10adc3949ba59abbe56e057f20f883e', 'admintest', '0', '0', '1', null, null, null, '2020-12-18 09:25:23', null, '2020-12-18 09:25:23', 'admintest', '635152644@qq.com', null, '13926205229', '38');
INSERT INTO `sys_user` VALUES ('7f48d869104744e5bf2e0ce7d4cc71b4', '123', 'e10adc3949ba59abbe56e057f20f883e', null, '0', '0', '1', null, null, null, '2020-11-26 16:43:11', null, '2020-11-29 14:40:00', null, null, null, null, '33');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `ID` varchar(32) NOT NULL,
  `USER_ID` varchar(32) DEFAULT NULL,
  `ROLE_ID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_SYS_USER_ROLE_TO_USER` (`USER_ID`) USING BTREE,
  KEY `FK_SYS_USER_ROLE_TO_ROLE` (`ROLE_ID`) USING BTREE,
  CONSTRAINT `FK_ROLE_ID_TO_ROLE` FOREIGN KEY (`ROLE_ID`) REFERENCES `sys_role` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统用户角色中间表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('05873606869e4e34b58abbbfa1335dfc', '28', '2');
INSERT INTO `sys_user_role` VALUES ('1', '1', '1');
INSERT INTO `sys_user_role` VALUES ('1bcddf94903f43bf9f462de5771b2d82', '100', '7c1d836539f0437885faf10df8862e8e');
INSERT INTO `sys_user_role` VALUES ('1c7fad7ebcd84400aa74dd10f40285ef', 'd059d45197284bf69343c4bb44ebe4b5', '2');
INSERT INTO `sys_user_role` VALUES ('2', '2', '1');
INSERT INTO `sys_user_role` VALUES ('5', '0991c08c5e4b4371a4e518c7c629e74b', '2');
INSERT INTO `sys_user_role` VALUES ('63a3773aae81448e884f3e1f9260ce70', '100', '2');
INSERT INTO `sys_user_role` VALUES ('63c0e3807bef4db7af51bc507aa58ce8', '6df113b027be40269a775af6a424ae34', '7c1d836539f0437885faf10df8862e8e');
INSERT INTO `sys_user_role` VALUES ('9551e404e6e446a1b625fd26b5802bc5', '100', '1');
INSERT INTO `sys_user_role` VALUES ('ac78a7e4f53f47098ed2497b926044a4', 'ef252c5bd3b14e9387f1e3decf156d69', '2');
INSERT INTO `sys_user_role` VALUES ('be1c5537116149b3a00c6a206ca660b5', '100', '8bc2762de3554d90b9422ad8d37a5158');
INSERT INTO `sys_user_role` VALUES ('e92b249dd01b492cbdf99e389355dad7', '100', 'd599cf97267447e38b24199df76f32c1');
