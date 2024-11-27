package DynamicProgramming.Tabulation.Triangle;

import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.getLast().size();

        int[][] dp = new int[n][m];

        // Filling the last row with the original values for calculations
        for(int i = 0; i < m; i++) {
            dp[n - 1][i] = triangle.get(n - 1).get(i);
        }

        for(int i = n - 2; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                int onePlus = dp[i + 1][j];
                int twoPlus = dp[i + 1][j + 1];
                dp[i][j] = triangle.get(i).get(j) + Math.min(onePlus, twoPlus);
            }
        }

        return dp[0][0];
    }

    /** Tabulation Space Optimized
    ** public int minimumTotal(List<List<Integer>> triangle) {
    **    int n = triangle.size();
    **    int m = triangle.getLast().size();
    **
    **    int[] prev = new int[m];
    **    int[] curr = new int[m];
    **    
    **  for(int i = 0; i < m; i++) {
    **      prev[i] = triangle.get(n - 1).get(i);
    **  }

    **  for(int i = n - 2; i >= 0; i--) {
    **      for(int j = 0; j <= i; j++) {
    **          int onePlus = prev[j];
    **          int twoPlus = prev[j + 1];
    **          curr[j] = triangle.get(i).get(j) + Math.min(onePlus, twoPlus);
    **      }
    **
    **      prev = curr;
    **  }
    **
    **  return prev[0];
    ** }
    **/
}

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = List.of(
            List.of(2),
            List.of(3, 4),
            List.of(6, 5, 7),
            List.of(4, 1, 8, 3)
        );

        System.out.println(new Solution().minimumTotal(triangle));
    }
}
