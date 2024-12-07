package Trees;

import java.util.ArrayDeque;
import java.util.Deque;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class PopolateRightPointer {
    public Node connect(Node root) {
        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(root);

        while(!deque.isEmpty()) {
            int size = deque.size();
            Node prev = null;
            
            for(int i = 0; i < size; i++) {
                Node curr = deque.poll();
                
                if(curr.right != null) deque.offer(curr.right);
                if(curr.left != null) deque.offer(curr.left);

                curr.next = prev;
                prev = curr;
            }
        }

        return root;
    }
}
