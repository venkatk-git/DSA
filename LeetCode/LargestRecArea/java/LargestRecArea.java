package LeetCode.LargestRecArea.java;

public class LargestRecArea {
    public static void main(String[] args) {
        int[] case1 = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(case1));
        
        int[] case2 = {2, 4};
        System.out.println(largestRectangleArea(case2));
        
        int[] case3 = {1, 4, 2, 7, 6, 11, 2, 12};
        System.out.println(largestRectangleArea(case3));
        
    }
    /** Brute Force Approach
    ** public static int largestRectangleArea(int[] heights){
    **    int n = heights.length;
    **    int width, l, r;
    **
    **    int area = 0;
    **
    **    for(int i = 0; i < n; i++){
    **        l = i - 1;
    **        r = i + 1;
    **        
    **        while(l >= 0 && heights[l] >= heights[i])
    **            l--;
    **        l++;
    **        
    **        while(r < n && heights[r] >= heights[i])
    **            r++;
    **        r--;
    **
    **        width = (r - l) + 1;
    **
    **        area = Math.max(area, Math.max(heights[i], width * heights[i])); 
    **    }
    **
    **    return area;
    **}
    */

    public static int largestRectangleArea(int[] heights){

        return 0;
    }
}
