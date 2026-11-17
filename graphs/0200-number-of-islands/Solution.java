import java.util.ArrayDeque;

/**
 * 200. Number of Islands  (Medium)
 * https://leetcode.com/problems/number-of-islands/
 *
 * Intuition: the grid is a GRAPH in disguise. Every '1' is a node, and it's
 *            connected to the '1's directly up, down, left and right. An island
 *            is a connected component. So: scan the grid; every time you find
 *            land you haven't visited, that's a new island. Flood-fill it
 *            (BFS) and "sink" every cell of it to '0' so it's never counted
 *            again.
 * Time:  O(m·n)          every cell is visited a constant number of times
 * Space: O(min(m, n))    the BFS queue (the grid itself marks what's visited)
 */
class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length, islands = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] != '1') continue;   // water, or land we already sank

                islands++;                         // unvisited land = a new island
                sink(grid, r, c);
            }
        }
        return islands;
    }

    // BFS from (r, c), turning the whole island into water
    private void sink(char[][] grid, int r, int c) {
        int rows = grid.length, cols = grid[0].length;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        grid[r][c] = '0';                          // mark when ADDING, so nothing is queued twice
        queue.add(new int[]{r, c});

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : DIRS) {
                int nr = cell[0] + d[0], nc = cell[1] + d[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1') {
                    grid[nr][nc] = '0';
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }
}
