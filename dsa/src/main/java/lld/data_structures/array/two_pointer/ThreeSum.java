package lld.data_structures.array.two_pointer;

import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args) {
        int[] a = {1, 4, 45, 6, 10, 8};
        int target = 13;
        int[] res = bruteForce(a, target);
        System.out.println("res: " + Arrays.toString(res));
        res = twoPointer(a, target);
        System.out.println("res: " + Arrays.toString(res));
    }

    private static int[] twoPointer(int[] a, int target) {
        Arrays.sort(a);
        for (int i = 0; i < a.length - 2; i++) {
            int l = i + 1;
            int r = a.length - 1;

            while (l < r) {
                int sum = a[i] + a[l] + a[r];
                if (sum == target) {
                    return new int[]{a[i], a[l], a[r]};
                } else if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return null;
    }

    static int[] bruteForce(int[] a, int target) {
        for (int i = 0; i < a.length - 2; i++) {
            for (int j = i + 1; j < a.length - 1; j++) {
                for (int k = j + 1; k < a.length; k++) {
                    int sum = a[i] + a[j] + a[k];
                    if (sum == target) {
                        return new int[]{a[i], a[j], a[k]};
                    }
                }
            }
        }
        return null;
    }
}


