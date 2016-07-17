public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int startx = 0, endx = n - 1, starty = 0, endy = n - 1;
        int cur = 1;
        while(true) {
            // top
            for(int i = starty; i <= endy; i++) {
                matrix[startx][i] = cur;
                cur++;
            }
            if(++startx > endx) {
                break;
            }
            
            for(int i = startx; i <= endx; i++) {
                matrix[i][endy] = cur;
                cur++;
            }
            
            if(--endy < starty) {
                break;
            }
            
            for(int i = endy; i >= starty; i--) {
                matrix[endx][i] = cur;
                cur++;
            }
            if(--endx < startx) {
                break;
            }
            
            for(int i = endx; i >= startx; i--) {
                matrix[i][starty] = cur;
                cur++;
            }
            if(++starty > endy) {
                break;
            }
        }
        
        return matrix;
    }
}