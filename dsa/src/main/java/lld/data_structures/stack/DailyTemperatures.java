package lld.data_structures.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] a = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(getDailyTemperatures(a)));
    }

    private static int[] getDailyTemperatures(int[] a) {
        Stack<Integer> stck = new Stack<>();
        int[] res = new int[a.length];
        Arrays.fill(res, -1);

        for (int i = a.length - 1; i >= 0; i--) {

            while (!stck.isEmpty() && a[stck.peek()] <= a[i]) {
                stck.pop();
            }

            if (!stck.isEmpty()) {
                res[i] = stck.peek() - i;
            }

            stck.push(i);
        }
        return res;
    }


}
