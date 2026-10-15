package lld.data_structures.stack;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String s1 = "[{()}]";
        String s2 = "([{]})";
        System.out.println(s1 + ": " + isValidParenthesis(s1));
        System.out.println(s2 + ": " + isValidParenthesis(s2));
    }

    private static boolean isValidParenthesis(String s) {
        // push all opening braces into a stack
        Stack<Character> stck = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '[' || ch == '{' || ch == '(') {
                stck.push(ch);
            } else {
                char top = stck.peek();
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
                stck.pop();
            }
        }
        return true;
    }
}
