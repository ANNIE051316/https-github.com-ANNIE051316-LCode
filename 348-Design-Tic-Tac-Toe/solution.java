public class TicTacToe {
    int[][] gameboard;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        gameboard = new int[n][n];
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
        gameboard[row][col] = player;
        int count = 0;
        for(int i = 0; i < gameboard[0].length; i++) {
            if(gameboard[row][i] != player){
                break;
            }
            else {
                count++;
            }
        }
        
        if(count == gameboard.length) {
            return player;
        }
        count = 0;
        
        for(int i = 0; i < gameboard.length; i++) {
            if(gameboard[i][col] != player) {
                break;
            }
            count++;
        }
        
        if(count == gameboard.length) {
            return player;
        }
        
        
        if(row == col) {
            count = 0;
            for(int i = 0; i < gameboard.length; i++) {
                if(gameboard[i][i] != player) {
                    break;
                }
                count++;
            }
            if(count == gameboard.length) {
                return player;
            }
        }
        
        if(row + col == gameboard.length - 1) {
            count = 0;
            for(int i = 0; i < gameboard.length; i++) {
                if(gameboard[i][gameboard.length - 1 - i] != player) {
                    break;
                }
                count++;
            }
            if(count == gameboard.length) {
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