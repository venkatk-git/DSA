package Backtracking.NQueens.java;

public class NQueens {
    public static void main(String[] args) {
        boolean[][] board = new boolean[8][8];

        int count = queens(board, 0);
        System.out.println(count);

    }

    private static void display(boolean[][] board){
        for (boolean[] row : board) {
            for(boolean elem : row){
                if(elem)
                    System.out.print("Q ");
                else 
                    System.out.print("_ ");    
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isSafe(boolean[][] board, int r, int c){

        for(int i = 0; i < board.length; i++)
            if(board[i][c])
                return false;

        for(int i = 1; i <= Math.min(r, c); i++)
             if(board[r - i][c - i])
                return false;
        
        for(int i = 1; i <= Math.min(r, board.length - c - 1); i++)
            if(board[r - i][c + i])
                return false;
        
        return true;
    }

    private static int queens(boolean[][] board, int r){
        if(r == board.length){
            display(board);
            return 1;
        }

        int count = 0;
        for(int c = 0; c < board.length; c++){
            if(isSafe(board, r, c)){
                board[r][c] = true;
                count += queens(board, r + 1);
                board[r][c] = false;
            } 
        }

        return count;
    }
}
