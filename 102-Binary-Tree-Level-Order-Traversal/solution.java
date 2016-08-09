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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        helper(root, 0, res);
        return res;
    }
    
    public void helper(TreeNode root, int level, List<List<Integer>> res) {
        if(root == null) {
            return;
        }
        if(res.size() - 1 < level) {
            res.add(new ArrayList<Integer>());
        }
        
        res.get(level).add(root.val);
        helper(root.left, level + 1, res);
        helper(root.right, level + 1, res);
        
    }
}