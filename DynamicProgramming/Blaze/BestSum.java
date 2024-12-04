package DynamicProgramming.Blaze;

import java.util.*;

public class BestSum {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(2); nums.add(4);

        ArrayList<Integer> result = bestSum(nums, 6, new HashMap<>());

        System.out.println(result);
    }

    private static ArrayList<Integer> bestSum(ArrayList<Integer> nums, int target, HashMap<Integer, ArrayList<Integer>> memo){
        if(memo.containsKey(target))
            return memo.get(target);

        if(target == 0)
            return new ArrayList<>();

        if(target < 0)
            return null;
        
        ArrayList<Integer> shortList = null;

        for(int num : nums){
            int remainder = target - num;
            ArrayList<Integer> result = bestSum(nums, remainder, memo);
            
            if(result != null){
                ArrayList<Integer> combination = new ArrayList<>(result);
                combination.add(num);
                if(shortList == null || combination.size() < shortList.size())
                    shortList = combination;
            }
        }

        memo.put(target, shortList);
        return shortList;
    }
}
