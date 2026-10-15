package lld.data_structures.stack.impl;

public class Stack_LL {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;
    private int capacity;

    Stack_LL(int capacity) {
        this.capacity = capacity;
        size = 0;
    }

    void push(int data) {
        if (size == capacity) {
            System.out.println("Stack overflow");
            return;
        }
        if (head == null) {
            head = new Node(data);
            size++;
            return;
        }
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    int pop() {
        if (head == null) {
            System.out.println("Stack underflow");
            return -1;
        }
        int i = head.data;
        head = head.next;
        size--;
        return i;
    }

    void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: [");
        if (head == null) {
            sb.append("]");
            System.out.println(sb);
            return;
        }
        Node curr = head;
        while (curr != null) {
            sb.append(curr.data).append(", ");
            curr = curr.next;
        }
        System.out.println(sb.substring(0, sb.length() - 2) + "]");
    }

    public static void main(String[] args) {
        Stack_LL stck = new Stack_LL(4);
        stck.print();
        stck.push(10);
        stck.push(20);
        stck.push(30);
        stck.push(40);
        stck.print();
        stck.push(50);
        System.out.println(stck.pop());
        System.out.println(stck.pop());
        System.out.println(stck.pop());
        stck.print();
        stck.pop();
    }

}
