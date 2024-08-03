package DynamicProgramming.Tabulation.GridTraveller.java;

import java.util.*;

public class GridTraveller {
    public static void main(String[] args) {
        long result = gridTraveller(18, 18);
        System.out.println(result);
    }   
    
    private static long gridTraveller(int m, int n){
        long[][] table = new long[m + 1][n + 1];
        
        for(long[] row : table)
            Arrays.fill(row, 0);

        table[1][1] = 1;

        for(int i = 0; i < m + 1; i++){
            for(int j = 0; j < n + 1; j++){
                if(j + 1 < n + 1)
                    table[i][j + 1] += table[i][j];
                if(i + 1 < m + 1)
                    table[i + 1][j] += table[i][j];
            }
        }

        return table[m][n];
    }
}
