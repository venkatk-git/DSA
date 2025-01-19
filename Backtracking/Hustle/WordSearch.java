package Backtracking.Hustle;

import cputils.FastReader;

public class WordSearch {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int m = fr.nextInt();
        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String[] l = fr.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = l[j].charAt(0); 
            }
        }
        String word = fr.nextLine();
        
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && exist(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    public static boolean exist(char[][] board, String word, int r, int c, int i) {
        boolean isRowInBound = r < board.length && r >= 0;
        boolean isColInBound = c < board[0].length && c >= 0;

        if (i == word.length())
            return true;

        if (!isRowInBound || !isColInBound || board[r][c] != word.charAt(i) || board[r][c] == '#')
            return false;
        
        char ch = board[r][c];
        board[r][c] = '#';

        boolean top = exist(board, word, r - 1, c, i + 1);
        boolean right = exist(board, word, r, c + 1, i + 1);
        boolean down = exist(board, word, r + 1, c, i + 1);
        boolean left = exist(board, word, r, c - 1, i + 1);

        board[r][c] = ch;

        return top || right || down || left;
    }
}