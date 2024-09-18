package StacksAndQueues.Stack.MaximalRectangle.java;

import java.util.*;

public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = {
            {'1', '0'}
        };

        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int area = 0;
        
        int[] row = new int[m];
        Arrays.fill(row, 0);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == '0')
                    row[j] = 0;
                else 
                    row[j] += matrix[i][j] - '0'; 
            }

            area = Math.max(area, findArea(row));
        }

        return area;
    }

    public static int findArea(int[] row){
        int n = row.length;
        int area = 0;

        int[] nse = findNse(row);
        int[] pse = findPse(row);

        for(int i = 0; i < n; i++)
            area = Math.max(area, (nse[i] - pse[i] - 1) * row[i]);

        return area;
    }

    public static int[] findNse(int[] row){
        int n = row.length;
        int[] nse = new int[n];

        int[] s = new int[n];
        int top = -1;

        for(int i = n - 1; i >= 0; i--){
            while(top != -1 && row[i] <= row[s[top]])
                top -= 1;

            if(top == -1)
                nse[i] = n;
            else 
                nse[i] = s[top];
            
            s[++top] = i;
        }

        return nse;
    }

    public static int[] findPse(int[] row){
        int n = row.length;
        int[] pse = new int[n];

        int[] s = new int[n];
        int top = -1;

        for(int i = 0; i < n; i++){
            while(top != -1 && row[i] <= row[s[top]])
                top -= 1;

            if(top == -1)
                pse[i] = -1;
            else 
                pse[i] = s[top];
            
            s[++top] = i;
        }

        return pse;
    }

}