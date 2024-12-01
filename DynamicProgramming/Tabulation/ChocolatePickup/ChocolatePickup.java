package DynamicProgramming.Tabulation.ChocolatePickup;

import java.util.Arrays;

class Solution {
	public int maximumChocolates(int r, int c, int[][] grid) {
		int[][][] dp = new int[r + 1][c][c];

		for(int[] a: dp[r]) {
			Arrays.fill(a, 0);
		}

		for(int i = r - 1; i >= 0; i--) {
			for(int ac = 0; ac < c; ac++) {
				for(int bc = 0; bc < c; bc++) {
					int chocolates;

					if(ac != bc) chocolates = (grid[i][ac] + grid[i][bc]);
					else chocolates = grid[i][ac];
					
					int prevMaxChocolates = 0;
					for(int j = -1; j <= 1; j++) {
						for(int k = -1; k <= 1; k++) {
							if(ac + j >= 0 && ac + j < c && bc + k >= 0 && bc + k < c) {
								prevMaxChocolates = Math.max(prevMaxChocolates, dp[i + 1][ac + j][bc + k]);
							}
						}
					}

					dp[i][ac][bc] = chocolates + prevMaxChocolates;
				}
			}
		}

		return dp[0][0][c - 1];
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