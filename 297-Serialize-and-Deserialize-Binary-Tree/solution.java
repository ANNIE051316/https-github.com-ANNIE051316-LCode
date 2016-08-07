/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val + ",");
        int lastnotnull = sb.length();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur.left == null) {
                sb.append("#,");
            }
            else {
                sb.append(cur.left.val + ",");
                queue.offer(cur.left);
                lastnotnull = sb.length();
            }
            
            if(cur.right == null) {
                sb.append("#,");
            }
            else {
                sb.append(cur.right.val + ",");
                queue.offer(cur.right);
                lastnotnull = sb.length();
            }
        }
        
        return sb.substring(0, lastnotnull);
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.equals("")) {
            return null;
        }
        
        String[] strs = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int index = 1;
        while(index < strs.length) {
            TreeNode cur = queue.poll();
            String s1 = strs[index++];
            if(!s1.equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(s1));
                cur.left = left;
                queue.offer(left);
            }
            
            if(index < strs.length && !strs[index].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(strs[index++]));
                cur.right = right;
                queue.offer(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));