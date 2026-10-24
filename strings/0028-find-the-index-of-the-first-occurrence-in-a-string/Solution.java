/**
 * 28. Find the Index of the First Occurrence in a String  (Easy)
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 *
 * Intuition: slide a window the size of `needle` across `haystack` and
 *            compare character by character at every starting position.
 * Time:  O(n * m)  n = haystack length, m = needle length
 * Space: O(1)
 */
class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();

        for (int start = 0; start + m <= n; start++) {      // every place needle could fit
            int j = 0;
            while (j < m && haystack.charAt(start + j) == needle.charAt(j)) {
                j++;                                        // characters keep matching
            }
            if (j == m) {
                return start;                               // matched the whole needle
            }
        }
        return -1;
    }
}
