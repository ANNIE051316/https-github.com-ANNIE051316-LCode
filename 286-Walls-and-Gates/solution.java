public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0) {
                    queue.offer(i);
                    queue.offer(j);
                    visited[i][j] = true;
                }
            }
        }
        int step = 1;
        while(!queue.isEmpty()) {
            int sz = queue.size() >> 1;
            for(int i = 0; i < sz; i++) {
                int row = queue.poll();
                int col = queue.poll();
                if(row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
                    visited[row - 1][col] = true;
                    rooms[row - 1][col] = step;
                    queue.offer(row - 1);
                    queue.offer(col);
                }
                if(row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
                    visited[row + 1][col] = true;
                    rooms[row + 1][col] = step;
                    queue.offer(row + 1);
                    queue.offer(col);
                }
                
                if(col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
                    visited[row][col - 1] = true;
                    rooms[row][col - 1] = step;
                    queue.offer(row);
                    queue.offer(col - 1);
                }
                
                if(col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
                    visited[row][col + 1] = true;
                    rooms[row][col + 1] = step;
                    queue.offer(row);
                    queue.offer(col + 1);
                }
            }
            step++;
        }
        
    
    }
}