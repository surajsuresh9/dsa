package lld.data_structures.stack;

import java.util.Arrays;
import java.util.Stack;

public class PreviousGreaterElement {
    public static void main(String[] args) {
        int[] a = {10, 4, 2, 20, 40, 12};
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(getPreviousGreaterElement_Brute(a)));
        System.out.println(Arrays.toString(getPreviousGreaterElement_Stack(a)));
    }

    static int[] getPreviousGreaterElement_Stack(int[] a) {
        int[] res = new int[a.length];
        Arrays.fill(res, -1);
        Stack<Integer> stck = new Stack<>();
        for (int i = 0; i < a.length; i++) {

            // pop elements from the stack that are smaller than
            // or equal to current element
            while (!stck.isEmpty() && a[i] >= stck.peek()) {
                stck.pop();
            }

            // if the stack is not empty, the top of the stack is
            // the previous greater element
            if (!stck.isEmpty()) {
                res[i] = stck.peek();
            }

            // push the current element onto the stack
            stck.push(a[i]);
        }
        return res;
    }

    static int[] getPreviousGreaterElement_Brute(int[] a) {
        int[] res = new int[a.length];
        Arrays.fill(res, -1);
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] > a[i]) {
                    res[i] = a[j];
                    break;
                }
            }
        }
        return res;
    }
}
