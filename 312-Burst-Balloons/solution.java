public class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] tmpnums = new int[nums.length + 2];
        tmpnums[0] = 1;
        tmpnums[tmpnums.length - 1] = 1;
        for(int i = 0; i < nums.length; i++) {
            tmpnums[i + 1] = nums[i];
        }
        
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        //dp[i][j] = balloon i to j
        
       for(int j = 1; j < tmpnums.length - 1; j++) {
           for(int i = j; i > 0; i--) {
               for(int k = i; k <= j; k++) {
                   dp[i][j] = Math.max(dp[i][j], tmpnums[i - 1] * tmpnums[k] * tmpnums[j + 1] + dp[i][k - 1] + dp[k + 1][j]);
               }
           }
       }
        
        return dp[1][nums.length];
    }
}