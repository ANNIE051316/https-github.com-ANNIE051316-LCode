public class Solution {
    public String minWindow(String s, String t) {
        int startmin = -1;
        int endmin = -1;
        Map<Character, Integer> map = new HashMap();
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer count = map.get(c);
            map.put(c, count == null ? 1 : count + 1);
        }
        
        int start = 0;
        int covered = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                continue;
            }
            int needed = map.get(c);
            map.put(c, needed - 1);
            if(needed > 0) {
                covered++;
            }
            
            if(covered == t.length()) {
                    
                    char tmp = s.charAt(start);
                    while(!map.containsKey(tmp) || map.get(tmp) < 0) {
                        if(map.containsKey(tmp)) {
                            map.put(tmp, map.get(tmp) + 1);
                        }
                        tmp = s.charAt(++start);
                    }
                    
                    if(startmin == - 1 || i - start < endmin - startmin) {
                        startmin = start;
                        endmin = i;
                    }
            }
            
        }
        
        return startmin == -1 ? "" : s.substring(startmin, endmin + 1);
         
    }
}