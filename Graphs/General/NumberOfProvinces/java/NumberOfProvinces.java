package Graphs.NumberOfProvinces.java;

class Solution {
    public int findCircleNum(int[][] isConnected){
        int n = isConnected.length;
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1){
                    dfs(i, j, isConnected);
                    count += 1;
                }
            }
        }

        return count;
    }

    private void dfs(int i, int j, int[][] graph){
        if(graph[i][j] == -1){
            return;
        }

        graph[i][j] = -1;

        for(int k = 0; k < graph.length; k++){
            if(graph[j][k] == 1){
                dfs(j, k, graph);
            }
        }
    }
}

public class NumberOfProvinces {
    public static void main(String[] agrs){
        int[][] isConnected = {
            {1,0,0,1},
            {0,1,1,0},
            {0,1,1,1},
            {1,0,1,1},
        };

        Solution solution = new Solution();
        System.out.println(solution.findCircleNum(isConnected));
    }
}