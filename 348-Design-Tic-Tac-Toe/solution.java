public class TicTacToe {
    int[] cols;
    int[] rows;
    int diagonal = 0;
    int anti_diagonal = 0;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        cols = new int[n];
        rows = new int[n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if(player == 1) {
            cols[col]++;
            rows[row]++;
            if(row == col) {
                diagonal++;
            }
            
            if(row + col == cols.length - 1) {
                anti_diagonal++;
            }
            if(cols[col] == cols.length || rows[row] == cols.length || diagonal == cols.length || anti_diagonal == cols.length) {
                return player;
             }
        }
        else {
            cols[col]--;
            rows[row]--;
            if(row == col) {
                diagonal--;
            }
            
            if(row + col == cols.length - 1) {
                anti_diagonal--;
            }
            if(cols[col] == -cols.length || rows[row] == -cols.length || diagonal == -cols.length || anti_diagonal == -cols.length) {
                return player;
             }
        }
        return 0;

    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */