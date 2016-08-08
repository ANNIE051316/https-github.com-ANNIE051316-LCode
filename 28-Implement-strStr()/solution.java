public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || haystack.length() < needle.length()) {
            return -1;
        }
        
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            String sub = haystack.substring(i, i + needle.length());
            if(sub.equals(needle)) {
                return i;
            }
        }
        
        return -1;
    }
}