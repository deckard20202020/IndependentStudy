package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class Graph_Medium_994_RottingOranges {
    public static void main(String[] args) {

        int[][] grid = {{2,1,1},
                        {1,1,0},
                        {0,1,1}};

        int answer = orangesRotting(grid);
        System.out.println(answer);
    }

    private static int orangesRotting(int[][] grid) {


        //idea
        //do a bfs through the graph rotting oranges along the way
        //keep track of how many iterations of bfs you do
        //keep track of how many fresh oranges you start with
        //at the end, if you don't have any fresh oranges left
        //return the number of minutes
        //else return -1

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<Pair> q = new ArrayDeque<>();

        int numFresh = 0;
        int minutes = 0;

        int[][] directions = {{-1,0}, {1,0}, {0, -1}, {0,1}};

        //put all the fresh oranges in the queue
        //and count the number of fresh oranges
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    numFresh++;
                }
                if (grid[r][c] == 2) {
                    q.add(new Pair(r, c));
                }
            }
        }

        //base case
        if (numFresh == 0) {
            return 0;
        }

        //Don't forget the second condition
        while (!q.isEmpty() && numFresh > 0) {

            int size = q.size();
            for (int i = 0; i < size; i++) {

                Pair p = q.poll();
                int x = p.x;
                int y = p.y;

                //check each direction of the current point
                for (int[] direction : directions) {

                    int x_change = x + direction[0];
                    int y_change = y + direction[1];

                    //make sure we are still in bounds and == 1
                    if (x_change < 0 || x_change > rows - 1 ||
                        y_change < 0 || y_change > cols - 1 ||
                        grid[x_change][y_change] == 0 ||
                        grid[x_change][y_change] == 2) {
                        continue;
                    }

                    //we know the orange we are looking at is fresh
                    //mark it rotton
                    grid[x_change][y_change] = 2;
                    //add it to the queue
                    q.add(new Pair(x_change, y_change));
                    //decrement the fresh oranges
                    numFresh--;

                }
            }

            //increment minutes after every pass of bfs
            minutes++;
        }

        if (numFresh == 0) {
            return minutes;
        }

        return -1;
    }

    static class Pair {

        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
