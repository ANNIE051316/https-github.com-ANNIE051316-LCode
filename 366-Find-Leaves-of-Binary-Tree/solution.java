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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        int level = helper(root, res);
        if(res.size() < level) {
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(root.val);
            res.add(tmp);
        }
        
        return res;
    }
    
    public int helper(TreeNode root, List<List<Integer>> res) {
        if(root == null) {
            return 0;
        }
        int level = 1+ Math.max(helper(root.left, res), helper(root.right, res));
        root.left = null;
        root.right = null;
        
        if(res.size() < level) {
            res.add(new ArrayList<Integer>());
        } 
        res.get(level - 1).add(root.val);
        return level;
    }
}