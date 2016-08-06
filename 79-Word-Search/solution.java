public class Solution {
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0) {
            return true;
        }
        
        if(board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(backtracking(board, i, j, word, 0, directions)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean backtracking(char[][] board, int row, int col, String word, int index, int[][] directions) {
        if(index == word.length()) {
            return true;
        }
        char c = word.charAt(index);
        
        if(board[row][col] != c) {
            return false;
        }
        if(index + 1 == word.length()) {
            return true;
        }
        
        board[row][col] = '.';
        
        for(int[] direction : directions) {
            int newrow = row + direction[0];
            int newcol = col + direction[1];
            if(newrow < 0 || newrow > board.length - 1 || newcol < 0 || newcol > board[0].length - 1) {
                continue;
            }
            if(backtracking(board, newrow, newcol, word, index + 1, directions)) {
                board[row][col] = c;
                return true;
            }
        }
        board[row][col] = c;
        return false;
        
    }
}