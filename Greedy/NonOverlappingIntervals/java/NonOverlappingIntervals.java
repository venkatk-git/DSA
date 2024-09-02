package Greedy.NonOverlappingIntervals.java;

import java.util.*;

/**
 * NonOverlappingIntervals
 */

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{10, 13},{9,14},{7,11},{12,16},{20,25},{1,50}};
        
        System.out.println(eraseOverlapIntervals(intervals));
    }
    public static int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int scheduledIntervals = 0;
        int currEndTime = Integer.MIN_VALUE;

        Arrays.sort(intervals, (i1, i2) -> i1[1] - i2[1]);

        for(int i = 0; i < n; i++){
            if(intervals[i][0] >= currEndTime){
                currEndTime = intervals[i][1];
                scheduledIntervals++;
            }
        }

        return n - scheduledIntervals;
    }
}
