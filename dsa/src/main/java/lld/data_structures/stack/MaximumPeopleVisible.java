package lld.data_structures.stack;

import java.util.Arrays;
import java.util.Stack;

public class MaximumPeopleVisible {
    public static void main(String[] args) {
        int[] a = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(Arrays.toString(a));
        System.out.println(getMaxPeopleVisible(a));
        getMaxPeopleVisible_Stack(a);
    }

    private static int getMaxPeopleVisible_Stack(int[] a) {
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(nextGreater(a)));
        System.out.println(Arrays.toString(previousGreater(a)));
        return -1;
    }

    private static int getMaxPeopleVisible(int[] a) {
        int maxCnt = 0;
        for (int i = 0; i < a.length; i++) {
            int cnt = 1;
            // left side
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] < a[i])
                    cnt++;
                if (a[j] >= a[i])
                    break;
            }
            // right side
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[i])
                    cnt++;
                if (a[j] >= a[i])
                    break;
            }
            maxCnt = Math.max(cnt, maxCnt);
        }
        return maxCnt;
    }

    // Function to compute Previous Greater Element for each index
    static int[] previousGreater(int[] arr) {
        int n = arr.length;
        int[] prev = new int[n];
        Arrays.fill(prev, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) prev[i] = st.peek();
            st.push(i);
        }
        return prev;
    }

    // Function to compute Next Greater Element for each index
    static int[] nextGreater(int[] arr) {
        int n = arr.length;
        int[] next = new int[n];
        Arrays.fill(next, n);
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) next[i] = st.peek();
            st.push(i);
        }
        return next;
    }

}

//[6, 2, 4, 4, 6, 6, -1]
//[-1, 6, 2, 2, 4, 5, 6]

//[6, 2, 4, 4, 6, 6, 7]
//[-1, 0, 0, 2, 2, 4, 0]