package SlidingWindowAnd2Pointers.SubarrayWithOddNum.java;

/**
 * SubarrayWithOddNum
 */

public class SubarrayWithOddNum {
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int k = 2;
        System.out.println(numberOfSubarrays(nums, k));
    }

    public static int numberOfSubarraysBF(int[] nums, int k){
        int count = 0;
        
        for(int i = 0; i < nums.length; i++){
            int oddNums = 0;
            for(int j = i; j < nums.length; j++){
                if(nums[j] % 2 != 0)
                    oddNums += 1;

                if(oddNums == k)
                    count += 1;
                
                if(oddNums > k)
                    break;
            }
        }

        return count;
    } 

    public static int numberOfSubarrays(int[] nums, int k){
        return helper(nums, k) - helper(nums, k - 1);
    }

    public static int helper(int[] nums, int k){
        if(k < 0)
            return 0;

        int l = 0; 
        int r = 0;
        int count = 0;
        int oddNums = 0;

        while(r < nums.length){
            if(nums[r] % 2 != 0)
                oddNums += 1;

            while (oddNums > k && l <= r) {
                if(nums[l] % 2 != 0)
                    oddNums -= 1;
                l++;       
            }

            count += r - l + 1;
            r++;
        }

        return count;
    }
}