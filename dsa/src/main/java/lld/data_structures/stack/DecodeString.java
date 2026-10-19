package lld.data_structures.stack;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String s = "3[b2[ca]]";
        System.out.println(s + " = " + decodedString_2Stacks(s));
        System.out.println(s + " = " + decodedString_1Stack(s));
    }

    private static String decodedString_1Stack(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // Push characters into the stack until ']' is encountered
            if (s.charAt(i) != ']') {
                st.push(s.charAt(i));
            }

            // Decode when ']' is found
            else {
                StringBuilder temp = new StringBuilder();
                // Pop characters until '[' is found
                while (!st.isEmpty() && st.peek() != '[') {
                    temp.append(st.pop());
                }
                temp.reverse();
                st.pop();

                StringBuilder num = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    num.insert(0, st.pop());
                }

                // Convert extracted number to integer
                int number = Integer.parseInt(num.toString());
                StringBuilder repeat = new StringBuilder();

                // Repeat the extracted string 'number' times
                for (int j = 0; j < number; j++) {
                    repeat.append(temp);
                }

                // Push the expanded string back onto the stack
                for (char c : repeat.toString().toCharArray()) {
                    st.push(c);
                }
            }
        }

        StringBuilder res = new StringBuilder();
        // Pop all characters from stack to form the final result
        while (!st.isEmpty()) {
            res.append(st.pop());
        }
        // Reverse to get the correct order
        res.reverse();
        return res.toString();
    }

    private static String decodedString_2Stacks(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();
        String temp = "";
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int cnt = 0;

            // If Digit, convert it into a number and
            // push it into the integer stack.
            if (Character.isDigit(s.charAt(i))) {
                while (Character.isDigit(s.charAt(i))) {
                    cnt = cnt * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                numStack.push(cnt);
            }

            // If closing bracket ']' is encountered
            else if (s.charAt(i) == ']') {
                temp = "";

                cnt = numStack.pop();

                // Pop elements till the opening bracket '[' is found
                // in the character stack.
                while (charStack.peek() != '[') {
                    temp = charStack.pop() + temp;
                }
                charStack.pop();

                // Repeating the popped string 'temp' count number of times.
                StringBuilder repeated = new StringBuilder();
                for (int j = 0; j < cnt; j++) {
                    repeated.append(temp);
                }

                // Push it into the character stack.
                for (int j = 0; j < repeated.length(); j++) {
                    charStack.push(repeated.charAt(j));
                }
            } else {
                charStack.push(s.charAt(i));
            }
        }

        // Pop all the elements, make a string, and return.
        while (!charStack.isEmpty()) {
            res.insert(0, charStack.pop());
        }

        return res.toString();
    }
}
