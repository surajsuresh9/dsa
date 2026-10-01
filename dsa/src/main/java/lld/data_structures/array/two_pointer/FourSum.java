package lld.data_structures.array.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] a = {1, 5, 3, 1, 2, 10};
        int target = 20;
        int[] res = bruteForce(a, target);
        System.out.println("res: " + Arrays.toString(res));
        List<List<Integer>> resList = twoPointer(a, target);
        System.out.println("res: " + resList);
    }

    private static List<List<Integer>> twoPointer(int[] a, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(a);
        for (int i = 0; i < a.length - 1; i++) {
            // skip duplicates for i
            if (i > 0 && a[i] == a[i - 1]) continue;

            for (int j = i + 1; j < a.length; j++) {
                // skip duplicates for j
                if (j > i + 1 && a[j] == a[j - 1]) continue;

                int k = j + 1;
                int l = a.length - 1;

                while (k < l) {
                    int sum = a[i] + a[j] + a[k] + a[l];

                    if (sum == target) {
                        res.add(Arrays.asList(a[i], a[j], a[k], a[l]));
                        k++;
                        l--;

                        // skip duplicates for k
                        while (k < l && a[k] == a[k - 1]) k++;

                        // skip duplicates for l
                        while (k < l && a[l] == a[l + 1]) l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return res;
    }

    private static int[] bruteForce(int[] a, int target) {
        for (int i = 0; i < a.length - 3; i++) {
            for (int j = i + 1; j < a.length - 2; j++) {
                for (int k = j + 1; k < a.length - 1; k++) {
                    for (int l = k + 1; l < a.length; l++) {
                        int sum = a[i] + a[j] + a[k] + a[l];
                        if (sum == target) {
                            return new int[]{a[i], a[j], a[k], a[l]};
                        }
                    }
                }
            }
        }
        return null;
    }
}
