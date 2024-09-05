package LeetCode.SingleNumber.java;

import java.util.*;

public class SingleNumber{
    public static void main(String[] args) {
        int[] nums = {1,0,1};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums){
        int res = nums[0]; 

        Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);

        for(int n : nums)
            if(map.get(n) == 1)
                res = n;
        
        return res;
    }    
}