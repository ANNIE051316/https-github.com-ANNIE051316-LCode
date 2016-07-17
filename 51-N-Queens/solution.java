public class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[] queens = new int[n];
        List<List<String>> res = new ArrayList<List<String>>();
        solver(queens, 0, res);
        return res;
    }
    
    public void solver(int[] queens, int row, List<List<String>> res) {
        if(row == queens.length) {
            List<String> tmp = new ArrayList<String>();
            for(int i = 0; i < queens.length; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < queens.length; j++) {
                    if(j != queens[i]) {
                        sb.append('.');
                    }
                    else {
                        sb.append('Q');
                    }
                }
                tmp.add(sb.toString());
            }
            res.add(tmp);
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
        // same col
        for(int i = 0; i < row; i++) {
            if(queens[i] == col || Math.abs(i - row) == Math.abs(col - queens[i])) {
                return false;
            }
        }
        
        return true;
    }
}