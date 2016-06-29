public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        
        for(int num : nums) {
            int sz = res.size();
            for(int i = 0; i < sz; i++) {
                List<Integer> tmp = new ArrayList<Integer>(res.get(i));
                tmp.add(num);
                res.add(tmp);
            }
        }
        
        return res;
    }
}