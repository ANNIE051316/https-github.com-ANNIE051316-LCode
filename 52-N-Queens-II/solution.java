public class Solution {
    public int totalNQueens(int n) {
        int[] queens = new int[n];
        int[] res = new int[1];
        solver(queens, 0, res);
        return res[0];
    }
    
    public void solver(int[] queens, int row, int[] res) {
        if(row >= queens.length) {
            res[0]++;
            return;
        }
        
        for(int i = 0; i < queens.length; i++) {
            if(valid(queens, row, i)) {
                queens[row] = i;
                solver(queens, row + 1, res);
            }
        }
    }
    
    public boolean valid(int[] queens, int row, int col) {
        for(int i = 0; i < row; i++) {
            if(queens[i] == col || Math.abs(row - i) == Math.abs(col - queens[i])) {
                return false;
            }
        }
        
        return true;
    }
}