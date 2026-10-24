/**
 * 14. Longest Common Prefix  (Easy)
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * Intuition: start by assuming the whole first word is the prefix, then
 *            shorten it until every other word starts with it.
 * Time:  O(S)  S = total number of characters across all words
 * Space: O(1)  apart from the returned string
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);  // drop last char
                if (prefix.isEmpty()) {
                    return "";      // nothing in common at all
                }
            }
        }
        return prefix;
    }
}
