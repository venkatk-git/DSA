package DynamicProgramming.Tabulation.BTS_IV;

import java.util.Arrays;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[3][2][n + 1];

        for(int t = 0; t <= 2; t++) {
            dp[t][0][n] = 0;
            dp[t][1][n] = 0;
        }

        for(int i = n - 1; i >= 0; i--) {
            for(int t = 0; t <= 2; t++) {
                // Buy
                int buyToday = -prices[i] + dp[t][0][i + 1];
                int dontBuyToday = dp[t][1][i + 1];
                dp[t][1][i] = Math.max(buyToday, dontBuyToday);
                
                // Sell
                int sellToday = prices[i] + dp[t - 1][1][i + 1];
                int dontSellToday = dp[t][0][i + 1];
                dp[t][0][i] = Math.max(sellToday, dontSellToday);
            }
        }

        for(int[][] a: dp) {
            for(int[] b: a) {
                System.out.println(Arrays.toString(b));
            }
        }

        return dp[2][1][0];
    }
}

public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};

        System.out.println(new Solution().maxProfit(prices));
    }    
    
}