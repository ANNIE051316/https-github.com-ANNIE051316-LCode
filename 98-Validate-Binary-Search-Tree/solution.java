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
    public boolean isValidBST(TreeNode root) {
        return isValidHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);   
    }
    
    public boolean isValidHelper(TreeNode root, long minValue, long maxValue) {
        if(root == null) {
            return true;
        }
        
        if(root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        return isValidHelper(root.left, minValue, root.val) && isValidHelper(root.right, root.val, maxValue);
    }
}