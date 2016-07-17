public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int startx = 0, endx = matrix.length - 1, starty = 0, endy = matrix[0].length - 1;
        while(true) {
            // top
            
            for(int i = starty; i <= endy; i++) {
                res.add(matrix[startx][i]);
            }
            startx++;
            if(startx > endx) {
                break;
            }
            
            //right
            for(int i = startx; i <= endx; i++) {
                res.add(matrix[i][endy]);
            }
            if(starty > --endy) {
                break;
            }
            //bottom
            for(int i = endy; i >= starty; i++) {
                res.add(matrix[endx][i]);
            }
            
            if(--endx < startx) {
                break;
            }
            
            //left
            for(int i = endx; i >= startx; i++) {
                res.add(matrix[i][starty]);
            }
            if(++starty > endy) {
                break;
            }
        }
        return res;
    }
}