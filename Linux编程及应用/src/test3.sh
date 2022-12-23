#!/bin/bash
array=()
echo 请输入数组长度
read length
for((i=0;i<length;i++))
do
	echo 请输入第$i个数
	read num
	array[$i]=$num
done
for((i=0;i<length;i++))
do
	for((j=i;j<length-1;j++))
	do
		if [ ${array[$j]} -gt ${array[$j+1]} ];then
			temp=${array[$j]}
			array[$j]=${array[$j+1]}
			array[$j+1]=$temp
		fi
	done
done
for((i=0;i<length;i++))
do
	echo 第$i个数字的值为：${array[$i]}
done
