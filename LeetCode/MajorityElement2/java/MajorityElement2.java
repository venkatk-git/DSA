package LeetCode.MajorityElement2.java;

import java.util.*;

public class MajorityElement2 {
    public static void main(String[] args) {
        int[] nums = {3,3,3,5,5,5,2,2};
        List<Integer> list = majorityElement2(nums);
        System.out.println(list);
    }
    
    public static List<Integer> majorityElement2(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            if(map.containsKey(num)){
                int val = map.get(num);
                map.put(num, val + 1);
            } else{
                map.put(num, 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        
        for(int num : nums){
            int val = map.get(num);
            if(val > nums.length / 3){
                list.add(num);
                map.put(num, 0);
            }
        }

        return list;
    }
}
