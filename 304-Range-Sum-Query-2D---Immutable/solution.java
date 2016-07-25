public class NumMatrix {
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        this.matrix = matrix;
        for(int i = 1; i < matrix.length; i++) {
            for(j = 0; j < matrix[0].length; j++) {
                matrix[i][j] += matrix[i - 1][j];
            }
        }
        
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int j = col1; j <= col2; j++) {
            sum += matrix[row2][j] - (row1 > 0 ? matrix[row1 - 1, j] : 0);
        }
        
        return sum;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);