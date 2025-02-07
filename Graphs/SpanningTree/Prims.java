import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Prims {
    public static void main(String[] args) {
        int[][] edges = {{1, 2, 1}, {1, 3, 3}, {1, 4, 4}, {2, 3, 2}, {3, 5, 6}, {3, 4, 7}};
        int n = 5;
        Map<Integer, List<int[]>> graph = new HashMap<>();
    
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        prims(graph, n);
    }

    public static void prims(Map<Integer, List<int[]>> graph, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
        pq.offer(new int[]{1, 0});

        Set<Integer> visited = new HashSet<>();

        int sum = 0;
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int u = edge[0];
            int w = edge[1];

            if (visited.size() == n) {
                System.out.println(sum);
                return;
            }

            visited.add(u);
            sum += w;
            for(int[] nei: graph.get(u)) {
                if (!visited.contains(nei[0])) {
                    pq.offer(new int[]{nei[0], w + nei[1]});
                }
            }
        }

        System.out.println(sum);
    }
}
