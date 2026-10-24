import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number  (Medium)
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * Intuition: for each digit we choose ONE of its letters, then move to the
 *            next digit. That's a decision tree; walking it with recursion
 *            (backtracking) lists every combination.
 * Time:  O(4^n * n)  up to 4 letters per digit, n characters per string
 * Space: O(n)  recursion depth (not counting the output)
 */
class Solution {
    private static final String[] KEYPAD = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) return result;
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder path, List<String> result) {
        if (index == digits.length()) {
            result.add(path.toString());            // picked one letter for every digit
            return;
        }

        String letters = KEYPAD[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            path.append(letter);                    // choose
            backtrack(digits, index + 1, path, result);   // explore
            path.deleteCharAt(path.length() - 1);   // un-choose (backtrack)
        }
    }
}
