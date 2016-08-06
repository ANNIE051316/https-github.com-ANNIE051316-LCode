public class Solution {
    public boolean isMatch(String s, String p) {
        int index = 0, pindex = 0, star = -1, mark = -1;
        
        while(index < s.length()) {
            char c = s.charAt(index);
           
            if(pindex < p.length() && (p.charAt(pindex) == '?' || p.charAt(pindex) == c)) {
                pindex++;
                index++;
            }
            else if(pindex < p.length() && p.charAt(pindex) == '*') {
                star = pindex;
                mark = index;
                pindex++;
              //  index++;
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
        
        while(pindex < p.length()) {
            if(p.charAt(pindex) != '*') {
                return false;
            }
            pindex++;
        }
        
        return true;
    }
}