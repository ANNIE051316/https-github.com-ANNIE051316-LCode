public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int res = 0;
        int[] hist = new int[matrix[0].length + 1];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '0') {
                    hist[j] = 0;
                }
                else {
                    hist[j] += 1;
                }
            }
            res = Math.max(res, helper(hist));
        }
        
        return res;
    }
    
    public int helper(int[] hist) {
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < hist.length; i++) {
           while(!stack.isEmpty() && hist[stack.peek()] > hist[i]) {
                    int height = hist[stack.pop()];
                    int curarea = height * (stack.isEmpty() ? i : (i - stack.peek() - 1));
                    max = Math.max(max, curarea);
           }
           stack.push(i);
        }
        
        return max;
    }
}