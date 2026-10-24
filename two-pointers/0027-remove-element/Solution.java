/**
 * 27. Remove Element  (Easy)
 * https://leetcode.com/problems/remove-element/
 *
 * Intuition: copy every element that is NOT val to the front of the array.
 *            A write pointer k tracks where the next kept element goes.
 * Time:  O(n)
 * Space: O(1)  in place
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;                      // next write position
        for (int num : nums) {
            if (num != val) {
                nums[k++] = num;        // keep it
            }
        }
        return k;                       // number of elements kept
    }
}
