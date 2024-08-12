package DynamicProgramming.Memoization.UniquePaths2.java;

import java.util.HashMap;

public class UniquePaths2 {
    public static void main(String[] args) {
        int[][] obstacleGrid1 = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid1));

        int[][] obstacleGrid2 = {{0, 1}, {0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid2));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return _uniquePathsWithObstacles(obstacleGrid, 0, 0, new HashMap<>());

    }

    private static int _uniquePathsWithObstacles(int[][] obstacleGrid, int m, int n, HashMap<String, Integer> memo){
        String key = "" + m + "," + n;
        if(memo.containsKey(key))
            return memo.get(key);
        
        if(obstacleGrid[m][n] == 1)
                return 0;
        
        if(m ==  obstacleGrid.length - 1 && n == obstacleGrid[0].length - 1)
            return 1;
        
        int down = 0;
        int right = 0;

        if(m < obstacleGrid.length - 1)
            down = _uniquePathsWithObstacles(obstacleGrid, m + 1, n, memo);
        
        if(n < obstacleGrid[0].length - 1)
            right = _uniquePathsWithObstacles(obstacleGrid, m, n + 1, memo);

        memo.put(key, down + right);
        return  down + right;
    }
}


