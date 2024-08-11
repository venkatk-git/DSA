package DynamicProgramming.Memoization.UniquePaths.java;

import java.util.*;

public class UniquePaths {
    public static void main(String[] args) {
        int m1 = 3;
        int n1 = 7;
        System.out.println(uniquePaths(m1, n1));
        
        int m2 = 3;
        int n2 = 2;
        System.out.println(uniquePaths(m2, n2));
    }   
    
    private static int uniquePaths(int m, int n){
        return _uniquePaths(m, n, new HashMap<>());
    }

    private static int _uniquePaths(int m, int n, HashMap<String, Integer> memo){
        String key = "" + m + "," + n;
        if(memo.containsKey(key))
            return memo.get(key);

        if(m == 1 && n == 1)
            return 1;
        
        int down = 0;
        int right = 0;

        if(m > 1)
            down = _uniquePaths(m - 1, n, memo);
        if(n > 1)
            right = _uniquePaths(m, n - 1, memo);

        memo.put(key, down+right);
        return down + right;
    }
}
