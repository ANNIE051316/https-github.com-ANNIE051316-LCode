public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[] colCounts = new int[grid[0].length];
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            int rowCount = 0;
            for(int j = 0; j < grid[0].length; j++) {
                if(j == 0 || grid[i][j - 1] == 'W') {
                    rowCount = 0;
                    for(int k = j; k < grid[0].length && grid[i][k] != 'W'; k++) {
                        if(grid[i][k] == 'E') {
                            rowCount++;
                        }
                    }
                }
                
                if(i == 0 || grid[i - 1][j] == 'W') {
                    colCounts[j] = 0;
                    for(int k = i; k < grid.length && grid[k][j] != 'W'; k++) {
                        if(grid[k][j] == 'E') {
                            colCounts[j]++;
                        }
                    }
                }
                
                if(grid[i][j] == '0') {
                    res = Math.max(res, colCounts[j] + rowCount);
                }
            }
        }
        
        return res;
    }
}