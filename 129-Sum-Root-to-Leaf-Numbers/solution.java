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
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    
    public int helper(TreeNode root, int cur) {
        if(root == null) {
            return 0;
        }
        
        cur = cur * 10 + root.val;
        if(root.left == null && root.right == null) {
            return cur;
        }
        
        return helper(root.left, cur) + helper(root.right, cur);
    }
}