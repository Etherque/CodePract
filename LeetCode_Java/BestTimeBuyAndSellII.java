/* Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

public class Solution {
    public int maxProfit(int[] prices) {
       if(prices == null || prices.length == 0) return 0;
       
       int profit = 0;
       for(int i = 0; i < prices.length - 1; i++) {
           int diff = prices[i + 1] - prices[i];
           if(diff > 0) profit += diff;
       }
       
       return profit;
    }
}