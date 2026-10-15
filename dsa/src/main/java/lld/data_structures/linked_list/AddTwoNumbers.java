package lld.data_structures.linked_list;

class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

public class AddTwoNumbers {

    // Function to reverse the linked list
    static Node reverse(Node head) {
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

    // Function to trim leading zeros in linked list
    static Node trimLeadingZeros(Node head) {
        while (head != null && head.data == 0) {
            head = head.next;
        }
        return head;
    }

    // Function to add two numbers represented by linked list
    static Node addTwoLists(Node num1, Node num2) {
        Node res = null;
        Node curr = null;
        int carry = 0;

        num1 = trimLeadingZeros(num1);
        num2 = trimLeadingZeros(num2);

        num1 = reverse(num1);
        num2 = reverse(num2);

        // Iterate till either num1 is not empty or num2 is
        // not empty or carry is greater than 0
        while (num1 != null || num2 != null || carry != 0) {
            int sum = carry;

            if (num1 != null) {
                sum += num1.data;
                num1 = num1.next;
            }

            if (num2 != null) {
                sum += num2.data;
                num2 = num2.next;
            }

            Node newNode = new Node(sum % 10);

            carry = sum / 10;

            // If this is the first node, then make this node
            // as the head of the resultant linked list
            if (res == null) {
                res = newNode;
                curr = newNode;
            } else {

                // Append new node to resultant linked list
                // and move to the next node
                curr.next = newNode;
                curr = curr.next;
            }
        }

        return reverse(res);
    }

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) {
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node num1 = new Node(1);
        num1.next = new Node(2);
        num1.next.next = new Node(3);

        Node num2 = new Node(9);
        num2.next = new Node(9);
        num2.next.next = new Node(9);
        System.out.print("num1: ");
        printList(num1);
        System.out.print("num2: ");
        printList(num2);

        Node sum = addTwoLists(num1, num2);
        System.out.print("sum: ");
        printList(sum);
    }
}