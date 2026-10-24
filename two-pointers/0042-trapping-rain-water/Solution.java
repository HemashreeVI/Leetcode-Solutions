/**
 * 42. Trapping Rain Water  (Hard)
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * Intuition: water above bar i = min(tallest bar on its left,
 *            tallest bar on its right) - height[i].
 *            With two pointers, whichever side has the SMALLER max is the
 *            limiting wall, so we can settle that side's water right away.
 * Time:  O(n)
 * Space: O(1)
 */
class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;      // tallest wall seen from each side
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                // right side has a wall at least this tall, so the left max decides
                if (height[left] >= leftMax) {
                    leftMax = height[left];             // new wall, holds no water itself
                } else {
                    water += leftMax - height[left];    // trapped above this bar
                }
                left++;
            } else {
                // left side has a wall at least this tall, so the right max decides
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }
}
