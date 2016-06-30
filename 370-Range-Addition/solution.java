public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[]  res = new int[length];
        for(int[] update : updates) {
            if(update[0] > 0) {
                res[update[0] - 1] -= update[2];
            }
            res[update[1]] += update[2];
        }
        
        for(int i = length - 2; i >= 0; i--) {
            res[i] += res[i + 1];
        }
        return res;
    }
}