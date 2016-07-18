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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        return isSym(root.left, root.right);
    }
    
    public boolean isSym(TreeNode root1, TreeNode root2) {
        if(root1 == null) {
            return root2 == null;
        }
        if(root2 == null || root1.val != root2.val) {
            return false;
        }
        return isSym(root1.left, root2.right) && isSym(root1.right, root2.left);
        
    }
}