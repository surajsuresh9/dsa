package lld.data_structures.queue.impl;

public class Queue_Array {
    private int size;
    private int capacity;
    private int[] q;
    private int front;
    private int rear;

    public Queue_Array(int capacity) {
        this.capacity = capacity;
        front = 0;
        rear = -1;
        size = 0;
        q = new int[capacity];
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue_Array full");
            return;
        }
        q[++rear] = data;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Empty queue");
            return -1;
        }
        int popped = q[front];
        for (int i = 0; i < q.length - 1; i++) {
            q[i] = q[i + 1];
        }
        q[q.length - 1] = 0;
        size--;
        rear--;
        return popped;
    }

    private boolean isFull() {
        return size == capacity;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public int getRear() {
        return q[rear];
    }

    public int getFront() {
        return q[front];
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Empty queue");
            return;
        }
        System.out.println(q[front]);
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue_Array:[");
        if (isEmpty()) {
            sb.append("]");
            System.out.println(sb);
            return;
        }
        for (int i = 0; i < size; i++) {
            sb.append(q[i]).append(", ");
        }
        System.out.println(sb.substring(0, sb.length() - 2) + "]");
    }

    public static void main(String[] args) {
        Queue_Array q = new Queue_Array(5);
        q.print();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.print();
        q.peek();
        System.out.println("removed: " + q.dequeue());
        System.out.println("removed: " + q.dequeue());
        System.out.println("removed: " + q.dequeue());
        q.print();
        q.peek();
        System.out.println("front: " + q.getFront());
        System.out.println("rear: " + q.getRear());
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.print();
        System.out.println("front: " + q.getFront());
        System.out.println("rear: " + q.getRear());
    }
}
