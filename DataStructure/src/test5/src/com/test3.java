package com;

public class test3 {

    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        LinkedQueue dequeueQueue = new LinkedQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        boolean bSingle = true;
        while (!queue.isEmpty()) {
            if (bSingle) {
                dequeueQueue.enqueue(queue.dequeue());
                bSingle = false;
            } else {
                queue.enqueue(queue.dequeue());
                bSingle = true;
            }
        }

        while (!dequeueQueue.isEmpty()) {
            System.out.println(dequeueQueue.dequeue());
        }
    }
}
