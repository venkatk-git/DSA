package HashMap.Blaze;

import cputils.FastReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        int[] nums = Arrays.stream(fastReader.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();    
        
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        int maxSequenceLength = 0;
        
        /**
         ** ANOTHER SOLUTION WITHOUT SET, BUT WITH VISITED ARRAY
         **
         ** int minNum = nums[0];
         ** int maxNum = nums[0];
         ** for (int num: nums) {
         **     minNum = Math.min(minNum, num);
         **     maxNum = Math.max(maxNum, num);
         ** }
         ** 
         ** boolean[] observed = new boolean[maxNum - minNum + 1];
         ** 
         ** for (int num: nums) {
         **     observed[num - minNum] = true;
         ** }
         ** 
         ** int currSequenceLength = 0;
         ** for (boolean isObserved: observed) {
         **     if(isObserved) {
         **         currSequenceLength++;
         **     } else {
         **         maxSequenceLength = Math.max(maxSequenceLength, currSequenceLength);
         **         currSequenceLength = 0;
         **     }
         ** }
         ** 
         ** maxSequenceLength = Math.max(maxSequenceLength, currSequenceLength);
        */
        
        Set<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);

        for (int num: nums) {
            if (!set.contains(num - 1)) {
                int currSequenceLength = 1;

                while (set.contains(num + currSequenceLength)) {
                    currSequenceLength++;
                }

                maxSequenceLength = Math.max(maxSequenceLength, currSequenceLength);
            }
        }

        return maxSequenceLength;
    }
}