package BFS;

public class BFS_Easy_104_MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {

        //runtime of this should be O(n) because we traversed the entire tree

        //base case
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        //now everything has bubbled back up
        //Don't forget to add 1
        int answer = Math.max(left, right) + 1;

        return answer;
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
