/**
 * 3483. Unique 3-Digit Even Numbers  (Easy)
 * https://leetcode.com/problems/unique-3-digit-even-numbers/
 *
 * Intuition: there are only 450 three-digit even numbers (100, 102, ..., 998).
 *            Instead of building numbers from the digits (and fighting
 *            duplicates), test each candidate: "can I make it with the
 *            digits I have?" Counting candidates gives distinct numbers for free.
 * Time:  O(450 * 3) = O(1)  plus O(len) to count the digits
 * Space: O(1)  two arrays of size 10
 */
class Solution {
    public int totalNumbers(int[] digits) {
        int[] have = new int[10];               // how many of each digit we own
        for (int d : digits) {
            have[d]++;
        }

        int count = 0;
        for (int num = 100; num <= 998; num += 2) {   // every 3-digit even number
            int[] need = new int[10];
            need[num / 100]++;          // hundreds digit (never 0, so no leading zero)
            need[(num / 10) % 10]++;    // tens digit
            need[num % 10]++;           // units digit (even, since num is even)

            if (canBuild(need, have)) {
                count++;
            }
        }
        return count;
    }

    private boolean canBuild(int[] need, int[] have) {
        for (int d = 0; d < 10; d++) {
            if (need[d] > have[d]) {
                return false;           // we'd use a digit more times than we have it
            }
        }
        return true;
    }
}
