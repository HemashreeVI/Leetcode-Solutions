import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix  (Medium)
 * https://leetcode.com/problems/spiral-matrix/
 *
 * Intuition: keep four walls (top, bottom, left, right). Walk along the
 *            top row, right column, bottom row and left column, moving each
 *            wall inward after it has been read.
 * Time:  O(m * n)
 * Space: O(1)  extra (output not counted)
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int c = left; c <= right; c++) result.add(matrix[top][c]);      // → along top
            top++;

            for (int r = top; r <= bottom; r++) result.add(matrix[r][right]);    // ↓ down right
            right--;

            if (top <= bottom) {                                                 // a row is left
                for (int c = right; c >= left; c--) result.add(matrix[bottom][c]);   // ← along bottom
                bottom--;
            }
            if (left <= right) {                                                 // a column is left
                for (int r = bottom; r >= top; r--) result.add(matrix[r][left]);     // ↑ up left
                left++;
            }
        }
        return result;
    }
}
