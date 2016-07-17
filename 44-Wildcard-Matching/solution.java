public class Solution {
    public boolean isMatch(String s, String p) {
        int index = 0, star = -1, pindex = 0, mark = -1;
        int slen = s.length(), plen = p.length();
        
        while(index < slen) {
            char c = s.charAt(index);
            
            if(pindex < plen && (p.charAt(pindex) == '?' || p.charAt(pindex) == c)) {
                pindex++;
                index++;
            }
            else if(pindex < plen && p.charAt(pindex) == '*') {
                star = pindex;
                mark = index;
                pindex++;
            }
            else if(star != -1) {
                pindex = star + 1;
                mark++;
                index = mark;
            }
            else {
                return false;
            }
        }
        
        while(pindex < plen) {
            if(p.charAt(pindex) != '*') {
                return false;
            }
            pindex++;
        }
        
        return true;
    }
}