/**
 * 977. Squares of a Sorted Array  (Easy)
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 *
 * Intuition: the biggest square is always at one of the two ENDS (a very
 *            negative number or a very positive one). Compare both ends and
 *            place the larger square at the back of the result.
 * Time:  O(n)
 * Space: O(n)  for the output array
 */
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1;

        for (int pos = n - 1; pos >= 0; pos--) {        // fill from largest to smallest
            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];
            if (leftSq > rightSq) {
                result[pos] = leftSq;
                left++;
            } else {
                result[pos] = rightSq;
                right--;
            }
        }
        return result;
    }
}
