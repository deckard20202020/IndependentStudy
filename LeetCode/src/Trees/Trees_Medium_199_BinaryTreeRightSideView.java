package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Trees_Medium_199_BinaryTreeRightSideView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        
        List<Integer> answer = rightSideView(root);
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i));
        }
    }

    private static List<Integer> rightSideView(TreeNode root) {
        
        //idea
        //level order traversal adding the last element in the level to the list

        List<Integer> answer = new ArrayList<>();

        //base case
        if (root == null) {
            return answer;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 1; i <= size; i++) {
                TreeNode curr = q.poll();
                if(i == size && curr != null) {
                    answer.add(curr.val);
                }

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
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
