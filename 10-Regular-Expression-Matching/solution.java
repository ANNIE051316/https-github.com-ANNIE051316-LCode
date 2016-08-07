public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for(int i = 1; i < p.length(); i += 2) {
            if(p.charAt(i) == '*') {
                dp[0][i] = true;
                dp[0][i + 1] = true;
            }
            else {
                break;
            }
        }
        
        for(int i = 1; i < dp.length; i++) {
            char c = s.charAt(i - 1);
            for(int j = 1; j < dp[0].length; j++) {
                char t = p.charAt(j - 1);
                if(t == '*') {
                    dp[i][j] = dp[i][j - 2] || ((p.charAt(j - 2) == '.' || p.charAt(j - 2) == c) && (dp[i - 1][j - 1] || dp[i - 1][j]));
                }
                else {
                    dp[i][j] = dp[i - 1][j - 1] && (t == '.' || t == c);
                }
            }
        }
    
        return dp[s.length()][p.length()];
    }
}