package LeetCode.ReversePairs.java;

public class ReversePairs {
    static int pairs = 0;
    public static void main(String[] args) {
        int[] nums = {2,4,3,5,1};
        
        System.out.println(reversePairs(nums));
    }

    private static int reversePairs(int[] nums){
        _reversePairs(nums, 0, nums.length - 1);
        return pairs;
    }

    private static void _reversePairs(int[] nums, int s, int e){
        if(s == e) 
            return;

        int m = (s + e) / 2;  
        _reversePairs(nums, s, m);
        _reversePairs(nums, m + 1, e);

        // Count pairs before sorting
        int i = s;
        int j = m + 1;
        while(i <= m && j <= e){
            if(nums[i] / 2.0 > nums[j]){
                j++;
                pairs += m - i + 1;
            } else {
                i++;
            }
        }

        merger(nums, s, m, e);
    }

    private static void merger(int[] nums, int l, int m, int r){
        int ln = m - l + 1;
        int rn = r - m;
        
        int[] L = new int[ln];
        for(int i = 0; i < ln; i++)
            L[i] = nums[l + i];
        
        int[] R = new int[rn];
        for(int i = 0; i < rn; i++)
            R[i] = nums[m + i + 1];

        int i = 0;
        int j = 0;
        int k = l;

        while(i < ln && j < rn){
            if(L[i] < R[j])
                nums[k++] = L[i++];
            else
                nums[k++] = R[j++];
        }

        while(i < ln)
            nums[k++] = L[i++];
        
        while (j < rn) 
            nums[k++] = R[j++];
    }
}
