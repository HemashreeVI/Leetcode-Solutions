/**
 * 58. Length of Last Word  (Easy)
 * https://leetcode.com/problems/length-of-last-word/
 *
 * Intuition: walk from the END of the string. Skip trailing spaces, then
 *            count letters until the next space (or the start).
 * Time:  O(n)
 * Space: O(1)
 */
class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;

        while (i >= 0 && s.charAt(i) == ' ') {
            i--;                    // skip trailing spaces
        }

        int length = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;               // count letters of the last word
            i--;
        }
        return length;
    }
}
