package DynamicProgramming.Tabulation.MinimumPathSum.java;

class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        dp[n - 1][m - 1] = grid[n - 1][m - 1];

        for(int i = n - 1; i >= 0; i--) {
            for(int j = m - 1; j >= 0; j--) {
                if(i == n - 1 && j == m - 1) continue;
                
                int down = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;

                if(i + 1 < n) down = dp[i + 1][j];
                if(j + 1 < m) right = dp[i][j + 1];
                
                dp[i][j] = grid[i][j] + Math.min(down, right);
            }
        }

        return dp[0][0];   
    }   
}