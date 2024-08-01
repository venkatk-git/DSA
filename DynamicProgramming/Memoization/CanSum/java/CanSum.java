package DynamicProgramming.Memoization.CanSum.java;

import java.util.HashMap;

public class CanSum {
    public static void main(String[] args){
        int[] nums = {7, 14};
        int target = 300;
        System.out.println(canSum(nums, target, new HashMap<>()));
    }

    private static boolean canSum(int[] nums, int target, HashMap<Integer, Boolean> memo){
        if(memo.containsKey(target)) 
            return memo.get(target);

        if(target == 0) 
            return true;
        
        if(target < 0)
            return false;

        for(int n : nums){
            int rem = target - n;
            if(canSum(nums, rem, memo)){
                memo.put(target, true);
                return true;
            }
        }

        memo.put(target, false);
        return false;
    }
}
