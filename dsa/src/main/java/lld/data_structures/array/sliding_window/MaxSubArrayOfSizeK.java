package lld.data_structures.array.sliding_window;

public class MaxSubArrayOfSizeK {
    public static void main(String[] args) {
        int[] a = {100, 200, 300, 400};
        int k = 2;
        int res = getMaxSubArrayOfSizeK_2(a, k);
        System.out.println(res);
    }

    private static int getMaxSubArrayOfSizeK_2(int[] a, int k) {
        int sum = 0;
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            sum += a[i];
        }
        for (int r = k; r < a.length; r++) {
            sum += a[r] - a[r - k];
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum;
    }

    private static int getMaxSubArrayOfSizeK(int[] a, int k) {
        int maxSum = 0;
        int sum = 0;
        int l = 0;
        int r = l + k - 1;
        while (r < a.length) {
            for (int i = l; i <= r; i++) {
                sum += a[i];
            }
            maxSum = Math.max(maxSum, sum);
            l++;
            r++;
        }
        return maxSum;
    }
}
