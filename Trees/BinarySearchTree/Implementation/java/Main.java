package Trees.BinarySearchTree.Implementation.java;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(8);
        bst.insert(2);

        System.out.println("Pre-Order Traversal");
        bst.preOrder();

        System.out.println();
        System.out.println();
        
        System.out.println("In-Order Traversal");
        bst.inOrder();
        
        System.out.println();
        System.out.println();
        
        System.out.println("Post-Order Traversal");
        bst.postOrder();
        
        System.out.println();
        System.out.println();
        
        System.out.println("Asecending Order");
        bst.ascnOrder();
        
        System.out.println();
        System.out.println();

        System.out.println("Decending Order");
        bst.descOrder();


    }

}
