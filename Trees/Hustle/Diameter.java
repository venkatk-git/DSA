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

    @Override
    public String toString() {
            return val + "";
    }
}

public class Diameter {
    static int max = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(5);
        root.right.left.left.left = new TreeNode(9);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);
        root.right.right.right.right = new TreeNode(8);
        diameterOfBinaryTree(root);
        System.out.println(max);
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        _diameterOfBinaryTree(root);
        return max;
    }   

    public static int _diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftHeight = _diameterOfBinaryTree(root.left);
        int rightHeight = _diameterOfBinaryTree(root.right);

        max = Math.max(max, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }   
}
