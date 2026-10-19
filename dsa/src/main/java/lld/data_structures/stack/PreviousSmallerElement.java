package lld.data_structures.stack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class PreviousSmallerElement {
    public static void main(String[] args) {
        int[] a = {1, 5, 0, 3, 4, 5};
        System.out.println("a: " + Arrays.toString(a));
        System.out.println("res: " + Arrays.toString(getPreviousSmallerElement_Brute(a)));
        System.out.println();
        System.out.println("a: " + Arrays.toString(a));
        System.out.println("res: " + Arrays.toString(getPreviousSmallerElement_Stack(a)));
    }

    static int[] getPreviousSmallerElement_Brute(int[] a) {
        int[] res = new int[a.length];
        Arrays.fill(res, -1);
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] < a[i]) {
                    res[i] = a[j];
                    break;
                }
            }
        }
        return res;
    }

    static int[] getPreviousSmallerElement_Stack(int[] a) {
        int[] res = new int[a.length];
        Arrays.fill(res, -1);
        Stack<Integer> stck = new Stack<>();

        for (int i = 0; i < a.length; i++) {
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
