public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null) {
            return 0;
        }
        
        int sz = triangle.size();
        List<Integer> list = triangle.get(sz - 1);
        
        while(--sz > 0) {
            for(int i = 0; i < sz; i++) {
                list.set(i, Math.min(list.get(i), list.get(i + 1)) + triangle.get(sz - 1).get(i));
            }
        }
        
        return list.get(0);
        
    }
}