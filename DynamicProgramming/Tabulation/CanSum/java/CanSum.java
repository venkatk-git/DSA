package DynamicProgramming.Tabulation.CanSum.java;

import java.util.Arrays;

public class CanSum {
    public static void main(String[] args) {
        int[] nums = {7, 14};
        boolean result = canSum(nums, 300);

        System.out.println(result);
    }

    private static boolean canSum(int[] nums, int target){
        boolean[] table = new boolean[target + 1];
        Arrays.fill(table, false);

        table[0] = true;
        for(int num : nums)
            table[num] = true;

        for(int i = 0; i < table.length; i++)
            for(int num : nums)
                if(i + num < table.length && table[i])
                    table[i + num] = true;
                

        return table[target];
    }
}
