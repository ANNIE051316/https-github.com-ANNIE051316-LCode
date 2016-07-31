public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n < 0 || n > 10) {
            return 0;
        }   
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            return 10;
        }
        int[] dp = new int[n];
        dp[0] = 10;
        int mul = 81;
        int prev = 9;
        for(int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + mul;
            prev--;
            mul *= prev;
        }
        
        return dp[n - 1];
    }
}