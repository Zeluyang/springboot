drop table if exists tb_user;

create table tb_user(
	id bigint auto_increment,
	name varchar(32),
	age int(3),
	primary key (id)
);