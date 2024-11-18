package Graphs.DetectCycle.java;

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
    public boolean isCycle(List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        for(int i = 0; i < V; i++) {
            if(!visited[i] && dfs(adj, i, -1, visited)){
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

    public boolean dfs(List<List<Integer>> adj, int src, int parent, boolean[] visited) {
        visited[src] = true;

        for(int v : adj.get(src)) {
            if(!visited[v]) {
                if(dfs(adj, v, src, visited)) {
                    return true;
                }
            } else if(v != parent) {
                return true;
            }
        }

        return false;
    }
}

public class DetectCycle {
    public static void main(String[] args) {
        List<List<Integer>> adj = List.of(
            List.of(4, 2),
            List.of(4, 1),
            List.of(6, 7),
            List.of(5, 13),
            List.of(10, 12),
            List.of(4, 17),
            List.of(2, 14)
        );

        System.out.println(new Solution().isCycle(adj, 20));
    }
}