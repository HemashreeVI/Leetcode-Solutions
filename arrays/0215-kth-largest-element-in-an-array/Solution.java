import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array  (Medium)
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Intuition: keep only the k biggest numbers seen so far in a MIN-heap.
 *            The smallest of those k (the heap's top) is the k-th largest.
 * Time:  O(n log k)
 * Space: O(k)
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();   // smallest on top

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();     // throw away the smallest, keep the k largest
            }
        }
        return minHeap.peek();      // smallest among the k largest = k-th largest
    }
}
