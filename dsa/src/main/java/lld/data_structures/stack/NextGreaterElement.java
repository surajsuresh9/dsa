package lld.data_structures.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] a = {1, 3, 2, 4};
        int[] arr = {6, 8, 0, 1, 3};
        System.out.println(Arrays.toString(getNextGreaterElement_Brute(a)));
        System.out.println(Arrays.toString(getNextGreaterElement_Stack(arr)));
    }

    static int[] getNextGreaterElement_Stack(int[] a) {
        int[] res = new int[a.length];
        Arrays.fill(res, -1);
        Stack<Integer> stck = new Stack<>();

        for (int i = a.length - 1; i >= 0; i--) {

            // remove all smaller elements than a[i] from stack
            while (!stck.isEmpty() && a[i] > stck.peek()) {
                stck.pop();
            }

            // update res with next largest value
            if (!stck.isEmpty()) {
                res[i] = stck.peek();
            }

            // add a[i] to stck
            stck.push(a[i]);
        }
        return res;
    }

    static int[] getNextGreaterElement_Brute(int[] a) {
        int[] res = new int[a.length];
        Arrays.fill(res, -1);

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] > a[i]) {
                    res[i] = a[j];
                    break;
                }
            }
        }
        return res;
    }
}
