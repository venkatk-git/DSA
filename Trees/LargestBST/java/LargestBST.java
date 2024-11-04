package Trees.LargestBST.java;

class Node { 
    public int data; 
    public Node left, right; 
   
    public Node(int d) { 
        data = d; 
        left = right = null; 
    } 
}

class NodeValue {
    public int maxNode, minNode, maxSize;

    public NodeValue(int maxNode, int minNode, int maxSize) {
        this.maxNode = maxNode;
        this.minNode = minNode;
        this.maxSize = maxSize;
    }
}

class Solution {
    public static int largestBst(Node root) {
        return dfs(root).maxSize;
    }

    public static NodeValue dfs(Node root) {
        if(root == null) {
            return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }

        NodeValue left = dfs(root.left);
        NodeValue right = dfs(root.right);
        
        if(left.maxNode < root.data && right.minNode > root.data) {
            return new NodeValue(Math.max(root.data, right.maxNode), Math.min(root.data, left.minNode), left.maxSize + right.maxSize + 1);
        }

        return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(left.maxSize, right.maxSize));
    }

}

public class LargestBST {
    public static void main(String[] args) {
        Node tree = new Node(6);    

        tree.left = new Node(6);
        tree.right = new Node(2);
        tree.left.right = new Node(2);
        tree.right.left = new Node(1);
        tree.right.right = new Node(3);

        System.out.println(new Solution().largestBst(tree));
    }
}