public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[][] counts = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 'E') {
                    updateHelper(grid, i, j, counts);
                }
            }
        }
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                res = Math.max(res, counts[i][j]);
            }
        }
        
        return res;
    }
    
    public void updateHelper(char[][] grid, int row, int col, int[][] counts) {
        int i = row;
        while(i > 0 && grid[i - 1][col] != 'W') {
            if(grid[i - 1][col] == '0') {
                counts[i - 1][col] += 1; 
            }
            i--;
        }
        
        i = row;
         while(i < grid.length - 1 && grid[i + 1][col] != 'W') {
            if(grid[i + 1][col] == '0') {
                counts[i + 1][col] += 1; 
            }
            i++;
        }
        
        i = col;
        while(i > 0 && grid[row][i - 1] != 'W') {
            if(grid[row][i - 1] == '0') {
                counts[row][i - 1] += 1;
            }
            i--;
        }
        
        i = col;
        while(i < grid[0].length - 1 && grid[row][i + 1] != 'W') {
            if(grid[row][i + 1] == '0') {
                counts[row][i + 1] += 1;
            }
            i++;
        } 
    }
}