public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        
        char[] s1array = s1.toCharArray();
        char[] s2array = s2.toCharArray();
        Arrays.sort(s1array);
        Arrays.sort(s2array);
        if(!String.valueOf(s1array).equals(String.valueOf(s2array))) {
            return false;
        }
        if(s1.equals(s2)) {
            return true;
        } 
        
        for(int i = 1; i < s1.length(); i++) {
            String sub1 = s1.substring(0, i);
            String sub2 = s1.substring(i);
            
            if(isScramble(sub1, s2.substring(0, i)) && isScramble(sub2, s2.substring(i)) || isScramble(sub1, s2.substring(s1.length() - i))&& isScramble(sub2, s2.substring(0, s1.length() - i))) {
                return true;
            }
        }
        
        return false;
     }
}