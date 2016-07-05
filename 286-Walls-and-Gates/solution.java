public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, - 1}};
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0) {
                    queue.offer(i);
                    queue.offer(j);
                }
            }
        }
        while(!queue.isEmpty()) {
            int row = queue.poll();
            int col = queue.poll();
            for(int[] direction : directions) {
                int r = row + direction[0];
                int c = col + direction[1];
                if(r < 0 || r >= rooms.length || c < 0 || c >= rooms[0].length || rooms[r][c] != Integer.MAX_VALUE) {
                    continue;
                }
                
                queue.offer(r);
                queue.offer(c);
                rooms[r][c] = rooms[row][col] + 1;
            }
        }
    
    }
}