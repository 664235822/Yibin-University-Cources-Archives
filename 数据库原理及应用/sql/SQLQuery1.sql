create database Student;
use Student;

create table Student
(sno char(9)primary key,
sname char(20) unique not null,
ssex char(2),
sage smallint,
sdept char(20),
constraint ck_sex_ check (ssex ='ÄĞ' or ssex = 'Å®'),
constraint ck_age check (sage <100));

create table Course
(Cno char(4) primary key,
cname char(40) not null,
cpno char(4),
ccredit smallint,
);

create table sc(
sno char(9),
cno char(4),
grade smallint,
primary key (sno,cno),
foreign key (sno) references Student(sno),
foreign key (cno) references Course (cno)
);

