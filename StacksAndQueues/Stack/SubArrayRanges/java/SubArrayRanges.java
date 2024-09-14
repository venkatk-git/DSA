package StacksAndQueues.Stack.SubArrayRanges.java;

import java.util.*;

/**
 * SubArrayRanges
 */
public class SubArrayRanges {
    public static void main(String[] args) {
        int[] nums = {4, -2, -3, 4, 1};
    
        System.out.println(subArrayRanges(nums));
    }

    /** Brute Force (Accepted) 
    ** public static long subArrayRanges(int[] nums){
    **     int n = nums.length;
    **     long sum = 0;
    ** 
    **     for(int i = 0; i < n; i++){
    **         int max = nums[i];
    **         int min = nums[i];
    **         for(int j = i + 1; j < n; j++){
    **             max = Math.max(max, nums[j]);
    **             min = Math.min(min, nums[j]);
    **             sum += max - min;
    **         }
    **     }
    ** 
    **     return sum;
    ** }
    */

    /** Sum of Subarray Minimum & Sum of Subarray Maximum Approach **/
    public static long subArrayRanges(int[] nums){
        return sumSubarrayMax(nums) - sumSubarrayMins(nums);
    }


    public static int sumSubarrayMins(int[] nums){
        int MOD = (int)1e9 + 7;
        int n = nums.length;
        long sum = 0;
        int[] nse = findNSE(nums);
        int[] pse = findPSE(nums);

        System.out.println(Arrays.toString(nse));
        System.out.println(Arrays.toString(pse));

        for(int i = 0; i < n; i++){
            long left = i - pse[i];
            long right = nse[i] - i;
            sum += (long)(left * right) % MOD * nums[i] % MOD;
            sum %= MOD;
        }

        return (int)sum;
    }

    public static int[] findNSE(int[] nums){
        int n = nums.length;
        int[] nse = new int[n];
        Arrays.fill(nse, n);
        
        Deque<Integer> s = new ArrayDeque<>();
        
        for(int i = n - 1; i >= 0; i--){
            while(!s.isEmpty() && nums[i] < nums[s.peek()])
                s.pop();
            
            if(!s.isEmpty())
                nse[i] = s.peek();
            
            s.push(i);
        }

        return nse;
    }

    public static int[] findPSE(int[] nums){
        int n = nums.length;
        int[] pse = new int[n];
        Arrays.fill(pse, -1);
        
        Deque<Integer> s = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            while(!s.isEmpty() && nums[i] <= nums[s.peek()])
                s.pop();
            
            if(!s.isEmpty())
                pse[i] = s.peek();
            
            s.push(i);
        }

        return pse;
    }

    public static int sumSubarrayMax(int[] nums){
        int MOD = (int)1e9 + 7;
        int n = nums.length;
        long sum = 0;
        int[] nge = findNGE(nums);
        int[] pge = findPGE(nums);

        System.out.println(Arrays.toString(nge));
        System.out.println(Arrays.toString(pge));

        for(int i = 0; i < n; i++){
            long left = i - pge[i];
            long right = nge[i] - i;
            sum += (long)(left * right) % MOD * nums[i] % MOD;
            sum %= MOD;
        }

        return (int)sum;
    }

    public static int[] findNGE(int[] nums){
        int n = nums.length;
        int[] nge = new int[n];
        Arrays.fill(nge, n);
        
        Deque<Integer> s = new ArrayDeque<>();
        
        for(int i = n - 1; i >= 0; i--){
            while(!s.isEmpty() && nums[i] > nums[s.peek()])
                s.pop();
            
            if(!s.isEmpty())
                nge[i] = s.peek();
            
            s.push(i);
        }

        return nge;
    }

    public static int[] findPGE(int[] nums){
        int n = nums.length;
        int[] pge = new int[n];
        Arrays.fill(pge, -1);
        
        Deque<Integer> s = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            while(!s.isEmpty() && nums[i] >= nums[s.peek()])
                s.pop();
            
            if(!s.isEmpty())
                pge[i] = s.peek();
            
            s.push(i);
        }

        return pge;
    }

}