public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        
        //check each row
        boolean[] filled = new boolean[9];
        
        for(int i = 0; i < 9; i++) {
            Arrays.fill(filled, false);
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    continue;
                }
                if(filled[board[i][j] - '1']) {
                    return false;
                }
                filled[board[i][j] - '1'] = true;
            }
        }
        
        // check each col
        
        for(int j = 0; j < 9; j++) {
            Arrays.fill(filled, false);
            for(int i = 0; i < 9; i++) {
                if(board[i][j] == '.') {
                    continue;
                }
                if(filled[board[i][j] - '1']) {
                    return false;
                }
                filled[board[i][j] - '1'] = true;
            }
        }
        
        // check each square
        for(int i = 0; i < 9; i += 3) {
            for(int j = 0; j < 9; j += 3) {
                Arrays.fill(filled, false);
                for(int k = 0; k < 9; k++) {
                    int row = i + k / 3;
                    int col = j + k % 3;
                    if(board[row][col] == '.') {
                        continue;
                    }
                    if(filled[board[row][col] - '1']) {
                        return false;
                    }
                    filled[board[row][col] - '1'] = true;
                }
            }
        }
        
        return true;
        
    }
}