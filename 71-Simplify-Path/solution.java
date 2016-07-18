public class Solution {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<String>();
        
        for(int i = 0; i < strs.length; i++) {
            switch (strs[i]) {
                case ".":
                    break;
                case "..":
                    if(!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                case "":
                    break;
                default:
                    stack.push(strs[i]);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            if(sb.length() != 0) {
                sb.insert(0, '/');
            }
            sb.insert(0, stack.pop());
        }
        
        sb.insert(0, '/');
        return sb.toString();
    }
}