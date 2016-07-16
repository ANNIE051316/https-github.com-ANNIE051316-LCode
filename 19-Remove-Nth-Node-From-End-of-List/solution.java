/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, fast = dummy;
        while(fast.next != null && n > 0) {
            fast = fast.next;
            n--;
        }
        
        while(fast.next != null) {
            fast = fast.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return dummy.next;
    }
}