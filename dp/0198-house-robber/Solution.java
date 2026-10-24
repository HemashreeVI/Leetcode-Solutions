/**
 * 198. House Robber  (Medium)
 * https://leetcode.com/problems/house-robber/
 *
 * Intuition: at each house you either
 *              - skip it  -> keep the best total up to the previous house, or
 *              - rob it   -> its money + best total up to two houses back.
 *            best(i) = max(best(i-1), best(i-2) + nums[i]). Only the last
 *            two values are needed.
 * Time:  O(n)
 * Space: O(1)
 */
class Solution {
    public int rob(int[] nums) {
        int twoBack = 0;    // best total up to house i-2
        int oneBack = 0;    // best total up to house i-1

        for (int money : nums) {
            int current = Math.max(oneBack, twoBack + money);   // skip vs rob
            twoBack = oneBack;
            oneBack = current;
        }
        return oneBack;
    }
}
