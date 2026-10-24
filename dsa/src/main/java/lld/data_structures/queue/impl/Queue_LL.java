package lld.data_structures.queue.impl;

public class Queue_LL {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;
    private int capacity;

    public Queue_LL(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("invalid capacity");
        }
        this.capacity = capacity;
        this.size = 0;
        this.head = this.tail = null;
    }

    void enqueue(int data) {
        if (size == capacity) {
            System.out.println("Queue full");
            return;
        }

        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = head;
            size++;
            return;
        }

//        Node curr = head;
//        while (curr.next != null) {
//            curr = curr.next;
//        }
//        curr.next = newNode;
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    int dequeue() {
        if (head == null) {
            throw new IllegalStateException("empty queue");
        }
        int popped = head.data;
        head = head.next;
        size--;

        if (head == null) {
            tail = null;
        }

        return popped;
    }

    void peek() {
        if (head == null) {
            System.out.println("empty queue");
            return;
        }
        System.out.println(head.data);
    }

    void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: [");
        if (head == null) {
            sb.append("]");
            System.out.println(sb);
            return;
        }
        Node curr = head;
        for (int i = 0; i < size; i++) {
            sb.append(curr.data).append(", ");
            curr = curr.next;
        }
        System.out.println(sb.substring(0, sb.length() - 2) + "]");
    }

    public static void main(String[] args) {
        Queue_LL q = new Queue_LL(5);
        q.print();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.print();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.print();
    }
}
