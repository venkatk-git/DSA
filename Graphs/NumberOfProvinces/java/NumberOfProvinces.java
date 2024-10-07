package Graphs.NumberOfProvinces.java;

import java.util.Arrays;

class Solution {
    public int findCircleNum(int[][] isConnected){
        int n = isConnected.length;
        int m = isConnected[0].length;
        int count = 0;
        boolean[][] visited = new boolean[n][m];

        for(boolean[] arr : visited){
            Arrays.fill(arr, false);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j]){
                    dfs(i, j, isConnected, visited);
                    count += 1;
                }
            }
        }

        return count;
    }

    private void dfs(int i, int j, int[][] graph, boolean[][] visited){
        boolean rowInBound = i >= 0 && i < graph.length;
        boolean colInBound = j >= 0 && j < graph[0].length;
        
        if(!rowInBound || !colInBound){
            return;
        }
        
        if(visited[i][j]){
            return;
        }
        
        visited[i][j] = true;
        
        if(graph[i][j] == 0){
            return;
        }

        dfs(i - 1, j, graph, visited);
        dfs(i + 1, j, graph, visited);
        dfs(i, j + 1, graph, visited);
        dfs(i, j - 1, graph, visited);
    }
}

public class NumberOfProvinces {
    public static void main(String[] agrs){
        int[][] isConnected = {
            {1,0,0},
            {0,1,0},
            {0,0,1}
        };

        Solution solution = new Solution();
        System.out.println(solution.findCircleNum(isConnected));
    }
}