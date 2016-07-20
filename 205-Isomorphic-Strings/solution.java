public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        
        int len = s.length();
        int tlen = t.length();
        if(len != tlen) {
            return false;
        }
        
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            char p = t.charAt(i);
            if(map.containsKey(c)) {
                if(map.get(c) != p) {
                    return false;
                }
            }
            else {
                if(map.containsValue(p)) {
                    return false;
                }
                map.put(c, p);
            }
        }
        
        return true;
    }
}