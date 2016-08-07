public class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) {
            return "/";
        }
        
        String[] strs = path.split("/");
        Stack<String> stack = new Stack();
        for(String s : strs) {
            s = s.trim();
            if(s.equals(".") || s.equals("")) {
                continue;
            }
            else if(s.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            if(sb.length() > 0) {
                sb.insert(0, stack.pop() + "/");
            }
            else {
                sb.insert(0, stack.pop());
            }
        }
        sb.insert(0, "/");
        return sb.toString();
    }
}