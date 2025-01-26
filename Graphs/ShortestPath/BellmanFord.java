import java.util.Arrays;
import java.util.List;

class Vertex {
    public int u;
    public int v;
    public int wt;

    public Vertex(int u, int v, int wt) {
        this.u = u;
        this.v = v;
        this.wt = wt;
    }

    @Override 
    public String toString() {
        return u + "-- " + wt + " --" + v;
    }
}

public class BellmanFord {
    public static void main(String[] args) {
        List<Vertex> edges = List.of(
            new Vertex(3, 2, 6),
            new Vertex(5, 3, 1),
            new Vertex(0, 1, 5),
            new Vertex(1, 5, -3),
            new Vertex(1, 2, -2),
            new Vertex(3, 4, -2),
            new Vertex(2, 4, 3)
        );
        int V = 6;

        System.out.println(Arrays.toString(bellmanFord(edges, V, 0)));
    }
    
    private static int[] bellmanFord(List<Vertex> edges, int V, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[src] = 0;
        for(int i = 0; i < V - 1; i++) {
            for(Vertex edge: edges) {
                int u = edge.u;
                int v = edge.v;
                int wt = edge.wt;

                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Just to find negative cycle
        for(int i = 0; i < V - 1; i++) {
            for(Vertex vertex: edges) {
                int u = vertex.u;
                int v = vertex.v;
                int wt = vertex.wt;

                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    return new int[]{-1}; // [-1] means, given graph have a negative cycle
                }
            }
        }

        return dist;
    }
} 