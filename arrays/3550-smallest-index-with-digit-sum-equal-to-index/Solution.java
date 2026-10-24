/**
 * 3550. Smallest Index With Digit Sum Equal to Index  (Easy)
 * https://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index/
 *
 * Intuition: scan left to right. The first index i whose number's digit sum
 *            equals i is automatically the smallest one.
 * Time:  O(n * d)  d = number of digits per element
 * Space: O(1)
 */
class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (digitSum(nums[i]) == i) {
                return i;           // first match = smallest index
            }
        }
        return -1;                  // no index matched
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;        // take the last digit
            num /= 10;              // drop the last digit
        }
        return sum;
    }
}
