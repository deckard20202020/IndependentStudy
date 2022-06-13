package Graph;

import java.util.*;

public class Graph_Medium_417_PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        int[][] heights = {{1,2,2,3,5},
                        {3,2,3,4,4},
                        {2,4,5,3,1},
                        {6,7,1,4,5},
                        {5,1,1,2,4}};

        List<List<Integer>> answer = pacificAtalantic(heights);
        for (int i = 0; i < answer.size(); i++) {
            for (int j = 0; j < answer.get(i).size(); j++) {
                System.out.print(answer.get(i).get(j) + ", ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> pacificAtalantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;
        int lastRow = rows - 1;
        int lastCol = cols - 1;

        Set<Integer> atlantic = new HashSet<>();
        Set<Integer> pacific = new HashSet<>();

        //put the edges in the sets
        for (int r = 0; r < rows; r++) {
            //west side
            mark(0, pacific, heights, r, 0, rows, cols);
            //east side
            mark(0, atlantic, heights, r, lastCol, rows, cols);
        }
        for (int c = 0; c < cols; c++) {
            //north side
            mark(0, pacific, heights, 0, c, rows, cols);
            //south side
            mark(0, atlantic, heights, lastRow, c, rows, cols);
        }

        //compare the two sets atlantic and pacific
        List<List<Integer>> answer = new ArrayList<>();
        for(Integer markerKey : pacific) {
            if (atlantic.contains(markerKey)) {
                //convert back to Integer to x,y point
                answer.add(Arrays.asList(markerKey / cols, markerKey % cols));
            }
        }

        return answer;
    }

    private static void mark(int parentH, Set<Integer> markers, int[][] heights, int r, int c, int rows, int cols) {

        int h = heights[r][c];

        //if next cell is >=
        if (h >= parentH) {
            //convert row and col of point to Integer to use as key in set
            int markerKey = r * cols + c;
            //if not visited yet
            if (markers.add(markerKey)) {
                //go north
                if (r > 0) {
                    mark(h, markers, heights, r - 1, c, rows, cols);
                }
                //go south
                if (r < rows - 1) {
                    mark(h, markers, heights, r + 1, c, rows, cols);
                }
                //go west
                if (c > 0) {
                    mark(h, markers, heights, r, c - 1, rows, cols);
                }
                //go east
                if (c < cols - 1) {
                    mark(h, markers, heights, r, c + 1, rows, cols);
                }
            }
        }
    }


}
