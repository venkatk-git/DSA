package LeetCode.SortColors.java;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int nums[] = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    
    // public static void sortColors(int[] nums){
    //     int[] count = new int[3];
    //     for(int n : nums)
    //         count[n]++;
        
    //     int indx = 0;
    //     for(int i = 0; i < count[0]; i++)
    //         nums[indx++] = 0;
    //     for(int i = 0; i < count[1]; i++)
    //         nums[indx++] = 1;
    //     for(int i = 0; i < count[2]; i++)
    //         nums[indx++] = 2;  
    // }

    public static void sortColors(int[] nums){
        int n = nums.length;
        int l = 0;
        int r = n - 1;

        int i = 0;
        while (i < r) {
            if(nums[i] == 0)
                swap(nums, l++, i);
            else if(nums[i] == 2)
                swap(nums, r--, i);
            else 
                i++;
            System.out.println(Arrays.toString(nums));
        }
    } 

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
