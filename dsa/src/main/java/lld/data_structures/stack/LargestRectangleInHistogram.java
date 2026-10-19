package lld.data_structures.stack;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] a = {60, 20, 50, 40, 10, 50, 60};
        System.out.println(getMaxArea_Brute(a));
        System.out.println(getMaxArea_Prev_Next_Smaller_Bar(a));
    }

    private static int getMaxArea_Prev_Next_Smaller_Bar(int[] a) {
        int maxArea = 0;
        int[] nextSmaller = getNextSmallerElement(a);
        int[] prevSmaller = getPrevSmallerElement(a);
        for (int i = 0; i < a.length; i++) {
            int width = nextSmaller[i] - prevSmaller[i] - 1;
            int area = a[i] * width;
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    private static int[] getPrevSmallerElement(int[] a) {
        Stack<Integer> stck = new Stack<>();
        int[] res = new int[a.length];
        Arrays.fill(res, -1);

        for (int i = 0; i < a.length; i++) {
            while (!stck.isEmpty() && a[stck.peek()] >= a[i]) {
                stck.pop();
            }
            if (!stck.isEmpty()) {
                res[i] = stck.peek();
            }
            stck.push(i);
        }
        return res;
    }

    private static int[] getNextSmallerElement(int[] a) {
        Stack<Integer> stck = new Stack<>();
        int[] res = new int[a.length];
        Arrays.fill(res, a.length);

        for (int i = a.length - 1; i >= 0; i--) {
            while (!stck.isEmpty() && a[stck.peek()] >= a[i]) {
                stck.pop();
            }
            if (!stck.isEmpty()) {
                res[i] = stck.peek();
            }
            stck.push(i);
        }
        return res;
    }

    private static int getMaxArea_Brute(int[] a) {
        int res = 0;

        for (int i = 0; i < a.length; i++) {
            int curr = a[i];

            for (int j = i - 1; j >= 0 && a[j] >= a[i]; j--) {
                curr += a[i];
            }
            for (int j = i + 1; j < a.length && a[j] >= a[i]; j++) {
                curr += a[i];
            }
            res = Math.max(res, curr);
        }
        return res;
    }
}
