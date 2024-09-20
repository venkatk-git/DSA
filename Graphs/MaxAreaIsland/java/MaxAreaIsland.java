package Graphs.MaxAreaIsland.java;

public class MaxAreaIsland {
    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };

        System.out.println(maxAreaOfIsland(grid));
    }  

    public static int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int size = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    int currSize = exploreIsland(grid, i, j);
                    size = Math.max(size, currSize);
                }
            }
        }

        return size;
    }

    public static int exploreIsland(int[][] grid, int i, int j){
        boolean rowInBound = i >= 0 && i < grid.length;
        boolean colInBound = j >= 0 && j < grid[0].length;

        if(!rowInBound || !colInBound || grid[i][j] == 0){
            return 0;
        }

        grid[i][j] = 0;

        int right = exploreIsland(grid, i, j + 1);
        int left = exploreIsland(grid, i, j - 1);
        int down = exploreIsland(grid, i + 1, j);
        int up = exploreIsland(grid, i - 1, j);

        return 1 + right + left + down + up;
    } 
}
