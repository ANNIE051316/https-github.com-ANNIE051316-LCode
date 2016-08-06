public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '{' || c == '[' || c == '(') {
                stack.push(c);
            }
            else {
                if(stack.isEmpty()) {
                    return false;
                }
                switch (c) {
                    case '}':
                        if(stack.pop() != '{') {
                            return false;
                        }
                        break;
                    case ']':
                        if(stack.pop() != '[') {
                            return false;
                        }
                        break;
                    case ')':
                        if(stack.pop() != '(') {
                            return false;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        
        return stack.isEmpty();
    }
}