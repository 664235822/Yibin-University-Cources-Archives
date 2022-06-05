create unique index PK_Student_Student on Student(sname)
exec sp_rename @objname='Student.PK_Student_Student',@newname='PK_Student.S',@objtype='index'

drop index Student.PK_Student_Student

select * from dbo.Student
where sname like 'Àî%' and Ssex = 'ÄÐ'

select sno,count(sno) as cno
from dbo.sc
where grade >60
group by sno
having count(cno)>=3

select Student.sno,sname,ssex,sage,sdept,cno,grade 
from Student,sc
where Student.sno = sc.sno