package lld.data_structures.linked_list;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static boolean detectCycle(Node head) {
        Set<Node> hs = new HashSet<>();
        Node curr = head;

        while (curr != null) {
            if (hs.contains(curr)) {
                return true;
            }
            hs.add(curr);
            curr = curr.next;
        }
        return false;
    }

    static boolean detectCycleFloyd_sCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(4);

        head.next.next.next = head.next;

        System.out.println(detectCycle(head));
        System.out.println(detectCycleFloyd_sCycle(head));

    }
}
