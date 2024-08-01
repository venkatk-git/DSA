package DynamicProgramming.Memoization.HowSum.java;

import java.util.*;

public class HowSum {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(7); nums.add(15);

        ArrayList<Integer> result = howSum(nums, 22);
        System.out.println(result);
    }

    private static ArrayList<Integer> howSum(ArrayList<Integer> nums, int target){
        if(target == 0) return new ArrayList<>();

        if(target < 0){
          return null;  
        } 

        for(int num : nums){
            ArrayList<Integer> result = howSum(nums, target - num);
            if (result != null) {
                result.add(num);
                return result;
            }
        }

        return null;
    }
}
