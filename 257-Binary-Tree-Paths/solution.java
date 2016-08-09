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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList();
        
        if(root == null) {
            return res;
        }
        helper(root, "", res);
        return res;
    }
    
    public void helper(TreeNode root, String prev, List<String> res) {
        if(root == null) {
            return;
        }
        if(prev.length() > 0) {
            prev = prev + "->";
        }
        prev = prev + root.val;
        
        if(root.left == null && root.right == null) {
            res.add(prev);
            return;
        }
        if(root.left != null) {
            helper(root.left, prev, res);
        }
        if(root.right != null) {
            helper(root.right, prev, res);
        }
    }
}