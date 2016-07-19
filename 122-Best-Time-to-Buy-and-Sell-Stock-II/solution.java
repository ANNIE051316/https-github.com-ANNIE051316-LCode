public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) {
            return 0;
        }
        int profit = 0;
        int curmin = prices[0];
        for(int i = 1; i < prices.length; i++) {
            if(i == prices.length - 1 || prices[i] > prices[i + 1]) {
                if(curmin < prices[i]) {
                    profit += prices[i] - curmin;
                }
                curmin = prices[i];
            }
            
            if(curmin > prices[i]) {
                curmin = prices[i];
            }
        }
        return profit;
    }
}