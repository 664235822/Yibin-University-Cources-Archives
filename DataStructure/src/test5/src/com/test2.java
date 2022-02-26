package com;

public class test2 {

    public static void main(String[] args) {
        // write your code here
        LoopQueue loopQueue = new LoopQueue();
        loopQueue.enqueue("a");
        loopQueue.enqueue("b");
        loopQueue.enqueue("c");
        System.out.println(loopQueue.dequeue());
        loopQueue.enqueue("d");
        loopQueue.enqueue("e");
        loopQueue.enqueue("f");
        while (!loopQueue.isEmpty()) {
            System.out.println(loopQueue.dequeue());
        }
    }
}
