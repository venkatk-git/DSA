package StacksAndQueues.Stack.PSE.java;

import java.util.*;

public class PSE {
    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 10, 8};

        System.out.println(prevSmaller(nums));
    }

    public static ArrayList<Integer> prevSmaller(int[] nums){
        int n = nums.length;
        ArrayList<Integer> pse = new ArrayList<>(n);

        Deque<Integer> s = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            while(!s.isEmpty() && nums[i] <= s.peek())
                s.pop();
            
            if(!s.isEmpty())
                pse.add(s.peek());
            else
                pse.add(-1);
            
            s.push(nums[i]);
        }

        return pse;
    }
}
