package SlidingWindowAnd2Pointers.LongestSubarrSum.java;

public class LongestSubarrSum {
    public static void main(String[] args) {
        int[] nums = {0, 2, 5, 67, 6, 3};
        int maxVal = 10;
        
        System.out.println(longestSubarrSum(nums, maxVal));
    }

    /** BruteForce
    ** private static int longestSubarrSum(int[] nums, int maxVal){
    **    int maxSum = 0;
    **    int windowSize = 0;
    **   
    **    int currSum;
    **    for(int i = 0; i < nums.length; i++){
    **        currSum = 0;
    **        for(int j = i; j < nums.length; j++){
    **            currSum += nums[j];
    **            if(currSum < maxVal && currSum > maxSum){
    **                maxSum = currSum;
    **                windowSize = j - i + 1;
    **            }
    **        }
    **    }
    **
    **   return windowSize;
    }
    **/

    /* Sliding Window */
    private static int longestSubarrSum(int[] nums, int maxVal){
        int maxSum = 0;
        int windowSize = 0;
        
        int currSum = 0;
        int l = 0, r = 0;
        while(r < nums.length){
            currSum += nums[r++]; 

            while(currSum > maxVal)
                currSum -= nums[l++];

            if(currSum > maxSum){
                maxSum = currSum;
                /**
                ** Why not (r - l + 1) ?
                ** Because, we are already incrementing the r in the line --> currSum += nums[r++];
                ** So, we should not add another 1 to it 
                **/
                windowSize = r - l;
            }
        }

        return windowSize;
    }
}
