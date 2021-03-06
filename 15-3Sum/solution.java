public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        if(nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i -1]) {
                continue;
            }
            
            int left = i + 1, right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    List<Integer> tmp = new ArrayList();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    res.add(tmp);
                    while(left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    left++;
                    while(left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    right--;
                }
                else if(sum > 0) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        
        return res;
    }
}