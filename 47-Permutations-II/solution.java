public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        
        for(int i = 0; i < nums.length; i++) {
            List<List<Integer>> tmpres = new ArrayList<List<Integer>>();
            Set<List<Integer>> set = new HashSet<List<Integer>>();
            for(List<Integer> list : res) {
                int sz = list.size();
                for(int j = 0; j <= sz; j++) {
                    List<Integer> tmp = new ArrayList<Integer>(list);
                    tmp.add(j, nums[i]);
                    if(!set.contains(tmp)) {
                        set.add(tmp);
                        tmpres.add(tmp);
                    }
                }
            }
            
            res = tmpres;
        }
        
        return res;
        
    }
}