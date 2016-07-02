public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] res = new int[A.length][B[0].length];
        
        for(int i = 0; i < A.length; i++) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int j = 0; j < A[0].length; j++) {
                if(A[i][j] != 0) {
                    map.put(j, A[i][j]);
                }
            }
            
            for(int j = 0; j < B[0].length; j++) {
                int tmp = 0;
                for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    int col = entry.getKey();
                    int value = entry.getValue();
                    tmp += value * B[col][j];
                }
                res[i][j] = tmp;
            }
        }
        
        return res;
    }
}