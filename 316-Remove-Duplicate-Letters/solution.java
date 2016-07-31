public class Solution {
    public String removeDuplicateLetters(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }
        
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
        }
        
        boolean[] used = new boolean[26];
        Stack<Character> stack = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']--;
            if(used[c - 'a']) {
                continue;
            }
            while(!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                char top = stack.pop();
                used[top - 'a'] = false;
            }
        
            stack.push(c);
            used[c - 'a'] = true;
        }
        
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}