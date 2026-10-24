/**
 * 1920. Build Array from Permutation  (Easy)
 * https://leetcode.com/problems/build-array-from-permutation/
 *
 * Intuition: just follow the definition ans[i] = nums[nums[i]].
 *            nums is a permutation of 0..n-1, so nums[i] is always a
 *            valid index.
 * Time:  O(n)
 * Space: O(n)  for the answer array
 */
class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[nums[i]];     // use nums[i] as an index into nums
        }
        return ans;
    }
}
