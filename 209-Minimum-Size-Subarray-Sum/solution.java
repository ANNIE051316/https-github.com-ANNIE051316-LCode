public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int[] sum = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int res = Integer.MAX_VALUE;
        for(int i = 1; i <= nums.length; i++) {
            if(sum[i] < s) {
                continue;
            }
            
            int index = binarysearch(sum[i] - s, 0, i - 1, sum);
            res = Math.min(res, i - index);
        }
        
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    
    private int binarysearch(int target, int left, int right, int[] sum) {
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(sum[mid] == target) {
                return mid;
            }
            else if(sum[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return right;
    }
}