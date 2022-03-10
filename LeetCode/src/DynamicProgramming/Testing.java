package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Testing {
    public static void main (String[] args) {
        int m = 3;
        int n = 7;
        
        int answer = uniquePaths(m,n);
        
        System.out.println(answer);
    }

    private static int uniquePaths(int m, int n) {
        //m = rows, n= columns

        //make a grid to store the values
        int[][] grid = new int[m][n];

        //initialize the base cases
        grid[0][0] = 1;
        // grid[0][1] = 1;
        // grid[1][0] =1;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++ ) {
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
