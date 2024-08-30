package LeetCode.PeekElement.java;

public class PeekElement {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        System.out.println(findPeedElement(nums));
    }

    public static int findPeedElement(int[] nums){
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int m;

        if(n == 1)
            return 0;

        while(l <= r){
            m = (l + r) / 2;

            if(m != 0 && m != n - 1){
                if(nums[m - 1] < nums[m] && nums[m + 1] < nums[m])
                    return m;
                else if(nums[m] < nums[m + 1])
                    l = m + 1;
                else 
                    r = m - 1;
            } else if(m == 0){
                if(nums[m + 1] < nums[m])
                    return m;
                else    
                    l = m + 1;
            } else{
                if(nums[m - 1] < nums[m])
                    return m;
                else    
                    r = m - 1;
            }
        }

        return 0;
    }
}
