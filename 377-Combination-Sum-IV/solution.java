public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for(int i = 1; i <= target; i++) {
            int tmp = 0;
            for(int num : nums) {
                if(num > i) {
                    continue;
                }
                tmp += dp[i - num];
            }
            dp[i] = tmp;
        } 
        return dp[target];
    }
}