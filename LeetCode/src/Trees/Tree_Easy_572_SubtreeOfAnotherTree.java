package Trees;

public class Tree_Easy_572_SubtreeOfAnotherTree {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(5);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(2);
//        TreeNode subRoot = new TreeNode(4);
//        subRoot.left = new TreeNode(1);
//        subRoot.right = new TreeNode(2);

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode();
        root.right.right = new TreeNode();
        root.left.left.left = new TreeNode();
        root.left.left.right = new TreeNode();
        root.left.right.left = new TreeNode(0);
        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        boolean answer = isSubTree(root, subRoot);
        System.out.println(answer);

    }

    private static boolean isSubTree(TreeNode root, TreeNode subRoot) {

        if (sameTree(root, subRoot)) {
            return true;
        }

        //Why do we need a null check here?
        return root != null && (isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot));
    }

    private static boolean sameTree(TreeNode root, TreeNode subRoot) {

        //if one has a value and the other doesn't
        if((root == null && subRoot != null) || (root != null && subRoot == null)) {
            return false;
        }
        //if both null return true
        if (root == null && subRoot == null) {
            return true;
        }

        //if the values are different return false
        if(root.val != subRoot.val) {
            return false;
        }
        //why do we need this check???
        if(((root.left == null && subRoot.left != null) || (root.left != null && subRoot.left == null)) ||
                ((root.right == null && subRoot.right != null) || (root.right != null && subRoot.right == null))) {
            return false;
        }

        return sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right);
    }

    public static class TreeNode {
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
}
