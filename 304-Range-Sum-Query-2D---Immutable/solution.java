public class NumMatrix {
    int[][] sum;
    public NumMatrix(int[][] matrix) {
        sum = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                sum[i][j] += matrix[i][j];
                if(j > 0) {
                    sum[i][j] += sum[i][j - 1];
                }
                if(i > 0) {
                    sum[i][j] += sum[i - 1][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getsum(row2, col2) - getsum(row2 - 1, col2) - getsum(row2, col2 - 1) + getsum(row1 - 1, col1 - 1);
    }
    
    public int getsum(int row, int col) {
        if(row < 0 || col < 0) {
            return 0;
        }
        
        return sum[row][col];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);