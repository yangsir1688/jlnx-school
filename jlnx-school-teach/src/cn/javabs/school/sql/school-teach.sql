create database school_teach;
use school_teach;
create  table  user(
  id int primary  key auto_increment,
  name varchar (50) ,
  username varchar (50) not  null  unique  ,
  password varchar (50) not  null   ,
  sex varchar (10),
  email varchar (50),
  isable int default 0,
  type varchar (50) DEFAULT '管理员'  ,
  birthday varchar (50),
  createTime varchar (50)
);
--  插入语句
INSERT INTO `user` (`id`, `name`, `username`, `password`, `sex`, `email`, `birthday`, `createTime`) VALUES ('1001', 'admin', 'admin', 'admin', '男', 'admin@javasb.cn', '1999-09-09', '2019-06-16')