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
        
        if(root == null){
            return res;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            int sz = queue.size();
            List<Integer> list = new ArrayList();
            for(int i = 0; i < sz; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(list);
        }
        
        return res;
    }
}