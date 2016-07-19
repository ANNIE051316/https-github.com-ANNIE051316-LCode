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
            if(cur.left != null) {
                if(prev != null) {
                    prev.next = cur.left;
                }
                prev = cur.left;
                
                if(nextstart == null) {
                    nextstart = cur.left;
                }
            }
            
            if(cur.right != null) {
                if(prev != null) {
                    prev.next = cur.right;
                }
        
                prev = cur.right;
        
                if(nextstart == null) {
                    nextstart = cur.right;
                }
            }
            
            cur = cur.next;
            if(cur == null) {
                prev = null;
                cur = nextstart;
                nextstart = null;
            }
        }
        
        
    }
}