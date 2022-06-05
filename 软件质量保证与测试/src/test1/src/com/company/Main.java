package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        String id = input.next();
        String name = input.next();
        String password = input.next();
        String rePassword = input.next();
        String birthYear = input.next();
        try {
            int idInt = Integer.parseInt(id);
            if (idInt < 6 || idInt > 10) {
                throw new Exception();
            }

            if (name.contains("1234567890")) {
                throw new Exception();
            }

            if (!password.equals(rePassword)) {
                throw new Exception();
            }

            if (Integer.parseInt(birthYear) < 1900 || Integer.parseInt(birthYear) > 2010) {
                throw new Exception();
            }

            System.out.println("成功");
        } catch (Exception e) {
            System.out.println("失败");
        }
    }
}
