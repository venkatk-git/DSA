package LeetCode.MaxConsOnes3.java;

public class MaxConsOnes3 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(longestOnes(nums, k));
    }   

    public static int longestOnes(int[] nums, int k){
        int n = nums.length;
        int max = 0;
        int currMax;

        int l = 0,r = 0;
        int currZeros = 0;
        while(r < n && l < n){
            if(nums[r] == 0)
                currZeros++;

            while(currZeros > k){
                if(nums[l] == 0)
                    currZeros--;
                l++;
            }
            
            currMax = r - l + 1;
            max = Math.max(max, currMax);
            r++;
        }

        return max;
    }
}
