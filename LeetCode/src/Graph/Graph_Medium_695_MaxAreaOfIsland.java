package Graph;

public class Graph_Medium_695_MaxAreaOfIsland {
    public static void main(String[] agrs) {
//        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
//                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
//                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
//                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
//                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
//                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                        {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int[][] grid = {{1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}};

        
        int answer = maxAreaOfIsland(grid);
        System.out.println(answer);
    }

    private static int maxAreaOfIsland(int[][] grid) {

        //idea
        //scroll throught the grid looking for 1's
        //if we find one
        //change it to a 0
        //do a bfs on all it's neighbors
        //time complexity will be O(width*height)- we will visit each node once
        //constant space complexity-we don't make any new structures

        int maxArea = 0;
        int width = grid[0].length;
        int height = grid.length;

        for (int row = 0; row < grid.length; row ++) {
            for (int col = 0; col < grid[0].length; col ++) {
                if (grid[row][col] == 1) {
                    int tempArea = checkNeighbors(row, col, width, height, grid);
                    maxArea = Math.max(maxArea, tempArea);
                }
            }
        }

        return maxArea;
    }

    private static int checkNeighbors(int row, int col, int width, int height, int[][] grid) {


        int tempArea = 1;
        grid[row][col] = 0;

        if (col+ 1 < width && grid[row][col + 1] == 1) {
            //grid[row][col + 1] = 0;
            tempArea += checkNeighbors(row, col + 1, width, height, grid);
        }
        if (col - 1 >=0  && grid[row][col - 1] == 1) {
            //grid[row][col + 1] = 0;
            tempArea += checkNeighbors(row, col - 1, width, height, grid);
        }
        if (row + 1 < height && grid[row + 1][col] == 1) {
            //grid[row + 1][col] = 0;
            tempArea += checkNeighbors(row + 1, col, width, height, grid);
        }
        if (row - 1 >= 0 && grid[row - 1][col] == 1) {
            //grid[row - 1][col] = 0;
            tempArea += checkNeighbors(row - 1, col, width, height, grid);
        }

        return tempArea;
    }
}
