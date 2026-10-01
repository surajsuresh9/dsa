package lld.data_structures.array.impl;

import java.util.Arrays;

public class RemoveDuplicatesSortedArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int newSize = removeDuplicates(a);
        for (int i = 0; i < newSize; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private static int removeDuplicates(int[] arr) {
        int n = arr.length;
        if (n <= 1)
            return n;

        // Start from the second element
        int idx = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[idx++] = arr[i];
            }
        }
        return idx;
    }
}
