/**
 * 32. Longest Valid Parentheses  (Hard)
 * https://leetcode.com/problems/longest-valid-parentheses/
 *
 * Intuition: dp[i] = length of the longest valid substring that ENDS at i.
 *            A valid substring can only end with ')'.
 *            - "...()"  : dp[i] = dp[i-2] + 2
 *            - "...))"  : s[i-1] closes a block of length dp[i-1]; if the
 *              char just before that block is '(', it matches s[i]:
 *              dp[i] = dp[i-1] + 2 + dp[before that '(' - 1]
 * Time:  O(n)
 * Space: O(n)
 */
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];      // dp[i] = longest valid substring ending at i
        int best = 0;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != ')') continue;           // must end with ')'

            if (s.charAt(i - 1) == '(') {
                // case "...()": pair with the previous char
                dp[i] = 2 + (i >= 2 ? dp[i - 2] : 0);
            } else {
                // case "...))": jump over the valid block that ends at i-1
                int open = i - dp[i - 1] - 1;           // index that should be '('
                if (open >= 0 && s.charAt(open) == '(') {
                    dp[i] = dp[i - 1] + 2 + (open >= 1 ? dp[open - 1] : 0);
                }
            }
            best = Math.max(best, dp[i]);
        }
        return best;
    }
}
