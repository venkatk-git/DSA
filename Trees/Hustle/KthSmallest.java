package Trees.Hustle;

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

public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) {
            return -1;
        }

        if(k == 0) {
            return root.val;
        }

        int leftSubTree = kthSmallest(root.left, k);
        
        if(leftSubTree != -1) {
            return leftSubTree;
        }

        k -= 1;

        int rightSubTree = kthSmallest(root.right, k);
        
        if(rightSubTree != -1) {
            return rightSubTree;
        }
        
        return -1;
    }
}