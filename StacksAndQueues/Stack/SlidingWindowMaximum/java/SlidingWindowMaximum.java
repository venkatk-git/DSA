package StacksAndQueues.Stack.SlidingWindowMaximum.java;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,3,1,2,0,5};

        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }   

    public static int[] maxSlidingWindow(int[] nums, int k){
        int n = nums.length;
        int[] res = new int[n - k + 1];
    
        Deque<Integer> deque = new ArrayDeque<>();

        int i = 0;
        while(i < k){
            if(!deque.isEmpty() && deque.peekFirst() <= i - k){
                deque.removeFirst();
            }   
            
            while(!deque.isEmpty() && (nums[i] > nums[deque.peekLast()])){
                deque.removeLast();
            }

            deque.addLast(i);
            i++;
        }
        
        int idx = 0;
        res[idx++] = nums[deque.peekFirst()];

        for(i = k; i < n; i++){
            if(!deque.isEmpty() && deque.peekFirst() <= i - k){
                deque.removeFirst();
            }

            while(!deque.isEmpty() && (nums[i] > nums[deque.peekLast()])){
                deque.removeLast();
            }

            deque.addLast(i);
            res[idx++] = nums[deque.peekFirst()];
        }

        return res;
    }
}
