import java.util.ArrayDeque;

/**
 * 994. Rotting Oranges  (Medium)
 * https://leetcode.com/problems/rotting-oranges/
 *
 * Intuition: rot spreads from EVERY rotten orange at the same time, one
 *            step per minute. That's a breadth-first search with many
 *            starting points (multi-source BFS): put all rotten oranges in
 *            the queue first, then process the queue one LEVEL at a time.
 *            Each level is one minute. Count the fresh oranges up front;
 *            if any are left when the rot stops spreading, they can never
 *            rot, so the answer is -1.
 * Time:  O(m·n)  every cell enters the queue at most once
 * Space: O(m·n)  the queue
 */
class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, fresh = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) queue.add(new int[]{r, c});   // every rotten orange starts at minute 0
                else if (grid[r][c] == 1) fresh++;
            }
        }

        int minutes = 0;
        while (!queue.isEmpty() && fresh > 0) {
            minutes++;                                  // one level of the BFS = one minute
            for (int size = queue.size(); size > 0; size--) {
                int[] o = queue.poll();
                for (int[] d : DIRS) {
                    int r = o[0] + d[0], c = o[1] + d[1];
                    if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == 1) {
                        grid[r][c] = 2;                 // it rots this minute
                        fresh--;
                        queue.add(new int[]{r, c});
                    }
                }
            }
        }
        return fresh == 0 ? minutes : -1;               // someone fresh was unreachable
    }
}
