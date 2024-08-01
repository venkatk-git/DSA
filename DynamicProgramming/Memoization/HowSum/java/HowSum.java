package DynamicProgramming.Memoization.HowSum.java;

import java.util.*;

public class HowSum {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(5); nums.add(3); nums.add(4); nums.add(7);

        ArrayList<Integer> result = howSum(nums, 7);
        System.out.println(result);
    }

    private static ArrayList<Integer> howSum(ArrayList<Integer> nums, int target){
        if(target == 0) return new ArrayList<>();

        if(target < 0) return null;

        for(int num : nums){
            ArrayList<Integer> result = howSum(nums, target - num);
            if(result != null){
                result.add(num);
                return result;
            }
        }

        return null;
    }
}
