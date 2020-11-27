use payroll_service

create table employees (
employee_id int unsigned not null,
name varchar(150) not null,
salary double not null,
primary key(employee_id)
);