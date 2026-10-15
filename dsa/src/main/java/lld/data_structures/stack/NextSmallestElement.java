package lld.data_structures.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallestElement {
    public static void main(String[] args) {
        int[] a = {4, 8, 5, 2, 25};
        int[] arr = {4, 8, 5, 2, 25};
        System.out.println("a: " + Arrays.toString(a));
        System.out.println("res: " + Arrays.toString(getSmallerElement_Brute(a)));
        System.out.println();
        System.out.println("a: " + Arrays.toString(arr));
        System.out.println("res: " + Arrays.toString(getSmallerElement_Stack(arr)));
    }

    static int[] getSmallerElement_Stack(int[] a) {
        Stack<Integer> stck = new Stack<>();
        int[] res = new int[a.length];
        Arrays.fill(res, -1);

        for (int i = a.length - 1; i >= 0; i--) {

            while (!stck.isEmpty() && stck.peek() > a[i]) {
                stck.pop();
            }

            if (!stck.isEmpty()) {
                res[i] = stck.peek();
            }

            stck.push(a[i]);
        }
        return res;
    }

    static int[] getSmallerElement_Brute(int[] a) {
        int[] res = new int[a.length];
        Arrays.fill(res, -1);

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[i]) {
                    res[i] = a[j];
                    break;
                }
            }
        }
        return res;
    }
}
