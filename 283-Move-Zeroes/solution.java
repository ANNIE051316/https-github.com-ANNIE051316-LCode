public class Solution {
    public void moveZeroes(int[] nums) {
        int prev = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[++prev] = nums[i];
            }
        }
        
        for(int i = prev + 1; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}