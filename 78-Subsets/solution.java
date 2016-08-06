public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        res.add(new ArrayList());
        for(int num : nums) {
            int sz = res.size();
            for(int i = 0; i < sz; i++) {
                List<Integer> tmp = new ArrayList(res.get(i));
                tmp.add(num);
                res.add(tmp);
            }
        }
        return res;
    }
}