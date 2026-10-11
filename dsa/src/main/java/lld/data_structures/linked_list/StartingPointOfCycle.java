package lld.data_structures.linked_list;

import java.util.HashSet;
import java.util.Set;

public class StartingPointOfCycle {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static int getStartingNodeFloyd_sCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                // Move slow to head
                // keep fast at meeting point
                slow = head;

                // Move both one step at a time until they meet
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                // Return the meeting node's data,
                // which is the start of the loop
                return slow.data;
            }
        }
        return -1;
    }

    static int getStartingNode(Node head) {
        Set<Node> hs = new HashSet<>();
        while (head != null) {
            if (hs.contains(head)) {
                return head.data;
            } else {
                hs.add(head);
                head = head.next;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.next.next.next.next.next = head.next.next;

        System.out.println(getStartingNode(head));
        System.out.println(getStartingNodeFloyd_sCycle(head));
    }
}
