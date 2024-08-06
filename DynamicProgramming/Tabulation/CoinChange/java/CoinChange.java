package DynamicProgramming.Tabulation.CoinChange.java;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2147483647};
        int amount = 2;

        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        if(amount == 0)
            return 0;
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        dp[0] = 0;

        for(int i = 0; i < amount; i++){
            if(dp[i] == -1)
                continue;
            
            for(int coin : coins){
                if((long)i + (long)coin > amount)
                    continue;
                
                if(dp[i + coin] == -1 || dp[i + coin] > dp[i] + 1)
                    dp[i + coin] = dp[i] + 1;
            }
        }

        return dp[amount];     
    }    
}
