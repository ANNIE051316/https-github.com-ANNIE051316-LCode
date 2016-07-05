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
    public int closestValue(TreeNode root, double target) {
        if(root.val > target) {
            if(root.left == null) {
                return root.val;
            }
            int left = closestValue(root.left, target);
            if(root.val - target < Math.abs(target - left)) {
                return root.val;
            }
            else {
                return left;
            }
        }
        else {
            if(root.right == null) {
                return root.val;
            }
            int right = closestValue(root.right, target);
            if(target - root.val < Math.abs(right - target)) {
                return root.val;
            }
            else {
                return right;
            }
        }
        
    }
}