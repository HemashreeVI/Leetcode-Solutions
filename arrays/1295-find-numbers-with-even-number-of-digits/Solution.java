/**
 * 1295. Find Numbers with Even Number of Digits  (Easy)
 * https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 *
 * Intuition: count the digits of each number by repeatedly dividing by 10,
 *            then check whether that count is even.
 * Time:  O(n * d)  d = digits per number (at most 6 here)
 * Space: O(1)
 */
class Solution {
    public int findNumbers(int[] nums) {
        int answer = 0;
        for (int num : nums) {
            if (countDigits(num) % 2 == 0) {
                answer++;
            }
        }
        return answer;
    }

    private int countDigits(int num) {
        int digits = 0;
        while (num > 0) {
            num /= 10;      // chop off the last digit
            digits++;
        }
        return digits;
    }
}
