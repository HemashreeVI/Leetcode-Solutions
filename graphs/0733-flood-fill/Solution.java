import java.util.ArrayDeque;

/**
 * 733. Flood Fill  (Easy)
 * https://leetcode.com/problems/flood-fill/
 *
 * Intuition: the paint-bucket tool. Start at (sr, sc) and spread to every
 *            pixel connected to it (up, down, left, right) that has the SAME
 *            starting colour, repainting as you go. It's the same flood fill
 *            as Number of Islands (200), just counting nothing.
 *            One catch: if the new colour equals the old one, there's nothing
 *            to do, and without that check the fill would never know which
 *            pixels it already painted.
 * Time:  O(m·n)  each pixel is painted at most once
 * Space: O(m·n)  the stack in the worst case (the whole image is one colour)
 */
class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int old = image[sr][sc];
        if (old == color) return image;            // already that colour: nothing changes

        int rows = image.length, cols = image[0].length;
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        image[sr][sc] = color;                     // paint when pushing, so no pixel is pushed twice
        stack.push(new int[]{sr, sc});

        while (!stack.isEmpty()) {
            int[] p = stack.pop();
            for (int[] d : DIRS) {
                int r = p[0] + d[0], c = p[1] + d[1];
                if (r >= 0 && r < rows && c >= 0 && c < cols && image[r][c] == old) {
                    image[r][c] = color;
                    stack.push(new int[]{r, c});
                }
            }
        }
        return image;
    }
}
