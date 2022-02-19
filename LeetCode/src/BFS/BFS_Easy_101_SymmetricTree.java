package BFS;

public class BFS_Easy_101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {

        //base case
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);

    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {

        //if one of them is null
        if (left == null || right == null) {
            return left == right;
        }

        //now we know at least one of them has a value
        //if they are not equal
        if (left.val != right.val) {
            return false;
        }

        //otherwise they are equal
        //we will need to check both their subtrees
        return isSymmetric(left.left, right.right)  && isSymmetric(left.right, right.left);

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
