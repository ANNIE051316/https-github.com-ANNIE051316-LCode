public class Solution {
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        dp[0][0] = true;
        for(int j = 1; j < plen && p.charAt(j) == '*'; j += 2) {
            dp[0][j] = true;
            dp[0][j + 1] = true;
        }
        
        for(int i = 1; i <= slen; i++) {
            char c = s.charAt(i - 1);
            for(int j = 1; j <= plen; j++) {
                char t = p.charAt(j - 1);
                if(t != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && (t == '.' || t == c);
                }
                else {
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (c == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                }
            }
        }
        return dp[slen][plen];
    }
}