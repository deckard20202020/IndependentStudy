package DynamicProgramming;

public class DP_medium_64_MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int answer = minPathSum(grid);
        System.out.println(answer);
    }

    private static int minPathSum(int[][] grid) {


        int rows = grid.length;
        int cols = grid[0].length;

        //initialize our sums
        //we can only go down and to the right
        int[][] sums = new int[rows][cols];
        sums[0][0] = grid[0][0];
        //to the right initialization of first row
        for (int c = 1; c < cols; c++) {
            int gridValue = grid[0][c];
            int leftValue = sums[0][c - 1];
            sums[0][c] = gridValue + leftValue;
        }
        //down initialization for the first col
        for (int r = 1; r < rows; r++) {
            int gridValue = grid[r][0];
            int aboveValue = sums[r - 1][0];
            sums[r][0] = gridValue + aboveValue;
        }

        //fill in the rest of the array using the min value
        //of the square above or the square to the left
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                int above = grid[r][c] + sums[r - 1][c];
                int left = grid[r][c] + sums[r][c - 1];
                sums[r][c] =  Math.min(above, left);
            }
        }

        return sums[rows - 1][cols - 1];
    }
}
