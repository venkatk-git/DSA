package Trees.AvgOfLevels;

import java.util.ArrayDeque;
import java.util.ArrayList;
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
}

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avg = new ArrayList<>();

        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int levelSize = q.size();

            long sum = 0;
            for(int i = 0; i < levelSize; i++) {
                TreeNode curr = q.poll();

                if(curr.left != null) {
                    q.offer(curr.left);
                }

                if(curr.right != null) {
                    q.offer(curr.right);
                }

                sum += curr.val;
            }

            avg.add((double)sum / levelSize);
        }

        return avg;
    }
}

public class AvgOfLevels {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
    
        System.out.println(new Solution().averageOfLevels(root));
    }
}