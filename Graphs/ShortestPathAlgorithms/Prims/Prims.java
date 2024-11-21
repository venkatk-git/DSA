package Graphs.ShortestPathAlgorithms.Prims;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class Edge {
    public int weight;
    public Character dest;
    public Character src;

    public Edge(int weight, Character dest) {
        this.weight = weight;
        this.dest = dest;
    }
    
    public Edge(int weight, Character src, Character dest) {
        this.weight = weight;
        this.src = src;
        this.dest = dest;
    }
}

public class Prims {
    public List<String> findMst(Map<Character, List<Edge>> graph, char src) {
        ArrayList<String> mst = new ArrayList<>();

        Queue<Edge> heapq = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);
        Set<Character> visited = new HashSet<>();

        for(Edge edge: graph.get(src)) {
            heapq.offer(new Edge(edge.weight, src, edge.dest));
        } 
        visited.add(src);

        while(!heapq.isEmpty() && visited.size() != graph.size()) {
            Edge curr = heapq.poll();
            Character source = curr.src;
            Character dest = curr.dest;

            visited.add(dest);

            mst.add(source + "--" + dest); 

            for(Edge edge: graph.get(dest)) {
                if(!visited.contains(edge.dest)) {
                    heapq.offer(new Edge(edge.weight, dest, edge.dest));
                }
            }
        }

        return mst;
    }       
}

class Main {
    public static void main(String[] args) {
        Map<Character, List<Edge>> graph = Map.ofEntries(
            Map.entry('A', List.of(new Edge(10, 'B'), new Edge(3, 'C'))),
            Map.entry('B', List.of(new Edge(10, 'A'), new Edge(4, 'C'), new Edge(1, 'D'))),
            Map.entry('C', List.of(new Edge(3, 'A'), new Edge(4, 'B'), new Edge(4, 'D'), new Edge(4, 'E'))),
            Map.entry('D', List.of(new Edge(1, 'B'), new Edge(4, 'C'), new Edge(2, 'E'))),
            Map.entry('E', List.of(new Edge(4, 'C'), new Edge(2, 'D')))
        );

        System.out.println(new Prims().findMst(graph, 'A'));
    }
}