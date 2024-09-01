package LeetCode.SortColors.java;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int nums[] = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums){
        int[] count = new int[3];
        for(int n : nums)
            count[n]++;
        
        int indx = 0;
        for(int i = 0; i < count[0]; i++)
            nums[indx++] = 0;
        for(int i = 0; i < count[1]; i++)
            nums[indx++] = 1;
        for(int i = 0; i < count[2]; i++)
            nums[indx++] = 2;  
    }
}
