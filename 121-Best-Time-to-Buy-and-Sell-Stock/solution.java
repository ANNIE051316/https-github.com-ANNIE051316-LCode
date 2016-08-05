public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }   
        
        int res = 0;
        int curmin = prices[0];
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > curmin) {
                res = Math.max(res, prices[i] - curmin);
            }
            else {
                curmin = prices[i];
            }
        }
        
        return res;
    }
}