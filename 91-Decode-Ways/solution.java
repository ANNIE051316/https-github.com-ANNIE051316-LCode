public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for(int i = 1; i < dp.length; i++) {
            char c = s.charAt(i - 1);
            if(c == '0') {
                dp[i] = dp[i - 2];
            }
            else {
                dp[i] = dp[i - 1];
                if(i > 1) {
                    int tmp =  Integer.parseInt(s.substring(i - 2, i));
                    if(tmp >= 10 && tmp <= 26) {
                        dp[i] += dp[i - 2];
                    }
                }
            }
        }
        
        return dp[dp.length - 1];
    }
}