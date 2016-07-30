public class Solution {
    public String shortestPalindrome(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder(s);
        sb.append("#");
        sb.append((new StringBuilder(s)).reverse());
        int[] dp = new int[sb.length()];
        
        for(int i = 1; i < dp.length; i++) {
            char cur = sb.charAt(i);
            int prev = dp[i - 1];
            while(prev > 0 && sb.charAt(prev) != cur) {
                prev = dp[prev - 1];
            }
            dp[i] = prev + 1;
        }
        
        return (new StringBuilder(s.substring(dp[dp.length - 1]))).reverse() + s;
    
    }
}