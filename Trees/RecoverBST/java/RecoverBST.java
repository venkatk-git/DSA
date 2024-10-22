package Trees.RecoverBST.java;

class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
}

class Solution {
    TreeNode nodeA;
    TreeNode nodeB;
    TreeNode prevNode;
    public void recoverTree(TreeNode root) {
        inorder(root);

        swap(nodeA, nodeB);
    }

    public void inorder(TreeNode root) {
        if(root == null) {
            return;
        }

        inorder(root.left);

        if(prevNode != null && prevNode.val >= root.val) {
            if(nodeA == null) {
                nodeA = prevNode;
            } 
            
            nodeB = root;
        }

        prevNode = root;

        inorder(root.right);
    }

    public void swap(TreeNode A, TreeNode B) {
        int valA = A.val;
        int valB = B.val;

        A.val = valB;
        B.val = valA;
    }
}


public class RecoverBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left =  new TreeNode(10);
        root.right =  new TreeNode(20);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(8);

        new Solution().recoverTree(root);
    }
}