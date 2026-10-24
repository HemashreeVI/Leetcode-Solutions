import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 150. Evaluate Reverse Polish Notation  (Medium)
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 *
 * Intuition: in RPN an operator always applies to the two most recent
 *            values, so keep values on a stack. On an operator, pop two,
 *            compute, and push the result back.
 * Time:  O(n)
 * Space: O(n)
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            switch (token) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "-" -> {
                    int b = stack.pop(), a = stack.pop();   // order matters: a - b
                    stack.push(a - b);
                }
                case "/" -> {
                    int b = stack.pop(), a = stack.pop();   // order matters: a / b
                    stack.push(a / b);                      // Java truncates toward zero
                }
                default -> stack.push(Integer.parseInt(token));   // a number
            }
        }
        return stack.pop();
    }
}
