-- 建数据库
CREATE DATABASE IF NOT EXISTS `message_system` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
-- 使用数据库message_system
USE `message_system`;

-- 删除表
DROP TABLE IF EXISTS `producer`;
DROP TABLE IF EXISTS `consumer`;
DROP TABLE IF EXISTS `destination`;
DROP TABLE IF EXISTS `producer_destination`;
DROP TABLE IF EXISTS `consumer_destination`;


-- 建表语句
CREATE TABLE IF NOT EXISTS `producer` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` VARCHAR(64) NOT NULL COMMENT '生产者名',
  `status` INT NOT NULL DEFAULT 1 COMMENT '状态值',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `producer_key` (`name`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '生产者信息表';

CREATE TABLE IF NOT EXISTS `consumer` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` VARCHAR(64) NOT NULL COMMENT '消费者名',
  `status` INT NOT NULL DEFAULT 1 COMMENT '状态值',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `consumer_key` (`name`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '消费者信息表';

CREATE TABLE IF NOT EXISTS `destination` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` VARCHAR(64) NOT NULL COMMENT 'destination名',
  `type` INT NOT NULL DEFAULT 0 COMMENT '类型 0：topic 1：queue',
  `status` INT NOT NULL DEFAULT 1 COMMENT '状态值',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `destination_key` (`name`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT 'MQ destination信息表';

CREATE TABLE IF NOT EXISTS `producer_destination` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `producer_id` BIGINT NOT NULL COMMENT '生产者id',
  `destination_id` BIGINT NOT NULL COMMENT 'destination_id',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `producer_id_key` (`producer_id`),
  KEY `destination_id_key` (`destination_id`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '生产者destination关系信息表';

CREATE TABLE IF NOT EXISTS `consumer_destination` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `consumer_id` BIGINT NOT NULL COMMENT '消费者id',
  `destination_id` BIGINT NOT NULL COMMENT 'destination_id',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `consumer_id_key` (`consumer_id`),
  KEY `destination_id_key` (`destination_id`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '消费者destination关系信息表';

-- 初始化数据
-- 生产者名称规则：系统名_生产者名_producer_编号
-- 插入默认生产者
INSERT INTO `producer`(`name`) VALUES ('default_default_producer_001');
-- 消费者名称规则：系统名_消费者名_consumer_编号
-- 插入默认消费者
INSERT INTO `consumer`(`name`) VALUES ('default_default_consumer_001');
-- destination名称规则：系统名_destination名_destination_编号
-- 插入默认destination
INSERT INTO `destination`(`name`) VALUES ('default_default_destination_001');
-- 默认生产者destination关系
INSERT INTO `producer_destination`(`producer_id`, `destination_id`) VALUES ('1', '1');
-- 默认消费者destination关系
INSERT INTO `consumer_destination`(`consumer_id`, `destination_id`) VALUES ('1', '1');