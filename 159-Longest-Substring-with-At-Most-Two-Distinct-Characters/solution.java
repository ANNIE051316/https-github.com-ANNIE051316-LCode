public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int index1 = -1; 
        int index2 = -1; 
        int res = 0;
        int start = 0;
        int len = s.length();
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(index1 == -1 || s.charAt(index1) == c) {
                index1 = i;
            }
            else if(index2 == -1 || s.charAt(index2) == c) {
                index2 = i;
            }
            else {
                if(index1 < index2) {
                    start = index1 + 1;
                    index1 = i;
                }
                else {
                    start = index2 + 1;
                    index2 = i;
                }
            }
            
            res = Math.max(res, i - start + 1);
        }
        
        return res;
    }
}