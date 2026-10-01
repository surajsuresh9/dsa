package lld.data_structures.array;

import java.util.Arrays;

public class SuffixSum {
    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50};
        // {150, 140, 120, 90, 50};
        int[] suffix = new int[a.length];
        suffix[suffix.length - 1] = a[a.length - 1];
        for (int i = suffix.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + a[i];
        }
        System.out.println("suffix: " + Arrays.toString(suffix));
    }
}
