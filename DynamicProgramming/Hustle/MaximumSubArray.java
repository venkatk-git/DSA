package DynamicProgramming.Hustle;

import java.util.*;

class MaximumSubArray{
    public static void main(String[] args) {
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums1));
        
        int[] nums2 = {1};
        System.out.println(maxSubArray(nums2));
        
        int[] nums3 = {5,4,-1,7,8};
        System.out.println(maxSubArray(nums3));
    }

    public static int maxSubArray(int[] nums){
        return _maxSubArray(nums, 0, Integer.MIN_VALUE, new HashMap<>());
    }
 
    private static int _maxSubArray(int[] nums, int s, int max, HashMap<Integer, Integer> memo){
        if(memo.containsKey(s))
            return memo.get(s);

        if(s == nums.length) 
            return max;

        int currMax = Integer.MIN_VALUE;
        int currSubMax = 0;

        for(int i = s ; i < nums.length; i++){
            currSubMax += nums[i];
            currMax = Math.max(currSubMax, currMax);
        }

        int result = _maxSubArray(nums, s + 1, Math.max(max, currMax), memo);
        memo.put(s, result);
        return memo.get(s);
    }
}
