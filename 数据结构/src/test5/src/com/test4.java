package com;

import java.util.Scanner;

public class test4 {

    static LinkedQueue queue = new LinkedQueue();

    public static void main(String[] args) {
        System.out.println("模拟医生看病流程");
        System.out.println("1.排队");
        System.out.println("2.就诊");
        System.out.println("3.查看排队");
        System.out.println("4.不再排队，余下依次就诊");
        System.out.println("5.医生下班");
        while (true) {
            run();
        }
    }

    static void run() {
        System.out.println("请输入：");
        Scanner input = new Scanner(System.in);
        int choose = input.nextInt();
        switch (choose) {
            case 1:
                System.out.println("请输入就诊号：");
                int num = input.nextInt();
                queue.enqueue(num);
                break;
            case 2:
                System.out.println("病人就诊号：");
                System.out.println(queue.dequeue());
                break;
            case 3:
                System.out.println("排队的人有：");
                queue.ShowAll();
                break;
            case 4:
                System.out.println("余下的人依次就诊：");
                while (!queue.isEmpty()) {
                    System.out.println(queue.dequeue());
                }
                System.exit(0);
                break;
            case 5:
                System.out.println("医生下班");
                System.exit(0);
                break;
        }
    }
}
