package com;

import java.util.Scanner;

public class Test3 {

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        System.out.println("请输入表达式：");
        String str = input.next();
        Expression expression = new Expression(str);
        expression.Handle();
    }
}
