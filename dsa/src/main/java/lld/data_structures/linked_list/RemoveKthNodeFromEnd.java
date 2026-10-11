package lld.data_structures.linked_list;

public class RemoveKthNodeFromEnd {
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

    private static Node deleteNthNodeFromEnd_TwoPointer(Node head, int n) {
        // Create dummy node
        Node dummy = new Node(0);

        dummy.next = head;

        // Initialize slow and fast pointers
        Node slow = dummy;
        Node fast = dummy;

        // Move fast pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            // If n is greater than length
            if (fast == null) {
                return head;
            }

            fast = fast.next;
        }

        // Move both pointers together
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Node to be deleted
        Node nodeDeleted = slow.next;

        // Delete target node
        if (nodeDeleted != null) {
            slow.next = nodeDeleted.next;
        }

        // Return updated head
        return dummy.next;
    }

    private static Node deleteNthNodeFromEnd(Node head, int n) {
        if (head == null) {
            return head;
        }

        int k = 0;
        Node curr = head;

        while (curr != null) {
            k++;
            curr = curr.next;
        }

        // If n is greater than length
        if (n > k) {
            return head;
        }

        // If head node needs to be deleted
        if (k - n == 0) {
            head = head.next;
            return head;
        }

        // Reach node just before target node
        curr = head;
        for (int i = 1; i < k - n; i++) {
            curr = curr.next;
        }

        // Delete target node
        curr.next = curr.next.next;
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);

        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        printList(head);
//        System.out.println();
//        Node newHead = deleteNthNodeFromEnd(head, 2);
//        printList(newHead);
        System.out.println();
        Node newHead = deleteNthNodeFromEnd_TwoPointer(head, 2);
        printList(newHead);
    }
}
