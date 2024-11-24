package Trees.IterativeDFS.java;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayDeque;
import java.util.Deque;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class IterativeDFS {
    public void inorder(TreeNode root) {
        Deque<TreeNode> s = new ArrayDeque<>();
        
        TreeNode curr = root;
        while(curr != null || !s.isEmpty()) {
            if(curr != null) {
                s.push(curr);
                curr = curr.left;
            } else {
                curr = s.pop();
                System.out.println(curr.val);
                curr = curr.right;
            }
        }
    }

    public void preorder(TreeNode root) {
        Deque<TreeNode> s = new ArrayDeque<>();
        
        TreeNode curr = root;
        while(curr != null || !s.isEmpty()) {
            if(curr != null) {
                System.out.println(curr.val);

                if(curr.right != null) {
                    s.push(curr.right);
                }

                curr = curr.left;
            } else {
                curr = s.pop();
            }
        }
    }

    public void postorder(TreeNode root) {
        Deque<SimpleEntry<TreeNode, Boolean>> s = new ArrayDeque<>();

        s.push(new SimpleEntry<>(root, false));
        while(!s.isEmpty()) {
            SimpleEntry<TreeNode, Boolean> currEntry = s.pop();
            TreeNode curr = currEntry.getKey();
            boolean isVisted = currEntry.getValue();
            
            if(curr != null) {
                if(isVisted) {
                    System.out.println(curr.val);
                } else {
                    s.push(new SimpleEntry<>(curr, true));
                    s.push(new SimpleEntry<>(curr.right, false));
                    s.push(new SimpleEntry<>(curr.left, false));
                }
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        IterativeDFS traverse = new IterativeDFS();
        traverse.postorder(root);
    }
}
