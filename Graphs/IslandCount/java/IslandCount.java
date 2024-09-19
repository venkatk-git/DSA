package Graphs.IslandCount.java;

import java.util.*;

public class IslandCount {
    public static void main(String[] args) {
        List<List<String>> grid = List.of(
            List.of("L", "W", "W", "L", "W"),
            List.of("L", "W", "W", "L", "L"),
            List.of("W", "L", "W", "L", "W"),
            List.of("W", "W", "W", "W", "W"),
            List.of("W", "W", "L", "L", "L")
        );
        
        System.out.println(islandCount(grid));
    }

    public static int islandCount(List<List<String>> grid){
        int n = grid.size();
        int m = grid.get(0).size();
        int count = 0;
        boolean[][] visited = new boolean[n][m];

        for(boolean[] row: visited){
            Arrays.fill(row, false);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(dfs(grid, visited, i, j)){
                    count += 1;
                }
            }
        }

        return count;
    }

    public static boolean dfs(List<List<String>> grid, boolean[][] visited, int i, int j){
        if(i < 0 || i >= grid.size() || j < 0 || j >= grid.get(0).size()){
            return false;
        }

        if(grid.get(i).get(j).equals("W")){
            return false;
        }

        if(visited[i][j]){
            return false;
        }

        visited[i][j] = true;

        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j + 1);
        dfs(grid, visited, i, j - 1);

        return true;
    }


    
}