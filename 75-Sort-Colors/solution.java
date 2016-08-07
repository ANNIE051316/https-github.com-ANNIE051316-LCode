public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        int left = -1, right = nums.length;
        
        for(int i = 0; i < right; i++) {
            if(nums[i] == 1) {
                continue;
            }
            else if(nums[i] == 0){
                left++;
                if(i != left) {
                    nums[i] = nums[left];
                    nums[left] = 0;
                    i--;
                }
            }
            else {
                right--;
                nums[i] = nums[right];
                nums[right] = 2;
                i--;
            }
        }
        
    }
}