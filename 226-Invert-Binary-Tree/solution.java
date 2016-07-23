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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode left = cur.left;
            cur.left = cur.right;
            cur.right = left;
            if(cur.left != null) {
                queue.offer(cur.left);
            }
            
            if(cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return root;
    }
}