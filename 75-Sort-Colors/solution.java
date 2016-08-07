public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        int end0 = -1, start2 = nums.length;
        while(start2 - 1 >= 0 && nums[start2 - 1] == 2) {
            start2--;
        }
        int i = 0;
        while(i < start2){
            if(nums[i] == 0) {
                if(i == end0 + 1) {
                    i++;
                }
                else {
                    nums[i] = nums[end0 + 1];
                    nums[end0 + 1] = 0;
                }
                end0 += 1;
            }
            else if(nums[i] == 2 && i != start2 - 1) {
                nums[i] = nums[start2 - 1];
                nums[start2 - 1] = 2;
                while(start2 - 1 >= 0 && nums[start2 - 2] == 2) {
                    start2--;
                }
            }
            else {
                i++;
            }
        }
    }
}