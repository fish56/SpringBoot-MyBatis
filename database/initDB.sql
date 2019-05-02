create database springboot_mybatis;
use springboot_mybatis;

drop table if exists user;
create table user(
  id int unsigned auto_increment,
  name varchar(20) not null ,
  password varchar(30),
  primary key (id)
);

insert into user(name, password) VALUES ('admin', '123456');
insert into user(name, password) VALUES ('Jon', '123456');