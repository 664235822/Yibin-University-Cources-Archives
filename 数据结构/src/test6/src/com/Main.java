package com;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        System.out.println("请输入原始的字符串：");
        String str = input.next();
        System.out.println("请输入要查询的字符串：");
        String search = input.next();
        System.out.println("请输入要替换的字符串：");
        String replace = input.next();
        CustomString customString = new CustomString(str);
        int index = customString.search(search);
        System.out.println("要查询的字符串位于第" + index + "位");
        String replaceResult = customString.replace(search, replace);
        System.out.println("替换后的字符串为：" + replaceResult);
    }
}
