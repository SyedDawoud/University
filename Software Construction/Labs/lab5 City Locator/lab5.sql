create schema CityLocator;

use CityLocator;

create table CityRecord (
 location_id int not null primary key,
 country varchar(20) not null,
region varchar(20),
city varchar(30),
postalcode varchar(30),
areacode varchar(30),
metrocode varchar(30),
longitude float not null,
latitude float not null


);