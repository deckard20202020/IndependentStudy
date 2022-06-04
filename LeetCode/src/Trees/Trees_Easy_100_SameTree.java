package Trees;

public class Trees_Easy_100_SameTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        boolean answer = isSameTree(p, q);
        System.out.println(answer);


    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        //if p and q are both null-return true
        if (p == null && q == null) {
            return true;
        }
        //if one is null and the other isn't-return false
        if ((p == null & q != null) || (p != null && q == null)) {
            return false;
        }
        //if their values are different-return false
        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
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
