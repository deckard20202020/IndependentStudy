package Trees;

public class Tree_Easy_235_LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //this is a binary search tree
        //all values to left are <
        //all values to right are >

        if ((p.val < root.val) && (q.val < root.val)) {
            //go left
            return lowestCommonAncestor(root.left, p, q);
        }

        if ((p.val > root.val) && (q.val > root.val)) {
            //go right
            return lowestCommonAncestor(root.right, p, q);
        }

        //otherwise return the root
        return root;
    }

      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
