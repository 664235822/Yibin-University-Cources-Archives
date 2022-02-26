package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(System.in);
            int num1 = scanner.nextInt();
            int num2=scanner.nextInt();
            TestList list=new TestList(new Object[]{1,2,2,3,4});

            list.Add(num1,num2);
            list.PrintAll();


            //TestList list2=new TestList(new Object[]{1,2,2,3,4});

            //list2.Add(num1,num2);
            //list2.PrintAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
