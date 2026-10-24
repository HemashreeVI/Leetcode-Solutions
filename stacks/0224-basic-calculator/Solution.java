import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 224. Basic Calculator  (Hard)
 * https://leetcode.com/problems/basic-calculator/
 *
 * Intuition: with only + and -, an expression is just a running sum of
 *            signed numbers. Parentheses only change the SIGN that applies
 *            inside them. When we see '(', save the current result and sign
 *            on a stack and start fresh; on ')', combine with what we saved.
 * Time:  O(n)
 * Space: O(n)  stack depth = nesting depth
 */
class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;     // running total at the current parenthesis level
        int number = 0;     // number being read digit by digit
        int sign = 1;       // sign in front of the current number (+1 or -1)

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');           // build multi-digit numbers
            } else if (c == '+' || c == '-') {
                result += sign * number;                    // finish the previous number
                number = 0;
                sign = (c == '+') ? 1 : -1;
            } else if (c == '(') {
                stack.push(result);                         // save outer total
                stack.push(sign);                           // save sign before '('
                result = 0;                                 // start fresh inside
                sign = 1;
            } else if (c == ')') {
                result += sign * number;                    // finish the last inner number
                number = 0;
                int signBefore = stack.pop();
                int outerResult = stack.pop();
                result = outerResult + signBefore * result; // apply the group to the outer total
            }
            // spaces are ignored
        }
        return result + sign * number;                      // add the final number
    }
}
