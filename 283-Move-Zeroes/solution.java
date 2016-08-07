public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        
        int prev = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                if(++prev == i) {
                    continue;
                }
                nums[prev] = nums[i];
                nums[i] = 0;
            }
        }
    }
}