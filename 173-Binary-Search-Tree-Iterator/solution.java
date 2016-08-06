/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    TreeNode cur;

    public BSTIterator(TreeNode root) {
        cur = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cur != null;
    }

    /** @return the next smallest number */
    public int next() {
        int res;
        while(cur != null) {
            if(cur.left == null) {
                res = cur.val;
                cur = cur.right;
                break;
            }
            
            TreeNode prev = cur.left;
            while(prev.right != null && prev.right != cur) {
                prev = prev.right;
            }
            
            if(prev.right == cur) {
                prev.right = null;
                res = cur.val;
                cur = cur.right;
                break;
            }
            else {
                prev.right = cur;
                cur = cur.left;
            }
        }
        
        return res;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */