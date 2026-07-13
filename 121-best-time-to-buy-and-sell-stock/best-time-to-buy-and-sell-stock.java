class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minBuy = prices[0];
        int profit = 0;
        for(int i=1; i<prices.length; i++){
            profit =  prices[i] - minBuy;
            minBuy = Math.min(prices[i],minBuy);
            maxProfit = Math.max(profit, maxProfit);

        }
        return maxProfit;
    }
}