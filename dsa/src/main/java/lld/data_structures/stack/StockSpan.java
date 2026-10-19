package lld.data_structures.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int[] a = {100, 80, 90, 120};
        int[] arr = {10, 4, 5, 90, 120, 80};
        System.out.println("a: " + Arrays.toString(a));
        System.out.println("res: " + getStockSpan(a));
        System.out.println("res: " + Arrays.toString(getStockSpan2(a)));
        System.out.println();
        System.out.println("a: " + Arrays.toString(arr));
        System.out.println("res: " + getStockSpan(arr));
        System.out.println("res: " + Arrays.toString(getStockSpan2(arr)));
    }

    static ArrayList<Integer> getStockSpan(int[] arr) {
        int n = arr.length;

        ArrayList<Integer> span = new ArrayList<>(
                Collections.nCopies(n, 0));
        Stack<Integer> st = new Stack<>();

        // Process each day's price
        for (int i = 0; i < n; i++) {

            // Remove elements from the stack while the current price
            // is greater than or equal to stack's top price
            while (!st.isEmpty() && arr[st.peek()] <=
                    arr[i]) {
                st.pop();
            }

            // If stack is empty, all elements to the left are smaller
            // Else, top of the stack is the last greater element's index
            if (st.isEmpty()) {
                span.set(i, (i + 1));
            } else {
                span.set(i, (i - st.peek()));
            }

            // Push the current index to the stack
            st.push(i);
        }
        return span;
    }

    static int[] getStockSpan2(int[] a) {
        int[] res = new int[a.length];
        Stack<Integer> stck = new Stack<>();

        for (int i = 0; i < a.length; i++) {
            while (!stck.isEmpty() && a[stck.peek()] <= a[i]) {
                stck.pop();
            }
            if (!stck.isEmpty()) {
                res[i] = i - stck.peek();
            } else {
                res[i] = i + 1;
            }
            stck.push(i);
        }
        return res;
    }
}
