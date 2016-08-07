public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int[] ids = new int[grid.length * grid[0].length];
        for(int i = 0; i < ids.length; i++) {
            ids[i] = i;
        }
        int[] res = new int[1];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    res[0]++;
                }
            }
        }
        int m = grid.length; 
        int n = grid[0].length;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                   if(i > 0 && grid[i - 1][j] == '1') {
                       union(ids, i * n + j, (i - 1) * n + j, res);
                   }
                   
                   if(j > 0 && grid[i][j - 1] == '1') {
                       union(ids, i * n + j, i * n + j - 1, res);
                   }
                }
            }
        }
        
        return res[0];
    }
    
    public void union(int[] ids, int i, int j, int[] res) {
        int r1 = find(ids, i);
        int r2 = find(ids, j);
        if(r1 != r2) {
            res[0]--;
            ids[r1] = r2;
        }
    }
    
    public int find(int[] ids, int i) {
        while(i != ids[i]) {
            ids[i] = ids[ids[i]];
            i = ids[i];
        }
        
        return i;
    }
}