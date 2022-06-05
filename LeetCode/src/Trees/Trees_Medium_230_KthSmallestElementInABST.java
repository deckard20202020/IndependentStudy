package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Trees_Medium_230_KthSmallestElementInABST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        int k = 1;

        int answer = kthSmallest(root, k);
        System.out.println(answer);
    }

    private static int kthSmallest(TreeNode root, int k) {
        //idea
        //This exercise is good practice for tree traversals
            //BFS
                //Level Order Traversal
            //DFS
                //Pre-Order Traversal
                //In-Order Traversal
                //Post-Order Traversal
        //Here we will use In-Order Traversal adding the elements to a list
        //we will return the k-1 element from the list

        //Time Complexity is O(n) since we traverse the entire tree
        //Space Complexity is O(n) since we make a list the same size of the tree

        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return(list.get(k-1));

    }

    private static void inOrder(TreeNode root, List<Integer> list) {

        //in order is left, root, right
        if (root == null) {
            return;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
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
