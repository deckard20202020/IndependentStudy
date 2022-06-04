package Trees;

public class Trees_Easy_543_DiameterOfBinaryTree {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//
//        [1,2,3,4,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int answer = diameterOfBinaryTree(root);
        System.out.println(answer);

    }

    private static int diameterOfBinaryTree(TreeNode root) {

            //idea
            //find the max height of the left side of the tree
            //find the max height of the right side of the tree
            //add them together

            //base case
            if (root.left == null && root.right == null) {
                return 0;
            }

            int leftHeight = 0;
            int rightHeight = 0;

            if(root.left != null) {
                leftHeight = findHeight(root.left);
            }

            if(root.right != null) {
                rightHeight = findHeight(root.right);
            }

            return leftHeight + rightHeight;
    }

    private static int findHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = findHeight(node.left);
        int right = findHeight(node.right);

        return Math.max(left, right) + 1;
    }

    private static class TreeNode {
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
