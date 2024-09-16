package StacksAndQueues.Stack.LargeRectangleHistogram.java;

import java.util.*;

public class LargeRectangleHistogram {
    public static void main(String[] args) {
        int[] heights = {4,2,0,3,2,5};

        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights){
        int n = heights.length;
        int area = 0;

        int[] nse = findNse(heights);
        int[] pse = findPse(heights);

        for(int i = 0; i < n; i++){
            int right = nse[i] - i;
            int left = i - pse[i];
            area = Math.max(area, (right + left - 1) * heights[i]);
        }

        return area;
    }

    private static int[] findNse(int[] heights){
        int n = heights.length;
        int[] nse = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()])
                stack.pop();
            
            if(stack.isEmpty())
                nse[i] = n;
            else 
                nse[i] = stack.peek();
            stack.push(i);
        }

        System.out.println(Arrays.toString(nse));

        return nse;
    }

    private static int[] findPse(int[] heights){
        int n = heights.length;
        int[] pse = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()])
                stack.pop();
            
            if(stack.isEmpty())
                pse[i] = -1;
            else 
                pse[i] = stack.peek();
            stack.push(i);
        }

        System.out.println(Arrays.toString(pse));

        return pse;
    }
}
