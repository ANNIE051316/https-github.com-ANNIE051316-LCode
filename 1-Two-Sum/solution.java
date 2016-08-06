public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Input array has a length less than 2");
        }
        
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        
        throw new IllegalArugmentException("No such pair of number have a sum equal to " + target);
        
        
    }
}