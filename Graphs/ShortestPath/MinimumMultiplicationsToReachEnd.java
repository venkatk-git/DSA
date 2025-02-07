import java.util.*;

public class MinimumMultiplicationsToReachEnd {
    public static void main(String[] args) {
        int[] arr = {9, 12, 18, 19};
        int start = 5, end = 5;
        
        System.out.println(minimumMultiplications(arr, start, end));
    }    
    
    static int minimumMultiplications(int[] multipliers, int start, int end) {
        int MOD = (int)1e5;
        Set<Integer> visited = new HashSet<>();
        Deque<List<Integer>> q = new ArrayDeque<>();
        q.offer(List.of(start, 0));
        visited.add(start);

        while (!q.isEmpty()) {
            List<Integer> number = q.poll();
            int num = number.get(0);
            int move = number.get(1);

            if (num == end)
                return move;

            for (int multiplier: multipliers) {
                int nextNumber = (num * multiplier) % MOD;
                int nextMove = move + 1;

                if (!visited.contains(nextNumber)) {
                    visited.add(nextNumber);
                    q.offer(List.of(nextNumber, nextMove));
                }
            }
        }

        return -1;
    }
}
