package DynamicProgramming.Memoization.MinimumPathSum.java;

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
