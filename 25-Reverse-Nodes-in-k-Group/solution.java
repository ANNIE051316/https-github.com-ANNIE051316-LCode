/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        prev.next = head;
        ListNode p1 = head, p2 = head;
        while(p2 != null) {
            int count = 0;
            while(p2 != null && count < k) {
                p2 = p2.next;
                count++;
            }
            
            if(count < k) {
                break;
            }
            
            while(p1.next != p2) {
                ListNode tmp = p1.next;
                p1.next = tmp.next;
                tmp.next = prev.next;
                prev.next = tmp;
            }
            prev = p1;
            p1 = p2;
        }
        
        return dummy.next;
    }
}