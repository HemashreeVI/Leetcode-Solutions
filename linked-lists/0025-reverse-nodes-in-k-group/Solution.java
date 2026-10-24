/**
 * 25. Reverse Nodes in k-Group  (Hard)
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 *
 * Intuition: process the list in blocks of k. For each block: check that k
 *            nodes exist, reverse just those k nodes, and stitch the reversed
 *            block back between the previous block and the next one. A
 *            leftover block shorter than k stays as it is.
 * Time:  O(n)  each node is visited a constant number of times
 * Space: O(1)
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;         // node just before the current block

        while (true) {
            // 1) find the k-th node of this block; stop if fewer than k remain
            ListNode kth = groupPrev;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }
            if (kth == null) break;

            ListNode groupNext = kth.next;  // first node AFTER the block

            // 2) reverse the block; point the first node at groupNext
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;
            while (curr != groupNext) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // 3) stitch: the old first node is now the block's tail
            ListNode oldFirst = groupPrev.next;
            groupPrev.next = kth;           // kth is the new block head
            groupPrev = oldFirst;           // move on to the next block
        }
        return dummy.next;
    }
}
