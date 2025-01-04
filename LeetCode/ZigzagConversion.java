package LeetCode;

import cputils.FastReader;
import java.util.Arrays;

public class ZigzagConversion {
    public static void main(String[] args) {
        FastReader fastReader = new  FastReader();

        String s = fastReader.nextLine();
        int numRows = fastReader.nextInt();

        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        
        /**
         * 1. Create a matrix of size n x s.length() -- Done
         * 2. Then, fill the matrix with some placeholder value -- Done
         * 3. Do a zigzag traversal throught the matrix from 
         *  - top --> down --> bottom 
         *  - bottom --> right --> top
         * 4. Replace the matrix value with the current s.charAt(i)
         * 5. Then print the all the values of the martix other than placeholder value.
         */

        int n = numRows;
        int m = s.length();
        char[][] mat = new char[n][m];
        for (char[] row: mat) Arrays.fill(row, '-');
        
        boolean down = true;

        int row = 0;
        int col = 0;
        int chIndex = 0;
        while (chIndex < s.length() && row < n && col < m) {
            if (down) {
                while (chIndex < s.length() && row + 1 < n) {
                    mat[row++][col] = s.charAt(chIndex++);
                }
                down = false;
            } else {
                while (chIndex < s.length() && row - 1 >= 0 && col + 1 < m) {
                    mat[row--][col++] = s.charAt(chIndex++);
                }
                down = true;
            }
        }

        StringBuilder resString = new StringBuilder();

        for (row = 0; row < n; row++) {
            for (col = 0; col < m; col++) {
                if (resString.length() == s.length()) break;
                if (mat[row][col] != '-') resString.append(mat[row][col]);
            }
        }

        return resString.toString();
    }
}
