package SlidingWindowAnd2Pointers.SubarrayKDistinctIntegers.java;

/**
 * SubarrayKDistinctIntegers
 */
import java.util.*;

public class SubarrayKDistinctIntegers {
    public static void main(String[] args) {
        int nums[] = {1,2,1,3,4};
        int k = 3;  

        System.out.println(subarraysWithKDistinct(nums, k));
    }

    public static int subarraysWithKDistinct(int[] nums, int k){
        return helper(nums, k) - helper(nums, k - 1);
    }

    public static int helper(int[] nums, int k){
        int l = 0;
        int r = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while(r < nums.length){
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            
            while(map.size() > k){
                map.put(nums[l], map.get(nums[l]) - 1);

                if(map.get(nums[l]) == 0)
                    map.remove(nums[l]);

                l++;
            }

            count += r - l + 1;
            r++;   
        }

        return count;
    }
    
}