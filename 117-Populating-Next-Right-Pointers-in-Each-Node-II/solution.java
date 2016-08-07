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
        if(root == null) {
            return;
        }
        
        TreeLinkNode cur = root;
        TreeLinkNode nextstart = null;
        TreeLinkNode prev = null;
        while(cur != null) {
            if(cur.left != null) {
                if(nextstart == null) {
                    nextstart = cur.left;
                    prev = cur.left;;
                }
                else {
                    prev.next = cur.left;
                    prev = prev.next;
                }
            }
            
            if(cur.right != null) {
                if(nextstart == null) {
                    nextstart = cur.right;
                    prev = cur.right;
                }
                else {
                    prev.next = cur.right;
                    prev = prev.next; 
                }
            }
            
            if(cur.next == null) {
                cur = nextstart;
                nextstart = null;
                prev = null;
            }
            else {
                cur = cur.next;
            }
        }
    }
}