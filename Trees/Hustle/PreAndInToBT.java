package Trees.Hustle;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

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

public class PreAndInToBT {
    static int preorderIndex;
    static Map<Integer, Integer> mapping;

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode root = buildTree(preorder, inorder);

        printTree(root);    
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        mapping = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            mapping.put(inorder[i], i);
        }

        preorderIndex = 0;
        return build(preorder, 0, inorder.length - 1);        
    }

    private static TreeNode build(int[] preorder, int start, int end) {
        if (start > end) return null;

        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);
        int mid = mapping.get(rootVal);

        root.left = build(preorder, start, mid - 1);
        root.right = build(preorder, mid + 1, end);

        return root;
    }

    public static void printTree(TreeNode root) {
        if(root == null) {
            return;
        }

        Deque<TreeNode> q = new  ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                System.out.print(curr.val);
                
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }

            System.out.println();
        }
    }
}
