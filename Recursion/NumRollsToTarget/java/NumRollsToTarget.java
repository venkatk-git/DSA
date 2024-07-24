package Recursion.NumRollsToTarget.java;

public class NumRollsToTarget {
    public static void main(String[] args) {
        int ans = numRollsToTarget(2, 3, 3);
        System.out.println(ans);    
    }
    
    public static int numRollsToTarget(int n, int k, int target) {
        return _numRollsToTarget(n, k, target);
    }

    private static int _numRollsToTarget(int n, int k, int t){
        if(n == 0){
            return t == 0 ? 1 : 0;
        }

        if(t < 0) return 0;

        int count = 0;

        for(int i = 1; i <= k; i++){
            count += numRollsToTarget(n - 1, k, t - i);
        }

        return count;
    }
}
