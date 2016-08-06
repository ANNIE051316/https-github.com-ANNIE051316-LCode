public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        res.add(new ArrayList());
        int prevsize = 1;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            int sz = res.size();
            int start = 0;
            if(i > 0 && nums[i] == nums[i - 1]) {
                start = prevsize;
            }
            for(int j = start; j < sz; j++) {
                List<Integer> tmp = new ArrayList(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
            
            prevsize = sz;
        }
        
        return res;
    }
}