public class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1;
        for(int i = nums.length - 1; i > 0; i--) {
            if(nums[i] > nums[i - 1]) {
                index = i - 1;
                break;
            }
        }
        if(index >= 0) {
            int i = nums.length - 1;
            while(i > index) {
                if(nums[i] > nums[index]) {
                    int tmp = nums[index];
                    nums[index] = nums[i];
                    nums[i] = tmp;
                    break;
                }
                i--;
            }
        }
        
        swap(nums, index + 1, nums.length - 1);
    }
    
    public void swap(int[] nums, int left, int right) {
        while(left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
}