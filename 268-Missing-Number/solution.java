public class Solution {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == i || nums[i] < 0 || nums[i] >= nums.length || nums[nums[i]] == nums[i]) {
                continue;
            }
            int tmp = nums[nums[i]];
            nums[nums[i]] = nums[i];
            nums[i] = tmp;
            i--;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i) {
                return i;
            }
        }
        
        return nums.length;
    }
}