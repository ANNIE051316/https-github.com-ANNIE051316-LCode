public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        
        if(coins == null || coins.length == 0) {
            return 0;
        }
        
        int[] dp = new int[amount + 1];
        for(int coin : coins) {
            dp[coin] = 1;
        }
        
        for(int i = 1; i <= amount; i++) {
            if(dp[i] == 0) {
                int tmp = Integer.MAX_VALUE;
                for(int j = 0; j < coins.length; j++) {
                    if(coins[j] < i) {
                        tmp = Math.min(tmp, dp[i - coins[j]]);
                    }
                }
                dp[i] = (tmp == Integer.MAX_VALUE ? Integer.MAX_VALUE : tmp + 1);
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}