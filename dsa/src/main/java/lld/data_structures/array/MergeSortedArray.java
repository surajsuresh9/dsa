package lld.data_structures.array;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] a1 = new int[]{1, 3, 4, 5};
        int[] a2 = new int[]{2, 4, 6, 8};

        int[] merged = merge(a1, a2);
        System.out.println(Arrays.toString(merged));
    }

    private static int[] merge(int[] foo, int[] bar) {
        int fooLength = foo.length;
        int barLength = bar.length;

        int[] merged = new int[fooLength + barLength];
        int fooPos = 0, barPos = 0, mergedPos = 0;

        while (fooPos < fooLength && barPos < barLength) {
            if (foo[fooPos] < bar[barPos]) {
                merged[mergedPos++] = foo[fooPos++];
            } else {
                merged[mergedPos++] = bar[barPos++];
            }
        }

        while (fooPos < fooLength) {
            merged[mergedPos++] = foo[fooPos++];
        }

        while (barPos < barLength) {
            merged[mergedPos++] = bar[barPos++];
        }
        return merged;
    }
}
