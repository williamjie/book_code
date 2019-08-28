

create database test;



t_member (username, nickname, password,        status, gender, phone,        create_time, update_time)



CREATE TABLE `t_member` (
  `id` int(13) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(33) DEFAULT NULL COMMENT '姓名',
  `nickname` varchar(33) DEFAULT NULL COMMENT '昵称',
  `password` varchar(33) DEFAULT NULL COMMENT '密码',
  `status` int(3) DEFAULT NULL COMMENT '状态',
  `gender` int(3) DEFAULT NULL COMMENT '性别',
  `phone` VARCHAR(33) DEFAULT NULL COMMENT '电话号码',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;





insert into t_member (username,nickname,password,status,gender,phone,create_time,update_time) value ("zj","zj_nick","1111",2,1,"13113636636",'20180109104400','20181009104400');

