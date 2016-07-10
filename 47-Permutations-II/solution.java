public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        permuter(nums, 0, used, new ArrayList<Integer>(), res);
        return res;
    }
    
    public void permuter(int[] nums, int count, boolean[] used, List<Integer> path, List<List<Integer>> res) {
        if(count == nums.length) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(used[i]) {
                continue;
            }
            
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            
            path.add(nums[i]);
            used[i] = true;
            permuter(nums, count + 1, used, path, res);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}