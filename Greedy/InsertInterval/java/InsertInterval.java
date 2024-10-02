package Greedy.InsertInterval.java;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval){
        int n = intervals.length;
        ArrayList<ArrayList<Integer>> newIntervals = new ArrayList<>();

        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        ArrayList<Integer> list = new ArrayList<>();

        int i = 0;
        while(i < n && intervals[i][0] < newStart){
            list.add(intervals[i][0]);
            list.add(intervals[i][1]);
            newIntervals.add(new ArrayList<>(list));
            i++;
            list.clear();
        }
        
        list.add(newStart);
        list.add(newEnd);
        newIntervals.add(new ArrayList<>(list));
        list.clear();
        while(i < n){
            list.add(intervals[i][0]);
            list.add(intervals[i][1]);
            newIntervals.add(new ArrayList<>(list));
            i++;
            list.clear();
        }

        System.out.println(newIntervals);
        newIntervals = solveOverlapping(newIntervals);

        return newIntervals.stream().map(u  ->  u.stream().mapToInt(j->j).toArray()).toArray(int[][]::new);
    }

    public ArrayList<ArrayList<Integer>> solveOverlapping(ArrayList<ArrayList<Integer>> intervals){
        int n = intervals.size();
        ArrayList<ArrayList<Integer>> newIntervals = new ArrayList<>();

        newIntervals.add(new ArrayList<>(intervals.get(0)));

        for(int i = 1; i < n; i++){
            int prevStart = newIntervals.getLast().get(0);
            int prevEnd = newIntervals.getLast().get(1);
            int currStart = intervals.get(i).get(0);
            int currEnd = intervals.get(i).get(1);

            ArrayList<Integer> list = new ArrayList<>();
            if(currStart <= prevEnd){
                if(currEnd < prevEnd){
                    continue;
                }
                newIntervals.removeLast();
                list.add(prevStart);
                list.add(currEnd);
                newIntervals.add(new ArrayList<>(list));
            } else {
                list.add(currStart);
                list.add(currEnd);
                newIntervals.add(new ArrayList<>(list));
            }
            list.clear();
        }

        return newIntervals;
    }
}

public class InsertInterval{
    public static void main(String[] args) {
        int[][] intervals = {
            {1,2},
            {3,5},
            {6,7},
            {8,10},
            {12,16}
        };

        int[] newInterval = {4,8};
        
        Solution solution = new Solution();

        System.out.println(Arrays.deepToString(solution.insert(intervals, newInterval)));
    }
}
