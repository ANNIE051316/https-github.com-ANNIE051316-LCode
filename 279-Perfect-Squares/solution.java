public class Solution {
    public int numSquares(int n) {
        if(n <= 0) {
            return 0;
        }
        
        int[] dp = new int[n];
        int cur = 1;
        for(int i = 1; i <= n; i++) {
            if(cur * cur == i) {
                dp[i - 1] = 1;
                cur += 1;
            }
            else {
                int tmp = Integer.MAX_VALUE;
                for(int j = cur - 1; j > 0; j--) {
                    tmp = Math.min(tmp, 1 + dp[i - j * j - 1]);
                }
                dp[i - 1] = tmp;
            }
        }
        
        return dp[n - 1];
    }
}