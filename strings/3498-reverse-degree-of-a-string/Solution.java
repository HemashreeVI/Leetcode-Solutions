/**
 * 3498. Reverse Degree of a String  (Easy)
 * https://leetcode.com/problems/reverse-degree-of-a-string/
 *
 * Intuition: in the reversed alphabet 'a' = 26, 'b' = 25, ..., 'z' = 1,
 *            which is just 26 - (c - 'a'). Multiply it by the 1-indexed
 *            position in the string and add everything up.
 * Time:  O(n)
 * Space: O(1)
 */
class Solution {
    public int reverseDegree(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int reversedValue = 26 - (s.charAt(i) - 'a');   // 'a' -> 26, 'z' -> 1
            total += reversedValue * (i + 1);               // positions are 1-indexed
        }
        return total;
    }
}
