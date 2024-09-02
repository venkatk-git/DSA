package LeetCode.MergeSort.java;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {31, 17, 8, 18, 28, 38, 4, 14, 24, 26, 9};
        int s = 0;
        int e = nums.length - 1;

        mergeSort(nums, s, e);
        System.out.println(Arrays.toString(nums));
    }

    private static void mergeSort(int[] nums, int s, int e){
        if(s == e) 
            return;

        int m = (s + e) / 2;  
        mergeSort(nums, s, m);
        mergeSort(nums, m + 1, e);
        merger(nums, s, m, e);
    }

    private static void merger(int[] nums, int l, int m, int r){
        int ln = m - l + 1;
        int rn = r - m;
        
        int[] L = new int[ln];
        for(int i = 0; i < ln; i++)
            L[i] = nums[l + i];
        
        int[] R = new int[rn];
        for(int i = 0; i < rn; i++)
            R[i] = nums[m + i + 1];
     
        int i = 0;
        int j = 0;
        int k = l;

        while(i < ln && j < rn){
            if(L[i] < R[j])
                nums[k++] = L[i++];
            else
                nums[k++] = R[j++];
        }

        while(i < ln)
            nums[k++] = L[i++];
        
        while (j < rn) 
            nums[k++] = R[j++];
    }
}
