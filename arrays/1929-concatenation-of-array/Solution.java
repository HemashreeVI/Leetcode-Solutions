/**
 * 1929. Concatenation of Array  (Easy)
 * https://leetcode.com/problems/concatenation-of-array/
 *
 * Intuition: ans has length 2n, and both halves are copies of nums:
 *            ans[i] = nums[i] and ans[i + n] = nums[i].
 * Time:  O(n)
 * Space: O(n)  for the answer array
 */
class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];           // first half
            ans[i + n] = nums[i];       // second half
        }
        return ans;
    }
}
