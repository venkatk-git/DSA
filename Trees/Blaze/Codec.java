package Trees.Blaze;

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

public class Codec {
    int i;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder encodedTree = new StringBuilder();

        serializeHelper(root, encodedTree);

        System.out.println(encodedTree);

        return encodedTree.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] decodedTree = data.split(",");

        this.i = 0;
        TreeNode root = deserializeHelper(decodedTree);

        return root;
    }

    private void serializeHelper(TreeNode root, StringBuilder encodedTree) {
        if(root == null) {
            encodedTree.append("null,");
            return;
        }

        encodedTree.append(root.val + ",");
        serializeHelper(root.left, encodedTree);
        serializeHelper(root.right, encodedTree);
    }

    private TreeNode deserializeHelper(String[] t) {
        if(i == t.length || t[i].equals("null")) {
            i++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(t[i++]));

        root.left = deserializeHelper(t);
        root.right = deserializeHelper(t);

        return root;
    }
}