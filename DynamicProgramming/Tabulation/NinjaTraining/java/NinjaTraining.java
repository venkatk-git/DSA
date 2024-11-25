package DynamicProgramming.Tabulation.NinjaTraining.java;

class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        int[][] dp = new int[n][3];

        dp[n - 1][0] = Math.max(points[n - 1][1], points[n - 1][2]);
        dp[n - 1][1] = Math.max(points[n - 1][0], points[n - 1][2]);
        dp[n - 1][2] = Math.max(points[n - 1][0], points[n - 1][1]);

        for(int i = n - 2; i >= 0; i--) {
            dp[i][0] = points[i][0] + dp[i + 1][0];
            dp[i][1] = points[i][1] + dp[i + 1][1];
            dp[i][2] = points[i][2] + dp[i + 1][2];

            int zeroth = Math.max(dp[i][1], dp[i][2]);
            int first = Math.max(dp[i][0], dp[i][2]);
            int second = Math.max(dp[i][0], dp[i][1]);

            dp[i][0] = zeroth;
            dp[i][1] = first;
            dp[i][2] = second;

        }

        return Math.max(Math.max(dp[0][0], dp[0][1]), dp[0][2]);
    }
}

public class NinjaTraining {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] points = {
            {10, 40, 70},
            {20, 50, 80},
            {30, 60, 90}
        };

        System.out.println(solution.ninjaTraining(3, points));
    }
}