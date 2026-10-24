/**
 * 1480. Running Sum of 1d Array  (Easy)
 * https://leetcode.com/problems/running-sum-of-1d-array/
 *
 * Intuition: runningSum[i] = runningSum[i-1] + nums[i]. Each answer
 *            builds on the previous one, so we can do it in place.
 * Time:  O(n)
 * Space: O(1)  (we reuse the input array)
 */
class Solution {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];     // add everything before me (already summed)
        }
        return nums;
    }
}
