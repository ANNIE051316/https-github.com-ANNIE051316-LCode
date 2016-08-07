public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList();
        if(isValid(s)) {
            res.add(s);
            return res;
        }
        Queue<String> queue = new LinkedList<String>();
        queue.offer(s);
        boolean flag = false;
        Set<String> visited = new HashSet();
        visited.add(s);
        while(!flag && !queue.isEmpty()) {
            int sz = queue.size();
            for(int i = 0; i < sz; i++) {
                String cur = queue.poll();
                for(int j = 0; j < cur.length(); j++) {
                    if(cur.charAt(j) != '(' && cur.charAt(j) != ')') {
                        continue;
                    }
                    String sub = cur.substring(0, j) + cur.substring(j + 1);
                    if(!visited.contains(sub)) {
                        if(isValid(sub)) {
                            flag = true;
                            res.add(sub);
                            visited.add(sub);
                        }   
                        if(!flag) {
                            visited.add(sub);
                            queue.offer(sub);
                        }
                    }
                }
            }
            
        }
        
        return res;
    }
    
    public boolean isValid(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                count++;
            }
            else if(c == ')') {
                if(--count < 0) {
                    return false;
                }
            }
        }
        
        return count == 0;
    }
}