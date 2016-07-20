/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        while(pa != null && pb != null && pa != pb) {
            pa = pa.next;
            pb = pb.next;
        }
        if(pa == pb) {
            return pa;
        }
        if(pa == null) {
            pa = headB;
            pb = pb.next;
        }
        if(pb == null) {
            pb = headA;
            pa = pa.next;
        }
        
        while(pa != null && pb != null && pa != pb) {
            pa = pa.next;
            pb = pb.next;
        }
        
        if(pa == pb) {
            return pa;
        }
        if(pa == null) {
            pa = headB;
            pb = pb.next;
        }
        if(pb == null) {
            pb = headA;
            pa = pa.next;
        }
        while(pa != null && pb != null && pa != pb) {
            pa = pa.next;
            pb = pb.next;
        }
        return (pa == pb ? pa : null);        
        
    }
}