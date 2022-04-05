package com;

import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        System.out.println("请输入值：");
        String str = input.next();
        BracketMatch bracketMatch = new BracketMatch(str);
        bracketMatch.Matching();
    }
}
