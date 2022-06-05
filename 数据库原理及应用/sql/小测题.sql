/*学号：        姓名：        */
/*1.将自己的信息插入到学生表*/
insert into Student values('210111316', '朱方灏钧', '男', 25, 'CS')


/*2.查询没有被学生选修的课程名称*/
select cname from Course
where not exists (select cno from SC where SC.cno = Course.cno)


/*3.查询没有选课的学生姓名*/
select sname from Student
where not exists(select sno from SC where SC.sno = Student.sno)


/*4.查询不选1号课程的学生姓名*/
select Student.sname from Student,SC
where not exists (select cno from SC where SC.cno = 1 and SC.sno = Student.sno)
group by sname

/*5.查询最少选了20220406学生所学课程的学生学号。*/
select sno from Student where 
exists(select cno from SC where sno = 20220406)

/*6.查询成绩不及格的学生姓名。*/
select Sname from Student,SC where Grade < 60 and Student.Sno = SC.Sno
group by Sname

/*7.查询最少有两课程不及格的学生学号。*/
select sno from SC
where (select Count(sno) from SC where grade<60) >=2
group by sno

/*8.求每个同学的平均成绩。*/
select sname,AVG(Grade) from Student,SC
where Student.sno= SC.sno
group by Student.sname

/*9.查询学分达到12分的学生姓名*/


/*10.查询选课最多的学生姓名。*/


/*11.根据课程将学生成绩排名。*/


/*12.将CS系全体学生的成绩增加20分,但超出100分以100分计*/
update SC set grade = case when Grade<80 then grade+20 else 100 end
from SC,Student
where Student.sdept = 'CS'

/*13.在学生表上创建一个视图，视图名和属性列自己决定*/
create view IS_Student
as select * from Student