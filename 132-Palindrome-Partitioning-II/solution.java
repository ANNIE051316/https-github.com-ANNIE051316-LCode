public class Solution {
    public int minCut(String s) {
        if(s == null || s.length() <= 1) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        
        for(int i = 0; i < len; i++) {
            dp[i + 1] = i + 1;
        }
        
        for(int i = 0; i < len; i++) {
            // odd palindrome
            
            for(int j = 0; j <= i && i + j < len && s.charAt(i - j) == s.charAt(i + j); j++) {
                dp[i + j + 1] = Math.min(dp[i + j + 1], dp[i - j] + 1);
            }
            
            // even palindrome
            
            for(int j = 0; j <= i && i + j + 1 < len && s.charAt(i - j) == s.charAt(i + j + 1); j++) {
                dp[i + j + 2] = Math.min(dp[i + j + 2], dp[i - j] + 1);
            }
        }
        
        return dp[len] - 1;
    }
    
}