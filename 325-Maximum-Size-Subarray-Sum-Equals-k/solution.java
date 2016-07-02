public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null) {
            return 0;
        }
        
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum == k) {
                res = Math.max(res, i + 1);
            }
            
            if(map.containsKey(sum - k)) {
                res = Math.max(res, i - map.get(sum - k));
            }
            
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        
        return res;
    }
}