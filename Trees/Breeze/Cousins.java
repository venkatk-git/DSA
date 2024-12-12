package Trees.Breeze;

import java.util.ArrayDeque;
import java.util.Deque;

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


public class Cousins {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);

        System.out.println(isCousins(root, 2, 3));
        System.out.println(isCousins(root, 4, 6));
    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

    
        while(!q.isEmpty()) {
            int size = q.size();
            boolean foundX = false;
            boolean foundY = false;

            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if(curr.left != null) {
                    if(curr.left.val == x) foundX = true;  
                    if(curr.left.val == y) foundY = true;  
                    q.offer(curr.left);
                } 
                
                if(curr.right != null){
                    if(curr.right.val == x) foundX = true;  
                    if(curr.right.val == y) foundY = true;  
                    q.offer(curr.right);
                }

                if(foundX && foundY) {
                    if(isSiblings(curr, x, y)) {
                        return false;
                    }

                    return true;
                }
            }
            
            if(foundX || foundY) return false;
        }

        return false;
    }

    private static boolean isSiblings(TreeNode node, int x, int y) {
        if(node.left == null || node.right == null) return false;
        return (node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x);
    }
}
