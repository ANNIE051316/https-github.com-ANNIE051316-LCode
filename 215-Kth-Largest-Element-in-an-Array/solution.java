public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(k > nums.length) {
            throw new IllegalArgumentException("");
        }
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}