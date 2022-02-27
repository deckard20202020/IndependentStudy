package BFS;

public class BFS_Easy_111_MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return findMinDepth(root) ;

    }

    public int findMinDepth(TreeNode root) {

        //if there is no value
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        //if there are no children
        //we have hit a leaf
        if (root.right == null && root.left == null) {
            return 1;
        }

        //make sure to understand why the 1 is there
        return Math.min(findMinDepth(root.right), findMinDepth(root.left)) + 1;
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
