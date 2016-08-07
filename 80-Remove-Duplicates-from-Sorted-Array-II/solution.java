public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int prev = -1; 
        int i = 0;
        while(i < nums.length) {
            if(prev < 1 || i < 2 || nums[prev - 1] != nums[i]) {
                nums[++prev] = nums[i];
            }
            i++;
        }
        
        return prev + 1;
    }
}