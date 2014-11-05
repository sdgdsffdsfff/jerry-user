CREATE TABLE `user` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`cts` DATETIME NOT NULL DEFAULT now() COMMENT '创建时间',
	`uts` DATETIME NOT NULL DEFAULT now() COMMENT '修改时间',
	`account` VARCHAR(32) NOT NULL COMMENT '账号，默认手机号',
	`name` VARCHAR(32) COMMENT '昵称',
	`desc` VARCHAR(256)	COMMENT '简介',
	`avatar` VARCHAR(256) COMMENT '头像',
	`avatarid` bigint(20) default 0 COMMENT '头像编号',
	`daren` BOOLEAN COMMENT '达人',
	PRIMARY KEY (`id`),
	UNIQUE KEY `idx_account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8 COMMENT='用户基本信息';

CREATE TABLE `principal` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `cts` DATETIME NOT NULL DEFAULT now() COMMENT '创建时间',
  `uts` DATETIME NOT NULL DEFAULT now() COMMENT '修改时间',
  `uid` INT(11) NOT NULL COMMENT '用户id',
  `alias` VARCHAR(32) NOT NULL COMMENT '登录账户',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_alias` (`alias`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '账户表格';


CREATE TABLE `credential` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `cts` DATETIME NOT NULL DEFAULT now() COMMENT '创建时间',
  `uts` DATETIME NOT NULL DEFAULT now() COMMENT '修改时间',
  `uid` INT(11) NOT NULL COMMENT '用户id',
  `salt` VARCHAR(10) NOT NULL COMMENT '盐巴',
  `pass` VARCHAR(128) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '账户凭证表格';


CREATE TABLE `status` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `cts` DATETIME NOT NULL DEFAULT now() COMMENT '创建时间',
  `uts` DATETIME NOT NULL DEFAULT now() COMMENT '修改时间',
  `uid` INT(11) NOT NULL COMMENT '用户id',
  `mama_status` INT(1) DEFAULT 0 COMMENT '妈妈状态',
  `mama_birth` DATETIME COMMENT '预产期',
  `baby_gender` INT(1) DEFAULT 0 COMMENT '宝贝性别',
  `baby_birth` DATETIME COMMENT '宝贝生日',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '妈妈状态';

CREATE TABLE `address` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `cts` DATETIME NOT NULL DEFAULT now() COMMENT '创建时间',
  `uts` DATETIME NOT NULL DEFAULT now() COMMENT '修改时间',
  `uid` BIGINT(20) NOT NULL COMMENT '用户id',
  `receiver` VARCHAR(32) NOT NULL COMMENT '收货人',
  `mobile` VARCHAR(32) NOT NULL COMMENT '手机号码',
  `province` int(11) unsigned NOT NULL COMMENT '省份',
  `city` int(11) unsigned NOT NULL COMMENT '城市',
  `county` int(11) unsigned NOT NULL COMMENT '区',
  `town` int(11)  unsigned NOT NULL COMMENT '街道',
  `detail` VARCHAR(64) NOT NULL COMMENT '详细地址',
  `postcode` VARCHAR(16) NOT NULL COMMENT '邮编',
  `isdefault` int(1) NOT NULL DEFAULT 0 COMMENT '默认地址',
  PRIMARY KEY (`id`),
  KEY `idx_uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '收货地址';


CREATE TABLE `captcha` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `cts` DATETIME NOT NULL DEFAULT now() COMMENT '创建时间',
  `uts` DATETIME NOT NULL DEFAULT now() COMMENT '修改时间',
  `phone` VARCHAR(16) NOT NULL COMMENT '用户账号',
  `captcha` VARCHAR(8) NOT NULL COMMENT '验证码',
  `expire` DATETIME NOT NULL DEFAULT now() COMMENT '过期时间',
  `service` VARCHAR(20) NOT NULL COMMENT '服务',
  `status` tinyint(4) NOT NULL COMMENT '状态',
  PRIMARY KEY (`id`),
  KEY `idx_phone_service_status` (`phone`, `service`, `status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '验证码';

CREATE TABLE `freshtoken` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `cts` DATETIME NOT NULL DEFAULT now() COMMENT '创建时间',
  `uts` DATETIME NOT NULL DEFAULT now() COMMENT '修改时间',
  `phone` VARCHAR(16) NOT NULL COMMENT '用户账号',
  `freshtoken` VARCHAR(64) NOT NULL COMMENT '刷新TOKEN',
  `expire` DATETIME NOT NULL DEFAULT now() COMMENT '过期时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_freshtoken` (`freshtoken`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '注册密码';

CREATE TABLE `token` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `cts` DATETIME NOT NULL DEFAULT now() COMMENT '创建时间',
  `uts` DATETIME NOT NULL DEFAULT now() COMMENT '修改时间',
  `uid` INT(11) NOT NULL COMMENT '用户id',
  `token` VARCHAR(64) NOT NULL COMMENT 'TOKEN',
  `device` VARCHAR(128) COMMENT '设备',
  `os` VARCHAR(128) COMMENT '操作系统',
  `lastlogin` DATETIME NOT NULL DEFAULT now() COMMENT '上次登录时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_token` (`token`),
  KEY `idx_uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户TOKEN';

CREATE TABLE `baby` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `uid` INT(11) NOT NULL COMMENT '用户编号',
  `status` INT(11) NOT NULL COMMENT '0-备孕，1-怀孕中，2-已出生',
  `edc` datetime COMMENT '预产期',
  `gender` tinyint(1) NOT NULL COMMENT '性别,0-未知，1-男，2-女',
  `birthday` datetime COMMENT '生日',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uidx_uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '宝宝状态';

CREATE TABLE `change_pwd_token` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `uid` INT(11) NOT NULL COMMENT '用户编号',
  `mobile` VARCHAR(32) NOT NULL COMMENT '手机号',
  `token` VARCHAR(64) NOT NULL COMMENT 'TOKEN',
  `cts` DATETIME NOT NULL DEFAULT now() COMMENT '创建时间',
  `uts` DATETIME NOT NULL DEFAULT now() COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uidx_token` (`token`),
  KEY `idx_mobile` (`mobile`),
  KEY `idx_uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '修改密码token';

CREATE TABLE `find_pwd_record` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `uid` INT(11) NOT NULL COMMENT '用户编号',
  `mobile` VARCHAR(32) NOT NULL COMMENT '手机号',
  `cts` DATETIME NOT NULL DEFAULT now() COMMENT '创建时间',
  `uts` DATETIME NOT NULL DEFAULT now() COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uidx_token` (`token`),
  KEY `idx_uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '修改密码token';

CREATE TABLE `reserved_word` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `word` varchar(32) NOT NULL COMMENT '关键字',
  `type` smallint(3) not null comment '类型',
  PRIMARY KEY (`id`),
  key `idx_word` (`word`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保留关键字';

CREATE TABLE `qrcode` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `uid` INT(11) UNSIGNED NOT NULL DEFAULT '0' COMMENT '绑定用户id',
  `uuid` VARCHAR(64) NOT NULL COMMENT '随机数',
  `status` smallint(3) UNSIGNED NOT NULL COMMENT '状态：0初始化，2已扫描，4已登录',
  `addtime` INT(11) UNSIGNED NOT NULL COMMENT '生成时间',
  PRIMARY KEY (`id`),
  KEY `uuid` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='qrcode与用户绑定表';

CREATE TABLE `client` (
    `id` int(11) not null auto_increment,
	`clientid` varchar(64) not null comment 'clientid',
	`deviceid` varchar(64) not null comment '设备编号',
	`os` varchar(50) not null comment '操作系统',
    `appversion` varchar(50) not null comment 'app版本号',
    `channel` varchar(50) not null comment '渠道',
    `dm` varchar(50) not null comment '手机',
	`cts` datetime not null comment '创建时间',
	primary key (`id`),
	unique key `uidx_clientid` (`clientid`),
	key `idx_deviceid` (`deviceid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='client信息';


create table `order_rc_record` (
	`id` int(11) not null auto_increment,
	`uid` int(11) not null comment '用户编号',
	`mobile` varchar(50) not null comment '账号',
	`deviceid` varchar(50) not null comment '设备编号',
	`clientid` varchar(50) not null comment 'clientid',
	`ip` bigint(20) not null comment 'ip',
	`receiver` VARCHAR(32) NOT NULL COMMENT '收货人',
    `receivermobile` VARCHAR(32) NOT NULL COMMENT '手机号码',
    `province` int(11) unsigned NOT NULL COMMENT '省份',
    `city` int(11) unsigned NOT NULL COMMENT '城市',
    `county` int(11) unsigned NOT NULL COMMENT '区',
    `town` int(11)  unsigned NOT NULL COMMENT '街道',
    `detail` VARCHAR(64) NOT NULL COMMENT '详细地址',
    `postcode` VARCHAR(16) NOT NULL COMMENT '邮编',
    `itemid` int(11) not null comment '商品编号',
    `skuid` int(11) not null comment 'sku编号',
    `quantity` int(11) not null comment '数量',
    primary key (`id`),
    key `idx_uid` (`uid`),
    key `idx_mobile` (`mobile`),
    key `idx_deviceid` (`deviceid`),
    key `idx_clientid` (`clientid`),
    key `idx_ip` (`ip`),
    key `idx_receivermobile` (`receivermobile`),
    key `idx_itemid_skuid_receivermobile` (`itemid`, `skuid`, `receivermobile`),
    key `idx_itemid_skuid_clientid` (`itemid`, `skuid`, `clientid`),
    key `idx_itemid_skuid_deviceid` (`itemid`, `skuid`, `deviceid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='下单风控记录';