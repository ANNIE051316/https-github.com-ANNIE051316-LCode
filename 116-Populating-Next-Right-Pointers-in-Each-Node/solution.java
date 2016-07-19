/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode cur = root;
        TreeLinkNode nextstart = null;
        TreeLinkNode prev = null;
        while(cur != null) {
            if(cur.left == null) {
                return;
            }
            cur.left.next = cur.right;
            if(prev != null) {
                prev.next = cur.left;
            }
            
            prev = cur.right;
            
            if(nextstart == null) {
                nextstart = cur.left;
            } 
            
            cur = cur.next;
            if(cur == null) {
                cur = nextstart;
                nextstart = null;
                prev = null;
            }
            
        }
    }
}