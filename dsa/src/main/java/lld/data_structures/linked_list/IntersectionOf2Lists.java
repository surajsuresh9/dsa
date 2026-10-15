package lld.data_structures.linked_list;

public class IntersectionOf2Lists {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // Function to get the intersection point of two linked lists
    static Node intersectPoint(Node head1, Node head2) {

        // Count the number of nodes in both linked lists
        int len1 = getCount(head1);
        int len2 = getCount(head2);

        int diff = 0;

        // If the first list is longer
        if (len1 > len2) {
            diff = len1 - len2;
            return getIntersectionByDiff(diff, head1, head2);
        } else {
            diff = len2 - len1;
            return getIntersectionByDiff(diff, head2, head1);
        }
    }


    // Function to get the intersection point of two
    // linked lists where head1 has d more nodes than head2
    static Node getIntersectionByDiff(int diff, Node head1, Node head2) {
        Node curr1 = head1;
        Node curr2 = head2;

        // Move the pointer forward by d nodes
        for (int i = 0; i < diff; i++) {
            if (curr1 == null)
                return null;
            curr1 = curr1.next;
        }

        // Move both pointers until they intersect
        while (curr1 != null && curr2 != null) {
            if (curr1 == curr2)
                return curr1;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return null;
    }

    private static int getCount(Node head) {
        int c = 0;
        while (head != null) {
            c++;
            head = head.next;
        }
        return c;
    }

    // Function to get the intersection point of two linked lists
    static Node intersectPoint2(Node head1, Node head2) {

        // Count the number of nodes in both linked lists
        int len1 = getCount(head1);
        int len2 = getCount(head2);

        int diff = 0;

        // If the first list is longer
        if (len1 > len2) {
            diff = len1 - len2;
            return getIntersectionByDiff(diff, head1, head2);
        } else {
            diff = len2 - len1;
            return getIntersectionByDiff(diff, head2, head1);
        }
    }

    static Node intersectionPoint(Node head1, Node head2) {
        while (head2 != null) {
            Node temp = head1;
            while (temp != null) {
                if (temp == head2) {
                    return head2;
                }
                temp = temp.next;
            }
            head2 = head2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        // creation of first list: 10 -> 15 -> 30
        Node head1 = new Node(10);
        head1.next = new Node(15);
        head1.next.next = new Node(30);

        // creation of second list: 3 -> 6 -> 9 -> 15 -> 30
        Node head2 = new Node(3);
        head2.next = new Node(6);
        head2.next.next = new Node(9);

        // 15 is the intersection point
        head2.next.next.next = head1.next;

        Node intersectionPoint = intersectionPoint(head1, head2);
        System.out.println(intersectionPoint.data);

        Node intersectionPoint2 = intersectPoint2(head1, head2);
        System.out.println(intersectionPoint2.data);

    }
}
