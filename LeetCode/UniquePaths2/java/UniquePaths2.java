package LeetCode.UniquePaths2.java;

import java.util.HashMap;

public class UniquePaths2 {
    public static void main(String[] args) {
        int[][] obstacleGrid1 = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid1));

        int[][] obstacleGrid2 = {{0, 1}, {0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid2));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return uniquePathsWithObstacles(obstacleGrid, 0, 0, new HashMap<>());
    }
    
    public static int uniquePathsWithObstacles(int[][] obstacleGrid, int i, int j, HashMap<String, Integer> memo) {
        String key = i + "-" + j;
        if(memo.containsKey(key))
            return memo.get(key);

        if(obstacleGrid[i][j] == 1)
            return 0;
        
        if(i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1)
            return 1;
        
        int down = 0;
        int right = 0;

        if(i < obstacleGrid.length - 1)
            down = uniquePathsWithObstacles(obstacleGrid, i + 1, j, memo);
            
        if(j < obstacleGrid[0].length - 1)
            right = uniquePathsWithObstacles(obstacleGrid, i, j + 1, memo);
        
        memo.put(key, down + right);
        return right + down;
    }   
}


