public class Solution {
    public int numDistinct(String s, String t) {
        if(s.length() < t.length()) {
            return 0;
        }
        
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        
        for(int i = 0; i <= s.length(); i++) {
            dp[0][i] = 1;
        }
        
        for(int i = 1; i < dp.length; i++) {
            char c = t.charAt(i - 1);
            for(int j = 1; j < dp[0].length; j++) {
                char p = s.charAt(j - 1);
                dp[i][j] = dp[i][j - 1]; // delete s[j - 1]
                if(c == p) {
                    dp[i][j] += dp[i - 1][j - 1]; 
                }
            }
        }
        
        return dp[t.length()][s.length()];
    }
}