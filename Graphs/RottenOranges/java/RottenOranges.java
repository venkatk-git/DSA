package Graphs.RottenOranges.java;

import java.util.ArrayDeque;

class Orange {
    public int row;
    public int col;
    public int count;

    public Orange(int row, int col){
        this.row = row;
        this.col = col;
        count = 0;
    }

    public Orange(int row, int col, int count){
        this.row = row;
        this.col = col;
        this.count = count;
    }
}

public class RottenOranges {
    public static void main(String[] ags){
        int[][] grid = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };

        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int minutes = 0;

        ArrayDeque<Orange> q = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.offer(new Orange(i, j));
                }
            }
        }

        if(q.isEmpty()){
            return -1;
        }

        while(!q.isEmpty()){
            Orange orange = q.poll();
            int row =  orange.row;
            int col = orange.col;
            int count = orange.count + 1;

            if(row + 1 < n && grid[row + 1][col] == 1){
                grid[row + 1][col] = 2;
                q.offer(new Orange(row + 1, col, count));
                minutes = count;
            }

            if(row - 1 >= 0 && grid[row - 1][col] == 1){
                grid[row - 1][col] = 2;
                q.offer(new Orange(row - 1, col, count));
                minutes = count;
            }

            if(col + 1 < m && grid[row][col + 1] == 1){
                grid[row][col + 1] = 2;
                q.offer(new Orange(row, col + 1, count));
                minutes = count;
            }

            if(col - 1 >= 0 && grid[row][col - 1] == 1){
                grid[row][col - 1] = 2;
                q.offer(new Orange(row, col - 1, count));
                minutes = count;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return minutes;
    }
}

