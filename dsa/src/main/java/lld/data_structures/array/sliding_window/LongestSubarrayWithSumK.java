package lld.data_structures.array.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        int[] a = {10, 5, 2, 7, 1, -10};
        int k = 15;
        System.out.println("maLen: " + bruteForce(a, k));
        System.out.println("maLen: " + optimal(a, k));
    }

    private static int optimal(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int prefixSum = 0;

        for (int i = 0; i < a.length; i++) {
            prefixSum += a[i];

            // subarray from 0 to i
            if (prefixSum == k) {
                maxLen = i + 1;
            }

            // prefixSum - oldSum = k
            if (map.containsKey(prefixSum - k)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum - k));
            }

            map.putIfAbsent(prefixSum, i);
        }
        return maxLen;
    }

    static int bruteForce(int[] a, int k) {
        int maxLen = 0;

        for (int i = 0; i < a.length; i++) {
            int sum = 0;

            for (int r = i; r < a.length; r++) {
                sum += a[r];

                if (sum == k) {
                    maxLen = Math.max(maxLen, r - i + 1);
                }
            }
        }
        return maxLen;
    }
}