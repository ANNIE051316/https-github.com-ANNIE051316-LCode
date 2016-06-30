public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null) {
            return;
        }
        int left = -1, right = nums.length;
        for(int i = 0; i < right; i++) {
            if(nums[i] == 1) {
                continue;
            }
            if(nums[i] == 0) {
                if(i == left + 1) {
                    left++;
                    continue;
                }
                nums[i] = nums[++left];
                nums[left] = 0;
                i--;
            }
            else {
                if(i == right - 1) {
                    right--;
                    continue;
                }
                nums[i] = nums[--right];
                nums[right] = 2;
                i--;
            }
        }
    }
}