import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestCycle {
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        int[] edges = {4, 4, 1, 4, 13, 8, 8, 8, 0, 8, 14, 9, 15, 11, -1, 10, 15, 22, 22, 22, 22, 22, 21};
       
        HashSet<Integer> visited = new HashSet<>();

        for (int i = 0; i < edges.length; i++) {
            if (!visited.contains(i)) {
                Map<Integer, Integer> dist = new HashMap<>();
                dist.put(i, 1);
                dfs(edges, i, visited, dist);
            }
        }

        System.out.println(max == Integer.MIN_VALUE ? -1 : max);
    }

    public static void dfs(int[] edges, int src, Set<Integer> visited, Map<Integer, Integer> dist) {
        if (edges[src] != -1 && !visited.contains(src)) {
            visited.add(src);

            int neighbor = edges[src];
            if (dist.containsKey(neighbor)) {
                max = Math.max(max, dist.get(src) - dist.get(neighbor) + 1);
                return;
            }            

            dist.put(neighbor, dist.get(src) + 1);
            dfs(edges, neighbor, visited, dist);
        }
    }
}
