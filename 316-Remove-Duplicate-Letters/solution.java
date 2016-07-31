public class Solution {
    public String removeDuplicateLetters(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }
        
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        int pos = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(pos) > s.charAt(i)) {
                pos = i;
            }
            if(--count[s.charAt(i) - 'a'] == 0) {
                break;
            }
        }
        
        return s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replace("" + s.charAt(pos), ""));
    }
}