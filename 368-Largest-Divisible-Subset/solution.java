public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        int[] dp = new int[nums.length];
        int[] index = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            index[i] = -1;
         }
        Arrays.sort(nums);
        int maxlen = 0;
        int maxIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    index[i] = j;
                }
            }
            
            if(maxlen < dp[i]) {
                maxlen = dp[i];
                maxIndex = i;
            }
        }
        
        for(int i = maxIndex; i != -1; i = index[i]) {
            res.add(nums[i]);
        }
        
        return res;
    }
}