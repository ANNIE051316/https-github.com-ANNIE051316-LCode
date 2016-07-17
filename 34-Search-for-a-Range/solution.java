public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        
        int left = 0, right = nums.length - 1;
        // left bound
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        
        if(left >= nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }
        int l = left;
        
        //rightbound;
        right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] <= target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        return new int[]{l, right};
    }
}