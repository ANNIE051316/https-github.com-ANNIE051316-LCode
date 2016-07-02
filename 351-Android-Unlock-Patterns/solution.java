public class Solution {
    public int numberOfPatterns(int m, int n) {
        List<List<Integer>> res = new ArrayList();
        for(int i = m; i <= n ; i++) {
            helper(0, new ArrayList<Integer>(), i, new HashSet<Integer>(), res);
        } 
        
        return res.size();
    }
    
    public void helper(int cur, List<Integer> path, int numToAdd, Set<Integer> visited, List<List<Integer>> res) {
        if(numToAdd == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = 1; i <= 9; i++) {
            if(visited.contains(i)) {
                continue;
            }
            
            if(cur == 1 && (i == 3 && !visited.contains(2) || i == 9 && !visited.contains(5) || i == 7 && !visited.contains(4))) {
                continue;
            }
            
            if(cur == 2 && i == 8 && !visited.contains(5)) {
                continue;
            }
            
            if(cur == 3 && (i == 1 && !visited.contains(2) || i == 7 && !visited.contains(5) || i == 9 && !visited.contains(6))) {
                continue;
            }
            
            if(cur == 4 && i == 6 && !visited.contains(5)) {
                continue;
            }
            
            if(cur == 6 && i == 4 && !visited.contains(5)) {
                continue;
            }
            
            if(cur == 7 && (i == 1 && !visited.contains(4) || i == 3 && !visited.contains(5) || i == 9 && !visited.contains(8))) {
                continue;
            }
            
            if(cur == 8 && i == 2 && !visited.contains(5)) {
                continue;
            }
            
            if(cur == 9 && (i == 1 && !visited.contains(5) || i == 3 && !visited.contains(6) || i == 7 && !visited.contains(8))) {
                continue;
            }
            
            path.add(i);
            visited.add(i);
            helper(i, path, numToAdd - 1, visited, res);
            visited.remove(i);
            path.remove(path.size() - 1);
         }
    }
    
}