package Trees.Blaze;

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

public class MaxPathSum {
    static int maxPathSum = Integer.MIN_VALUE;
        
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);    
        root.left = new TreeNode(9);    
        root.right = new TreeNode(20);    
        root.right.left = new TreeNode(15);       
        root.right.right = new TreeNode(7);
        
        System.out.println(maxPathSum(root));
    }
    
    public static int maxPathSum(TreeNode root) {
        _maxPathSum(root);
        return maxPathSum;
    }

    public static int _maxPathSum(TreeNode root) {
        if(root == null) return 0;
        
        int computedSum = root.val;
        maxPathSum = Math.max(maxPathSum, root.val);

        int leftSubTreeSum = _maxPathSum(root.left);
        computedSum = Math.max(computedSum, root.val + leftSubTreeSum);

        int rightSubTreeSum = _maxPathSum(root.right);
        computedSum = Math.max(computedSum, root.val + rightSubTreeSum);
        
        computedSum = Math.max(computedSum, root.val + leftSubTreeSum + rightSubTreeSum);
        
        maxPathSum = Math.max(maxPathSum, computedSum);

        return Math.max(root.val, root.val + Math.max(leftSubTreeSum, rightSubTreeSum));
    }
}