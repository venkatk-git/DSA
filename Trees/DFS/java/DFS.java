import java.util.Stack;

class Node {
    public int val;
    public Node left, right;

    public Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class BinaryTree {
    public Node root;

    public void inorder() {
        if(root == null) {
            return;
        }

        Stack<Node> s = new Stack<>();
        Node curr = root;

        while(curr != null || !s.isEmpty()) {
            while(curr != null) {
                s.push(curr);
                curr = curr.left;
            }

            curr = s.pop();
            System.out.println(curr.val);

            curr = curr.right;
        }
    }
}

public class DFS {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(5);
        bt.inorder();
    }
    
}