package com;

public class LinkedQueue {

    QueuePtr queuePtr;

    public LinkedQueue() {

    }

    public void enqueue(Object data) {
        if (queuePtr != null) {
            QueuePtr ptr = queuePtr;
            while (ptr.next != null) {
                ptr = ptr.next;
            }

            QueuePtr temp = new QueuePtr();
            temp.data = data;
            ptr.next = temp;
        } else {
            queuePtr = new QueuePtr();
            queuePtr.data = data;
        }
    }

    public Object dequeue() {
        QueuePtr ptr = queuePtr;
        if (queuePtr.next != null) {
            queuePtr = queuePtr.next;
        } else {
            queuePtr = null;
        }
        return ptr.data;
    }

    public boolean isEmpty() {
        return queuePtr == null;
    }

    public void ShowAll() {
        QueuePtr ptr = queuePtr;
        while (ptr != null) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }
}
