show databases;
create database employee_directory;
use employee_directory;

select * from employee;
select * from roles;
select * from members;
-- insert into employee_directory.employee values
-- (1,'Tushar','more','tushar@gmail.com'),
-- (2,'prakash','morre','prakash@gmail.com'),
-- (3,'thunder','strom','thunder@gmail.com'),
-- (4,'rahul','moree','rahul@gmail.com'),
-- (5,'payal','moore','payal@gmail.com');

-- drop table users;
-- drop table authorities;
create table users(
	username varchar(50) not null,
    `password` varchar(68) not null,
    enabled tinyint not null,
    primary key (username)
)engine=InnoDB default charset=latin1;

-- insert into users values ('john','{noop}test123',1),
-- ('mary','{noop}test123',1),
-- ('susan','{noop}test123',1);

select * from users;
select * from authorities; 
create table authorities(
	username varchar(50) not null,
    authority varchar(50) not null,
    unique key authorities_idx_1 (username,authority),
    constraint authorities_ibfk_1 foreign key (username) references users(username)
)engine=InnoDB default charset=latin1;

-- insert into authorities values
-- ('john','ROLE_EMPLOYEE'),
-- ('mary','ROLE_EMPLOYEE'),
-- ('mary','ROLE_MANAGER'),
-- ('susan','ROLE_EMPLOYEE'),
-- ('susan','ROLE_MANAGER'),
-- ('susan','ROLE_ADMIN');

