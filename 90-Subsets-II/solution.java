public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        int presize = 0;
        for(int i = 0; i < nums.length; i++) {
            int sz = res.size();
            int start = 0;
            if(i > 0 && nums[i] == nums[i - 1]) {
                start = presize;
            }
            
            for(int j = start; j < sz; j++) {
                List<Integer> tmp = new ArrayList<Integer>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
            presize = sz;
        }
        
        return res;
        
    }
}