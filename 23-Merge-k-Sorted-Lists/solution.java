/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        
        return partition(lists, 0, lists.length - 1);
    }
    
    public ListNode partition(ListNode[] lists, int s, int e) {
        if(s == e) {
            return lists[s];
        }
        int mid = s + (e - s) / 2;
        ListNode l1 = partition(lists, s, mid);
        ListNode l2 = partition(lists, mid + 1, e);
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                prev.next = l1;
                prev = prev.next;
                l1 = l1.next;
            }
            else {
                prev.next = l2;
                prev = prev.next;
                l2 = l2.next;
            }
        }
        
        if(l1 != null) {
            prev.next = l1;
        }
        if(l2 != null) {
            prev.next = l2;
        }
        return dummy.next;
    }
    
    
}