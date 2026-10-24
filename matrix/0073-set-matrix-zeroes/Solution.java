/**
 * 73. Set Matrix Zeroes  (Medium)
 * https://leetcode.com/problems/set-matrix-zeroes/
 *
 * Intuition: we must remember which rows/cols contain a 0 before we start
 *            writing zeros. Instead of extra arrays, use the FIRST ROW and
 *            FIRST COLUMN of the matrix itself as markers. Two booleans
 *            remember whether row 0 / col 0 themselves need zeroing.
 * Time:  O(m * n)
 * Space: O(1)
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstRowZero = false, firstColZero = false;

        for (int c = 0; c < n; c++) if (matrix[0][c] == 0) firstRowZero = true;
        for (int r = 0; r < m; r++) if (matrix[r][0] == 0) firstColZero = true;

        // 1) use row 0 / col 0 as markers for the rest of the matrix
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;   // mark row r
                    matrix[0][c] = 0;   // mark column c
                }
            }
        }

        // 2) zero the inner cells using the markers
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        // 3) finally handle the first row and column themselves
        if (firstRowZero) for (int c = 0; c < n; c++) matrix[0][c] = 0;
        if (firstColZero) for (int r = 0; r < m; r++) matrix[r][0] = 0;
    }
}
