/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : shopsysapp

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2018-12-28 17:53:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `address_name` varchar(1000) DEFAULT NULL,
  `address_code` varchar(100) DEFAULT NULL,
  `address_status` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `address_tel` varchar(50) DEFAULT NULL,
  `address_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('1', '北京市北京市东城区', '88', '1', '2', '11', '小红');

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `admin_name` varchar(50) DEFAULT NULL,
  `admin_password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'd7afde3e7059cd0a0fe09eec4b0008cd');

-- ----------------------------
-- Table structure for `attribute`
-- ----------------------------
DROP TABLE IF EXISTS `attribute`;
CREATE TABLE `attribute` (
  `attribute_id` int(11) NOT NULL AUTO_INCREMENT,
  `attribute_name` varchar(100) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `secondtype_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`attribute_id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attribute
-- ----------------------------
INSERT INTO `attribute` VALUES ('1', '颜色', '0', '1');
INSERT INTO `attribute` VALUES ('2', '尺码', '0', '1');
INSERT INTO `attribute` VALUES ('3', '红色', '1', '1');
INSERT INTO `attribute` VALUES ('4', '粉色', '1', '1');
INSERT INTO `attribute` VALUES ('5', '白色', '1', '1');
INSERT INTO `attribute` VALUES ('6', '黑色', '1', '1');
INSERT INTO `attribute` VALUES ('7', '蓝色', '1', '1');
INSERT INTO `attribute` VALUES ('8', '黄色', '1', '1');
INSERT INTO `attribute` VALUES ('9', '灰色', '1', '1');
INSERT INTO `attribute` VALUES ('10', 'S码', '2', '1');
INSERT INTO `attribute` VALUES ('11', 'M码', '2', '1');
INSERT INTO `attribute` VALUES ('12', 'L码', '2', '1');
INSERT INTO `attribute` VALUES ('13', 'XL码', '2', '1');
INSERT INTO `attribute` VALUES ('14', 'XXL码', '2', '1');

-- ----------------------------
-- Table structure for `cart`
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `cart_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`cart_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('1', '1');
INSERT INTO `cart` VALUES ('2', '2');

-- ----------------------------
-- Table structure for `cartdetail`
-- ----------------------------
DROP TABLE IF EXISTS `cartdetail`;
CREATE TABLE `cartdetail` (
  `cartdetail_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_count` int(11) DEFAULT NULL,
  `goods_money` double DEFAULT NULL,
  `cartdetail_status` int(11) DEFAULT NULL,
  `goodsdetail_id` int(11) DEFAULT NULL,
  `cart_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`cartdetail_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cartdetail
-- ----------------------------
INSERT INTO `cartdetail` VALUES ('1', '1', '179', '1', '30', '2');
INSERT INTO `cartdetail` VALUES ('2', '1', '698', '1', '1', '2');

-- ----------------------------
-- Table structure for `contact`
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
  `contact_id` int(11) NOT NULL AUTO_INCREMENT,
  `attribute_id` int(11) DEFAULT NULL,
  `goodsdetail_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`contact_id`)
) ENGINE=MyISAM AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contact
-- ----------------------------
INSERT INTO `contact` VALUES ('1', '4', '1');
INSERT INTO `contact` VALUES ('2', '11', '1');
INSERT INTO `contact` VALUES ('3', '6', '2');
INSERT INTO `contact` VALUES ('4', '12', '2');
INSERT INTO `contact` VALUES ('5', '8', '3');
INSERT INTO `contact` VALUES ('6', '13', '3');
INSERT INTO `contact` VALUES ('7', '7', '4');
INSERT INTO `contact` VALUES ('8', '14', '4');
INSERT INTO `contact` VALUES ('9', '9', '5');
INSERT INTO `contact` VALUES ('10', '11', '5');
INSERT INTO `contact` VALUES ('11', '6', '6');
INSERT INTO `contact` VALUES ('12', '12', '6');
INSERT INTO `contact` VALUES ('13', '6', '7');
INSERT INTO `contact` VALUES ('14', '12', '7');
INSERT INTO `contact` VALUES ('15', '9', '8');
INSERT INTO `contact` VALUES ('16', '11', '8');
INSERT INTO `contact` VALUES ('17', '5', '9');
INSERT INTO `contact` VALUES ('18', '10', '9');
INSERT INTO `contact` VALUES ('19', '3', '10');
INSERT INTO `contact` VALUES ('20', '11', '10');
INSERT INTO `contact` VALUES ('21', '5', '11');
INSERT INTO `contact` VALUES ('22', '13', '11');
INSERT INTO `contact` VALUES ('23', '6', '12');
INSERT INTO `contact` VALUES ('24', '11', '12');
INSERT INTO `contact` VALUES ('25', '4', '13');
INSERT INTO `contact` VALUES ('26', '13', '13');
INSERT INTO `contact` VALUES ('27', '6', '14');
INSERT INTO `contact` VALUES ('28', '12', '14');
INSERT INTO `contact` VALUES ('29', '4', '15');
INSERT INTO `contact` VALUES ('30', '12', '15');
INSERT INTO `contact` VALUES ('31', '6', '16');
INSERT INTO `contact` VALUES ('32', '13', '16');
INSERT INTO `contact` VALUES ('33', '5', '17');
INSERT INTO `contact` VALUES ('34', '12', '17');
INSERT INTO `contact` VALUES ('35', '6', '18');
INSERT INTO `contact` VALUES ('36', '10', '18');
INSERT INTO `contact` VALUES ('37', '7', '19');
INSERT INTO `contact` VALUES ('38', '13', '19');
INSERT INTO `contact` VALUES ('39', '3', '20');
INSERT INTO `contact` VALUES ('40', '12', '20');
INSERT INTO `contact` VALUES ('41', '5', '21');
INSERT INTO `contact` VALUES ('42', '12', '21');
INSERT INTO `contact` VALUES ('43', '6', '22');
INSERT INTO `contact` VALUES ('44', '14', '22');
INSERT INTO `contact` VALUES ('45', '6', '23');
INSERT INTO `contact` VALUES ('46', '12', '23');
INSERT INTO `contact` VALUES ('47', '5', '24');
INSERT INTO `contact` VALUES ('48', '12', '24');
INSERT INTO `contact` VALUES ('49', '6', '25');
INSERT INTO `contact` VALUES ('50', '12', '25');
INSERT INTO `contact` VALUES ('51', '7', '26');
INSERT INTO `contact` VALUES ('52', '13', '26');
INSERT INTO `contact` VALUES ('53', '6', '27');
INSERT INTO `contact` VALUES ('54', '12', '27');
INSERT INTO `contact` VALUES ('55', '6', '28');
INSERT INTO `contact` VALUES ('56', '11', '28');
INSERT INTO `contact` VALUES ('57', '6', '29');
INSERT INTO `contact` VALUES ('58', '10', '29');
INSERT INTO `contact` VALUES ('59', '9', '30');
INSERT INTO `contact` VALUES ('60', '11', '30');
INSERT INTO `contact` VALUES ('61', '4', '31');
INSERT INTO `contact` VALUES ('62', '11', '31');

-- ----------------------------
-- Table structure for `firsttype`
-- ----------------------------
DROP TABLE IF EXISTS `firsttype`;
CREATE TABLE `firsttype` (
  `firsttype_id` int(11) NOT NULL AUTO_INCREMENT,
  `firsttype_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`firsttype_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of firsttype
-- ----------------------------
INSERT INTO `firsttype` VALUES ('1', '服装');

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(100) DEFAULT NULL,
  `goods_desc` varchar(200) DEFAULT NULL,
  `goods_pubtime` date DEFAULT NULL,
  `goods_isnew` int(11) DEFAULT NULL,
  `goods_sale` int(11) DEFAULT '0',
  `thirdtype_id` int(11) DEFAULT NULL,
  `updateTime` datetime DEFAULT '2018-12-28 16:43:29',
  PRIMARY KEY (`goods_id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '冬季新款超大毛领羽绒服女中长款白鸭绒韩版小个子短款外套潮', '\r\n正品保证极速退款七天无理由退换', '2018-12-28', '1', '0', '1', '2018-12-28 15:13:36');
INSERT INTO `goods` VALUES ('2', '男装 无缝羽绒大衣 409332 优衣库UNIQLO', '赠保价险正品保证门店自提极速退款赠运费险七天无理由退换', '2018-12-28', '1', '0', '1', '2018-12-28 16:43:29');
INSERT INTO `goods` VALUES ('3', '波司登羽绒服男2018新款短款羽绒冬季防寒加厚款', '赠保价险正品保证极速退款赠运费险七天无理由退换', '2018-12-28', '1', '0', '1', '2018-12-28 16:43:29');
INSERT INTO `goods` VALUES ('4', '女装 高级轻型羽绒茄克 400711 优衣库', '赠保价险正品保证门店自提极速退款赠运费险七天无理由退换', '2018-12-28', '1', '0', '1', '2018-12-28 16:43:29');
INSERT INTO `goods` VALUES ('5', '斐乐女羽绒服2018冬季新款运动休闲时尚潮流时尚长羽绒服', '赠保价险正品保证门店自提极速退款赠运费险七天无理由退换', '2018-12-28', '1', '0', '1', '2018-12-28 16:43:29');
INSERT INTO `goods` VALUES ('6', '格子黄金貂绒毛呢外套女中长款2018新款小清新加厚千鸟格呢子大衣', '赠保价险正品保证门店自提极速退款赠运费险七天无理由退换', '2018-12-28', '1', '0', '2', '2018-12-28 16:43:29');
INSERT INTO `goods` VALUES ('7', '羊剪绒大衣女中长款2018新款仿水貂毛领外套黄金貂连帽羊毛呢外套', '赠保价险正品保证门店自提极速退款赠运费险七天无理由退换', '2018-12-28', '1', '0', '2', '2018-12-28 16:43:29');
INSERT INTO `goods` VALUES ('8', '加厚加绒毛衣男圆领冬季2018新款韩版学生套头日系针织衫毛线衣', '赠保价险正品保证门店自提极速退款赠运费险七天无理由退换', '2018-12-28', '1', '0', '3', '2018-12-28 16:43:29');
INSERT INTO `goods` VALUES ('9', '妤后新款高贵复古中国风仙鹤祥云刺绣重工刺绣气质红色连衣裙', '赠保价险正品保证门店自提极速退款赠运费险七天无理由退换', '2018-12-28', '1', '0', '4', '2018-12-28 16:43:29');
INSERT INTO `goods` VALUES ('10', '秋装男士长袖t恤冬季潮上衣打底衫男装加绒加厚卫衣男保暖秋衣服', '赠保价险正品保证门店自提极速退款赠运费险七天无理由退换', '2018-12-28', '1', '0', '5', '2018-12-28 16:43:29');
INSERT INTO `goods` VALUES ('11', '英爵伦 男士皮衣 夹克外套机车服立领加绒皮夹克2018新款修身帅气', '赠保价险正品保证门店自提极速退款赠运费险七天无理由退换', '2018-12-28', '1', '0', '6', '2018-12-28 16:43:29');
INSERT INTO `goods` VALUES ('12', '秋季2018新款青年韩版潮流修身加绒保暖衬衫男长袖商务休闲白衬衣', '赠保价险正品保证门店自提极速退款赠运费险七天无理由退换', '2018-12-28', '1', '0', '7', '2018-12-28 16:43:29');
INSERT INTO `goods` VALUES ('13', '爱登堡男装秋冬保暖外套夹克男士中青年立领修身休闲棒球服茄克衫', '赠保价险正品保证门店自提极速退款赠运费险七天无理由退换', '2018-12-28', '1', '0', '8', '2018-12-28 16:43:29');
INSERT INTO `goods` VALUES ('14', '男装 防风仿羊羔绒摇粒绒拉链茄克 409878 优衣库', '赠保价险正品保证门店自提极速退款赠运费险七天无理由退换', '2018-12-28', '1', '0', '8', '2018-12-28 16:43:29');
INSERT INTO `goods` VALUES ('15', '西服套装男士三件套商务正装职业小西装修身伴郎服装新郎结婚礼服', '赠保价险正品保证门店自提极速退款赠运费险七天无理由退换', '2018-12-28', '1', '0', '9', '2018-12-28 16:43:29');
INSERT INTO `goods` VALUES ('16', '短袖t恤男士2019新款夏装潮牌背后印花半袖学生宽松休闲青年上衣', '赠保价险正品保证门店自提极速退款赠运费险七天无理由退换', '2018-12-28', '1', '0', '10', '2018-12-28 16:43:29');
INSERT INTO `goods` VALUES ('17', '歌瑞尔甜美可外穿睡衣女秋冬加厚保暖舒适长袖连帽法兰绒家居服', '赠保价险正品保证门店自提极速退款赠运费险七天无理由退换', '2018-12-28', '1', '0', '11', '2018-12-28 16:43:29');

-- ----------------------------
-- Table structure for `goodsdetail`
-- ----------------------------
DROP TABLE IF EXISTS `goodsdetail`;
CREATE TABLE `goodsdetail` (
  `goodsdetail_id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsdetail_price` double DEFAULT NULL,
  `goods_count` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`goodsdetail_id`)
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodsdetail
-- ----------------------------
INSERT INTO `goodsdetail` VALUES ('1', '698', '100', '1');
INSERT INTO `goodsdetail` VALUES ('2', '699', '100', '1');
INSERT INTO `goodsdetail` VALUES ('3', '700', '100', '1');
INSERT INTO `goodsdetail` VALUES ('4', '701', '100', '1');
INSERT INTO `goodsdetail` VALUES ('5', '799', '100', '2');
INSERT INTO `goodsdetail` VALUES ('6', '899', '100', '2');
INSERT INTO `goodsdetail` VALUES ('7', '799', '100', '3');
INSERT INTO `goodsdetail` VALUES ('8', '899', '100', '3');
INSERT INTO `goodsdetail` VALUES ('9', '299', '100', '4');
INSERT INTO `goodsdetail` VALUES ('10', '399', '100', '4');
INSERT INTO `goodsdetail` VALUES ('11', '2133', '100', '5');
INSERT INTO `goodsdetail` VALUES ('12', '2100', '100', '5');
INSERT INTO `goodsdetail` VALUES ('13', '2222', '100', '5');
INSERT INTO `goodsdetail` VALUES ('14', '248', '100', '6');
INSERT INTO `goodsdetail` VALUES ('15', '309', '100', '7');
INSERT INTO `goodsdetail` VALUES ('16', '409', '100', '7');
INSERT INTO `goodsdetail` VALUES ('17', '509', '100', '8');
INSERT INTO `goodsdetail` VALUES ('18', '609', '100', '8');
INSERT INTO `goodsdetail` VALUES ('19', '709', '100', '8');
INSERT INTO `goodsdetail` VALUES ('20', '419', '100', '9');
INSERT INTO `goodsdetail` VALUES ('21', '509', '100', '10');
INSERT INTO `goodsdetail` VALUES ('22', '709', '100', '10');
INSERT INTO `goodsdetail` VALUES ('23', '248', '100', '11');
INSERT INTO `goodsdetail` VALUES ('24', '99', '100', '12');
INSERT INTO `goodsdetail` VALUES ('25', '100', '100', '12');
INSERT INTO `goodsdetail` VALUES ('26', '179', '100', '13');
INSERT INTO `goodsdetail` VALUES ('27', '149', '100', '14');
INSERT INTO `goodsdetail` VALUES ('28', '199', '100', '15');
INSERT INTO `goodsdetail` VALUES ('29', '79', '100', '16');
INSERT INTO `goodsdetail` VALUES ('30', '179', '100', '17');
INSERT INTO `goodsdetail` VALUES ('31', '189', '100', '17');

-- ----------------------------
-- Table structure for `image`
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
  `image_id` int(11) NOT NULL AUTO_INCREMENT,
  `image_path` varchar(100) DEFAULT NULL,
  `goodsdetail_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`image_id`)
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES ('1', 'detail_1_1.png', '1');
INSERT INTO `image` VALUES ('2', 'detail_1_2.png', '2');
INSERT INTO `image` VALUES ('3', 'detail_1_3.png', '3');
INSERT INTO `image` VALUES ('4', 'detail_1_4.png', '4');
INSERT INTO `image` VALUES ('5', 'detail_2_1.png', '5');
INSERT INTO `image` VALUES ('6', 'detail_2_2.png', '6');
INSERT INTO `image` VALUES ('7', 'detail_3_1.png', '7');
INSERT INTO `image` VALUES ('8', 'detail_3_2.png', '8');
INSERT INTO `image` VALUES ('9', 'detail_4_1.png', '9');
INSERT INTO `image` VALUES ('10', 'detail_4_2.png', '10');
INSERT INTO `image` VALUES ('11', 'detail_5_1.png', '11');
INSERT INTO `image` VALUES ('12', 'detail_5_2.png', '12');
INSERT INTO `image` VALUES ('13', 'detail_5_3.png', '13');
INSERT INTO `image` VALUES ('14', 'detail_6_1.png', '14');
INSERT INTO `image` VALUES ('15', 'detail_7_1 (2).png', '15');
INSERT INTO `image` VALUES ('16', 'detail_7_2.png', '16');
INSERT INTO `image` VALUES ('17', 'detail_8_1.png', '17');
INSERT INTO `image` VALUES ('18', 'detail_8_2.png', '18');
INSERT INTO `image` VALUES ('19', 'detail_8_3.png', '19');
INSERT INTO `image` VALUES ('20', 'detail_9_1.png', '20');
INSERT INTO `image` VALUES ('21', 'detail_10_1.png', '21');
INSERT INTO `image` VALUES ('22', 'detail_10_2.png', '22');
INSERT INTO `image` VALUES ('23', 'detail_11_1.png', '23');
INSERT INTO `image` VALUES ('24', 'detail_12_1.png', '24');
INSERT INTO `image` VALUES ('25', 'detail_12_2.png', '25');
INSERT INTO `image` VALUES ('26', 'detail_13_1.png', '26');
INSERT INTO `image` VALUES ('27', 'detail_14_1.png', '27');
INSERT INTO `image` VALUES ('28', 'detail_15_1.png', '28');
INSERT INTO `image` VALUES ('29', 'detail_16_1.png', '29');
INSERT INTO `image` VALUES ('30', 'detail_17_1.png', '30');
INSERT INTO `image` VALUES ('31', 'detail_18_1.png', '31');

-- ----------------------------
-- Table structure for `orderdetail`
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `orderdetail_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_count` int(11) DEFAULT NULL,
  `goods_buyprice` double DEFAULT NULL,
  `goodsdetail_id` int(11) DEFAULT NULL,
  `Order_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`orderdetail_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_id` varchar(50) NOT NULL DEFAULT '',
  `to_userName` varchar(100) DEFAULT NULL,
  `to_addr` varchar(500) DEFAULT NULL,
  `to_tel` varchar(100) DEFAULT NULL,
  `order_time` date DEFAULT NULL,
  `order_status` int(11) DEFAULT NULL,
  `order_totalmoney` double DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for `orderstatus`
-- ----------------------------
DROP TABLE IF EXISTS `orderstatus`;
CREATE TABLE `orderstatus` (
  `orderdetail_id` int(11) NOT NULL,
  `orderdetail_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderdetail_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderstatus
-- ----------------------------

-- ----------------------------
-- Table structure for `review`
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
  `review_id` int(11) NOT NULL AUTO_INCREMENT,
  `review_level` float(11,0) DEFAULT NULL,
  `review_content` varchar(5000) DEFAULT NULL,
  `review_image` varchar(100) DEFAULT NULL,
  `orderdetail_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `review_date` datetime DEFAULT NULL,
  PRIMARY KEY (`review_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of review
-- ----------------------------

-- ----------------------------
-- Table structure for `secondtype`
-- ----------------------------
DROP TABLE IF EXISTS `secondtype`;
CREATE TABLE `secondtype` (
  `secondtype_id` int(11) NOT NULL AUTO_INCREMENT,
  `secondtype_name` varchar(100) DEFAULT NULL,
  `firsttype_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`secondtype_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of secondtype
-- ----------------------------
INSERT INTO `secondtype` VALUES ('1', '男装女装', '1');

-- ----------------------------
-- Table structure for `thirdtype`
-- ----------------------------
DROP TABLE IF EXISTS `thirdtype`;
CREATE TABLE `thirdtype` (
  `thirdtype_id` int(11) NOT NULL AUTO_INCREMENT,
  `thirdtype_name` varchar(100) DEFAULT NULL,
  `secondtype_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`thirdtype_id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of thirdtype
-- ----------------------------
INSERT INTO `thirdtype` VALUES ('1', '羽绒服', '1');
INSERT INTO `thirdtype` VALUES ('2', '毛呢大衣', '1');
INSERT INTO `thirdtype` VALUES ('3', '毛衣', '1');
INSERT INTO `thirdtype` VALUES ('4', '连衣裙', '1');
INSERT INTO `thirdtype` VALUES ('5', '卫衣', '1');
INSERT INTO `thirdtype` VALUES ('6', '皮衣', '1');
INSERT INTO `thirdtype` VALUES ('7', '衬衫', '1');
INSERT INTO `thirdtype` VALUES ('8', '夹克', '1');
INSERT INTO `thirdtype` VALUES ('9', '西装', '1');
INSERT INTO `thirdtype` VALUES ('10', 'T恤', '1');
INSERT INTO `thirdtype` VALUES ('11', '睡衣套装', '1');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_sex` varchar(100) DEFAULT NULL,
  `user_date` date DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `user_pwd` varchar(100) DEFAULT NULL,
  `user_tel` varchar(100) DEFAULT NULL,
  `user_email` varchar(100) DEFAULT NULL,
  `user_idcard` varchar(100) DEFAULT NULL,
  `user_account` double DEFAULT NULL,
  `user_level` varchar(100) DEFAULT NULL,
  `user_head` varchar(100) DEFAULT 'default_head.png',
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '男', '2018-12-28', '我是小红', 'aa', '17535434476', '1127437840@qq.com', '140926199611200015', '0', '普通会员', 'user_1_head.jpeg');
INSERT INTO `users` VALUES ('2', '男', '2018-12-28', 'aaaaaa', 'aaaaaa', '17535434475', '1127437849@qq.com', '140926199611200015', '0', '普通会员', 'user_2_head.jpeg');
DROP TRIGGER IF EXISTS `tg3`;
DELIMITER ;;
CREATE TRIGGER `tg3` BEFORE UPDATE ON `cartdetail` FOR EACH ROW begin
set new.goods_money=new.goods_count*(old.goods_money/old.goods_count);
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `tg2`;
DELIMITER ;;
CREATE TRIGGER `tg2` AFTER INSERT ON `orderdetail` FOR EACH ROW begin
insert into orderstatus values(new.orderdetail_id,0);
update goodsdetail set goods_count=goods_count-new.goods_count where goodsdetail_id=new.goodsdetail_id;
update goods set goods_sale=goods_sale+new.goods_count where goods_id=(select goods_id from goodsdetail where goodsdetail_id = new.goodsdetail_id);
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `tg4`;
DELIMITER ;;
CREATE TRIGGER `tg4` AFTER INSERT ON `orderdetail` FOR EACH ROW begin

end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `tg5`;
DELIMITER ;;
CREATE TRIGGER `tg5` AFTER INSERT ON `orderdetail` FOR EACH ROW begin

end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `tg1`;
DELIMITER ;;
CREATE TRIGGER `tg1` AFTER DELETE ON `orderdetail` FOR EACH ROW begin
update goodsdetail set goods_count=goods_count+old.goods_count where goodsdetail_id=old.goodsdetail_id;
end
;;
DELIMITER ;
