package lld.data_structures.stack;

import java.util.Stack;

public class EvaluationOfPrefixExpression {
    public static void main(String[] args) {
        String[] s = new String[]{"+", "*", "/", "+", "100", "200", "2", "5", "7"};
        System.out.println(evalPrefixExpression(s));
    }

    static int evalPrefixExpression(String[] sArr) {
        Stack<Integer> st = new Stack<>();

        for (int i = sArr.length - 1; i >= 0; i--) {
            String token = sArr[i];

            // If it's an operand (number), push it onto the stack
            if (Character.isDigit(token.charAt(0)) ||
                    (token.length() > 1 && token.charAt(0) == '-')) {
                st.push(Integer.parseInt(token));
            }

            // Otherwise, it must be an operator
            else {
                int val1 = st.pop();
                int val2 = st.pop();

                if (token.equals("+")) st.push(val1 + val2);
                else if (token.equals("-")) st.push(val1 - val2);
                else if (token.equals("*")) st.push(val1 * val2);
                else if (token.equals("/")) st.push(floorDiv(val1, val2));
                else if (token.equals("^")) st.push((int) Math.pow(val1, val2));
            }
        }
        return st.pop();
    }

    static int floorDiv(int a, int b) {
        if (a * b < 0 && a % b != 0)
            return (a / b) - 1;
        return a / b;
    }
}
