
import java.util.Arrays;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color){
        if(image[sr][sc] == color){
            return image;
        }

        bfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    public void bfs(int[][] image, int i, int j, int color, int ogColor){
        boolean rowInBound = i >= 0 && i < image.length;
        boolean colInBound = j >= 0 && j < image[0].length;

        if(!rowInBound || !colInBound){
            return;
        }

        if(image[i][j] == color || image[i][j] != ogColor){
            return;
        }

        image[i][j] = color;

        bfs(image, i + 1, j, color, ogColor);
        bfs(image, i - 1, j, color, ogColor);
        bfs(image, i, j + 1, color, ogColor);
        bfs(image, i, j - 1, color, ogColor);
    }
}

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {
            {0, 0, 0},
            {1, 0, 0}
        };

        Solution sol = new Solution();

        for(int[] row : sol.floodFill(image, 1, 0, 2)){
            System.out.println(Arrays.toString(row));
        }
    }

}