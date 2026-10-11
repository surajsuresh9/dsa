package lld.data_structures.linked_list;

public class FindKthNodeFromEnd {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static int removeKthNodeFromEnd_TwoPointer(Node head, int k) {
        Node slow = head;
        Node fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow != null ? slow.data : -1;
    }

    private static int removeKthNodeFromEnd(Node head, int k) {
        // Count the total number of nodes
        int c = 0;
        Node curr = head;

        while (curr != null) {
            c++;
            curr = curr.next;
        }
        if (k > c) {
            return -1;
        }

        curr = head;
        for (int i = 0; i < c - k; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            if (node.next != null)
                System.out.print(" -> ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next
                = new Node(8);
        head.next.next.next.next.next.next.next.next
                = new Node(9);
        int k = 2;
        printList(head);
        System.out.println();
        System.out.println(removeKthNodeFromEnd(head, k));
        System.out.println(removeKthNodeFromEnd_TwoPointer(head, k));
    }


}
