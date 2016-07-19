public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0;
        int curmin = prices[0];
        
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < prices[i - 1]) {
                profit += prices[i - 1] - curmin;
                curmin = prices[i];
            }
            
            if(i == prices.length - 1 && curmin < prices[i]) {
                profit += prices[i] - curmin;
            }
        }
        
        return profit;
    }
}