package lld.data_structures.array.impl;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(a));
        rotateLeft(a, 2);
        System.out.println(Arrays.toString(a));
        rotateRight(a, 2);
        System.out.println(Arrays.toString(a));
    }

    // {1, 2, 3, 4, 5};
    // {2, 3, 4, 5, 5};
    // {3, 4, 5, 1, 2};
    static void rotateLeft(int[] a, int k) {
        if (a.length == 0) return;
        for (int c = 0; c < k; c++) {
            int first = a[0];
            for (int i = 0; i < a.length - 1; i++) {
                a[i] = a[i + 1];
            }
            a[a.length - 1] = first;
        }
    }

    // {1, 2, 3, 4, 5};
    // {1, 1, 2, 3, 4};
    // {5, 1, 2, 3, 4};
    static void rotateRight(int[] a, int k) {
        if (a.length == 0) return;
        for (int c = 0; c < k; c++) {
            int last = a[a.length - 1];
            for (int i = a.length - 1; i > 0; i--) {
                a[i] = a[i - 1];
            }
            a[0] = last;
        }
    }
}
