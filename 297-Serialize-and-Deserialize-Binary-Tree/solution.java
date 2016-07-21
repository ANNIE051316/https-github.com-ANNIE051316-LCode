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
        sb.append(root.val);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            sb.append(" ");
            if(tmp.left != null) {
                sb.append(tmp.left.val);
                queue.offer(tmp.left);
            }
            else {
                sb.append("#");
            }
            
            sb.append(" ");
            
            if(tmp.right != null) {
                sb.append(tmp.right.val);
                queue.offer(tmp.right);
            }
            else {
                sb.append("#");
            }
            
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) {
            return null;
        }
        
        String[] nodes = data.split(" ");
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[index]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while(index < nodes.length - 1 && !queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if(!nodes[++index].equals("#")) {
                tmp.left = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offer(tmp.left);
            }
            
            if(!nodes[++index].equals("#")) {
                tmp.right = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offer(tmp.right);
            }
        }
        
        return root; 
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));