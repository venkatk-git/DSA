package DynamicProgramming.Hustle;

import java.util.Arrays;

class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] a: dp) {
            Arrays.fill(a, -1);
        }

        return minPathSum(grid, 0, 0, dp);   
    }

    private int minPathSum(int[][] grid, int i, int j, int[][] dp) {
        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        
        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;

        if(i + 1 < grid.length) {
            down = grid[i][j] + minPathSum(grid, i + 1, j, dp);
        }

        if(j + 1 < grid[0].length) {
            right = grid[i][j] + minPathSum(grid, i, j + 1, dp);
        }

        dp[i][j] = Math.min(down, right);
        return Math.min(down, right);
    }   
}

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };

        System.out.println(new Solution().minPathSum(grid));
    }
}
