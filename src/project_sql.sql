create database project;
use project;

create table user(
user_id varchar(60) primary key,
username varchar(30) not null,
password char(8) not null);

create table vehicle(
user_id varchar(60),
vehicle_number varchar(11) primary key,
fuel_type char(6),
FOREIGN KEY (user_id) 
References user(user_id));

drop table vehicle;
create table vehicle(
user_id varchar(60),
vehicle_number varchar(11) primary key,
fuel_type char(6));

drop table transaction;


create table transaction(
vehicle_number varchar(11),
fuel_date date,
fuel_quantity int,
bunk_id int,
odometer_reading int,
km_gained int,
mile int);


create table bunk
(
bunk_id int,
bunk_name varchar(90) not null
);

insert into bunk(bunk_id,bunk_name)
values (1,'Indian Oil Corporation'),
(2,'Bharat Petroleum'),
(3,'shell Petroleum'),
(4,'Hindusthan Petroleum'),
(5,'Essar Petroleum'),
(6,'Reliance Petroleum'),
(7,'Oil India Petroleum');



desc transaction;
show tables;
select * from transaction;
desc user1;

