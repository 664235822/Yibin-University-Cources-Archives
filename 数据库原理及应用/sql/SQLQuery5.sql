create table Student(
	Sno varchar(10) primary key,
	Sname varchar(10) not null,
	Sage datetime,
	Ssex varchar(10)
	);
insert into Student values(01 , '赵雷' , 1990-01-01 , '男');
insert into Student values(02 , '钱电' , 1990-12-21 , '男');
insert into Student values(03 , '孙风' , 1990-12-20 , '男');
insert into Student values(04 , '李云' , 1990-12-06 , '男');
insert into Student values(05 , '周梅' , 1991-12-01 , '女');
insert into Student values(06 , '吴兰' , 1992-01-01 , '女');
insert into Student values(07 , '郑竹' , 1989-01-01 , '女');
insert into Student values(09 , '张三' , 2017-12-20 , '女');
insert into Student values(10 , '李四' , 2017-12-25 , '女');
insert into Student values(11 , '李四' , 2012-06-06 , '女');
insert into Student values(12 , '赵六' , 2013-06-13 , '女');
insert into Student values(13 , '孙七' , 2014-06-01 , '女');

create table Teacher(
	Tno varchar(10) primary key,
	Tname varchar(10) not null
	);
insert into Teacher values('01' , '张三');
insert into Teacher values('02' , '李四');
insert into Teacher values('03' , '王五');

create table Course(
	Cno varchar(10) primary key,
	Cname nvarchar(10) not null,
	Tno varchar(10),
	foreign key(Tno) references Teacher(Tno)
	);
insert into Course values('01' , '语文' , '02');
insert into Course values('02' , '数学' , '01');
insert into Course values('03' , '英语' , '03');

create table SC(
	Sno varchar(10),
	Cno varchar(10),
	score decimal(18,1)
	primary key(Sno, Cno),
	foreign key(Sno) references Student(Sno),
	foreign key(Cno) references Course(Cno)
	);
insert into SC values('01' , '01' , 80);
insert into SC values('01' , '02' , 90);
insert into SC values('01' , '03' , 99);
insert into SC values('02' , '01' , 70);
insert into SC values('02' , '02' , 60);
insert into SC values('02' , '03' , 80);
insert into SC values('03' , '01' , 80);
insert into SC values('03' , '02' , 80);
insert into SC values('03' , '03' , 80);
insert into SC values('04' , '01' , 50);
insert into SC values('04' , '02' , 30);
insert into SC values('04' , '03' , 20);
insert into SC values('05' , '01' , 76);
insert into SC values('05' , '02' , 87);
insert into SC values('06' , '01' , 31);
insert into SC values('06' , '03' , 34);
insert into SC values('07' , '02' , 89);
insert into SC values('07' , '03' , 98);

create trigger trigger_insertStudent
on Student
for insert
as 
	declare @sno varchar(10),@cno varchar(10)
	select @sno = sno from inserted
	select top 1 @cno=cno from Course order by rand()
	insert into SC values(@sno,@cno,60)
	
create trigger trigger_updateGrade
on SC
for insert,update
as 
	declare @sno varchar(10), @score decimal(18,1)
	select @sno = sno,@score = score from inserted
	declare @sname varchar(10)
	select @sname = sname from Student where sno = @sno
	if(@score < 60)
		begin
			print '添加学号为'+ @sno+'，姓名为'+@sname+'的同学到重修表'
		end

create trigger trigger_deleteStudent
on Student
for delete
as
	declare @sno varchar(10)
	select @sno = sno from deleted
	delete from SC where sno = @sno