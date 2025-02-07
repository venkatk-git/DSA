package Graphs.ShortestPathAlgorithms.Dijikstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {
    public static void main(String[] args) {
        int[][] edges = {
            {1, 2, 1},
            {1, 4, 2},
            {2, 3, 4},
            {4, 2, 3},
            {4, 3, 1},
            {4, 5, 4},
            {3, 5, 5}
        };

        System.out.println(Arrays.toString(shortestPath(edges, 5, 1)));
    }

    public static int[] shortestPath(int[][] edges, int n, int src) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int s = edge[0], d = edge[1], w = edge[2];
            graph.get(s).add(new int[] {d, w});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int)1e8);
        dist[src] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int u = node[0];
            int w = node[1];

            for (int[] nei: graph.get(u)) {
                int v = nei[0], vw = nei[1];

                if (w + vw < dist[v]) {
                    dist[v] = w + vw;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        
        return dist;
    }
}