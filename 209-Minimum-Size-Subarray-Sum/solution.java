public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int res= Integer.MAX_VALUE;
        int start = 0;
        int cursum = 0;
        for(int i = 0; i < nums.length; i++) {
            cursum += nums[i];
            if(cursum < s) {
                continue;
            }
            
            while(cursum - nums[start] >= s) {
                start++;
            }
            res = Math.min(res, i - start + 1);
        }
        
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}