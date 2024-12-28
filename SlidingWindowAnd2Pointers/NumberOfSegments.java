package SlidingWindowAnd2Pointers;

import cputils.FastReader;
import java.util.Arrays;

public class NumberOfSegments {
    public static void main(String args[]) {
        FastReader fastReader = new FastReader();
        int n = fastReader.nextInt();
        int maxSum = fastReader.nextInt();
        int[] nums = Arrays.stream(fastReader.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    
        System.out.println(maxSegments(nums, n, maxSum));
    }
        
    private static int maxSegments(int[] nums, int n, int maxSum) {
        int l = 0;
        int r = 0;
        int maxSegment = 0;

        int sum = 0;
        while(r < n) {
            sum += nums[r];
            
            if (sum > maxSum) {
                sum -= nums[l];
                l++;
            }
            
            maxSegment = Math.max(maxSegment, (r - l + 1 ));
            r++;
        }

        return maxSegment;
    }
}