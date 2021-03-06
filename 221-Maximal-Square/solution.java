public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int[][] counts = new int[matrix.length][matrix[0].length];
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1') {
                    if( i > 0 && j > 0) {
                        counts[i][j] = Math.min(counts[i - 1][j], Math.min(counts[i][j - 1], counts[i - 1][j - 1])) + 1;
                    }
                    else {
                        counts[i][j] = 1;
                    }
                    max = Math.max(max, counts[i][j]);
                }
            }
        }
        
        return max * max;
    }
}