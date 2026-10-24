/**
 * 2906. Construct Product Matrix  (Medium)
 * https://leetcode.com/problems/construct-product-matrix/
 *
 * Intuition: p[i][j] = product of ALL other cells. Division isn't safe under
 *            a modulus (12345 isn't prime, and cells can be multiples of it),
 *            so flatten the grid into one long row and use
 *            product = (prefix product before me) * (suffix product after me).
 * Time:  O(n * m)
 * Space: O(1)  extra besides the answer matrix
 */
class Solution {
    private static final int MOD = 12345;

    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] p = new int[n][m];

        // pass 1 (forward): p[i][j] = product of every cell BEFORE (i, j)
        long prefix = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                p[i][j] = (int) prefix;
                prefix = (prefix * (grid[i][j] % MOD)) % MOD;
            }
        }

        // pass 2 (backward): multiply by the product of every cell AFTER (i, j)
        long suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                p[i][j] = (int) ((p[i][j] * suffix) % MOD);
                suffix = (suffix * (grid[i][j] % MOD)) % MOD;
            }
        }
        return p;
    }
}
