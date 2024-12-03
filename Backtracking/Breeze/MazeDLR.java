package Backtracking.Breeze;

import java.util.Arrays;

public class MazeDLR {
    public static void main(String[] args) {
        boolean[][] maze = new boolean[][]{
            {true, true, true},
            {true, true, true},
            {true, true, true}
        };

        mazeDLR(maze, "", 0, 0);
    }

    private static void mazeDLR(boolean[][] maze, String path, int r, int c){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            System.out.println(Arrays.deepToString(maze));
            System.out.println(path);
            return;
        }

        if(!maze[r][c]){
            return;
        }

        if(c > 0){
            maze[r][c] = false;
            mazeDLR(maze, path + "L", r, c - 1);
        }
        
        if(r < maze.length - 1){
            maze[r][c] = false;
            mazeDLR(maze, path + "D", r + 1, c);
        }
        
        if(c < maze[0].length - 1){
            maze[r][c] = false;
            mazeDLR(maze, path + "R", r, c + 1);
        }

        maze[r][c] = true;
    }
}
