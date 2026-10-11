package lld.data_structures.linked_list.impl;

public class SinglyLinkedList {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    /*
- Insert at head
- Insert at tail
- Insert at index
- Delete node
- Delete by value
- Delete by index
- Get node at index
     */

    int getNodeAtIndex(int idx) {
        validateIdx(idx);
        if (idx == 0) {
            return head.data;
        }
        Node curr = head;
        for (int i = 0; i < idx; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    void deleteNodeByIndex(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if (idx == 0) {
            head = head.next;
        } else {
            Node curr = head;
            for (int i = 0; i < idx - 1; i++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }
        size--;
    }

    void deleteNode() {
        if (head == null) {
            return;
        }
        if (size == 1) {
            head = null;
            size--;
            return;
        }
        Node curr = head;
        Node prev = null;
        for (int i = 1; i < size; i++) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        size--;
    }

    void deleteByValue(int val) {
        if (head == null) {
            return;
        }
        if (head.data == val) {
            head = head.next;
            size--;
            return;
        }
        Node curr = head;
        Node prev = head;
        while (curr.next != null && curr.data != val) {
            prev = curr;
            curr = curr.next;
        }
        if (curr.data == val) {
            prev.next = curr.next;
            size--;
        } else {
            System.out.println("val not found");
        }
    }

    void insertAtHead(int data) {
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

    void insert(int data) {
        if (head == null) {
            insertAtHead(data);
            return;
        }
        Node curr = head;

        for (int i = 1; i < size; i++) {
            curr = curr.next;
        }

        curr.next = new Node(data);
        size++;
    }

    // 0-based indexing
    void insertAtIndex(int data, int idx) {
        validateIdx(idx);

        if (idx == 0) {
            insertAtHead(data);
            return;
        }

        Node curr = head;
        for (int i = 1; i < idx; i++) {
            curr = curr.next;
        }
        Node newNode = new Node(data);
        newNode.next = curr.next;
        curr.next = newNode;
        size++;
    }

    private void validateIdx(int idx) {
        if (idx > size || idx < 0) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
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
        SinglyLinkedList l = new SinglyLinkedList();
        l.insertAtIndex(10, 0);
        l.insertAtIndex(20, 1);
        l.insertAtIndex(30, 2);
        l.insertAtIndex(40, 3);
        l.insertAtIndex(50, 4);
        l.insertAtIndex(60, 5);
        l.print();
        l.deleteNodeByIndex(0);
        l.print();
        l.deleteNodeByIndex(1);
        l.print();
    }
}
