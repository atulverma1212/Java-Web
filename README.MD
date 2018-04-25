Use Mysql Database on local server

Database Name - Test
Password - 1212

Create Two tables by following commands;

1. create table address(id int primary key auto_increment, city varchar(255), state varchar(255), pincode int);

2. create table employee(id int primary key auto_increment, name varchar(255), salary int, address_id int references address(id));

Run Maven-install on Eclipse Oxygen after importing the project.
