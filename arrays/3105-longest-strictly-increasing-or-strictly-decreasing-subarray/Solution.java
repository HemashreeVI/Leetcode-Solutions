/**
 * 3105. Longest Strictly Increasing or Strictly Decreasing Subarray  (Easy)
 * https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/
 *
 * Intuition: walk the array once and keep two running lengths that END at i:
 *            `inc` = longest strictly increasing run, `dec` = longest strictly
 *            decreasing run. Compare nums[i] with nums[i-1]:
 *              bigger  -> inc grows, dec restarts at 1
 *              smaller -> dec grows, inc restarts at 1
 *              equal   -> both restart at 1 (equal is not "strictly")
 *            The answer is the biggest value either run ever reaches.
 * Time:  O(n)  one pass
 * Space: O(1)  three counters
 */
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1, dec = 1, best = 1;   // a single element is a valid run

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {          // still going up
                inc++;
                dec = 1;
            } else if (nums[i] < nums[i - 1]) {   // still going down
                dec++;
                inc = 1;
            } else {                              // equal breaks both runs
                inc = 1;
                dec = 1;
            }
            best = Math.max(best, Math.max(inc, dec));
        }
        return best;
    }
}
