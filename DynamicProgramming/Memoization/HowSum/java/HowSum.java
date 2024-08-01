package DynamicProgramming.Memoization.HowSum.java;

import java.util.*;

public class HowSum {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(7); nums.add(15);

        ArrayList<Integer> result = howSum(nums, 22, new HashMap<>());
        System.out.println(result);
    }

    private static ArrayList<Integer> howSum(ArrayList<Integer> nums, int target, HashMap<Integer, ArrayList<Integer>> memo){
        if(memo.containsKey(target))
            return memo.get(target);

        if(target == 0)
            return new ArrayList<>();

        if(target < 0){
          return null;  
        } 

        for(int num : nums){
            ArrayList<Integer> result = howSum(nums, target - num, memo);
            if (result != null) {
                result.add(num);
                memo.put(target, result);
                return result;
            }
        }

        memo.put(target, null);
        return null;
    }
}
