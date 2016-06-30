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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy, j = dummy;
        while(j.next != null) {
            if(j.val < 9) {
                i = j;
            }
            j = j.next;
        }
        
        if(j.val < 9) {
            j.val++;
        }
        else {
            i.val++;
            while(i.next != null) {
                i = i.next;
                i.val = 0;
            }
        }
        
        return dummy.val == 0 ? dummy.next : dummy;
    }
}