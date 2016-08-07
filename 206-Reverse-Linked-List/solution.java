/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while(head.next != null) {
            ListNode tmp = head.next;
            head.next = tmp.next;
            tmp.next = dummy.next;
            dummy.next = tmp;
        }
        
        return dummy.next;
    }
}