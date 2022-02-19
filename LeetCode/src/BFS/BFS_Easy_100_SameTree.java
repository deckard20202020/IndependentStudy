package BFS;

public class BFS_Easy_100_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        //if both are null
        if (p == null && q == null) {
            return true;
        }
        //if one is null
        if (p == null || q == null) {
            return false;
        }
        //if they don't have the same value
        if (p.val != q.val) {
            return false;
        }
        //otherwise check the right and left nodes
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);

    }

    public class TreeNode {

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
