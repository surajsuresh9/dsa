package lld.data_structures.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterII {
    public static void main(String[] args) {
        int[] a = {1, 3, 2, 4};
        int[] a1 = {6, 8, 0, 1, 3};
        System.out.println("a: " + Arrays.toString(a));
        System.out.println("res: " + Arrays.toString(getNextGreaterElement(a)));
        System.out.println();
        System.out.println("a: " + Arrays.toString(a1));
        System.out.println("res: " + Arrays.toString(getNextGreaterElement(a1)));
    }

    static int[] getNextGreaterElement(int[] a) {
        int[] res = new int[a.length];
        Arrays.fill(res, -1);
        Stack<Integer> stck = new Stack<>();

        for (int i = a.length - 1; i >= 0; i--) {

            while (!stck.isEmpty() && a[i] >= stck.peek()) {
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
