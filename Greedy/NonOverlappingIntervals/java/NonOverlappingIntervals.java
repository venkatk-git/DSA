package Greedy.NonOverlappingIntervals.java;

import java.util.*;

/**
 * NonOverlappingIntervals
 */

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,2},{2,3},{3,4},{1,3}};
        
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int scheduled = 0;
        int currEndTime = Integer.MIN_VALUE;
        Arrays.sort(intervals, (i1, i2) -> i1[1] - i2[1]);

        for(int i = 0; i < n; i++){
            if(intervals[i][0] >= currEndTime){
                scheduled += 1;
                currEndTime = intervals[i][1];
            }            
        }

        return n - scheduled;
    }
}
