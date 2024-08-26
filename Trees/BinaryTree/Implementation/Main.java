package Trees.BinaryTree.Implementation;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insertRoot(12); 
        tree.insert(10);
        tree.insert(5);
        tree.insert(20);
        tree.printTree();
    }   
}
