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
        
        TreeLinkNode  start = root;
        TreeLinkNode prev = null;
        TreeLinkNode nextStart = null;
        while(start != null) {
            if(start.left != null) {
                if(prev != null) {
                    prev.next = start.left;
                    prev = prev.next;
                }
                else {
                    prev = start.left;
                }
                
                if(nextStart == null) {
                    nextStart = start.left;
                }
            }
            
            if(start.right != null) {
                if(prev != null) {
                    prev.next = start.right;
                    prev = prev.next;
                }
                else {
                    prev = start.right;
                }
                
                if(nextStart == null) {
                    nextStart = start.right;
                }
            }
            
            start = start.next;
            if(start == null) {
                start = nextStart;
                prev = null;
            }
        }
        
    }
}