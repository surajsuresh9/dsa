package lld.data_structures.stack;

import java.util.Stack;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String s = "aaabbaaccd";
        System.out.println(removeDuplicates(s));
        System.out.println(removeDuplicates_Stack(s));
    }


    private static String removeDuplicates_Stack(String s) {
        Stack<Character> stck = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stck.isEmpty() && stck.peek() == ch) {
                stck.pop();
            } else {
                stck.push(ch);
            }
        }

        StringBuilder res = new StringBuilder();

        // Build result string from stack
        while (!stck.isEmpty()) {
            res.append(stck.pop());
        }
        res.reverse();
        return res.length() == 0 ? "-1" : res.toString();
    }

    private static String removeDuplicates(String s) {
        String curr = s;
        while (true) {
            StringBuilder temp = new StringBuilder();
            boolean removed = false;

            for (int i = 0; i < curr.length(); i++) {
                // Remove consecutive duplicate pair
                if (i + 1 < curr.length() && curr.charAt(i) == curr.charAt(i + 1)) {
                    removed = true;
                    i++;
                } else {
                    temp.append(curr.charAt(i));
                }
            }

            // No pair found
            if (!removed) {
                break;
            }

            curr = temp.toString();
            if (curr.isEmpty()) {
                return "-1";
            }
        }
        return curr;
    }
}
