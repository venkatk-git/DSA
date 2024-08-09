package Backtracking.CombinationSum.java;

import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        int[] combinations1 = {2, 3, 6, 7};
        int target1 = 7;
        List<List<Integer>> result1 = combinationSum(combinations1, target1, 0, new ArrayList<>(), new ArrayList<>());
        System.out.println(result1);
        
        int[] combinations2 = {2, 3, 5};
        int target2 = 8;
        List<List<Integer>> result2 = combinationSum(combinations2, target2, 0, new ArrayList<>(), new ArrayList<>());
        System.out.println(result2);
        
        int[] combinations3 = {2};
        int target3 = 1;
        List<List<Integer>> result3 = combinationSum(combinations3, target3, 0, new ArrayList<>(), new ArrayList<>());
        System.out.println(result3);
    }

    private static final HashMap<Integer, List<List<Integer>>> memo = new HashMap<>();

    private static List<List<Integer>> combinationSum(int[] candidates, int target, int curr, List<Integer> combination, List<List<Integer>> combinations){
        if(memo.containsKey(target))
            memo.get(target);

        if(target == 0){
            List<Integer> validCombination = new ArrayList<>(combination);
            combinations.add(validCombination);
            combination.removeLast();
            memo.put(target, combinations);
            return combinations;
        }

        if(target < 0){
            combination.removeLast();
            return combinations;
        }

        for(int i = curr; i < candidates.length; i++){
            int candidate = candidates[i];
            List<Integer> newCombination = new ArrayList<>(combination);
            newCombination.add(candidate);
            combinationSum(candidates, target - candidate, curr++, newCombination, combinations);
        }

        memo.put(target, combinations);
        return combinations;
    }
    
 
}