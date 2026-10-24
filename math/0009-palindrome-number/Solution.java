/**
 * 9. Palindrome Number  (Easy)
 * https://leetcode.com/problems/palindrome-number/
 *
 * Intuition: reverse only the SECOND HALF of the number and compare it with
 *            the first half. No string conversion, and no overflow because we
 *            never build the full reversed number.
 * Time:  O(log10 x)  we process half of the digits
 * Space: O(1)
 */
class Solution {
    public boolean isPalindrome(int x) {
        // negatives are never palindromes; numbers ending in 0 can't be either (except 0)
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {          // stop once we've reached the middle
            reversedHalf = reversedHalf * 10 + x % 10;   // move last digit of x over
            x /= 10;
        }

        // even length: x == reversedHalf
        // odd length:  the middle digit sits at the end of reversedHalf, so drop it
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
