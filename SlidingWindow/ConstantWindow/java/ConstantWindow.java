package SlidingWindow.ConstantWindow.java;

public class ConstantWindow {
    public static void main(String[] args){
        int[] nums = {3, 0, 9, -3, 19, 7};
        int windowSize = 3;

        System.out.println(constantWindow(nums, windowSize));
    }

    private static int constantWindow(int[] nums, int windowSize){
        int ws = 0;
        int we = windowSize - 1;
        int res = 0;
        int currSum = 0;

        for(int i = 0; i < windowSize; i++)
            currSum += nums[i];

        res = currSum;
        while(we + 1 < nums.length){
            currSum -= nums[ws++];
            currSum += nums[++we];
            res = Math.max(res, currSum);
        }

        return res;
    }
}
