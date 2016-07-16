public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        String res = strs[0];
        for(int i = 1; i < strs.length; i++) {
            StringBuilder tmp = new StringBuilder();
            int len = Math.min(res.length(), strs[i].length());
            for(int j = 0; j < len; j++) {
                if(res.charAt(j) == strs[i].charAt(j)) {
                    tmp.append(res.charAt(j));
                }
                else {
                    break;
                }
            }
            res = tmp.toString();
        }
        
        return res;
    }
}