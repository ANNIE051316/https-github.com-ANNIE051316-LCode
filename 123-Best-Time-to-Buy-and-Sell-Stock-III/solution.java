public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) {
            return 0;
        }
        
        int[] onetrans = new int[prices.length];
        int curmin = prices[0];
        for(int i = 1; i < prices.length; i++) {

            onetrans[i] = Math.max(onetrans[i - 1], prices[i] - curmin);
            
            if(prices[i] < curmin){
                curmin = prices[i];
            }
        }
        
        int profit = onetrans[prices.length - 1];
        
        int curmax = prices[prices.length - 1];
        int profit2 = 0;
        for(int i = prices.length - 2; i >= 0; i--) {
            profit2 = Math.max(profit2, curmax - prices[i]);
            if(prices[i] > curmax) {
                curmax = prices[i];
            }
            profit = Math.max(profit, profit2 + onetrans[i]);
        }
        
        return profit;
    }
}