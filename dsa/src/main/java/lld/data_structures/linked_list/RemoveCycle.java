package lld.data_structures.linked_list;

import java.util.HashSet;
import java.util.Set;

public class RemoveCycle {
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

    private static void removeLoopFloyd_sCycle(Node head) {
        Node fast = head;
        Node slow = head;

        // detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                slow = head;
                if (slow != fast) {
                    while (slow.next != fast.next) {
                        slow = slow.next;
                        fast = fast.next;
                    }
                    fast.next = null;
                }
            }
        }
    }

    private static void removeLoop(Node head) {
        Node prev = null;

        // hash set to hash addresses of
        // the linked list nodes
        Set<Node> hs = new HashSet<>();

        while (head != null) {
            if (!hs.contains(head)) {
                hs.add(head);
                prev = head;
                head = head.next;
            } else {
                prev.next = null;
                break;
            }
        }
    }


    public static void main(String[] args) {
        // Create a hard-coded linked list:
        // 1 -> 3 -> 4
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(4);

        // Create a loop
        head.next.next.next = head.next;
        removeLoop(head);
        printList(head);
        System.out.println();
        removeLoopFloyd_sCycle(head);
        printList(head);
    }
}
