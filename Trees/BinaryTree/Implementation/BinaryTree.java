package Trees.BinaryTree.Implementation;

class BinaryTree{
    private static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
            this.left = null;
            this.right= null;
        }
    }

    public BinaryTree(){

    }

    private Node root;

    public boolean insertRoot(int val){
        root = new Node(val);
        return true;
    }

    public void insert(int val){
        insert(root, val);
    }

    public void insert(Node root, int val){
        if(root.left == null && val < root.val){
            root.left = new Node(val);
            return;
        }
        
        if(root.right == null && val > root.val){
            root.right = new Node(val);
            return; 
        }

        if(val < root.val)
            insert(root.left, val);
        
        if(val > root.val)
            insert(root.right, val);
    }

    public void printTree(){
        printTree(root);
    }

    public void printTree(Node root){
        if(root == null)
            return;
    
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}