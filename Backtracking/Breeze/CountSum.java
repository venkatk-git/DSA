public class CountSum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 7, -2, 5};

        System.out.println(countSum(nums, 0, 0, 10));
    }

    public static int countSum(int[] nums, int i, int sum, int t) {
        if(sum == t) {
            return 1;
        }

        if(i == nums.length) {
            return 0;
        }

        int withCurrentElement = 0; 
        int withoutCurrentElement = 0;
        
        for(int j = i; j < nums.length; j++) {
            withCurrentElement = countSum(nums, i + 1, sum + nums[i], t);
            withoutCurrentElement = countSum(nums, i + 1, sum, t);
        }

        return withCurrentElement + withoutCurrentElement;
    }
    
}