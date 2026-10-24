import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses  (Medium)
 * https://leetcode.com/problems/generate-parentheses/
 *
 * Intuition: build the string one char at a time, but only make VALID moves:
 *            - we may add '(' while we still have some left (open < n)
 *            - we may add ')' only if it closes something (close < open)
 *            Following only valid moves means every finished string is valid.
 * Time:  O(4^n / sqrt(n))  the n-th Catalan number of results
 * Space: O(n)  recursion depth
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int n, int open, int close, StringBuilder path, List<String> result) {
        if (path.length() == 2 * n) {
            result.add(path.toString());
            return;
        }
        if (open < n) {                     // can still open a new pair
            path.append('(');
            backtrack(n, open + 1, close, path, result);
            path.deleteCharAt(path.length() - 1);
        }
        if (close < open) {                 // there is an unmatched '(' to close
            path.append(')');
            backtrack(n, open, close + 1, path, result);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
