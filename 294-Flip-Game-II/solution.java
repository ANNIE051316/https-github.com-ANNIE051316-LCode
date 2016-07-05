public class Solution {
    public boolean canWin(String s) {
        if(s == null || s.length() <= 1) {
            return false;
        }
        
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        return helper(s, map);
    }
    
    public boolean helper(String s, Map<String, Boolean> map) {
        if(map.containsKey(s)) {
            return map.get(s);
        }
        
        int len = s.length();
        for(int i = 0; i < len - 1; i++) {
            if(s.charAt(i) != '+' || s.charAt(i + 1) != '+') {
                continue;
            }
            String tmp = s.substring(0, i) + "--" + s.substring(i + 2);
            if(!helper(tmp, map)) {
                return true;
            }
            map.put(tmp, true);
        }
        map.put(s, false);
        return false;
    }
}