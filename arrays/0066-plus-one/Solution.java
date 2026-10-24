/**
 * 66. Plus One  (Easy)
 * https://leetcode.com/problems/plus-one/
 *
 * Intuition: add 1 like we do on paper, starting from the last digit.
 *            A digit < 9 just increments and we're done. A 9 becomes 0
 *            and the carry moves left. If every digit was 9 (e.g. 999),
 *            the answer is 1 followed by zeros (1000).
 * Time:  O(n)
 * Space: O(1)  extra (O(n) only in the all-9s case for the new array)
 */
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;        // no carry needed, finished
                return digits;
            }
            digits[i] = 0;          // 9 + 1 = 10 -> write 0, carry 1 to the left
        }

        // we only get here if all digits were 9, e.g. [9,9,9] -> [1,0,0,0]
        int[] result = new int[digits.length + 1];
        result[0] = 1;              // Java arrays start as all zeros
        return result;
    }
}
