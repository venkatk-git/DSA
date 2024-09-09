package StacksAndQueues.Stack.NGE.java;

import java.util.*;

public class NGE {
    public static void main(String[] args) {
        int[] nums1 = {4,3,6,9};
        int[] nums2 = {3,4,6,9};

        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2){
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] res = new int[n1];
        int[] nge = new int[10000];

        Stack<Integer> s = new Stack<>();

        for(int i = n2 - 1; i >= 0; i--){
            while(!s.isEmpty() && nums2[i] >= s.peek())
                s.pop();
            
            if(!s.isEmpty())
                nge[nums2[i]] = s.peek();
            else 
                nge[nums2[i]] = -1;

            s.push(nums2[i]);
        }

        for(int i = 0; i < n1; i++)
            res[i] = nge[nums1[i]];

        return res;
    }
}
