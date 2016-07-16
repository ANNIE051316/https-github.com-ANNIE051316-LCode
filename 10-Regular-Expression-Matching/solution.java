public class Solution {
    public boolean isMatch(String s, String p) {
        if(p == null || p.length() == 0) {
            return s == null || s.length() == 0;
        }
        
        return backtracking(s, 0, s.length() - 1, p, 0, p.length() - 1); 
    }
    
    public boolean backtracking(String s, int start, int end, String p, int pstart, int pend) {
        if(start > end) {
            if(pstart > pend) {
                return true;
            }
            else {
                while(pstart <= pend) {
                    if(p.charAt(pstart) != '*') {
                        return false;
                    }
                    pstart++;
                }
                return true;
            }
        }
            
            if(pstart > pend) {
                return false;
            }
            char c = s.charAt(start);
            char t = p.charAt(pstart);
            if(c == t || t == '.') {
                return backtracking(s, start + 1, end, p, pstart + 1, pend);
            }
            if(t == '*') {
                return backtracking(s, start, end, p, pstart + 1, pend) || backtracking(s, start, end, p, pstart - 1, pend);
            }
            else {
                if(pstart < pend && p.charAt(pstart + 1) == '*') {
                    return backtracking(s, start, end, p, pstart + 1, pend);
                }       
                return false;
            }
            
            
    }
}