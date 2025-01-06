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
        int m = calculateColsNeeded(n, s.length());
        char[][] mat = new char[n][m];
        for (char[] row: mat) Arrays.fill(row, '-');
        
        int row = 0;
        int col = 0;
        int chIndex = 0;
        boolean down = true;
        while (chIndex < s.length() && row < n && col < m) {
            if (down) {
                while (chIndex < s.length() && row + 1 < n) {
                    mat[row++][col] = s.charAt(chIndex++);
                }
                if (chIndex < s.length()) mat[row][col] = s.charAt(chIndex++);
                row--;
                col++;
                down = false;
            } else {
                while (chIndex < s.length() && row - 1 >= 0 && col + 1 < m) {
                    mat[row--][col++] = s.charAt(chIndex++);
                }
                if (chIndex < s.length()) mat[row][col] = s.charAt(chIndex++);
                row++;
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

        for (char[] a: mat) System.out.println(Arrays.toString(a));

        
        return resString.toString();
    }

    private static int calculateColsNeeded(int n, int len) {
        if (n == 1) return len;

        int rows = 0;
        int section = (n * 2) - 2;

        rows += (len / section) * (n - 1);

        int rem = len % section;
        if (rem != 0) {
            rows += rem <= n ? 1 : (rem % n) + 1;
        }

        return rows; 
    }
}
