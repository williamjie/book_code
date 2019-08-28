

CREATE database erp2;

CREATE TABLE `user` (
  `id` int(13) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(33) DEFAULT NULL COMMENT '姓名',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `money` double DEFAULT NULL COMMENT '账户余额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

insert into user (id,name,age,money) value (2,"zdr",1,999999);
insert into user (id,name,age,money) value (1,"zj",30,111111111);



CREATE TABLE `money` (
  `id` int(13) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `basic` int(3) DEFAULT  NULL COMMENT '基础',
  `reward` int(3) DEFAULT NULL COMMENT '奖励',
  `punishment` int(3) DEFAULT NULL COMMENT '惩罚',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

insert into money (id,basic,reward,punishment) value (1,2,1,999999);
insert into money (id,basic,reward,punishment) value (2,3,9,9111);
insert into money (id,basic,reward,punishment) value (3,9,1,999999);
