    package Backtracking.Blaze;

    import cputils.FastReader;
    import java.util.Arrays;

    public class NQueens2 {
        public static void main(String[] args) {
            int n = new FastReader().nextInt();

        System.out.println(totalNQueens(n));
    }

    public static int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        
        for(boolean[] row: board) Arrays.fill(row, false);

        return totalNQueens(board, n, 0);
    }

    private static int totalNQueens(boolean[][] board, int n, int i) {
        if(i == board.length) {
            return 1;
        }

        int currCount = 0;
        for(int col = 0; col < n; col++) {
            if(isSafe(board, i, col)) {
                board[i][col] = true;
                currCount += totalNQueens(board, n, i + 1);
                board[i][col] = false;
            }
        }

        return currCount;
    }

    private static boolean isSafe(boolean[][] board, int i, int j) {
        // Go up
        for(int up = i; up >= 0; up--) {
            if(board[up][j]) {
                return false;
            }
        }

        // Go left-diagonal
        for(int row = i, col = j; row >= 0 && col < board.length; row--, col++) {
            if(board[row][col]) {
                return false;
            }
        }
        
        // Go right-diagonal
        for(int row = i, col = j; row >= 0 && col >= 0; row--, col--) {
            if(board[row][col]) {
                return false;
            }
        }

        return true;
    }
}
