package lld.data_structures.queue.impl;

public class CircularQueue {
    int[] q;
    int capacity;
    int size;
    int front;

    public CircularQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("invalid capacity");
        }
        this.capacity = capacity;
        this.q = new int[capacity];
        this.size = 0;
        this.front = 0;
    }

    public void enqueue(int data) {
        if (size == capacity) {
            System.out.println("Queue_Array is full");
            return;
        }
        int rear = front + size % capacity;
        q[rear] = data;
        size++;
    }

    public int dequeue() {
        if (size == 0) {
            System.out.println("Empty Queue_Array");
            return -1;
        }
        int res = q[front];
        front = (front + 1) % capacity;
        size--;
        return res;
    }

    public int getRear() {
        if (size == 0) {
            System.out.println("Empty Queue_Array");
            return -1;
        }
        int rear = (front + size - 1) % capacity;
        return q[rear];
    }

    public int getFront() {
        if (size == 0) {
            System.out.println("Empty Queue_Array");
            return -1;
        }
        return q[front];
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue_Array:[");
        if (size == 0) {
            sb.append("]");
            System.out.println(sb);
            return;
        }
        for (int i = front; i <= (front + size - 1) % capacity; i++) {
            sb.append(q[i]).append(", ");
        }
        System.out.println(sb.substring(0, sb.length() - 2) + "]");
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.print();
        System.out.println(q.getFront() + " " + q.getRear());
        System.out.println("removed: " + q.dequeue());
        q.print();
        System.out.println(q.getFront() + " " + q.getRear());
        q.enqueue(40);
        q.print();
        System.out.println(q.getFront() + " " + q.getRear());
        q.print();
    }
}
