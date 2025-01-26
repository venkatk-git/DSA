package Graphs.ShortestPath;

import java.util.*;

class Edge {
    public int from;
    public int to;
    public int weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}

class Vertex {
    public int v;
    public int w;

    public Vertex(int v, int w) {
        this.v = v;
        this.w = w;
    }
}

public class ShortestPathInDAG {
    public static void main(String[] args) {
        int[][] edges = {
            {0, 1, 2},
            {0, 4, 1},
            {4, 5, 4},
            {4, 2, 2},
            {1, 2, 3},
            {2, 3, 6},
            {4, 3, 1}
        };
        int V = 6;

        Map<Integer, List<Vertex>> graph = buildGraph(edges, V);
        int[] dist = dijkstras(graph, 0, V);
    
        System.out.println(Arrays.toString(dist));
    }    

    public static Map<Integer, List<Vertex>> buildGraph(int[][] edges, int V) {
        Map<Integer, List<Vertex>> graph = new HashMap<>();
        
        for (int i = 0; i < V; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new Vertex(edge[1], edge[2]));
        }

        return graph;
    }

    public static int[] dijkstras(Map<Integer, List<Vertex>> graph, int src, int V) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0; // Initialize distance to the source as 0
        
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Vertex> heap = new PriorityQueue<>((v1, v2) -> v1.w - v2.w);
        heap.add(new Vertex(src, 0));

        while (!heap.isEmpty()) {
            Vertex vertex = heap.poll();
            int v = vertex.v;

            // Skip if already visited
            if (visited.contains(v)) continue;

            visited.add(v);

            for (Vertex neighbor : graph.get(v)) {
                if (!visited.contains(neighbor.v) && dist[v] + neighbor.w < dist[neighbor.v]) {
                    dist[neighbor.v] = dist[v] + neighbor.w;
                    heap.add(new Vertex(neighbor.v, dist[neighbor.v]));
                }
            }
        }

        return dist;
    }
}
