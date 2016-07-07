public class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        } 
        
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int j = 0; j < costs[0].length; j++) {
            if(costs[0][j] <= min1) {
                min2 = min1;
                min1 = costs[0][j];
            }
            else if(costs[0][j] < min2) {
                min2 = costs[0][j];
            }
        }
        
        for(int i = 1; i < costs.length; i++) {
            int tmpmin1 = Integer.MAX_VALUE;
            int tmpmin2 = Integer.MAX_VALUE;
            for(int j = 0; j < costs[0].length; j++) {
                if(costs[i - 1][j] == min1) {
                    costs[i][j] += min2;
                }
                else {
                    costs[i][j] += min1;
                }
                if(costs[i][j] <= tmpmin1) {
                    tmpmin2 = tmpmin1;
                    tmpmin1 = costs[i][j];
                }
                else if(costs[i][j] < tmpmin2) {
                    tmpmin2 = costs[i][j];
                }
            }
            min1 = tmpmin1;
            min2 = tmpmin2;
        }
        
        return min1;
    }
}