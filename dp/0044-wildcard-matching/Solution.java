/**
 * 44. Wildcard Matching  (Hard)
 * https://leetcode.com/problems/wildcard-matching/
 *
 * Intuition: dp[i][j] = does s[0..i) match p[0..j)?
 *            - letter or '?': must match one char -> dp[i-1][j-1]
 *            - '*': either matches NOTHING (dp[i][j-1]) or swallows one more
 *              char of s and stays (dp[i-1][j]).
 * Time:  O(m * n)
 * Space: O(m * n)
 */
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;                                    // empty matches empty

        // empty s can only be matched by a pattern made entirely of '*'
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && p.charAt(j - 1) == '*';
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pc = p.charAt(j - 1);
                if (pc == '*') {
                    // '*' matches empty (skip it)  OR  matches s[i-1] and keeps going
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (pc == '?' || pc == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];            // one-to-one match
                }
                // else: stays false
            }
        }
        return dp[m][n];
    }
}
