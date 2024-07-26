create table members(
	user_id varchar(50) not null,
    pw varchar(68) not null,
    active tinyint not null,
    primary key (user_id)
)engine=InnoDB default charset=latin1;

insert into members values ('john','{noop}test123',1),
('mary','{noop}test123',1),
('susan','{noop}test123',1);

select * from members;
select * from roles; 
create table roles(
	user_id varchar(50) not null,
    role varchar(50) not null,
    unique key authorities_idx_1 (user_id,role),
    constraint authorities_ibfk_1 foreign key (user_id) references members(user_id)
)engine=InnoDB default charset=latin1;

insert into roles values
('john','ROLE_EMPLOYEE'),
('mary','ROLE_EMPLOYEE'),
('mary','ROLE_MANAGER'),
('susan','ROLE_EMPLOYEE'),
('susan','ROLE_MANAGER'),
('susan','ROLE_ADMIN');

