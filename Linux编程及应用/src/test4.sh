#!/bin/bash
echo 欢迎来到学生信息管理系统
echo 1.查询所有学生
echo 2.查询单个学生
echo 3.添加学生信息
echo 4.删除学生信息
echo 5.修改学生信息
echo 其他：退出学生信息管理系统
echo 清输入：
read choose
case $choose in 
"1" )
	cat student.txt
	;;
"2" )
	echo 请输入学号：
	read stuNum
	echo 学号	姓名	数学	语文	英语	总分
	grep ^$stuNum student.txt
	;;
"3")
	echo 请输入学号：
	read stuNum
	echo 请输入姓名：
	read name
	echo 请输入数学:
	read math
	echo 请输入语文：
	read chinese
	echo 请输入英语：
	read english
	total=$(($math+$chinese+$english))
	echo "$stuNum	$name	$math	$chinese	$english	$total" >> student.txt
	;;
"4" )
	echo 请输入学号：
	read stuNum
	sed -i -r "/^($stuNum)/d" student.txt
	;;
"5" )
	echo 请输入学号：
        read stuNum
        echo 请输入姓名：
        read name
        echo 请输入数学:
        read math
        echo 请输入语文：
        read chinese
        echo 请输入英语：
        read english
        total=$(($math+$chinese+$english))
	sed -i -r "/^($stuNum)/c$stuNum   $name   $math   $chinese        $english        $total" student.txt
	;;
esac
