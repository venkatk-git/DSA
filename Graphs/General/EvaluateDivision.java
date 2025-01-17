package Graphs.General;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Vertex {
    public String to;
    public double value;

    public Vertex(String to, double value) {
        this.to = to;
        this.value = value;
    }    

    public String toString() {
        return "{ " + to + ", " + value + " }";
    }
}

public class EvaluateDivision {
    public static void main(String[] args) {
        List<List<String>> equations = List.of(List.of("a","b"));
        double[] values = {0.5};
        List<List<String>> queriesList = List.of(
            List.of("a", "b"),
            List.of("b", "a"),
            List.of("a", "c"),
            List.of("x", "y")
        );
        System.out.println(Arrays.toString(calcEquation(equations, values, queriesList)));
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = queries.size();
        double[] result = new double[n];
        
        Map<String, List<Vertex>> graph = buildGraph(equations, values);

        for (int i = 0; i < n; i++) {
            String from = queries.get(i).get(0);
            String to = queries.get(i).get(1);

            if (!graph.containsKey(from) || !graph.containsKey(to)) result[i] = -1.0;
            else if (from.equals(to)) result[i] = 1.0;
            else result[i] = dfs(graph, from, to, new HashSet<>());
        }

        return result;
    }

    private static Map<String, List<Vertex>> buildGraph(List<List<String>> equations, double[] values) {
        int n = values.length;
        Map<String, List<Vertex>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String from = equations.get(i).get(0);            
            String to = equations.get(i).get(1);            
            
            if (!graph.containsKey(from)) graph.put(from, new ArrayList<>());
            if (!graph.containsKey(to)) graph.put(to, new ArrayList<>());

            graph.get(from).add(new Vertex(to, values[i]));
            graph.get(to).add(new Vertex(from, 1/values[i]));
        }

        System.out.println(graph);

        return graph;
    }

    private static double dfs(Map<String, List<Vertex>> graph, String src, String dst, Set<String> visited) {
        if (visited.contains(src)) {
            return -1.0;
        } 

        if (src.equals(dst)) {
            return 1;
        }

        visited.add(src);

        for (Vertex v: graph.get(src)) {
            double res = dfs(graph, v.to, dst, visited);
            if (res != -1.0) return v.value * res;
        }

        return -1.0;
    }
}