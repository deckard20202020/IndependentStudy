package LeetCodeDaily;

public class Easy_108_ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};

        TreeNode answer = sortedArrayToBST(nums);
        System.out.println(answer);
    }

    private static TreeNode sortedArrayToBST(int[] nums) {

        int length = nums.length - 1;
        return helper(nums, 0, length);
    }

    private static TreeNode helper(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);

        return root;
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
