package DynamicProgramming.Tabulation.MaximumPathSum;

public class Solution {
    public static int getMaxPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        System.arraycopy(matrix[n - 1], 0, dp[n - 1], 0, m);

        for(int i = n - 2; i >= 0 ; i--) {
            for(int j = 0; j < m; j++) {
                int leftDiagonal = Integer.MIN_VALUE;
                int down = dp[i + 1][j];
                int rightDiagonal = Integer.MIN_VALUE;
                
                if(j - 1 >= 0) leftDiagonal = dp[i + 1][j - 1];
                if(j + 1 < m) rightDiagonal = dp[i + 1][j + 1];
                
                dp[i][j] = matrix[i][j] + Math.max(Math.max(leftDiagonal, down), rightDiagonal);
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < matrix[0].length; i++) {
            max = Math.max(max, dp[0][i]);
        }
        
        return max;
    }
}

class MaximumPathSum {
    public static void main(String[] args) {
        int[][] matrix = {
            {-9999, -9888, -9777, -9666, -9555},
            {1, 10, 2, 4, 5},
            {-9999, -9888, -9777, -9666, -9555},
            {0, 0, 0, 0, 0},
            {-99, -98, -97, -96, -95}
        };

        System.out.println(new Solution().getMaxPathSum(matrix));
    }
    
}
