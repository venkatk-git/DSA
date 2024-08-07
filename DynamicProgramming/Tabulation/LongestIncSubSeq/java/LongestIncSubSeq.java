package DynamicProgramming.Tabulation.LongestIncSubSeq.java;

import java.util.*;

public class LongestIncSubSeq {
    public static void main(String[] args){
        int[] nums = {0, 1, 0, 3, 2, 3};
        int result = lengthOfLIS(nums);

        System.out.println(result);
    }
    
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for(int i = 0; i < nums.length; i++)
            for(int j = i + 1; j < nums.length; j++)
                if(nums[j] > nums[i])
                    dp[j] = Math.max(dp[j], dp[i] + 1);

        int result = 0;
        for (int n : dp) 
            result = Math.max(result, n);

        return result;
    }
}