package DynamicProgramming;

public class DP_Medium_63_UniquePaths2 {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int answer = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(answer);
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        //for each grid space, the # of ways to get to that space
        //is the sum of the space above it and to the left
        //just need to check to make sure the spaces
        //above and to the left are within the range of the grid
        //the base cases will be the space to the right and down from the origin

        //m = rows, n= columns
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        //make a grid to store the values
        int[][] grid = new int[m][n];

        //initialize the base cases
        grid[0][0] = 1;
        // grid[0][1] = 1;
        // grid[1][0] =1;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++ ) {

                //check to see if obstacle
                if (obstacleGrid[row][col] == 1) {
                    grid[row][col] = 0;
                    continue;
                }
                if (row ==0 && col == 0) {
                    grid[0][0] = 1;
                }
                if (row -1 >=0 && col -1 >= 0) {
                    grid[row][col] = grid[row -1][col] + grid[row][col-1];
                } else if (row -1 >=0) {
                    grid[row][col] = grid[row - 1][col];
                } else if (col -1 >=0) {
                    grid[row][col] = grid[row][col - 1];
                }
            }
        }

        return grid[m-1][n-1];
    }
}
