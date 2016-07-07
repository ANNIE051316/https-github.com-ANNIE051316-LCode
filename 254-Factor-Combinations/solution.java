public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(new ArrayList<Integer>(), 2, n, res);
        return res;
    }
    
    public void backtrack(List<Integer> path, int start, int target, List<List<Integer>> res) {
        if(start > target) {
            return;
        }
        
 /*       if(start == target) {
            path.add(start);
            res.add(new ArrayList<Integer>(path));
            return;
        }
   */     
        int end = (int)Math.sqrt(target);
        
        for(int i = start; i <= end; i++) {
            if(target % i == 0) {
                path.add(i);
                path.add(target / i);
                res.add(new ArrayList<Integer>(path));
                path.remove(path.size() - 1);
                backtrack(path, i, target / i, res);
                path.remove(path.size() - 1);
            }
        }
        
    } 
}