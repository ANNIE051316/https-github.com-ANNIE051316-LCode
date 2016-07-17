public class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9) {
            return;
        }
        
        solver(board, 0, 0);
    }
    
    public boolean solver(char[][] board, int i , int j) {
        if(j >= 9) {
            return solver(board, i + 1, 0);
        }
        
        if(i >= 9) {
            return true;
        }
        
        if(board[i][j] != '.') {
            return solver(board, i, j + 1);
        }
        
        for(char c = '1'; c <= '9'; c++) {
             if(valid(board, i, j, c)) {
                 board[i][j] = c;
                 if(solver(board, i, j + 1)) {
                     return true;
                 }
             }
        }
        board[i][j] = '.';
        return false;
    }
    
    public boolean valid(char[][] board, int row, int col, char c) {
        // check row
        for(int j = 0; j < 9; j++) {
            if(board[row][j] == c) {
                return false;
            }
        }
        
        for(int i = 0; i < 9; i++) {
            if(board[i][col] == c) {
                return false;
            }
        }
        
        int r = row / 3 * 3;
        int co = col / 3 * 3;
        for(int i = 0; i < 9; i++) {
            if(board[r + i /3][co + i % 3] == c) {
                return false;
            }
        }
        
        return true;
    }
}