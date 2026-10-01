package lld.data_structures.array.sliding_window;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] a = {0, 1, 0, 1, 1, 1, 1};
        int maxCount = 0, count = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] == a[i]) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
        }
        maxCount = Math.max(maxCount, count);
        System.out.println(maxCount);
        System.out.println("maxConsecutiveOnes: " + maxConsecutiveOnes(a));
    }

    static int maxConsecutiveOnes(int[] a) {
        int count = 0;
        int max = 0;

        for (int num : a) {
            if (num == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        return max;
    }
}
