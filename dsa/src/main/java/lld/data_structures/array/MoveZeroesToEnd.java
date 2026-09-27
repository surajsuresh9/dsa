package lld.data_structures.array;

import java.util.Arrays;

public class MoveZeroesToEnd {
    public static void main(String[] args) {
        int[] a = {1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1};

        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                swap(a, i, j);
                j++;
            }
        }

        System.out.println(Arrays.toString(a));
    }

    private static void swap(int[] a, int start, int end) {
        int t = a[start];
        a[start] = a[end];
        a[end] = t;
    }
}
