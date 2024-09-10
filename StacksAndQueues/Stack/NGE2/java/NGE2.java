package StacksAndQueues.Stack.NGE2.java; 

import java.util.*;

public class NGE2 {
    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4, 3};

        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }    

    public static int[] nextGreaterElements(int[] nums){
        int n = nums.length;

        int[] nge = new int[n];
        Arrays.fill(nge, -1);
        
        Deque<Integer> s = new ArrayDeque<>();

        for(int i = (n * 2) - 1; i >= 0; i--){
            while(!s.isEmpty() && nums[i % n] >= s.peek())
                s.pop();
            
            if(!s.isEmpty())
                nge[i % n] = s.peek();
            
            s.push(nums[i % n]);
        }

        return nge;
    }
}
