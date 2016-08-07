public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        
        int count0 = 0, count1 = 0;
        for(int num : nums) {
            if(num == 0) {
                count0++;
            }
            else if(num == 1) {
                count1++;
            }
        }
        int index = 0;
        while(index < count0) {
            nums[index++] = 0;
        }
        while(index < count0 + count1) {
            nums[index++] = 1;
        }
        while(index < nums.length) {
            nums[index++] = 2;
        }
    }
}