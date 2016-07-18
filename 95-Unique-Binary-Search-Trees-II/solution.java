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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = helper(1, n);
        return res;
    }
    
    public List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(start > end) {
            return res;
        }
        
        if(start == end) {
            res.add(new TreeNode(start));
            return res;
        }
        
        for(int i = start; i <= end; i++) {
            List<TreeNode> left = helper(start, i - 1);
            List<TreeNode> right = helper(i + 1, end);
            if(left.size() == 0) {
                for(TreeNode r : right) {
                     TreeNode root = new TreeNode(i);
                     root.right = r;
                     res.add(root);
                }
            }
            else if(right.size() == 0) {
                for(TreeNode l : left) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    res.add(root);
                }
            }
            else {
                for(TreeNode l : left) {
                    for(TreeNode r : right) {
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        res.add(root);
                    }
                }
            }
        }
        
        return res;
    }
}