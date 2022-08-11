package LeetCodeDaily;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Medium_98_ValidateBinarySearchTree {

    private static boolean flag=true;
    static TreeNode prev = null;
    
    public static void main(String[] args) {

//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(2);
//        TreeNode root = new TreeNode(0);
//        root.left = new TreeNode(-1);
//        [32,26,47,19,null,null,56,null,27]
        TreeNode root = new TreeNode(32);
        root.left = new TreeNode(26);
        root.right = new TreeNode(47);
        root.left.left = new TreeNode(19);
        root.left.right = null;
        root.right.left = new TreeNode(56);
        root.right.right = null;
        root.left.left.left = new TreeNode(27);
        boolean answer = isValidBST(root);
        System.out.println(answer);

    }

    private static boolean isValidBST(TreeNode root) {

        inorder(root);
        return flag;
    }

    private static void inorder(TreeNode root) {

        if(root==null) return;

        inorder(root.left);

        if(prev!=null && root.val<=prev.val){
            flag=false;
            return;
        }
        prev=root;

        inorder(root.right);
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
