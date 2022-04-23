package Graph;

public class Graph_Medium_200_NumberOfIslands {
    public int numIslands(char[][] grid) {

        //idea how many bfs do i have to do to mark all pieces of land?

        int count = 0;

        //scroll through the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                //if we see a 1
                if(grid[i][j] == '1') {
                    //increment the count
                    count++;
                    //do a bfs
                    bfs(grid, i, j);
                }
            }
        }

        return count;

    }

    public void bfs(char[][]grid, int i, int j) {
        //check out boundaries or if the grid value has been changed to a 0
        if (i < 0 || i >= grid.length ||
                j < 0 || j >= grid[i].length ||
                grid[i][j] == '0') {
            return;
        }

        //otherwise change the value of the grid to a 0
        grid[i][j] = '0';
        //and then call bfs on the neighbors
        bfs(grid, i, j+1);  //right
        bfs(grid, i, j-1); //left
        bfs(grid, i+1, j); //up
        bfs(grid, i-1, j);  //down
    }
}
