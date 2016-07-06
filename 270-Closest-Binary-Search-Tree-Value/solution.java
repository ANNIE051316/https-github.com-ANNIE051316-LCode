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
        int a = root.val;
        TreeNode kid = a < target ? root.right : root.left;
        if(kid == null) {
            return a;
        }
        int b = closestValue(kid, target);
        return Math.abs(a - target) > Math.abs(b - target) ? b : a;
    }
}