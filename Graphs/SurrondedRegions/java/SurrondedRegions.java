class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int i = 0; 
        int j = 0;
        while(j < m) {
            if(board[i][j] == 'O') {
                dfs(board, i, j);
            }
            j++;
        }

        j = m - 1;
        while(i < n) {
            if(board[i][j] == 'O') {
                dfs(board, i, j);
            }
            i++;
        }

        i = n - 1;
        while(j >= 0) {
            if(board[i][j] == 'O') {
                dfs(board, i, j);
            }
            j--;
        }

        j = 0;
        while(i >= 0) {
            if(board[i][j] == 'O') {
                dfs(board, i, j);
            }
            i--;
        }

        for(i = 0; i < n; i++) {
            for(j = 0; j < m; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                if(board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        boolean rowInBound = i >= 0 && i < board.length;
        boolean colInBound = j >= 0 && j < board[0].length;

        if(!rowInBound || !colInBound || board[i][j] != 'O') {
            return;
        }
        
        board[i][j] = 'S';

        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}

public class SurrondedRegions {
    public static void main(String[] args) {
        char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };

        new Solution().solve(board);

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}