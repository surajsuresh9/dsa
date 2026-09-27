package lld.data_structures.array;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(a));
        reverse(a);
        System.out.println(Arrays.toString(a));
    }

    static void reverse(int[] a) {
        int start = 0;
        int end = a.length - 1;
        while (start < end) {
            int t = a[start];
            a[start] = a[end];
            a[end] = t;

            start++;
            end--;
        }
    }

}
