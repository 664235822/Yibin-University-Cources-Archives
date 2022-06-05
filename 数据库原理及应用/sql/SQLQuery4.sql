exec sp_addLogin 's1'

create database s1DB

create table s1Table1(
id int primary key not null,
name varchar(10) not null
)

create table s1Table2(
id int primary key not null,
name varchar(10) not null
)

exec sp_addlogin 's2'
exec sp_addlogin 's3'
exec sp_addlogin 's4'
exec sp_addlogin 's5'
exec sp_addlogin 's6'

create user ss2 for login s2
create user ss3 for login s3
create user ss4 for login s4
create user ss5 for login s5
create user ss6 for login s6

grant select,update on s1Table1 to ss2,ss3 with grant option

grant select,update,insert,delete on s1Table2 to ss2 with grant option

grant select,update on s1Table1 to ss4 with grant option

grant select,update on s1Table1 to ss5

revoke select,update on s1Table1 from ss2 cascade

create role student

exec sp_addrolemember student,'ss2'
exec sp_addrolemember student,'ss5'
exec sp_addrolemember student,'ss6'

grant select,update on s1Table1 to student

create role student2

exec sp_addrolemember student,'ss4'

exec sp_addrolemember student,'student2'

revoke select,update,insert,delete on s1Table1 to ss5,ss6

revoke select,update,insert,delete on s1Table1 to student