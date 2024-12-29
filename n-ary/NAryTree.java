import java.util.*;

class TreeNode{
    public int val;
    public List<TreeNode> children;

    public TreeNode (int val) {
        this.val = val;
        children = new ArrayList<>();
    }

    public void insertChildren(TreeNode child) {
        children.add(child);
    }
}

public class NAryTree {
        
}
