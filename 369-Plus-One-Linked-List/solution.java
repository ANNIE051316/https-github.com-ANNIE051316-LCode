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
        int carry = helper(head, 1);
        if(carry == 0) {
            return head;
        }
        else {
            ListNode h = new ListNode(carry);
            h.next = head;
            return h;
        }
    }
    
    public int helper(ListNode node, int carry) {
        if(node == null || carry == 0) {
            return carry;
        }
        
        carry =  helper(node.next, carry);
        
        carry += node.val;
        node.val = carry % 10;
        carry /= 10;
        return carry;
        
    }
}