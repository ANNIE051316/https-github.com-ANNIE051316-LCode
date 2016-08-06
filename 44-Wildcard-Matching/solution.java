public class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || s.length() == 0) {
            if(p == null || p.length() == 0) {
                return true;
            }
            else {
                for(int i = 0; i < p.length(); i++) {
                    if(p.charAt(i) != '*') {
                        return false;
                    }
                }
            }
            return true;
        }
        
        if(p == null || p.length() == 0) {
            return false;
        }
        
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        
        dp[0][0] = true;
        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '*') {
                dp[i + 1][0] = true; 
            }
            else {
                break;
            }
        }
        
        for(int i = 1; i < p.length() + 1; i++) {
            char c = p.charAt(i - 1);
            for(int j = 1; j < s.length() + 1; j++){
                char t = s.charAt(j - 1);
                if(c != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && ( c == '?' || c == t);
                }
                else {
                    for(int k = j; k >= 0; k--) {
                        if(dp[i - 1][k]) {
                            dp[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        
        return dp[dp.length - 1][dp[0].length - 1];
    }
}