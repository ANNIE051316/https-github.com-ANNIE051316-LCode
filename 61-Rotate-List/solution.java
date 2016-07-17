/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return head;
        }
        
        ListNode tmp = head;
        int count = 0;
        ListNode tail = head;
        while(tmp != null) {
            count++;
            if(tmp.next == null) {
                tail = tmp;
            }
            tmp = tmp.next;
        }
        
        k = k % count;
        
        int precount = count - k;
        tail.next = head;
        while(precount != 1) {
            precount--;
            head = head.next;
        }
        
        ListNode newhead = head.next;
        head.next = null;
        return newhead;
        
    }
}