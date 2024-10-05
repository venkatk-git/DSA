package Greedy.MergeIntervals.java;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> mergedIntervals = new ArrayList<>();

        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

        int currStart;
        int currEnd;
        for(int[] interval : intervals){
            if(mergedIntervals.isEmpty() || mergedIntervals.getLast()[1] < interval[0]){
                currStart = interval[0];
                currEnd = interval[1];
            } else {
                currStart = mergedIntervals.getLast()[0];
                currEnd = Math.max(mergedIntervals.getLast()[1], interval[1]);
                mergedIntervals.removeLast();
            }

            mergedIntervals.add(new int[]{currStart, currEnd});
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][2]);
    }
}

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,4},{4,5}};
        Solution solution = new Solution();

        for(int[] arr : solution.merge(intervals))
            System.out.println(Arrays.toString(arr));
    }
}
