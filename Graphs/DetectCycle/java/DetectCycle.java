import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

class Pair {
    public int vertex;
    public int parent;

    public Pair(int vertex, int parent) {
        this.vertex = vertex;
        this.parent = parent;
    }
}

class Solution {
    public boolean isCycle(List<List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        Arrays.fill(visited, false);

        for(int i = 0; i < adj.size(); i++) {
            if(!visited[i] && bfs(adj, i, visited)){
                return true;
            }
        }

        return false;
    }

    public boolean bfs(List<List<Integer>> adj, int src, boolean[] visited) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(0, -1));
        visited[src] = true;

        while(!q.isEmpty()){
            int vertex = q.peek().vertex;
            int parent = q.peek().parent;
            q.remove();
            
            visited[vertex] = true;

            for(int v : adj.get(vertex)) {
                if(!visited[v]) {
                    q.offer(new Pair(v, vertex));
                } else if(v != parent) {
                    return true;
                }
            }
        }

        return false;
    }

    public void dfs(List<List<Integer>> adj) {

    }
}

public class DetectCycle {
    public static void main(String[] args) {
        List<List<Integer>> adj = List.of(
            List.of(1),
            List.of(0, 2, 4),
            List.of(1, 3),
            List.of(2, 4),
            List.of(1, 3)
        );

        System.out.println(new Solution().isCycle(adj));
    }
}