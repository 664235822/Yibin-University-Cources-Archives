/*创建学生表*/
create table Student(
	Sno char(9) primary key,
	Sname char(20) Unique,
	Ssex char(2),
	Sage Smallint,
	Sdept char(20)
 )
 /*创建选课表*/
 create table Course(
	Cno char(4) primary key,
	Cname char(40) not null,
	Cpno Char(4),
	Ccredit Smallint,
	foreign key(Cpno) references Course(Cno)
 )
  /*创建选修表*/
  create table SC(
	Sno char(9),
	Cno char(4),
	Grade Smallint,
	primary key(Sno, Cno),
	foreign key(Sno) references Student(Sno),
	foreign key(Cno) references Course(Cno)
  )
 /*插入数据*/ 
 insert
 into Student
 values('20220401', '李一', '女', 20, 'CS'),
	   ('20220402', '李二', '男', 19, 'CS'),
	   ('20220403', '李三', '女', 18, 'IS'),
	   ('20220404', '李四', '女', 17, 'IS'),
	   ('20220405', '李五', '男', 20, 'MA'),
	   ('20220406', '李六', '女', 21, 'MA'),
	   ('20220407', '李七', '男', 19, 'CS')

insert 
into Course
values(1,'数据库',5,4),
	(2,'语文',4,2),
	(3,'操作系统',8,4),
	(4,'数学',NULL,3),
	(5,'数据结构',7,6),
	(6,'JAVA',NULL,4),
	(7,'C语言',4,4),
	(8,'计算机网络',6,6),
	(9,'计算机组成',2,6)

insert 
into SC
values('20220401',1,80),
	('20220401',2,85),
	('20220401',5,88),
	('20220401',6,59),
	('20220401',7,20),
	('20220402',2,30),
	('20220402',6,50),
	('20220402',4,51),
	('20220403',4,90),
	('20220405',1,90),
	('20220405',8,91),
	('20220405',9,70),
	('20220406',8,60),
	('20220406',9,40)

   