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
    public int countUnivalSubtrees(TreeNode root) {
        int[] res = new int[1];
        helper(root, res);
        return res[0];
    }
    
    public boolean helper(TreeNode root, int[] res) {
        if(root == null) {
            return true;
        }
        
        boolean left = helper(root.left, res);
        boolean right = helper(root.right, res);
        
        if(left && right) {
            if((root.left == null || root.left.val == root.val) && (root.right == null || root.right.val == root.val)) {
                res[0]++;
                return true;
            }
        }
        
        return false;
    }
}