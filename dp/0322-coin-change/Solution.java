import java.util.Arrays;

/**
 * 322. Coin Change  (Medium)
 * https://leetcode.com/problems/coin-change/
 *
 * Intuition: dp[a] = fewest coins to make amount a. To make `a`, the last
 *            coin is some c, so dp[a] = 1 + dp[a - c] for the best c.
 *            Build the table from 0 up to amount.
 * Time:  O(amount * coins)
 * Space: O(amount)
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);    // "infinity": more coins than could ever be needed
        dp[0] = 0;                      // zero coins make amount 0

        for (int a = 1; a <= amount; a++) {
            for (int coin : coins) {
                if (coin <= a) {
                    dp[a] = Math.min(dp[a], dp[a - coin] + 1);  // use this coin last
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];   // still "infinity" -> impossible
    }
}
