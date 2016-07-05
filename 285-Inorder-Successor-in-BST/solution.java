/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) {
            return null;
        }
        if(root.val < p.val || root == p) {
            return inorderSuccessor(root.right, p);
        }
        
        TreeNode left = inorderSuccessor(root.left);
        return left == null ? root : left;
        
    }
}