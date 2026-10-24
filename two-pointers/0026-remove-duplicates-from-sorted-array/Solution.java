/**
 * 26. Remove Duplicates from Sorted Array  (Easy)
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * Intuition: the array is sorted, so duplicates sit next to each other.
 *            A slow pointer marks where the next UNIQUE value goes, and
 *            a fast pointer scans ahead looking for new values.
 * Time:  O(n)
 * Space: O(1)  in place
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int k = 1;                              // nums[0..k-1] are the unique values so far
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {       // a value we haven't kept yet
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
