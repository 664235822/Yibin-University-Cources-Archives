package com;

import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int num = input.nextInt();
        System.out.println("请输入进制：（最多16进制）");
        int scale = input.nextInt();
        CalculateScaleStack customStack = new CalculateScaleStack(num, scale);
        customStack.Calculate();
        customStack.Show();
    }
}
