package lld.data_structures.array.two_pointer;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2};
        System.out.println("arr: " + Arrays.toString(arr));
        int[] res = sortColors(arr);
        System.out.println("res: " + Arrays.toString(res));
    }

    private static int[] sortColors(int[] a) {
        int low = 0, mid = 0;
        int high = a.length - 1;

        while (mid <= high) {
            if (a[mid] == 0) {
                swap(a, low, mid);
                low++;
                mid++;
            } else if (a[mid] == 1) {
                mid++;
            } else {
                swap(a, mid, high);
                high--;
            }
        }
        return a;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
