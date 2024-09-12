import java.util.*;

public class HasPath {
    public static void main(String[] args) {
        List<List<String>> edges = List.of(
            List.of("i", "j"),
            List.of("k", "i"),
            List.of("m", "k"),
            List.of("k", "l"),
            List.of("o", "n")
          );
          
          System.out.println(hasPath(edges, "o", "n")); 
    }

    public static boolean hasPath(List<List<String>> edges, String src, String dest){
        Set<String> visited = new HashSet<>();
        Deque<String> s = new ArrayDeque<>();
        s.offer(src);

        Map<String, List<String>> graph = buildGraph(edges);

        while(!s.isEmpty()){
            String currNode = s.pop();

            if(currNode.equals(dest))
                return true;

            for(String neighbor : graph.get(currNode)){
                if(!visited.contains(neighbor))
                    s.offer(neighbor);
                visited.add(neighbor);
            }
        }

        return false;
    }

    public static Map<String, List<String>> buildGraph(List<List<String>> edges){
        Map<String, List<String>> graph = new HashMap<>();

        for(List<String> list : edges){
            String v1 = list.get(0);
            String v2 = list.get(1);

            if(!graph.containsKey(v1))
                graph.put(v1, new ArrayList<>());
            
            if(!graph.containsKey(v2))
                graph.put(v2, new ArrayList<>());

            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        return graph;
    }
}
