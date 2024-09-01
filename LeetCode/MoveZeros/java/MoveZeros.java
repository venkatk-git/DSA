package LeetCode.MoveZeros.java;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeros(nums);
        System.out.println(Arrays.toString(nums));
    }  
    
    public static void moveZeros(int[] nums){
        int n = nums.length;
        int nonZ = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] != 0)
                swap(nums, nonZ++, i);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
