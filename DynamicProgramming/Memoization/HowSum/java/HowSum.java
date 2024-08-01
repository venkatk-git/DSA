package DynamicProgramming.Memoization.HowSum.java;

import java.util.*;

public class HowSum {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(7); nums.add(15);

        ArrayList<Integer> result = howSum(nums, 22, new ArrayList<>(), new HashMap<>());
        System.out.println(result);
    }

    private static ArrayList<Integer> howSum(ArrayList<Integer> nums, int target, ArrayList<Integer> list, HashMap<Integer, ArrayList<Integer>> memo){
        if(memo.containsKey(target))
            return memo.get(target);
        
        if(target == 0) 
            return list;

        if(target < 0){
          return null;  
        } 

        for(int num : nums){
            list.add(num);
            ArrayList<Integer> result = howSum(nums, target - num, list, memo);
            if (result != null) {
                memo.put(target, result);
                return result;
            }
            list.remove(list.size() - 1);
        }

        memo.put(target, null);
        return null;
    }
}
