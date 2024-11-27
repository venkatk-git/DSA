package DynamicProgramming.Memoization.Triangle;

import java.util.Arrays;
import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.getLast().size()];
        
        for(int[] a: dp) {
            Arrays.fill(a, -1);
        }
        
        return minimumTotal(triangle, 0, 0, dp);
    }

    private int minimumTotal(List<List<Integer>> triangle, int i, int j, int[][] dp) {
        int n = triangle.size();
        int m = triangle.getLast().size();
        
        if(i >= n || j >= m) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int onePlus = minimumTotal(triangle, i + 1, j, dp);
        int twoPlus = minimumTotal(triangle, i + 1, j + 1, dp);
        
        dp[i][j] = triangle.get(i).get(j) + Math.min(onePlus, twoPlus);

        return dp[i][j];
    }
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
