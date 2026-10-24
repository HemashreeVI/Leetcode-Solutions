/**
 * 143. Reorder List  (Medium)
 * https://leetcode.com/problems/reorder-list/
 *
 * Intuition: L0 -> Ln -> L1 -> Ln-1 ... alternates between the front half
 *            and the BACK half read backwards. So:
 *            1) find the middle, 2) reverse the second half,
 *            3) weave the two halves together.
 * Time:  O(n)
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 1) find the middle (slow ends at the end of the first half)
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2) reverse the second half and cut it off from the first half
        ListNode second = reverse(slow.next);
        slow.next = null;

        // 3) weave: first1 -> second1 -> first2 -> second2 ...
        ListNode first = head;
        while (second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}
