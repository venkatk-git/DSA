package DynamicProgramming.Tabulation.HowSum.java;

import java.util.Arrays;

public class HowSum {
    public static void main(String[] args) {
        int[] nums = {7, 14};

        int[] result = howSum(nums, 300);
        System.out.println(Arrays.toString(result));
    }

    private static int[] join(int[] nums, int n){
        int[] res = new int[nums.length + 1];

        for(int i = 0; i < nums.length; i++)
            res[i] = nums[i];
        
        res[nums.length] = n;

        return res;
    }

    private static int[] howSum(int[] nums, int target){
        int[][] table = new int[target + 1][];
        Arrays.fill(table, null);

        table[0] = new int[]{};
        for(int num : nums){
            table[num] = new int[]{num};  
        }

        for(int i = 0; i <= target; i++){
            for(int num : nums){
                if(table[i] != null && i + num <= target){
                    int[] res = join(table[i], num);
                    table[i + num] = res;
                }
            }
        }


        return table[target];
    }
}
