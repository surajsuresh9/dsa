package lld.data_structures.linked_list.impl;

public class DoublyLinkedList {
    static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = this.prev = null;
        }
    }

    private int size;
    private Node head;
    private Node tail;

    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    void insertAtBeginning(int data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
        } else {
            Node newNode = new Node(data);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    void insert(int data) {
        if (head == null) {
            head = tail = new Node(data);
        } else {
            Node newNode = new Node(data);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    void deleteAtEnd() {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    void deleteAtBeginning() {
        if (head == null) return;
        head = head.next;
        size--;

        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
    }

    void delete(int pos) {
        if (pos < 1 || pos > size) {
            System.out.println("Invalid position");
            return;
        }

        if (head == null) {
            return;
        }

        if (pos == 1) {
            deleteAtBeginning();
            return;
        }

        Node current = head;
        int count = 1;
        while (current != null && count < pos) {
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("Position wrong");
            return;
        }
        if (current == tail) {
            deleteAtEnd();
            return;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        current.prev = null;
        current.next = null;
        size--;
    }

    void delete() {
        if (head == null) {
            return;
        }
        if (head == tail) {
            head = tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    private void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("Linked List:[");
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
        DoublyLinkedList l = new DoublyLinkedList();
        l.print();
        l.insert(10);
        l.insert(20);
        l.insert(30);
        l.insert(40);
        l.insertAtBeginning(80);
        l.insertAtBeginning(90);
        l.insert(60);
        l.insertAtBeginning(100);
        l.print();
        l.insertAtEnd(900);
        l.print();
        l.delete();
        l.print();
        l.deleteAtBeginning();
        l.print();
        l.deleteAtEnd();
        l.print();
        l.delete(2);
        l.print();
    }
}
