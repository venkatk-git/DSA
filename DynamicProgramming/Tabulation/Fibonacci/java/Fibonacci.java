package DynamicProgramming.Tabulation.Fibonacci.java;

import java.util.*;

public class Fibonacci {
    public static void main(String[] args) {
        long result = fib(50);
        System.out.println(result);
    }   
    
    private static long fib(int n){
        long[] table = new long[n + 1];
        Arrays.fill(table, 0);

        long prevprev = 0;
        long prev = 1;

        for(int i = 2; i < table.length; i++){
            table[i] = prevprev + prev;
            prevprev = prev;
            prev = table[i];
        }

        return table[n];
    }
}
