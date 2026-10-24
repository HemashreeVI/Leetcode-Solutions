/**
 * 88. Merge Sorted Array  (Easy)
 * https://leetcode.com/problems/merge-sorted-array/
 *
 * Intuition: nums1 has empty space at the END. If we fill from the back
 *            (placing the largest remaining element each time), we never
 *            overwrite a number of nums1 we haven't used yet.
 * Time:  O(m + n)
 * Space: O(1)
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;          // last real element of nums1
        int j = n - 1;          // last element of nums2
        int write = m + n - 1;  // last slot of nums1

        while (j >= 0) {        // once nums2 is used up, nums1's rest is already in place
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[write--] = nums1[i--];
            } else {
                nums1[write--] = nums2[j--];
            }
        }
    }
}
