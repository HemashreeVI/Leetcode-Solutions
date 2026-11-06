import java.util.Arrays;

/**
 * 2747. Count Zero Request Servers  (Medium)
 * https://leetcode.com/problems/count-zero-request-servers/
 *
 * Intuition: sort the queries by time so the window [q - x, q] only slides
 *            forward. Each log enters the window once (right pointer) and
 *            leaves once (left pointer); count[] tracks requests per server
 *            inside the window, and `active` = servers with count > 0.
 *            Answer = n - active.
 * Time:  O(L log L + Q log Q)  sorting; after that each log moves in/out once
 * Space: O(n + Q)  per-server counts + the sorted query order
 */
class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> a[1] - b[1]);              // logs by time

        int q = queries.length;
        Integer[] order = new Integer[q];                       // query indices
        for (int i = 0; i < q; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> queries[a] - queries[b]);  // by query time

        int[] count = new int[n + 1];   // requests per server inside the window
        int active = 0;                 // servers with at least one request
        int left = 0, right = 0;
        int[] ans = new int[q];

        for (int idx : order) {
            int end = queries[idx], start = end - x;

            // add logs that are now inside the window (time <= end)
            while (right < logs.length && logs[right][1] <= end) {
                if (count[logs[right][0]]++ == 0) active++;
                right++;
            }
            // drop logs that fell out of the window (time < start)
            while (left < right && logs[left][1] < start) {
                if (--count[logs[left][0]] == 0) active--;
                left++;
            }
            ans[idx] = n - active;      // everyone else got zero requests
        }
        return ans;
    }
}
