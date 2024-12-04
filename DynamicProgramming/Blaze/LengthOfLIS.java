package DynamicProgramming.Blaze;

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1) {
            return 1;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        int max = 1;
        for(int i = 0; i < nums.length; i++) {
            int res = lengthOfLIS(nums, i, dp);
            System.out.println(nums[i] + ": " + res);
            max = Math.max(max, res);
        }

        return max;
    }

    private int lengthOfLIS(int[] nums, int i, int[] dp) {
        if(i == nums.length - 1) {
            return 1;
        }           
        
        if(dp[i] != -1) {
            return dp[i];
        }

        int max = 1; 
        for(int j = i + 1; j < nums.length; j++) {
            if(nums[j] > nums[i]) {
                int res = 1 + lengthOfLIS(nums, j, dp);
                max = Math.max(max, res);
            }
        }

        dp[i] = max;
        return max;
    }
}


public class LengthOfLIS {
    public static void main(String[] args) {
        int[] nums = {1,3,6,7,9,4,10,5,6};
        
        System.out.println(new Solution().lengthOfLIS(nums));
    }
}