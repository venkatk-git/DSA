package Graphs.MinimumIsland.java;

import java.util.*;

public class MinimumIsland {
    public static void main(String[] args) {
        List<List<String>> grid = List.of(
            List.of("L", "W", "W", "L", "W"),
            List.of("L", "W", "W", "L", "L"),
            List.of("W", "L", "W", "L", "W"),
            List.of("W", "W", "W", "W", "W"),
            List.of("W", "W", "L", "L", "L")
          );
          
        System.out.println(minimumIsland(grid));
    }

    public static int minimumIsland(List<List<String>> grid){
        int n = grid.size();
        int m = grid.get(0).size();
        int size = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[n][m];

        for(boolean[] row : visited){
            Arrays.fill(row, false);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid.get(i).get(j).equals("L")){
                    int currSize = exploreIsland(grid, visited, i, j);
                    if(currSize > 0){
                        size = Math.min(size, currSize);
                    }
                }
            }
        }

        return size;
    }
    
    public static int exploreIsland(List<List<String>> grid, boolean[][] visited, int i, int j){
        boolean rowInBound = i >= 0 && i < grid.size();
        boolean colInBound = j >= 0 && j < grid.get(0).size();

        if(!rowInBound || !colInBound){
            return 0;
        }

        if(visited[i][j]){
            return 0;
        }

        if(grid.get(i).get(j).equals("W")){
            return 0;
        }

        visited[i][j] = true;

        int right = exploreIsland(grid, visited, i, j + 1);
        int left = exploreIsland(grid, visited, i, j - 1);
        int down = exploreIsland(grid, visited, i + 1, j);
        int up = exploreIsland(grid, visited, i - 1, j);

        return 1 + right + left + down + up;
    }
}