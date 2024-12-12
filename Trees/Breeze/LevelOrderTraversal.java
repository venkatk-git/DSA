package Trees.Breeze;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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

public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);

        System.out.println(bfs(root));
    }   

    public static List<Integer> bfs(TreeNode root) {
        List<Integer> bfs = new ArrayList<>();

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()) {
            System.out.println(q);
            int size = q.size();
            
            for(int i = 0; i < size; i++) {
                TreeNode currNode = q.poll();    
                bfs.add(currNode.val);
                
                
                if(currNode.left != null) {
                    q.offer(currNode.left);
                }

                if(currNode.right != null) {
                    q.offer(currNode.right);
                }
            }
        }

        return bfs;
    }
}
