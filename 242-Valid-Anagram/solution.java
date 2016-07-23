public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] counts = new int[26];
        int len = s.length();
        int lt =t.length();
        if(len != lt) {
            return false;
        }
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            char p = t.charAt(i);
            counts[c - 'a']++;
            counts[p - 'a']--;
        }
        
        for(int i = 0; i < counts.length; i++) {
            if(counts[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}