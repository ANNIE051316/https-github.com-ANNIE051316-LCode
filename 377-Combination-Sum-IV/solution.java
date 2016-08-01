public class Solution {
    public int combinationSum4(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList();
        if(nums == null || nums.length == 0) {
            return res.size();
        }
        
        Arrays.sort(nums);
        helper(nums, target, new ArrayList<Integer>(), res);
        return res.size();
    }
    
    public void helper(int[] nums, int target, List<Integer> path, List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > target) {
                break;
            }
            path.add(nums[i]);
            helper(nums, target - nums[i], path, res);
            path.remove(path.size() - 1);
        }
    }
}