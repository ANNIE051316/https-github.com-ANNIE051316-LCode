public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();
        if(Math.abs(l1 - l2) > 1 || s.equals(t)) {
            return false;
        }
        int min = Math.min(l1, l2);
        for(int i = 0; i < min; i++) {
            char c = s.charAt(i);
            char p = t.charAt(i);
            if(c != p) {
                return s.substring(i + 1).equals(t.substring(i)) || s.substring(i).equals(t.substring(i + 1)) || s.substring(i + 1).equals(t.substring(i + 1));
            }
        }
        
        return true;
        
    }
}