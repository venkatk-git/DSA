package Backtracking.Blaze;

import cputils.FastReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int n = new FastReader().nextInt();
        
        for(List<String> board: solveNQueens(n)) {
            System.out.println(board);
        }
    }
    
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> boards = new ArrayList<>();
        
        boolean[][] board = new boolean[n][n];
        for(boolean[] row: board) {
            Arrays.fill(row, false);
        }

        solveNQueens(board, 0, n, boards);

        return boards;
    }

    private static void solveNQueens(boolean[][] board, int i, int n, List<List<String>> boards) {
        if(i == n) {
            boards.add(new ArrayList<>(toStringList(board)));
            return;
        }

        for(int j = 0; j < n; j++) {
            if(isSafe(board, i, j)) {
                board[i][j] = true;
                solveNQueens(board, i + 1, n, boards);
                board[i][j] = false;
            }
        }
    }

    private static boolean isSafe(boolean[][] board, int i, int j) {
        // Check up direction
        for(int row = i; row >= 0; row--) {
            if(board[row][j]) return false;
        }

        // Check left direction
        for(int col = j; col >= 0; col--) {
            if(board[i][col]) return false;
        }

        // Check right-diagonal direction
        for(int row = i, col = j; row >= 0 && col < board.length; row--, col++) {
            if(board[row][col]) return false;
        }

        // Check left-diagonal direction
        for(int row = i, col = j; row >= 0 && col >= 0; row--, col--) {
            if(board[row][col]) return false;
        }

        return true;
    }

    private static List<String> toStringList(boolean[][] board) {
        List<String> newBoard = new ArrayList<>();

        for (boolean[] row : board) {
            StringBuilder s = new StringBuilder();
            
            for (int j = 0; j < board.length; j++) {
                s.append(row[j] ? "Q" : ".");
            }

            newBoard.add(s.toString());
        }

        return newBoard;
    }
}
