package Graphs.WordLadder1.java;

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

    public String toString() {
        return word;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean present = false;
        
        for(String word : wordList) {
            if(word.equals(endWord)) {
                present = true;
            }
        }

        if(!present) {
            return 0;
        }
        
        int seq = Integer.MAX_VALUE;
        Map<Node, ArrayList<Node>> graph = buildGraph(wordList, endWord);
        System.out.println(graph);
        for(Node wordNode : graph.keySet()) {
            String word = wordNode.word;
            if(isValidWord(beginWord, word)) {
                seq = Math.min(seq, wordNode.seq + 1);
            }
        }

        return seq;
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
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog"); 
        String beginWord = "hit";
        String endWord = "cog";

        System.out.println(new Solution().ladderLength(beginWord, endWord, wordList));
        // System.out.println(new Solution().isValidWord("hot", "cat"));
    }
}