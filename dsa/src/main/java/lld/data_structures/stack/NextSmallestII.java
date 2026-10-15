package lld.data_structures.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallestII {
    public static void main(String[] args) {
        int[] a = {4, 8, 5, 2, 25};
        System.out.println("a: " + Arrays.toString(a));
        System.out.println("res: " + Arrays.toString(getNextSmallestElement(a)));
    }

    static int[] getNextSmallestElement(int[] a) {
        int[] res = new int[a.length];
        Arrays.fill(res, -1);
        Stack<Integer> stck = new Stack<>();

        for (int i = a.length - 1; i >= 0; i--) {
            while (!stck.isEmpty() && stck.peek() >= a[i]) {
                stck.pop();
            }
            if (!stck.isEmpty()) {
                res[i] = stck.peek();
            }
            stck.push(a[i]);
        }
        return res;
    }
}
