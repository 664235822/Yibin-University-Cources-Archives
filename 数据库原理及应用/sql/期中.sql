/*学号：210111316  姓名：朱方灏钧 */
/*蔬菜种类表（Vegetables)
	Vno(蔬菜编号)：定长字符型，8位长，主码
	Vname(蔬菜名）：可变长字符型，20位长，非空，唯一
	Vseason(蔬菜季节): 定长字符型，4个字符，允许空
	Vprice(蔬菜卖价): 定点小数（小数点后保留2位，小数点前6位），不允许为空
	Vpurchaseprice(蔬菜进价）：定点小数（小数点后保留2位，小数点前6位），不允许为空
商家表(Business)
	Bno(商家编号）：定长字符型，8位长，主码
	Bname(商家名）：可变长字符型，20位长，非空
	Baddress（商家地址）：可变长字符型，40位长，允许空
	Bphone（商家电话）：定长字符型，11个字符，允许空
商家蔬菜表(BVB)
	Bno(商家编号）：定长字符型，8位长，主码，参照Business的Bno
	Vno(蔬菜编号)：定长字符型，8位长，主码，参照Fruit的Fno
	Vquantity(蔬菜进货数量)：整型，默认值为200并要大于等于100*/
	create database middleTest
	use middleTest
/*（1）用SQL创建上述三个表：蔬菜表，商家表和商家蔬菜表。*/
	create table Vegetables(
	Vno char(8) primary key,
	Vname varchar(20) not null unique,
	Vseason char(4),
	Vprice decimal(6,2) not null,
	Vpurchaseprice decimal(6,2) not null
	)

	create table Business(
	Bno char(8) primary key,
	Bname varchar(20) not null,
	Baddress varchar(40),
	Bphone char(11))

	create table BVB(
	Bno char(8),
	Vno char(8),
	Vquantity int default(200) check (Vquantity >=100),
	foreign key (Bno) references Business(Bno),
	foreign key (Vno) references Vegetables(Vno))
	
/*（2）在Vegetables表里插入一种新的蔬菜，并在BVB表里新增一条数据。*/
insert into Vegetables
values('v8', '藤藤菜', '夏季', 3, 1)

insert into BVB
values('b1','v8',200)
/*（3）查询b2商家购买的蔬菜信息（蔬菜编号、蔬菜名、蔬菜季节、蔬菜卖价、蔬菜进价、蔬菜进货数量）*/
select BVB.Vno,Vname,Vseason,Vprice,Vpurchaseprice,Vquantity from Vegetables,BVB where Bno = 'B2'
/*（4）查询BVB上出进货数量最多的蔬菜信息（蔬菜编号、蔬菜名、蔬菜季节、蔬菜卖价、蔬菜进价、蔬菜总进货数量）*/
select BVB.Vno,Vname,Vseason,Vprice,Vpurchaseprice,Vquantity from Vegetables,BVB where Vquantity =( select Max(Vquantity) from BVB) 
/*（5）查询至少购买b3商家全部购买的商家信息(商家编号、商家名、商家地址、商家电话）*/
select Business.Bno,Bname,Baddress,Bphone from Business,BVB where exists (select Bno from BVB where Bno = 'B3') group by Business.Bno,Bname,Baddress,Bphone
/*（6）查询卖价不大于v2蔬菜的蔬菜信息以及售卖这个蔬菜的商家信息(蔬菜名、蔬菜卖价、商家编号、商家名、商家地址、商家电话）*/
select Vname,Vprice,Bno,Bname,Baddress,Bphone from Vegetables,Business where Vprice <= (select Vprice from Vegetables where Vno = 'v2')
/*（7）查询没有商家进货的蔬菜信息果信息（蔬菜编号、蔬菜名、蔬菜季节、蔬菜卖价、蔬菜进价）*/
select BVB.Vno,Vname,Vseason,Vprice,Vpurchaseprice from Vegetables,BVB where not exists(select Bno from BVB,Vegetables where BVB.Vno = Vegetables.Vno)
/*（8）创建一个视图VBV，里面包含属性Bno、Bname、Vno、Vname、Vquantity、Vprice。*/
create view VBV as (select BVB.Bno,Bname,BVB.Vno,Vname,Vquantity,Vprice from Vegetables,Business,BVB where BVB.Bno = Business.Bno and BVB.Vno = Vegetables.Vno )

/*（9）创建用户U1、U2，把Business的查看权限给U1，U1再把Business中Bname、Baddress的查看权限给U2 */
exec sp_addLogin 'user1'
exec sp_addLogin 'user2'
create user U1 for login user1
create user U2 for login user2

grant select on Business to U1 with grant option
grant select(Bname,Baddress) on Business to U2
/*（10）创建一个触发器，删除Vegetables中蔬菜的时候，同时删除BVB上的商家购买蔬菜的信息。*/
create trigger tr_deleteVegetables
on Vegetables
for delete
as
	declare @Vno char(8)
	select @Vno = Vno from deleted
	delete from BVB where Vno = @vno