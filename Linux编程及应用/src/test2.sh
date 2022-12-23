#!/bin/bash
echo 请输入一个数：
read num
sum=1
for((i=1;i<=num;i++))
do
	sum=$[$sum*$i]
done
echo 这个数的阶乘是$sum
