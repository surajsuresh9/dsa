package lld.data_structures.array.impl;

import java.util.Arrays;

public class RotateArrayByReversal {
    static void rotateLeft(int[] a, int k) {
        int n = a.length - 1;
        // 1st block reversed
        rotateArrayByReversal(a, 0, k - 1);

        // 2nd block reversed
        rotateArrayByReversal(a, k, n);

        // whole array reversed
        rotateArrayByReversal(a, 0, n);
    }

    static void rotateArrayByReversal(int[] a, int start, int end) {
        int t;
        while (start < end) {
            t = a[start];
            a[start] = a[end];
            a[end] = t;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int d = 2;

        rotateLeft(arr, d); // Rotate array by d
        System.out.println(Arrays.toString(arr));
    }
}
