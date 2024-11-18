package Graphs.NumberOfIsland.java;

class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ones = 0;

        int i = 0;
        int j;
        for(j = 0; j < m; j++) {
            if(grid[i][j] == 1) {
                dfs(grid, i, j);
            }
        }

        j = m - 1;
        for(i = 0; i < n; i++) {
            if(grid[i][j] == 1) {
                dfs(grid, i, j);
            }
        }

        i = n - 1;
        for(j = m - 1; j >= 0; j--) {
            if(grid[i][j] == 1) {
                dfs(grid, i, j);
            }
        }
        
        j = 0;
        for(i = n - 1; i >= 0; i--) {
            if(grid[i][j] == 1) {
                dfs(grid, i, j);
            }
        }

        for(i = 0; i < n; i++) {
            for(j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    ones += 1;
                }
            }
        }

        return ones;
    }
    
    public void dfs(int[][] grid, int i, int j) {
        boolean inBound = i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;

        if(!inBound || grid[i][j] != 1) {
            return;
        }

        grid[i][j] = -1;

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}

public class NumberOfEnclaves {
    public static void main(String[] args) {
        int[][] grid = {
            {0, 1, 0, 0},
            {1, 0, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}
        };

        System.out.println(new Solution().numEnclaves(grid));
    }
}