/**
 * 35. Search Insert Position  (Easy)
 * https://leetcode.com/problems/search-insert-position/
 *
 * Intuition: classic binary search. If the target isn't found, `lo` ends at
 *            the first index whose value is bigger than target, which is
 *            exactly where it should be inserted.
 * Time:  O(log n)
 * Space: O(1)
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;   // avoids int overflow of (lo + hi)
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lo = mid + 1;               // target is in the right half
            } else {
                hi = mid - 1;               // target is in the left half
            }
        }
        return lo;                          // insertion point
    }
}
