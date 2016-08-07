public class Solution {
    public static int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int island = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    island++;
                    helper(grid, i, j);
                }
            }
        }
        
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '.') {
                    grid[i][j] = '1';
                }
            }
        }
        return island;
    }
    
    public void helper(char[][] grid, int row, int col) {
        grid[row][col] = '.';
        for(int[] direction : directions) {
            int newrow = row + direction[0];
            int newcol = col + direction[1];
            if(newrow < 0 || newrow >= grid.length || newcol < 0 || newcol >= grid[0].length || gird[newrow][newcol] != '1') {
                continue;
            }
            
            helper(grid, newrow, newcol);
        }
    }
}