package lld.data_structures.queue.impl;

public class MyQueue {
    private int[] a;
    private int size;
    private int front;
    private int capacity;

    public MyQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("invalid capacity");
        }
        this.capacity = capacity;
        this.a = new int[capacity];
        this.size = 0;
        this.front = 0;
    }

    void enqueue(int data) {
        if (size == capacity) {
            System.out.println("queue full");
            return;
        }
        int rear = (front + size) % capacity;
        a[rear] = data;
        size++;
    }

    int dequeue() {
        if (size == 0) {
            throw new IllegalStateException("queue empty");
        }
        int popped = a[front];
        front = (front + 1) % capacity;
        size--;
        return popped;
    }

    void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue:[");
        if (size == 0) {
            sb.append("]");
            System.out.println(sb);
            return;
        }
        for (int i = front; i <= ((front + size - 1) % capacity); i++) {
            sb.append(a[i]).append(", ");
        }
        System.out.println(sb.substring(0, sb.length() - 2) + "]");
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue(5);
        q.print();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60);
        q.print();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.print();
    }
}
