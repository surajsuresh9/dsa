package lld.data_structures.array.impl;

public class SecondLargestAndSmallest {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        System.out.println("2nd largest: " + getSecondLargest(a));
        System.out.println("2nd smallest: " + getSecondSmallest(a));
    }

    private static int getSecondLargest(int[] a) {
        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > largest) {
                second = largest;
                largest = a[i];
            } else if (a[i] > second && a[i] != largest) {
                second = a[i];
            }
        }
        return second;
    }

    private static int getSecondSmallest(int[] a) {
        int smallest = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < smallest) {
                second = smallest;
                smallest = a[i];
            } else if (a[i] < second && a[i] != smallest) {
                second = a[i];
            }
        }
        return second;
    }
}
