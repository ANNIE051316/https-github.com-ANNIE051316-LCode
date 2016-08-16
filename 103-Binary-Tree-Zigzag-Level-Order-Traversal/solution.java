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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null) {
            return res;
        }
        
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        boolean flag = true;
        while(!queue.isEmpty()) {
            int sz = queue.size();
            List<Integer> tmp = new ArrayList();
            for(int i = 0; i < sz; i++) {
                TreeNode node = queue.poll();
                if(flag) {
                    tmp.add(node.val);
                }
                else {
                    tmp.add(0, node.val);
                }
                
                if(node.left != null) {
                    queue.offer(node.left);
                }
                
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            
            res.add(tmp);
            flag = !flag;
            tmp = new ArrayList();
        }
        
        return res;
    }
}