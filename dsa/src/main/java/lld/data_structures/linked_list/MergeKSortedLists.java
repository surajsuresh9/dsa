package lld.data_structures.linked_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class MergeKSortedLists {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Using Divide and Conquer (Works better for equal sized lists)
    static Node mergeListRecur(int i, int j, List<Node> arr) {
        // If single list is left
        if (i == j) return arr.get(i);

        // Find the middle of lists
        int mid = i + (j - i) / 2;

        // Merge lists from i to mid
        Node head1 = mergeListRecur(i, mid, arr);

        // Merge lists from mid+1 to j
        Node head2 = mergeListRecur(mid + 1, j, arr);

        // Merge the above 2 lists
        Node head = merge2SortedLists(head1, head2);

        return head;
    }

    static Node mergeKLists_merge(List<Node> arr) {
        if (arr.isEmpty()) return null;
        return mergeListRecur(0, arr.size() - 1, arr);
    }

    // Function to get node with minimum value
    static Node getMinNode(List<Node> arr) {
        Node mini = null;
        int index = -1;

        for (int i = 0; i < arr.size(); i++) {

            // If current list is processed
            if (arr.get(i) == null) continue;

            // If min node is not set or
            // current head has smaller value.
            if (mini == null || arr.get(i).data < mini.data) {
                index = i;
                mini = arr.get(i);
            }
        }

        // Increment the head node
        if (index != -1) arr.set(index, arr.get(index).next);

        return mini;
    }

    // Function to merge K sorted linked lists
    static Node mergeKLists(List<Node> arr) {
        Node dummy = new Node(-1);
        Node tail = dummy;

        Node mini = getMinNode(arr);

        // Process all nodes.
        while (mini != null) {

            // Append min node to the result.
            tail.next = mini;
            tail = mini;

            // Find the next min node
            mini = getMinNode(arr);
        }

        return dummy.next;
    }


    static Node merge2SortedLists(Node head1, Node head2) {

        // merge 2 lists
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

    static Node mergeKSortedLists(List<Node> nodes) {
        Node res = null;
        for (Node node : nodes) {
            res = merge2SortedLists(res, node);
        }
        return res;
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
        List<Node> arr = new ArrayList<>();

        arr.add(new Node(1));
        arr.get(0).next = new Node(3);
        arr.get(0).next.next = new Node(5);
        arr.get(0).next.next.next = new Node(7);

        arr.add(new Node(2));
        arr.get(1).next = new Node(4);
        arr.get(1).next.next = new Node(6);
        arr.get(1).next.next.next = new Node(8);

        arr.add(new Node(0));
        arr.get(2).next = new Node(9);
        arr.get(2).next.next = new Node(10);
        arr.get(2).next.next.next = new Node(11);


        System.out.print("List-1: ");
        printList(arr.get(0));
        System.out.println();
        System.out.print("List-2: ");
        printList(arr.get(1));
        System.out.println();
        System.out.print("List-3: ");
        printList(arr.get(2));
        System.out.println();

//        Node mergedList = mergeKSortedLists(arr);
//        System.out.print("Merged: ");
//        printList(mergedList);

        Node mergedList2 = mergeKLists(arr);
        System.out.print("Merged: ");
        printList(mergedList2);

//        Node mergedList3 = mergeKLists_merge(arr);
//        System.out.print("Merged: ");
//        printList(mergedList3);



    }

}
