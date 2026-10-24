/**
 * 21. Merge Two Sorted Lists  (Easy)
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * Intuition: like merging two sorted piles of cards: repeatedly take the
 *            smaller front card. A dummy head avoids special-casing the
 *            first node.
 * Time:  O(m + n)
 * Space: O(1)  we re-link existing nodes
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);   // fake head, the answer is dummy.next
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;          // take from list1
                list1 = list1.next;
            } else {
                tail.next = list2;          // take from list2
                list2 = list2.next;
            }
            tail = tail.next;
        }

        tail.next = (list1 != null) ? list1 : list2;   // attach whatever is left
        return dummy.next;
    }
}
