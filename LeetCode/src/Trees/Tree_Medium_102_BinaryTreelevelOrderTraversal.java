package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Tree_Medium_102_BinaryTreelevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        
        List<List<Integer>> answer = levelOrder(root);
        for (int i = 0; i < answer.size(); i++) {
            for (int j = 0; j < answer.get(i).size(); j++) {
                System.out.print(answer.get(i).get(j) + ", ");
            }
            System.out.println();
        }
        
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {


        //we will traverse the tree adding the nodes level by level
        List<List<Integer>> answer = new ArrayList<>();

        //base case
        if (root == null) {
            return answer;
        }
        //we know the tree isn't empty
        Queue<TreeNode> q = new ArrayDeque<>();
        //add the root to the q
        q.add(root);

        while (!q.isEmpty()) {
            //create a list for the level
            List<Integer> level = new ArrayList<>();
            //need to set the size here because we will
            //be altering the size in the loop below
            int count = q.size();
            //empty the queue adding our values to our list
            for (int i = 0; i < count; i++) {
                //pop the node from the queue
                TreeNode curr = q.poll();
                //add the value to our list
                level.add(curr.val);
                //add the children to the queue
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            answer.add(level);
        }
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
