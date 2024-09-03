package LeetCode.ClimbingStairs.java;

import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 8; 
        System.out.println(climbStairs(n));
    }   
    
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++)
            dp[i] += dp[i - 1] + dp[i - 2];

        return dp[n];
    }
}
