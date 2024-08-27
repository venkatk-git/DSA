package Trees.BinarySearchTree.Implementation.java;

public class BinarySearchTree {
    class Node{
        private int val;
        private int height;
        private Node left;
        private Node right;

        public Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }

        public int getValue(){
            return val;
        }
    }

    private Node root;

    public boolean insert(int val){
        if(root == null){
            root = new Node(val);
            return true;
        }
        return insert(root, val);
    }

    public boolean insert(Node node, int val){
        if(val < node.val && node.left == null){
            node.left = new Node(val);
            return true;
        }

        if(val > node.val && node.right == null){
            node.right = new Node(val);
            return true;
        }

        if(val < node.val)
            insert(node.left, val);
        else 
            insert(node.right, val);

        return true;
    }

    public boolean isEmpty(){
        return root == null;
    }   

    
    public void display(){
        display(root, "Root node: ");
    }

    public void display(Node node, String s){
        if(node == null)
            return;
        
        System.out.println(s + node.val);
        display(node.left, "Left child of " + node.val + " : ");
        display(node.right, "Right child of " + node.val + " : ");
    }    

    public void preOrder(){
        preOrder(root);
    }

    public void inOrder(){
        inOrder(root);
    }

    public void postOrder(){
        postOrder(root);
    }

    public void preOrder(Node node){
        if(node == null)
            return;
        
        System.out.print(node.val + "-->");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(Node node){
        if(node == null)
            return;
        
        inOrder(node.left);
        System.out.print(node.val + "-->");
        inOrder(node.right);
    }

    public void postOrder(Node node){
        if(node == null)
            return;
        
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + "-->");
    }

    public void ascnOrder(){
        ascnOrder(root);
    }

    public void descOrder(){
        descOrder(root);
    }

    public void ascnOrder(Node node){
        if(node == null)
            return;

        ascnOrder(node.left);
        System.out.print(node.val + " ");
        ascnOrder(node.right);
    }

    public void descOrder(Node node){
        if(node == null)
            return;
        
        descOrder(node.right);
        System.out.print(node.val + " ");
        descOrder(node.left);
    }
}
