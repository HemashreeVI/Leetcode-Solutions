/**
 * 3675. Minimum Operations to Transform String  (Medium)
 * https://leetcode.com/problems/minimum-operations-to-transform-string/
 *
 * Intuition: one operation shifts ALL copies of a letter c to c+1 (z -> a).
 *            Every letter has to travel forward to 'a'. The letter farthest
 *            from 'a' is the SMALLEST non-'a' letter. As it moves forward, it
 *            merges with every bigger letter it passes, so they ride along for
 *            free. Answer = steps for the smallest non-'a' letter = 26 - (c - 'a').
 * Time:  O(n)
 * Space: O(1)
 */
class Solution {
    public int minOperations(String s) {
        char smallest = '{';                    // the character just after 'z'
        for (char c : s.toCharArray()) {
            if (c != 'a' && c < smallest) {
                smallest = c;                   // smallest letter that still needs work
            }
        }
        if (smallest == '{') {
            return 0;                           // already all 'a'
        }
        return 26 - (smallest - 'a');           // steps from smallest to wrap around to 'a'
    }
}
