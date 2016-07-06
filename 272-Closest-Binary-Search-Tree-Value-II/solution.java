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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
        
        List<Integer> res = new LinkedList<Integer>();
        int count = 0;
        boolean update = true;
        while(!stack.isEmpty() && update) {
            TreeNode cur = stack.pop();
            if(count < k || Math.abs(res.get(0) - target) > Math.abs(cur.val - target)) {
                if(count == k) {
                    res.remove(0);
                    count--;
                }
                count++;
                res.add(cur.val);
            }
            else {
                update = false;
            }
            
            cur = cur.right;
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
        return res;
    }
}