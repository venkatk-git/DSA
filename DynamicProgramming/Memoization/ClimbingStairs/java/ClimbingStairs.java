package DynamicProgramming.Memoization.ClimbingStairs.java;

import java.util.HashMap;

class ClimbingStairs{
    public static void main(String[] args) {
        int numberOfStairs = 22;
        System.out.println(climbingStairs(numberOfStairs));
    }

    private static int climbingStairs(int n){
        return _climbingStairs(0, n, new HashMap<>());
    }

    public static int _climbingStairs(int n, int N, HashMap<Integer, Integer> memo){
        if(memo.containsKey(n))
            return memo.get(n);
        
        if(n == N)
            return 1;
        
        if(n > N)
            return 0;
        
        int result = _climbingStairs(n + 1, N, memo) + _climbingStairs(n + 2, N, memo);
        memo.put(n, result);
        return result;
    }
}