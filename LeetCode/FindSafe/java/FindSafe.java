package LeetCode.FindSafe.java;

import java.util.List;

public class FindSafe {
    public static void main(String[] args) {
    List<List<Integer>> grid = List.of(
        List.of(0,1,0,0,0), 
        List.of(0,1,0,1,0),
        List.of(0,0,0,1,0)
    );
        boolean[][] memo = new boolean[rows][cols];
    
         findSafeWalkHelper(grid, health, m, n, memo);
    }
    
    private boolean findSafeWalkHelper(List<List<Integer>> grid, int health, int m, int n, boolean[][] memo) {
        if (m < 0 || m >= grid.size() || n < 0 || n >= grid.get(0).size()) {
            return false;
        }
    
        if (memo[m][n]) {
            return false; // Already explored and found no safe path
        }
    
        if (health - grid.get(m).get(n) < 0) {
            return false; // Insufficient health
        }
    
        if (m == grid.size() - 1 && n == grid.get(0).size() - 1) {
            return true; // Reached destination
        }
    
        memo[m][n] = true; // Mark as explored
    
        return findSafeWalkHelper(grid, health - grid.get(m).get(n), m + 1, n, memo) ||
               findSafeWalkHelper(grid, health - grid.get(m).get(n), m - 1, n, memo) ||
               findSafeWalkHelper(grid, health - grid.get(m).get(n), m, n + 1, memo) ||
               findSafeWalkHelper(grid, health - grid.get(m).get(n), m, n - 1, memo);
    } 
}
