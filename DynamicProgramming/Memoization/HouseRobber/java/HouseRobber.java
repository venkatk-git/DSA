package DynamicProgramming.Memoization.HouseRobber.java;

import java.util.HashMap;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        System.out.println(rob(nums1));
        
        int[] nums2 = {2,7,9,3,1};
        System.out.println(rob(nums2));
    }

    private static int rob(int[] nums){
        return _rob(nums, 0, new HashMap<>());
    }

    private static int _rob(int[] nums, int i, HashMap<Integer, Integer> memo){
        if(memo.containsKey(i))
            return memo.get(i);

        if(i >= nums.length)
            return 0;
        
        int rob = nums[i] + _rob(nums, i + 2, memo);
        int skip = _rob(nums, i + 1, memo);

        memo.put(i, Math.max(rob, skip));
        return Math.max(rob, skip);
    }
}
