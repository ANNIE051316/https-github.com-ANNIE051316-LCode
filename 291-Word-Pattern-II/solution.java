public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<Character, String>();
        return helper(pattern, 0, pattern.length() - 1, str, 0, str.length() - 1, map);
    }
    
    public boolean helper(String pattern, int pindex, int pend, String str, int sindex, int strend, Map<Character, String> map) {
        if(pindex > pend && sindex > strend) {
            return true;
        }
        
        if(pindex > pend  || sindex > strend) {
            return false;
        }
        char c = pattern.charAt(pindex);
        if(map.containsKey(c)){
            if(str.substring(sindex).startsWith(map.get(c))) {
                return helper(pattern, pindex + 1, pend, str, sindex + map.get(c).length(), strend, map); 
            }
            return false;
        }
        
        for(int i = sindex; i <= strend; i++) {
            String tmp = str.substring(sindex, i + 1);
            if(map.containsValue(tmp)) {
                continue;
            }
            map.put(c, tmp);
            if(helper(pattern, pindex + 1, pend, str, i + 1, strend, map)) {
                return true;
            }
            map.remove(c);
        }
        
        return false;
    }
}