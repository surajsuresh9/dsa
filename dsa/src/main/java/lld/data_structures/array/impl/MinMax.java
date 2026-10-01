package lld.data_structures.array.impl;

public class MinMax {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        System.out.println("max: " + getMax(a));
        System.out.println("min: " + getMin(a));
    }

    static int getMax(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            max = Math.max(a[i], max);
        }
        return max;
    }

    static int getMin(int[] a) {
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            min = Math.min(a[i], min);
        }
        return min;
    }
}
