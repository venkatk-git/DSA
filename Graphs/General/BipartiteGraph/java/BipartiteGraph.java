package Graphs.BipartiteGraph.java;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        HashSet<Integer> A = new HashSet<>();
        HashSet<Integer> B = new HashSet<>();
        
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        for(int i = 0; i < n; i++) {
            if(!bfs(graph, i, visited, A, B)) {
                return false;
            }
        }

        System.out.println(A);
        System.out.println(B);

        return true;
    }

    public boolean bfs(int[][] graph, int src, boolean[] visited, HashSet<Integer> A, HashSet<Integer> B) {
        visited[src] = true;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(src);
        
        if(!B.contains(src)) {
            A.add(src);
        } else if(!A.contains(src)) {
            B.add(src);
        }
            
        while(!q.isEmpty()) {
            int node = q.poll();

            for(int neighbour : graph[node]) {
                if(visited[neighbour]) {
                    if(A.contains(node) && A.contains(neighbour)
                    || B.contains(node) && B.contains(neighbour)) {
                        return false;
                    }
                } else {
                    visited[neighbour] = true;

                    if(A.contains(node)) {
                        if(A.contains(neighbour)) {
                            return false;
                        }
                        B.add(neighbour);
                    } else {
                        if(B.contains(neighbour)) {
                            return false;
                        }
                        A.add(neighbour);
                    }

                    q.offer(neighbour);
                }
            }
            
        }

        return true;
    }
}

public class BipartiteGraph {
    public static void main(String[] args) {
        int[][] graph = {
            {1, 2, 3},
            {0, 2},
            {0, 1, 3},
            {0, 2}
        };
        
        System.out.println(new Solution().isBipartite(graph));
    }
}