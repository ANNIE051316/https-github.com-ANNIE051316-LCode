/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        int pre = 0;
        ListNode p1 = head;
        while(p1 != null) {
            if(p1 == head) {
                if(p1.next == null || p1.next.val != p1.val) {
                    prev.next = p1;
                    prev = prev.next;
                }
            }
            else if(p1.val != pre && (p1.next == null || p1.next.val != p1.val)){
                prev.next = p1;
                prev = prev.next;
            }
            pre = p1.val;
            p1 = p1.next;
        }
        
        prev.next = null;
        return dummy.next;
    }
}