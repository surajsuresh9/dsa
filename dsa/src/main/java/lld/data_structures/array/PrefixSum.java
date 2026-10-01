package lld.data_structures.array;

import java.util.Arrays;

public class PrefixSum {
    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50};
        // {10,30,60,100,150};
        int[] prefix = new int[a.length];
        prefix[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            prefix[i] = prefix[i - 1] + a[i];
        }
        System.out.println("prefix: " + Arrays.toString(prefix));
    }
}
