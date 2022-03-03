package BFS;

public class BFS_Easy_112_PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        //Path must go from root all the way to leaf!!!
        //cannot find target along the way

        //check null case
        if (root == null) {
            return false;
        }

        //check for path
        boolean a = checkForTarget(root, 0, targetSum);

        return a;

    }

    public boolean checkForTarget(TreeNode root, int sum, int t) {
        boolean answer = false;

        //if we are at a leaf node
        if (root.right == null && root.left == null) {

            //return whether or not the target is equal to the current sum + the value of the leaf
            return t == sum + root.val;

        }

        //we know there are children
        sum = sum + root.val;

        //if there is a left child
        if (root.left != null) {
            //check down that path
            answer = checkForTarget(root.left, sum, t);
        }
        //if we have found a match
        if (answer) {
            //return true
            return true;
        }

        //if there is a right child
        if (root.right != null) {
            answer = checkForTarget(root.right, sum, t);
        }
        if(answer) {
            return true;
        }

        return answer;

    }
}
