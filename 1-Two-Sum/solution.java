public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Input array has a length less than 2");
        }
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            else {
                map.put(target - nums[i], i);
            }
        }
        
        throw new IllegalArgumentException("No such pair of number have a sum equal to " + target);
        
        
    }
}