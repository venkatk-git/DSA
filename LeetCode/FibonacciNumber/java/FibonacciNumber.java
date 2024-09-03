package LeetCode.FibonacciNumber.java;

/**
 * FibonacciNumber
 */

import java.util.*;

 public class FibonacciNumber {
    public static void main(String[] args) {
        int n = 25;
        System.out.println(fib(n));
    }

    /* Brute Force Recursive Approach */
    public static int fib(int n){
        if(n <= 1)
            return n;
        
        return fib(n - 1) + fib(n - 2);
    }

    /* DP Memoization Approach */
    public int fib(int n, HashMap<Integer, Integer> memo) {
        if(memo.containsKey(n))
            return memo.get(n);
        
        if(n <= 1)
            return n;
        
        int res = fib(n - 1, memo) + fib(n - 2, memo);
        memo.put(n, res);
        return res;
    }
}