/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 
 /*
 
BFS, put node, col into queue at the same time
Every left child access col - 1 while right child col + 1
This maps node into different col buckets
Get col boundary min and max on the fly
Retrieve result from cols
 */
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) {
            return res;
        }
        int min = 0, max = 0;
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        Queue<Integer> cols = new LinkedList<Integer>();
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        nodes.offer(root);
        cols.offer(0);
        while(!nodes.isEmpty()) {
            int curcol = cols.poll();
            TreeNode node = nodes.poll();
            if(!map.containsKey(curcol)) {
                map.put(curcol, new ArrayList<Integer>());
            }
            map.get(curcol).add(node.val);
            if(node.left != null) {
                nodes.offer(node.left);
                cols.offer(curcol - 1);
            }
            if(node.right != null) {
                nodes.offer(node.right);
                cols.offer(curcol + 1);
            }
            min = Math.min(min, curcol);
            max = Math.max(max, curcol);
        }
        
        for(int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}