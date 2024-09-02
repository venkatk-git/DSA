package Greedy.MergeIntervals.java;

import java.util.*;

/**
 * Merge Intervals
 */

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,4},{4,5}};
        
        int[][] list = merge(intervals);
        for(int[] arr : list)
            System.out.println(Arrays.toString(arr));
    }
    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

        for(int[] interval : intervals){
            if(res.isEmpty() || interval[0] > res.getLast()[1])
                res.add(interval);
            else 
                res.getLast()[1] = Math.max(res.getLast()[1], interval[1]);
        }

        return res.toArray(new int[res.size()][2]);
    }
}
