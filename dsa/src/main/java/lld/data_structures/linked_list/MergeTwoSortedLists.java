package lld.data_structures.linked_list;

import java.util.*;

public class MergeTwoSortedLists {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static Node mergeLists(Node head1, Node head2) {
        ArrayList<Integer> arr = new ArrayList<>();

        // pushing the values of the first linked list
        while (head1 != null) {
            arr.add(head1.data);
            head1 = head1.next;
        }

        // pushing the values of the second linked list
        while (head2 != null) {
            arr.add(head2.data);
            head2 = head2.next;
        }

        // sorting the list, remove duplicates
        HashSet<Integer> hs = new HashSet<>(arr);
        arr.clear();
        arr.addAll(hs);
        Collections.sort(arr);

        // creating a new list with sorted values
        Node dummy = new Node(-1);
        Node curr = dummy;

        for (int i = 0; i < arr.size(); i++) {
            curr.next = new Node(arr.get(i));
            curr = curr.next;
        }

        return dummy.next;
    }

    private static Node mergeListsIterative(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node curr = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }

        if (head1 != null) {
            curr.next = head1;
        } else {
            curr.next = head2;
        }
        return dummy.next;
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
        Node head1 = new Node(5);
        head1.next = new Node(10);
        head1.next.next = new Node(15);
        head1.next.next.next = new Node(40);

        Node head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(20);

        System.out.print("List-1: ");
        printList(head1);
        System.out.println();
        System.out.print("List-2: ");
        printList(head2);
        System.out.println();

        Node mergedList = mergeListsIterative(head1, head2);
        System.out.print("Merged: ");
        printList(mergedList);

        System.out.println();
        mergedList = mergeLists(head1, head2);
        System.out.print("Merged: ");
        printList(mergedList);
    }

}
