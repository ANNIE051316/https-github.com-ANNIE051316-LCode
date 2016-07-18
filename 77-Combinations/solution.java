public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        combinehelper(1, n, new ArrayList<Integer>(), k, res);
        return res;
    }
    
    public void combinehelper(int start, int end, List<Integer> path, int numneeded, List<List<Integer>> res) {
        if(numneeded == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        
        if(start > end || end - start + 1 < numneeded) {
            return;
        }
        
        for(int i = start; i <= end; i++) {
            path.add(i);
            combinehelper(i + 1, end, path, numneeded - 1, res);
            path.remove(path.size() - 1);
        }
    }
}