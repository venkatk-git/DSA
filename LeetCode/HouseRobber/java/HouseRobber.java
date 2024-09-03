package LeetCode.HouseRobber.java;

import java.util.*;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        System.out.println(rob(nums1));
        
        int[] nums2 = {2, 1, 1, 2};
        System.out.println(rob(nums2));
    }

    /* DP Memoization Apprach */
    private static int rob(int[] nums, int i, HashMap<Integer, Integer> memo){
        if(memo.containsKey(i))
            return memo.get(i);

        if(i >= nums.length)
            return 0;
        
        int rob = nums[i] + rob(nums, i + 2, memo);
        int dontRob = rob(nums, i + 1, memo);
        
        return memo.put(i, Math.max(rob, dontRob));
    }

    /* DP Tabulation Approach & O(1) Approach */
    private static int rob(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 0);

        int prev = 0;
        int prevprev = 0;

        for(int i = 0; i < n; i++){
            dp[i] = Math.max(prevprev + nums[i], prev);
            prevprev = prev;
            prev = dp[i];
        }

        /** DP O(1) Approach 
        ** int max = 0;
        ** 
        ** for(int i = 0; i < nums.length; i++){
        **    max = Math.max(prevprev + nums[i], prev);
        **    prevprev = prev;
        **    prev = max;
        ** }
        **
        ** return max;
        */

        return dp[n - 1];
    }

}
