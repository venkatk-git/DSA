package Trees.Breeze;

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

public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode a, TreeNode b) {
        if(a == null && b == null) {
            return true;
        }

        if(a == null || b == null || a.val != b.val) {
            return false;
        }

        boolean leftRightSubTree = isSymmetric(a.left, b.right);
        
        boolean rightLeftSubTree = isSymmetric(a.right, b.left);

        return leftRightSubTree && rightLeftSubTree;
    }
}
