public class Solution {
    public boolean isMatch(String s, String p) {
        int plen = p.length();
        if(plen == 0) {
            return s.length() == 0;
        }
        
        if(plen == 1) {
            return (s.length() == 1 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)));
        }
        
        if(p.charAt(1) == '*') {
            if(isMatch(s, p.substring(2))) {
                return true;
            }
            else {
                if(s.length() > 0 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))) {
                    return isMatch(s.substring(1), p);
                }
                else {
                    return false;
                }
            }
        }
        else {
            if(s.length() > 0 && ( p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))) {
                return isMatch(s.substring(1), p.substring(1));
            }
            else {
                return false;
            }
        }
    }
}