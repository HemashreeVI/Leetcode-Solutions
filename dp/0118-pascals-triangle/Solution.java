import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle  (Easy)
 * https://leetcode.com/problems/pascals-triangle/
 *
 * Intuition: each row starts and ends with 1, and every inner value is the
 *            sum of the two values directly above it:
 *            row[j] = prev[j-1] + prev[j]
 * Time:  O(numRows^2)
 * Space: O(1)  extra (output not counted)
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);                                 // edges are always 1
                } else {
                    List<Integer> prev = triangle.get(i - 1);
                    row.add(prev.get(j - 1) + prev.get(j));     // sum of the two above
                }
            }
            triangle.add(row);
        }
        return triangle;
    }
}
