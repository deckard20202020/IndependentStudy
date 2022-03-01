package BFS;

public class BFS_Easy_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) {
            return false;
        }

        return (isBalanced(root.left) && isBalanced(root.right));
    }

    int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }


        int height = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

        return height;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
