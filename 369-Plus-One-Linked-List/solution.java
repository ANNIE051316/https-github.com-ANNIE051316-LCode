/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        if(head == null) {
            return new ListNode(1);
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int carry = 1;
        while(head.next != null) {
            ListNode tmp = head.next;
            head.next = tmp.next;
            tmp.next = dummy.next;
            dummy.next = tmp;
        }
        
        ListNode cur = dummy.next;
        while(carry != 0) {
            carry += cur.val;
            cur.val = carry % 10;
            carry /= 10;
            if(cur.next == null) {
                if(carry != 0) {
                    cur.next = new ListNode(carry);
                }
                break;
            } 
            cur = cur.next;
        }
        cur = dummy.next;
        while(cur.next != null) {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = dummy.next;
            dummy.next = tmp;
        }
        
        return dummy.next;
        
    }
}