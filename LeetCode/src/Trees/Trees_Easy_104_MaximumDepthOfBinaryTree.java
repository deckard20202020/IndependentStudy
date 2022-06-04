package Trees;

public class Trees_Easy_104_MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
//        3,9,20,null,null,15,7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15   );
        root.right.right = new TreeNode(7);

        int answer = maxDepth(root);
        System.out.println(answer);

    }
    public static int maxDepth(TreeNode root) {

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
