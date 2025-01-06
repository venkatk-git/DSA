import java.util.Arrays;

public class MaximumHeight {
    public long maximumTotalSum(int[] maximumHeight) {
        int n = maximumHeight.length;
        Arrays.sort(maximumHeight);
        
        long heights = 0;
        long lastHeight = maximumHeight[n - 1];

        for (int i = n - 1; i >= 0; i--) {
            if (lastHeight <= 0) return -1;

            long height = Math.min(lastHeight, maximumHeight[i]);
            heights += height;
            lastHeight = height - 1;
        }

        return heights;
    }
}