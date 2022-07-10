package DynamicProgramming;

public class DP_Medium_96_UniqueBinarySearchTrees {
    public static void main(String[] args) {
        int n = 3;
        int answer = numTrees(n);
        System.out.println(answer);
    }

    private static int numTrees(int n) {

//        Initialize a dp array of size n+1.
//        Put 1 at index 0 and 1. This is the base case.
//        For n=2 we can have 2 unique trees.
//        For n=3 we can have 5 unique trees this can be determined by taking each node as root and trying to form left and right sub tree patterns.
//
//        For n = 3, let's take 1 as a root node now we have 2 nodes to the right of 1 and 0 node to the left of 1.
//        For 0 nodes only one tree is possible that is null and for 2 nodes 2 unique trees are possible. Multiply the left with right possibilities we get 2. Store it in a variable sum.
//        Let's take 2 as a root node now we have 1 node to left of it and 1 to right of it and both corresponds to 1 and 1 BST's respectively. So multiplying 1 and 1 gives us 1. Add this to the sum. Now sum is 2+1 = 3
//        Now for the final node that is 3. We have 2 nodes to the left (2 subtrees) and 0 nodes to the right(1 subtree). Multiply both and add this to the sum . Sum = 3+2 = 5.
//        So for n=3 we get 5 unique BST store this value in dp and move ahead for your desired value of n.
//        Return dp[n] .

        //base case
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            int sum = 0;
            for (int j = 1; j <=i; j++) {
                int left = dp[j-1];
                int right = dp[i-j];
                sum = sum + (left * right);
            }

            dp[i] = sum;
        }

        return dp[dp.length - 1];
    }
}
