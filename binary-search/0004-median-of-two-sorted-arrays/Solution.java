/**
 * 4. Median of Two Sorted Arrays  (Hard)
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * Intuition: the median splits all numbers into a LEFT half and a RIGHT half
 *            where every left value <= every right value. Binary search on how
 *            many elements to take from the smaller array (i); the rest of the
 *            left half (j) comes from the other array. A cut is correct when
 *            A[i-1] <= B[j] and B[j-1] <= A[i].
 * Time:  O(log(min(m, n)))
 * Space: O(1)
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // always binary search the SHORTER array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int half = (m + n + 1) / 2;         // size of the left half (gets the extra one if odd)
        int lo = 0, hi = m;

        while (lo <= hi) {
            int i = (lo + hi) / 2;          // take i from nums1
            int j = half - i;               // and j from nums2

            // values around the cut (use infinities when a side is empty)
            int aLeft  = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int aRight = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int bLeft  = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int bRight = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (aLeft <= bRight && bLeft <= aRight) {
                // correct partition found
                if ((m + n) % 2 == 1) {
                    return Math.max(aLeft, bLeft);
                }
                return (Math.max(aLeft, bLeft) + (double) Math.min(aRight, bRight)) / 2.0;
            } else if (aLeft > bRight) {
                hi = i - 1;                 // took too many from nums1
            } else {
                lo = i + 1;                 // took too few from nums1
            }
        }
        return 0.0;   // unreachable for valid (sorted) input
    }
}
