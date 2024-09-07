package SlidingWindowAnd2Pointers.TrapingRainWater.java;
/*
 * 42. Trapping Rain Water
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 */

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {1,3,2,4,2,1,2,8,3,7,6};
        System.out.println(trap(height));
    }   
    
    /** Linear time approach with O(2n) Space Complexity (Prefix Max Array & Suffix Max Array)
    **
    ** public int trap(int[] height) {
    **    int n = height.length;
    **    int trap = 0;
    **    
    **    int currMax;
    **    int[] l = new int[n];
    **    int[] r = new int[n];
    **    
    **    currMax = height[0];
    **    for(int i  = 0; i < n; i++){
    **        l[i] = currMax;
    **        currMax = Math.max(height[i], currMax);
    **    }
    **    
    **    currMax = height[n - 1];
    **    for(int i = n - 1; i >= 0; i--){
    **        r[i] = currMax;
    **        currMax = Math.max(currMax, height[i]);
    **    }
    **    
    **    int leftMax, rightMax;
    **    for(int i = 0; i < n; i++){
    **        leftMax = Math.max(height[i], l[i]);
    **        rightMax = Math.max(height[i], r[i]);
    **        
    **        trap += Math.min(leftMax, rightMax) - height[i];
    **    }
    **    
    **    return trap;
    ** }
    */
    
    /* Optimized Two pointers appraoch */
    public static int trap(int[] height){
        int n = height.length;
        int trap = 0;
        int leftMax = 0;
        int rightMax = 0;

        int l = 0;
        int r = n - 1;
        while(l < r){
            if(height[l] < height[r]){
                if(leftMax < height[l])
                    leftMax = height[l];
                else
                    trap += leftMax - height[l];
                l++;
            } else {
                if(rightMax < height[r])
                    rightMax = height[r];
                else
                    trap += rightMax - height[r];
                r--;
            }
        }

        return trap;
    }
}
