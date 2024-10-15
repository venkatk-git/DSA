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

    public void preorder() {
        if(root == null) {
            return;
        }

        Stack<Node> s = new Stack<>();
        Node curr = root;

        while(curr != null || !s.isEmpty()) {
            while(curr != null) {
                System.out.println(curr.val);
                
                if(curr.right != null) {
                    s.push(curr.right);
                }

                curr = curr.left;
            }

            if(!s.isEmpty()) {
                curr = s.pop();
            }
        }
    }

    public void postorder() {
        if(root == null) {
            return;
        }        

        Stack<Node> s = new Stack<>();
        Node curr = root;
    }
}

public class DFS {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new Node(10);
        bt.root.left = new Node(20);
        bt.root.right = new Node(30);
        bt.root.left.left = new Node(40);
        bt.root.left.left.left = new Node(70);
        bt.root.left.right = new Node(50);
        bt.root.right.left = new Node(60);
        bt.root.left.left.right = new Node(80);
        bt.preorder();
    }
    
}