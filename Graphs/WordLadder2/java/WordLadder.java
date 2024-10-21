import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    public String word;
    public int seq;
    public boolean visited;
    
    public Node(String word, int seq) {
        this.word = word;
        this.seq = seq;
        visited = false;
    }

    @Override
    public String toString() {
        return word;
    }
}

class Solution {
    List<List<String>> resList = new ArrayList<>();

    public List<List<String>> ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean present = false;
        
        for(String word : wordList) {
            if(word.equals(endWord)) {
                present = true;
            }
        }

        if(!present) {
            return null;
        }
        
        int seq = Integer.MAX_VALUE;
        Map<Node, ArrayList<Node>> graph = buildGraph(wordList, endWord);

        for(Node wordNode : graph.keySet()) {
            String word = wordNode.word;
            if(isValidWord(beginWord, word)) {
                seq = Math.min(seq, wordNode.seq);
            }
        }

        for(Node wordNode : graph.keySet()) {
            String word = wordNode.word;
            if(isValidWord(beginWord, word)) {
                List<String> list = new ArrayList<>();
                list.add(beginWord);
                dfs(graph, wordNode, null, endWord, seq, list);
            }
        }

        return resList;
    }

    public void dfs(Map<Node, ArrayList<Node>> graph, Node src, Node parent, String endWord, int seq, List<String> list) {
        String word = src.word;
        list.add(word);
        if(seq == 1) {
            if(word.equals(endWord)) {
                if(resList.isEmpty()) {
                    resList.add(new ArrayList<>(list));
                } else if(resList.getLast().size() >= list.size()) {
                  
                    if(resList.getLast().size() > list.size()) {
                        resList.removeLast();
                    }
                  
                    resList.add(new ArrayList<>(list));
                } 
            }

            list.removeLast();
            return;
        }
        
        for(Node neighbour : graph.get(src)) {
            if(neighbour != parent) {
                dfs(graph, neighbour, src, endWord, seq - 1, list);
            }
        }

        list.removeLast();
    }

   
    public Map<Node, ArrayList<Node>> buildGraph(List<String> wordList, String endWord) {
        Map<Node, ArrayList<Node>> graph = new HashMap<>();
        Map<String, Node> visited = new HashMap<>();

        Node word = new Node(endWord, 1);
        ArrayDeque<Node> s = new ArrayDeque<>();
        s.offer(word);
        visited.put(endWord, word);
        word.visited = true;

        while(!s.isEmpty()) {
            Node currWord = s.poll();
            
            if(!graph.containsKey(currWord)) {
                graph.put(currWord, new ArrayList<>());
            }
            
            for(String w : wordList) {
                if(isValidWord(w, currWord.word) && !w.equals(currWord.word)) {
                    if(visited.containsKey(w)) {
                        visited.get(w).seq = Math.min(visited.get(w).seq, currWord.seq + 1);
                    } else {
                        visited.put(w, new Node(w, currWord.seq + 1));           
                    }

                    graph.get(currWord).add(visited.get(w));

                    if(!visited.get(w).visited) {
                        s.offer(visited.get(w));
                        visited.get(w).visited = true;
                    }
                } 
            }
        }

        return graph;
    }


    public boolean isValidWord(String word1, String word2) {
        boolean diffCh = false;
        for(int i = 0; i < word1.length(); i++) {
            if(word1.charAt(i) != word2.charAt(i)) {
                if(diffCh) {
                    return false;
                }
                diffCh = true;
            }
        }

        return true;
    }
}

public class WordLadder {
    public static void main(String[] args) {
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog"); 
        String beginWord = "hit";
        String endWord = "cog";

        System.out.println(new Solution().ladderLength(beginWord, endWord, wordList));
    }
}