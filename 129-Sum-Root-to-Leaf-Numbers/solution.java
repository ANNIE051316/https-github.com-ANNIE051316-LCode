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
        int[] res = new int[1];
        if(root == null) {
            return 0;
        }
        helper(root, 0, res);
        return res[0];
    }
    
    public void helper(TreeNode root, int cur, int[] res) {
        if(root == null) {
            return;
        }
        cur = cur * 10 + root.val;
        if(root.left == null && root.right == null) {
            res[0] += cur;
            return;
        }
        
        if(root.left != null) {
            helper(root.left, cur, res);
        }
        
        if(root.right != null) {
            helper(root.right, cur, res);
        }
    }
}