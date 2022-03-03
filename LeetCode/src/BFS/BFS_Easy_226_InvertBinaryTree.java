package BFS;

public class BFS_Easy_226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {

        //if root is null return empty
        if (root == null) {
            return null;
        }

        TreeNode t = reverseTree(root);

        return t;

    }

    public TreeNode reverseTree(TreeNode t) {

        if (t == null || (t.left == null && t.right == null)) {
            return t;
        }

        //we know we have children
        //switch them
        TreeNode temp = t.left;
        t.left = t.right;
        t.right = temp;

        //go down the tree
        reverseTree(t.left);
        reverseTree(t.right);

        return t;

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
