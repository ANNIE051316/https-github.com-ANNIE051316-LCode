public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) {
            return 0;
        }
        int[] buys = new int[prices.length];
        int[] sells = new int[prices.length];
        buys[0] = -prices[0];
        buys[1] = Math.max(-prices[1], buys[0]);
        sells[1] = Math.max(0, prices[1] - prices[0]);
        
        for(int i = 2; i < prices.length; i++) {
            buys[i] = Math.max(buys[i - 1], sells[i - 2] - prices[i]);
            sells[i] = Math.max(sells[i - 1], buys[i] + prices[i]);
        }
        
        return sells[prices.length - 1];
    }
}