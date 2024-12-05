package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Zigzag {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left =  new TreeNode(2);
        root.right =  new TreeNode(3);
        root.left.left =  new TreeNode(4);
        root.left.right =  new TreeNode(5);
        root.right.left =  new TreeNode(6);
        root.right.right =  new TreeNode(7);
        root.left.left.left =  new TreeNode(8);
        root.left.left.right =  new TreeNode(9);
        root.right.right.left =  new TreeNode(10);
        root.right.right.right =  new TreeNode(11);
    
        System.out.println(zigzagLevelOrder(root));
    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> list = new ArrayList<>();

        boolean goLeft = true;
        
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);

        while(!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> innerList = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                TreeNode curr;

                if(goLeft) {
                    curr = deque.removeLast();
                    if(curr.left != null) deque.addFirst(curr.left);
                    if(curr.right != null) deque.addFirst(curr.right);
                } else {
                    curr = deque.removeFirst();
                    if(curr.right != null) deque.addLast(curr.right);
                    if(curr.left != null) deque.addLast(curr.left);
                }
                
                innerList.add(curr.val);
            }

            list.add(innerList);
            goLeft = !goLeft;
        }

        return list;
    }
}


