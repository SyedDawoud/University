create schema Reservations;

use Reservations;




create table Users(
username varchar(20) not null,
password varchar(40) not null,
userType varchar(20) not null,
primary key(username,password)

);

create table Reservation(
name varchar(20) not null,
time varchar(20) not null,
people int not null,
reservedTable varchar(2) not null,
orderDetails varchar(40) not null,

foreign key userCheck (name) references Users(username),
primary key (name,time,people,orderDetails)
);


create table logs(
name varchar(20) not null,
event varchar(50) not null,
time varchar(50) not null,
primary key (name,event,time),
foreign key (name) references Users(username)

);

drop table reservation;

insert into Users(username,password,userType)values("Ali","123","Customer"),
("Z","12","Customer"), ("A","12","Staff");



select * from Users where username="A" and password="12" and userType="Staff";


