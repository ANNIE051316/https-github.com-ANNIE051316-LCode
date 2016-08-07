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
        
        ListNode dummy = new ListNode(0);
        
        PriorityQueue<ListNode> pq = new PriorityQueue(11, new Comparator<ListNode>() {
            @Override
            
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });
        
        for(ListNode list : lists) {
            pq.offer(list);
        }
        
        ListNode prev = dummy;
        while(!pq.isEmpty()) {
            ListNode min = pq.poll();
            prev.next = min;
            prev = prev.next;
            if(min.next != null) {
                pq.offer(min.next);
            }
        }
        
        return dummy.next;
    }
}