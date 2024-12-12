package DynamicProgramming.Nightmare;

import java.util.Arrays;
public class MaximumPathSum {
    public static void main(String[] args) {
        int[][] matrix = {
            {-9999, -9888, -9777, -9666, -9555},
            {1, 10, 2, 4, 5},
            {-9999, -9888, -9777, -9666, -9555},
            {0, 0, 0, 0, 0},
            {-99, -98, -97, -96, -95}
        };

        System.out.println(getMaxPathSum(matrix));
    }

    public static int getMaxPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        for(int[] a: dp) {
            Arrays.fill(a, -1);
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < matrix[0].length; i++) {
            max = Math.max(max, getMaxPathSum(matrix, 0, i, dp));
        }
        
        return max;
    }

    private static int getMaxPathSum(int[][] matrix, int i, int j, int[][] dp) {
        boolean isRowInBound = i < matrix.length;
        boolean isColInBound = j >= 0 && j < matrix[0].length;
        
        if(!isRowInBound || !isColInBound) {
            return Integer.MIN_VALUE;
        }

        if(i == matrix.length - 1) {
            return matrix[i][j];
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int leftDiagonal = getMaxPathSum(matrix, i + 1, j - 1, dp);
        int down = getMaxPathSum(matrix, i + 1, j, dp);
        int rightDiagonal = getMaxPathSum(matrix, i + 1, j + 1, dp);
        
        dp[i][j] = matrix[i][j] + Math.max(Math.max(leftDiagonal, down), rightDiagonal);
        return dp[i][j];
    }
    
}