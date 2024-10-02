package Greedy.ShortestJobFirst.java;

import java.util.Arrays;

class Solution {
    public int solve(int[] bt){
        int n = bt.length;
        int time = 0;
        int wt = 0;

        Arrays.sort(bt);
        
        for(int i = 0; i < n; i++){
            time += wt;
            wt += bt[i];
        }

        return time / bt.length;
    }
}

public class SJF {
    public static void main(String[] args){
        int[] bt = {4,3,7,1,2};

        Solution solution = new Solution();
    
        System.out.println(solution.solve(bt));
    }
}
