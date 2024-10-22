package Graphs.NumberOfIsland.java;

import java.util.ArrayDeque;
import java.util.Arrays;

class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int islandCount(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        boolean[][] visited = new boolean[n][m];
        for(boolean[] a : visited) {
            Arrays.fill(a, false);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    bfs(grid, i, j, visited);
                    count += 1;
                }
            }
        }

        return count;
    }

    public void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        boolean inBound = i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;

        if(!inBound || grid[i][j] == 0 || visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        dfs(grid, i + 1, j, visited);
        dfs(grid, i - 1, j, visited);
        dfs(grid, i, j + 1, visited);
        dfs(grid, i, j - 1, visited);
    }

    public void bfs(int[][] grid, int i, int j, boolean[][] visited) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(i, j));

        while(!q.isEmpty()) {
            Pair land = q.poll();
            int row = land.row;
            int col = land.col;

            boolean inBound = row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;

            if(inBound && !visited[row][col] && grid[row][col] == 1) {
                q.offer(new Pair(row + 1, col));
                q.offer(new Pair(row - 1, col));
                q.offer(new Pair(row, col + 1));
                q.offer(new Pair(row, col - 1));
                visited[row][col] = true;
            }

        }
    }
}

public class NumberOfIsland {
    public static void main(String[] args) {
        int[][] grid = {
            {0, 1, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 1, 0},
            {1, 1, 0, 1}
        };

        System.out.println(new Solution().islandCount(grid));
    }    
}