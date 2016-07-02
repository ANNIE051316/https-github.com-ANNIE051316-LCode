public class Solution {
    public int numberOfPatterns(int m, int n) {
        int res = 0;
        for(int i = m; i <= n; i++) {
            res += dfs(0, 1, new boolean[9], i - 1) * 4;
            res += dfs(0, 2, new boolean[9], i - 1) * 4;
            res += dfs(0, 5, new boolean[9], i - 1);
        }
        
        return res;
    }
    
    public int dfs(int last, int cur, boolean[] visited, int numToAdd) {
        if(numToAdd == 0) {
            return 1;
        }
        visited[cur - 1] = true;
        int res = 0;
        for(int i = 1; i <= 9; i++) {
            if(isValid(visited, i, cur)) {
                res += dfs(cur, i, visited, numToAdd -1);
            }
        }
        visited[cur - 1] = false;
        return res;
    }
    
    
    public boolean isValid(boolean[] visited, int cur, int last) {
        if(visited[cur - 1]) {
            return false;
        }
        int min = Math.min(cur, last);
        int max = Math.max(cur, last);
        int mid = (min + max) / 2;
        if((min == 1 || min == 4 || min == 7) && max == min + 2) {
            return visited[mid - 1];
        }
        
        if(min < 4 && max == min + 6) {
            return visited[mid - 1];
        }
        if(min == 1 && max == 9 || min == 3 && max == 7) {
            return visited[mid - 1];
        }
        return true;
    }
}