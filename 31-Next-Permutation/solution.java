public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return;
        }
        
        int index = -1;
        for(int i = nums.length - 1; i > 0; i--) {
            if(nums[i] > nums[i - 1]) {
                index = i - 1;
                break;
            }
        }
        
        if(index != -1) {
            for(int i = nums.length - 1; i > index; i--) {
                if(nums[i] > nums[index]) {
                    swap(nums, i, index);
                    break;
                }
            }
        }
        
        int left = index + 1, right = nums.length - 1;
        while(left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
    
    public void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}