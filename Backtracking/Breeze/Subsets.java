package Backtracking.Breeze;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        subSets(nums, 0, new ArrayList<>());

        System.out.println(list);
    }

    private static void subSets(int[] nums, int i, List<Integer> innerList) {
        if(i >= nums.length) {
            list.add(new ArrayList<>(innerList));
            return;
        }

        innerList.add(nums[i]);
        subSets(nums, i + 1, innerList);
        
        // Cleanup
        innerList.removeLast();
        
        subSets(nums, i + 1, innerList);
    }
}
