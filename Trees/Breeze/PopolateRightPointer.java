package Trees.Breeze;

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
        if (root == null) {
            return root;
        }

        Node curr = root;
        Node next = curr.left;

        while(next != null) {
            curr.left.next = curr.right;

            if (curr.next != null) {
                curr.right.next = curr.next.left;
                curr = curr.next;   
            } else {
                curr = next;
                next = curr != null ? curr.left : null;
            }

        }
        
        return root;
    }
}
