/**
 * 1317. Convert Integer to the Sum of Two No-Zero Integers  (Easy)
 * https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/
 *
 * Intuition: try a = 1, 2, 3, ... and b = n - a. The first pair where
 *            neither number contains the digit 0 is a valid answer.
 * Time:  O(n log n)  worst case; in practice a valid a is found very quickly
 * Space: O(1)
 */
class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int a = 1; a < n; a++) {
            int b = n - a;
            if (hasNoZero(a) && hasNoZero(b)) {
                return new int[] { a, b };
            }
        }
        return new int[] {};    // a valid answer is guaranteed
    }

    private boolean hasNoZero(int num) {
        while (num > 0) {
            if (num % 10 == 0) {
                return false;   // found a 0 digit
            }
            num /= 10;
        }
        return true;
    }
}
