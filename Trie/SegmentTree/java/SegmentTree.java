package Trie.SegmentTree.java;

import java.util.ArrayDeque;
import java.util.Deque;

class Node {
    public int sum;
    public Node left;
    public Node right;
    public int start;
    public int end;

    public Node(int sum, int start, int end) {
        this.sum = sum;
        this.start = start;
        this.end = end;
        left = null;
        right = null;
    }
}

public class SegmentTree {
    public Node buildSegmentTree(int[] nums, int i, int j) {
        if(i == j) {
            return new Node(nums[i], i, j);
        }

        int m = (i + j) / 2;
        Node rootNode = new Node(0, i, j);
        rootNode.left = buildSegmentTree(nums, i, m);
        rootNode.right = buildSegmentTree(nums, m + 1, j);
        rootNode.sum = rootNode.left.sum + rootNode.right.sum;

        return rootNode;
    }

    public void update(Node root, int i, int val) {
        if(root.start == root.end) {
            root.sum = val;
            return;
        }

        int m = (root.start + root.end) / 2;

        if(m < i) {
            update(root.right, i, val);
        } else {
            update(root.left, i, val);
        }

        root.sum = root.left.sum + root.right.sum;      
    }

    public int query(Node root, int start, int end) {
        if(start == root.start && end == root.end) {
            return root.sum;
        }

        int m = (root.start + root.end) / 2;
        
        if(start > m) {
            return query(root.right, start, end);
        } else if(end <= m) {
            return query(root.left, start, end);
        } else {
            return query(root.left, start, m) + query(root.right, m + 1, end);
        }
    }

    public void printSegmentTree(Node root) {
        Deque<Node> q = new ArrayDeque<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            if(curr.left != null) {
                q.offer(curr.left);
            }
            
            if(curr.right != null) {
                q.offer(curr.right);
            }
            

            System.out.println("Sum of all values " + "from " + curr.start + " to " + curr.end + " is: " + curr.sum);
        }
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {5, 3, 7, 1, 4, 2};
        SegmentTree segmentTree = new SegmentTree();
        Node root = segmentTree.buildSegmentTree(nums, 0, nums.length - 1);
        // segmentTree.printSegmentTree(root);
        // System.out.println(root.start);
        System.out.println(segmentTree.query(root, 2, 4));
    }
}