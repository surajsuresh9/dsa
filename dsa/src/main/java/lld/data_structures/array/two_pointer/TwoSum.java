package lld.data_structures.array.two_pointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] a = new int[]{0, -1, 2, -3, 1};
        int target = -2;
        int[] res = bruteForce(a, target);
        System.out.println("res: " + Arrays.toString(res));
        res = twoPointer(a, target);
        System.out.println("res: " + Arrays.toString(res));
        res = hashMap(a, target);
        System.out.println("res: " + Arrays.toString(res));
    }

    private static int[] hashMap(int[] a, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int compliment = target - a[i];
            if (map.containsKey(compliment)) {
                return new int[]{compliment, a[i]};
            }
            map.put(a[i], i);
        }
        return null;
    }

    private static int[] twoPointer(int[] a, int target) {
        sortArray(a);
        int l = 0, r = a.length - 1;
        while (l < r) {
            int sum = a[l] + a[r];
            if (sum == target) {
                return new int[]{a[l], a[r]};
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return null;
    }

    private static int[] bruteForce(int[] a, int target) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
//                System.out.println(a[i] + " + " + a[j] + " = " + (a[i] + a[j]));
                if (a[i] + a[j] == target) {
                    return new int[]{a[i], a[j]};
                }
            }
//            System.out.println("===========");
        }
        return null;
    }

    static void sortArray(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }
    }
}