package lld.data_structures.linked_list;

import java.util.Stack;

public class ReverseLinkedList {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            if (node.next != null)
                System.out.print(" -> ");
            node = node.next;
        }
    }

    static Node reverseListInPlace(Node head) {
        Node curr = head;
        Node next = null;
        Node prev = null;
        while (curr != null) {
            // Store next
            next = curr.next;
            // Reverse current node's next pointer
            curr.next = prev;
            // Move pointers one position ahead
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static void reverseList(Node head) {
        Stack<Node> stck = new Stack<>();
        Node curr = head;

        while (curr != null) {
            stck.push(curr);
            curr = curr.next;
        }
        while (!stck.isEmpty()) {
            System.out.print(stck.pop().data + " ");
        }
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        ReverseLinkedList l = new ReverseLinkedList();
        l.reverseList(head);
        System.out.println();
        head = reverseListInPlace(head);
        printList(head);
    }
}
