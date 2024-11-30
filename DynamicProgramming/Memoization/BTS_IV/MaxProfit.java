package DynamicProgramming.Memoization.BTS_IV;

import java.util.Arrays;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[2][2][n];

        for(int[][] a: dp) {
            for(int[] b: a) {
                Arrays.fill(b, -1);
            }
        }

        return maxProfit(prices, 1, 0, 0, dp);
    }
    
    private int maxProfit(int[] prices, int buy, int i, int transactions, int[][][] dp) {
        if(i == prices.length || transactions == 2) {
            return 0;
        }

        if(dp[transactions][buy][i] != -1) {
            return dp[transactions][buy][i];
        }

        int profit;
        
        if(buy == 1) {
            int buyToday = -prices[i] + maxProfit(prices, 0, i + 1, transactions, dp);
            int dontBuyToday = maxProfit(prices, 1, i + 1, transactions, dp);

            profit = Math.max(buyToday, dontBuyToday);    
        } else {
            int sellToday = prices[i] + maxProfit(prices, 1, i + 1, transactions + 1, dp);
            int dontSellToday = maxProfit(prices, 0, i + 1, transactions, dp);

            profit = Math.max(sellToday, dontSellToday);
        }

        dp[transactions][buy][i] = Math.max(profit, 0);
        return Math.max(profit, 0);
    }
}

public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};

        System.out.println(new Solution().maxProfit(prices));
    }    
    
}