package Trie.Breeze;

class Node {
    boolean isEnd;
    Node[] children;

    Node() {
        children = new Node[26];
        isEnd = false;
    }
}

public class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node currNode = root;
        int currIndex = 0;

        while (currIndex < word.length()) {
            Character ch = word.charAt(currIndex);

            if (currNode.children[ch - 'a'] == null) {
                currNode.children[ch - 'a'] = new Node();
            }

            currIndex++;
            currNode = currNode.children[ch - 'a'];
        }

        currNode.isEnd = true;
    }

    public boolean search(String word) {
        Node location = location(word);

        if (location == null) return false;

        return location.isEnd;
    }

    public boolean startsWith(String prefix) {
        return location(prefix) != null;
    }

    private Node location(String prefix) {
        Node currNode = root;
        int currIndex = 0;

        while (currIndex < prefix.length()) {
            Character ch = prefix.charAt(currIndex);

            if (currNode.children[ch - 'a'] == null) return null;

            currIndex++;
            currNode = currNode.children[ch - 'a'];
        }

        return currNode;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */