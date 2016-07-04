public class NumMatrix {
    int[][] nums;
    int[][] bitsums;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        nums = new int[matrix.length][matrix[0].length];
        bitsums = new int[matrix.length][matrix[0].length];
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        int dif = val - nums[row][col];
        nums[row][col] = val;
        
        for(int i = row; i < nums.length; i += lowBit(i + 1)) {
            for(int j = col; j < nums[0].length; j += lowBit(j + 1)) {
                bitsums += dif;
            }
        }
    }
        

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumHelper(row2, col2) - sumHelper(row1 - 1, col1 - 1);
    }
    
    public int sumHelper(int row, int col) {
        int sum = 0;
        for(int i = row; i >= 0; i -= lowBit(i + 1)) {
            for(int j = col; j >= 0; j -= lowBit(j + 1)) {
                sum += bitsums[i][j];
            }
        }
        return sum;
    }
    
    private int lowBit(int x) {
        return x & (-x);
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);