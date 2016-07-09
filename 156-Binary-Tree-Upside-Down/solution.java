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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
        TreeNode newroot = stack.pop();
        TreeNode prev = newroot;
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            prev.left = cur.right;
            prev.right = cur;
            cur.left = null;
            cur.right = null;
            prev = cur;
        }
        return newroot;
    }
}