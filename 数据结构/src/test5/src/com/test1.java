package com;

public class test1 {

    public static void main(String[] args) {
        // write your code here
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("a");
        linkedQueue.enqueue("b");
        linkedQueue.enqueue("c");
        System.out.println(linkedQueue.dequeue());
        linkedQueue.enqueue("d");
        linkedQueue.enqueue("e");
        linkedQueue.enqueue("f");
        while (!linkedQueue.isEmpty()) {
            System.out.println(linkedQueue.dequeue());
        }
    }
}
