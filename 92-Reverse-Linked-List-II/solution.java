/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, p1 = head;
        int move = n - m;
        while(m != 1) {
            p1 = p1.next;
            prev = prev.next;
            m--;
        }
        
        while(move > 0) {
            ListNode tmp = p1.next;
            p1.next = p1.next.next;
            tmp.next = prev.next;
            prev.next = tmp;
            move--;
        }
        
        return dummy.next;
    }
}