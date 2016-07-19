public class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O') {
                helper(board, i, 0);
            }
            
            if(board[i][n - 1] == 'O') {
                helper(board, i, n - 1);
            }
        }
        
        for(int j = 0; j < n; j++) {
            if(board[0][j] == 'O') {
                helper(board, 0, j);
            }
            
            if(board[m - 1][j] == 'O') {
                helper(board, m - 1, j);
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '.') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    public void helper(char[][] board, int row, int col) {
        board[row][col] = '.';
        if(row > 0 && board[row - 1][col] == 'O') {
            helper(board, row - 1, col);
        }
        
        if(row < board.length - 2 && board[row + 1][col] == 'O') {
            helper(board, row + 1, col);
        }
        
        if(col > 0 && board[row][col - 1] == 'O') {
            helper(board, row, col - 1);
        }
        
        if(col < board[0].length - 2 && board[row][col + 1] == 'O') {
            helper(board, row, col + 1);
        }
    }
}