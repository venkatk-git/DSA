package Graphs.ShortestPathAlgorithms.Kruskal_s;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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

public class Kruskal_s {
    public List<String> findMst(List<Edge> edges) {
        ArrayList<String> mst = new ArrayList<>();

        Queue<Edge> heapq = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);
        heapq.addAll(edges);

        while(!heapq.isEmpty() && mst.size() < edges.size() - 1) {
            Edge currEdge = heapq.poll();
            char src = currEdge.src;
            char dest = currEdge.dest;

            // use union find to check src and dest not already unioned

            mst.add(src + "--" + dest);
            
            // union src and dest
        }

        return mst;
    }
}


class Main {
    public static void main(String[] args) {
        List<Edge> edges = List.of(
            new Edge(10, 'A', 'B'),
            new Edge(3, 'A', 'C'),
            new Edge(4, 'B', 'C'),
            new Edge(1, 'B', 'D'),
            new Edge(4, 'C', 'D'),
            new Edge(4, 'C', 'E'),
            new Edge(1, 'D', 'E')
        );

        System.out.println(new Kruskal_s().findMst(edges));
    }
}