package DynamicProgramming;

public class DP_Medium_931_MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][] matrix = {{-84,-36,2},{87,-79,10},{42,10,63}};
        int answer = minFallingPathSum(matrix);
        System.out.println(answer);
    }

    private static int minFallingPathSum(int[][] matrix) {

        //idea
        //make a new matrix of sums
        //scroll through the matrix and update all the values in the array
        //return the smallest element in the last row

        int rows = matrix.length;
        int cols = matrix[0].length;

        //initialize the first row of our sums
        int[][] sums = new int[rows][cols];
        for (int i = 0; i < cols; i++) {
            sums[0][i] = matrix[0][i];

        }

        //calculate the rest of our sums
        for (int r = 1; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int sumAbove = matrix[r][c] + sums[r - 1][c];

                int sumLeft = Integer.MAX_VALUE;
                if (c - 1 >= 0) {
                    sumLeft = matrix[r][c] + sums[r - 1][c - 1];
                }

                int sumRight = Integer.MAX_VALUE;
                if (c + 1 < cols) {
                    sumRight = matrix[r][c] + sums[r - 1][c + 1];
                }

                sums[r][c] = Math.min(sumAbove, Math.min(sumLeft, sumRight));
            }
        }

        //find the min total
        int min = Integer.MAX_VALUE;
        for (int c = 0; c < cols; c++) {
            min = Math.min(min, sums[rows - 1][c]);
        }

        return min;
    }

}
