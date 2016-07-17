public class Solution {
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        dp[0][0] = true;
        for(int j = 1; j <= plen; j++) {
            if(p.charAt(j - 1) == '*') {
                dp[0][j] = true;
            }
            else {
                break;
            }
        }
        
        
        for(int i = 1; i <= slen; i++) {
            char c = s.charAt(i - 1);
            for(int j = 1; j <= plen; j++) {
                int t = p.charAt(j - 1);
                
                if(t != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && (t == '?' || t == c);
                }
                else {
                    for(int k = i; k >= 0; k--) {
                        if(dp[k][j - 1]) {
                            dp[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        
        return dp[slen][plen];
    }
}