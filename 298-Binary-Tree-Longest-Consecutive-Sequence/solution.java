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
    public int longestConsecutive(TreeNode root) {
        int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }
    
    public int dfs(TreeNode root, int[] res) {
        if(root == null) {
            return 0;
        }
        
        int left = dfs(root.left, res);
        int right = dfs (root.right, res);
        int tmp = 1;
        if(root.left != null && root.left.val == root.val + 1) {
            tmp = Math.max(tmp, left + 1);
        }
        if(root.right != null && root.right.val == root.val + 1) {
            tmp = Math.max(tmp, right + 1);
        }
        
        res[0] = Math.max(res[0], tmp);
        return tmp;
    }
}