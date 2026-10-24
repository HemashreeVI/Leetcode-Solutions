/**
 * 70. Climbing Stairs  (Easy)
 * https://leetcode.com/problems/climbing-stairs/
 *
 * Intuition: to stand on step i, your last move was either 1 step (from i-1)
 *            or 2 steps (from i-2). So ways(i) = ways(i-1) + ways(i-2),
 *            which is the Fibonacci sequence. Only the last two values are needed.
 * Time:  O(n)
 * Space: O(1)
 */
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int twoBack = 1;    // ways to reach step 1
        int oneBack = 2;    // ways to reach step 2
        for (int i = 3; i <= n; i++) {
            int current = oneBack + twoBack;
            twoBack = oneBack;
            oneBack = current;
        }
        return oneBack;
    }
}
