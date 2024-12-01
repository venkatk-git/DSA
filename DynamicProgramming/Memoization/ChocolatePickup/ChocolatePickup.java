package DynamicProgramming.Memoization.ChocolatePickup;

import java.util.Arrays;

class Solution {
	static int[] paths = {-1, 0, 1};

	public int maximumChocolates(int r, int c, int[][] grid) {
		int[][][] dp = new int[r][c][c];

		for(int[][] a: dp) {
			for(int[] b: a) {
				Arrays.fill(b, -1);
			}
		}

		return maximumChocolates(0, 0, grid[0].length - 1, grid, dp);
	}

	private int maximumChocolates(int i, int aj, int bj, int[][] grid, int[][][] dp) {
		boolean isAlexInBound = aj >= 0 && aj < grid[0].length;
		boolean isBobInBound = bj >= 0 && bj < grid[0].length;

		if(i == grid.length || !isAlexInBound || !isBobInBound) {
			return 0;
		}
		
		if(dp[i][aj][bj] != -1) {
			return dp[i][aj][bj];
		}

		int alex = grid[i][aj];
		int bob = grid[i][bj];

		if(aj == bj) {
			bob = 0;
		}

		int maxChocolates = 0;

		for(int ac = 0; ac < 3; ac++) {
			for(int bc = 0; bc < 3; bc++) {
				maxChocolates = Math.max(maxChocolates, maximumChocolates(i + 1, aj + paths[ac], bj + paths[bc], grid, dp));
			}
		}

		dp[i][aj][bj] = alex + bob + maxChocolates;

		return alex + bob + maxChocolates;
	}
}


public class ChocolatePickup {
	public static void main(String[] args) {
		int[][] chocolates = {
			{2, 3, 1, 2},
			{3, 4, 2, 2},
			{5, 6, 3, 5}
		};
		
		System.out.println(new Solution().maximumChocolates(chocolates.length, chocolates[0].length, chocolates));
	}
	
}