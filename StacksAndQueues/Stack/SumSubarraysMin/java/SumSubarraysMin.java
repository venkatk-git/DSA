package StacksAndQueues.Stack.SumSubarraysMin.java;

import java.util.*;

/**
 * SumSubarraysMin
 */
public class SumSubarraysMin {
    static int MOD = (int)1e9 + 7;
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};

        System.out.println(sumSubarrayMins(nums));
    }

    /** Brute Force (Time Limit Exceeded) 
    ** public static int sumSubarrayMins(int[] nums){
    **    int n = nums.length;
    **    long sum = 0;
    **
    **    for(int i = 0; i < n; i++){
    **        int min = nums[i];
    **        for(int j = i; j < n; j++){
    **            min = Math.min(min, nums[j]);
    **            sum += min;
    **        }
    **    }
    **
    **    return (int)(sum % MOD);
    ** }    
    */
    
    /** Next Smaller Element & Previous Smaller Element Approach **/
    public static int sumSubarrayMins(int[] nums){
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

}