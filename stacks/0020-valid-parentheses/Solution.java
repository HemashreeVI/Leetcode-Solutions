import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 20. Valid Parentheses  (Easy)
 * https://leetcode.com/problems/valid-parentheses/
 *
 * Intuition: the most recently opened bracket must be the first one closed,
 *            which is exactly Last-In-First-Out, so use a stack. Push the
 *            closing bracket we EXPECT; when a closer arrives it must match the top.
 * Time:  O(n)
 * Space: O(n)  stack in the worst case (all openers)
 */
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');            // remember which closer we need
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;               // closer with no opener, or wrong type
            }
        }
        return stack.isEmpty();             // every opener must be closed
    }
}
