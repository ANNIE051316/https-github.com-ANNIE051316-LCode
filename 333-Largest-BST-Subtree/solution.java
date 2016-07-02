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
    private int maxLength = 0;
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) {
            return maxLength;
        }
        
        helper(root);
        return maxLength;
    }
    
    public int[] helper(TreeNode root) {
        int[] res = new int[3];
        res[1] = root.val;
        res[2] = root.val;
        res[0] = 1;
/*        if(root.left == null && root.right == null) {
            res = Math.max(res, 1);
            return new int[]{1, root.val, root.val};
        }
        
        
 */     
 
        boolean isValid = true;
        if(root.left != null) {
            int[] left = helper(root.left);
            if(left[0] == 0 || left[2] > root.val) {
                isValid = false;
            }
            
            res[0] += left[0];
            res[1] = left[1];
            res[2] = root.val;
        }
        
        if(root.right != null) {
            int[] right = helper(root.right);
            if(right[0] == 0 || right[1] <= root.val) {
                isValid = false;
            }
            res[0] += right[0];
            res[2] = right[2];
        }
        
        if(isValid) {
            maxLength = Math.max(maxLength, res[0]);
            return res;
        }
        
        return new int[3];
    }
}