package lld.data_structures.linked_list;

import java.util.Stack;

public class Palindrome {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to check whether the list is palindrome
    static boolean isPalindromeReverseMiddleHalf(Node head) {
        if (head == null || head.next == null)
            return true;

        Node slow = head, fast = head;

        while (fast.next != null
                && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node head2 = reverseList(slow.next);
        slow.next = null;

        boolean ret = isIdentical(head, head2);

        head2 = reverseList(head2);
        slow.next = head2;

        return ret;
    }


    private static Node findMiddleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Function to reverse a linked list
    static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Function to check if two lists are identical
    static boolean isIdentical(Node n1, Node n2) {
        while (n1 != null && n2 != null) {
            if (n1.data != n2.data)
                return false;
            n1 = n1.next;
            n2 = n2.next;
        }
        return true;
    }

    static boolean isPalindromeUsingStack(Node head) {
        Stack<Integer> stck = new Stack<>();

        // Push all elements of the list to the stack
        while (head != null) {
            stck.add(head.data);
            head = head.next;
        }

        // Iterate in the list again and check
        // by popping from the stack
        while (head != null) {
            if (stck.pop() != head.data) {
                return false;
            }
            head = head.next;
        }
        return true;
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
        // Linked list : 1->2->3->2->1
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

//        boolean isPalindrome = isPalindromeUsingStack(head);
        boolean isPalindrome = isPalindromeReverseMiddleHalf(head);
        System.out.println("isPalindrome: " + isPalindrome);
    }
}
