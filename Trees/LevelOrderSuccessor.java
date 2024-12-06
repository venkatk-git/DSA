package Trees;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public static int levelOrderSuccssor(TreeNode root, int val) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                int currVal = curr.val;

                if(curr.left != null) {
                    q.offer(curr.left);
                }

                if(curr.right != null) {
                    q.offer(curr.right);
                }

                if(currVal == val) {
                    if(q.isEmpty()) return -1;

                    return q.poll().val;
                }
            }

        }

        return -1;
    }
}

public class LevelOrderSuccessor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(12);
        root.left.right = new TreeNode(14);
        root.right.left = new TreeNode(36);
        root.right.right = new TreeNode(9);

        System.out.println(new Solution().levelOrderSuccssor(root, 3));
    }  
}
