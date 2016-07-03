public class Solution {
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
        int[][] reaches = new int[grid.length][grid[0].length];
        
        int numofbuilding = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    bfs(grid, i, j, numofbuilding, reaches);
                    numofbuilding++;
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == -numofbuilding) {
                    res = Math.min(res, reaches[i][j]);
                }
            }
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    public void bfs(int[][] grid, int row, int col, int numofbuilding, int[][] reaches) {
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        queue.offer(row);
        queue.offer(col);
        visited[row][col] = true;;
        int step = 0;
        
        while(!queue.isEmpty()) {
            int sz = queue.size() >> 1;
            for(int i = 0; i < sz; i++) {
                int r = queue.poll();
                int c = queue.poll();
                if(grid[r][c] == -numofbuilding) {
                    reaches[r][c] += step;
                    grid[r][c]--;
                }
                
                if(r > 0 && grid[r - 1][c] == -numofbuilding && !visited[r - 1][c]) {
                    queue.offer(r - 1);
                    queue.offer(c);
                    visited[r - 1][c] = true;
                }
                
                
                if(r < grid.length - 1 && grid[r + 1][c] == -numofbuilding && !visited[r + 1][c]) {
                    queue.offer(r + 1);
                    queue.offer(c);
                    visited[r + 1][c] = true;
                }
                
                if(c > 0 && grid[r][c - 1] == -numofbuilding && !visited[r][c - 1]) {
                    queue.offer(r);
                    queue.offer(c - 1);
                    visited[r][c - 1] = true;
                }
                
                if(c < grid[0].length - 1 &&  grid[r][c + 1] == -numofbuilding && !visited[r][c + 1]) {
                    queue.offer(r);
                    queue.offer(c + 1);
                    visited[r][c + 1] = true;
                }
            }
            step++;
        }
        
        
    }
}