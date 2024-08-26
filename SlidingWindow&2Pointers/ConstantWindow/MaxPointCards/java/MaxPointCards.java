

class MaxPointCards{
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;

        System.out.println(maxScore(nums, k));
    }

    private static int maxScore(int[] nums, int k){
        int max;
        int currMax;
        int lSum = 0;
        int rSum = 0;
        
        for(int i = 0; i < k; i++)
            lSum += nums[i];
        
        max = lSum;
        for(int i = 1; i <= k; i++){
            lSum -= nums[k - i];
            rSum += nums[nums.length - i];

            currMax = lSum + rSum;
            max = Math.max(max, currMax);
        }

        return max; 
    }
}