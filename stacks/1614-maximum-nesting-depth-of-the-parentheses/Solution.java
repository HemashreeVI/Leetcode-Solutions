/**
 * 1614. Maximum Nesting Depth of the Parentheses  (Easy)
 * https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
 *
 * Intuition: we don't need an actual stack, only its SIZE. '(' goes one
 *            level deeper and ')' comes back up. Track the deepest level.
 * Time:  O(n)
 * Space: O(1)
 */
class Solution {
    public int maxDepth(String s) {
        int depth = 0, maxDepth = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            } else if (c == ')') {
                depth--;
            }
        }
        return maxDepth;
    }
}
