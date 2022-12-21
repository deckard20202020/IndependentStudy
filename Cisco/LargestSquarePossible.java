package Cisco;

public class LargestSquarePossible {
    public static void main(String[] args) {

//        int[] stack = {5,4,3};
//        int[] stack = {4, 1, 3, 3, 2};
//        int[] stack = {1, 1};
//        int[] stack = {0};
        int[] stack = {1};
        int answer = largestSquarePossible(stack);
        System.out.println(answer);
    }

    private static int largestSquarePossible(int[] stacks) {

        //find the height of the largest stack
        int tallest = findLargestStack(stacks);

        //create a 2d array with 0's representing the blocks
        int[][] arr = new int[stacks.length][tallest];

        //populate the array
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < stacks[i]; j++) {
                arr[i][j] = 1;
            }
        }

        int answer = maximalSquare(arr);

        return answer;
    }

    private static int maximalSquare(int[][] matrix) {

        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;

        //initialize a matrix with an extra row and extra column
        int[][] dp = new int[rows + 1][cols + 1];

        //keep track of  our max along the way
        //so we only have to scroll through the matrix one time
        int maxsqlen = 0;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }

    private static int findLargestStack(int[] stacks) {

        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < stacks.length; i++) {
            answer = Math.max(answer, stacks[i]);
        }

        return answer;
    }
}
