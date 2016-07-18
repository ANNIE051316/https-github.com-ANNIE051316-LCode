public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 0; i < len1; i++) {
            dp[i + 1][0] = dp[i][0] + 1; 
        }
        for(int j = 0; j < len2; j++) {
            dp[0][j + 1] = dp[0][j] + 1; 
        }
        
        for(int i = 1; i <= len1; i++) {
            char c = word1.charAt(i - 1);
            for(int j = 1; j <= len2; j++) {
                char t = word2.charAt(j - 1);
                if(c == t) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }
        
        return dp[len1][len2];
    }
}