public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int start = -1, end = -1;
        
        int cursum = 0, tmpstart = 0;
        for(int i = 0; i < nums.length; i++) {
            cursum += nums[i];
            if(cursum >= s) {
                while(cursum - nums[tmpstart] >= s) {
                    cursum -= nums[tmpstart++];
                }
                
                if(start == -1 || end - start > i - tmpstart) {
                    start = tmpstart;
                    end = i;
                }
            }
        }
        
        return start == -1 ? 0 : end - start + 1;
    }
}