package com;

public class LoopQueue {

    QueuePtr queuePtr;

    QueuePtr rear;

    public LoopQueue() {

    }

    public void enqueue(Object data) {
        if (queuePtr != null) {
            QueuePtr ptr = queuePtr;
            while (ptr.next != null && ptr != rear) {
                ptr = ptr.next;
            }

            QueuePtr temp = new QueuePtr();
            temp.data = data;
            ptr.next = temp;

            rear = temp;
            temp.next = queuePtr;
        } else {
            queuePtr = new QueuePtr();
            queuePtr.data = data;
            rear = queuePtr;
        }
    }

    public Object dequeue() {
        QueuePtr ptr = queuePtr;
        if (queuePtr.next != null && queuePtr != rear) {
            queuePtr = queuePtr.next;
        } else {
            queuePtr = null;
            rear = null;
        }
        return ptr.data;
    }

    public boolean isEmpty() {
        return queuePtr == null;
    }
}
