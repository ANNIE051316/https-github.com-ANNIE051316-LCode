/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }
        
        ListNode slow = head, fast = head;
        
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        fast = slow.next;
        while(fast != null && fast.next != null) {
            ListNode tmp = fast.next;
            fast.next = tmp.next;
            tmp.next = slow.next;
            slow.next = tmp;
        }
        boolean flag = true;
        fast = slow.next;
        ListNode node = head;
        while(fast != null) {
            if(fast.val != node.val) {
                flag = false;
                break;
            }
            fast = fast.next;
            node = node.next;
        }
        
        fast = slow.next;
        while(fast != null && fast.next != null) {
            ListNode tmp = fast.next;
            fast.next = tmp.next;
            tmp.next = slow.next;
            slow.next = tmp;
        }
        
        return flag;
    }
}