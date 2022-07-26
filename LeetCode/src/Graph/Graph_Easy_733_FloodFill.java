package Graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Graph_Easy_733_FloodFill {
    public static void main(String[] args) {
//        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
//        int sr = 1;
//        int sc = 1;
//        int color = 2;

        int[][] image = {{0,0,0},{0,0,0}};
        int sr = 0;
        int sc = 0;
        int color = 0;

        int[][] answer = floodFill(image, sr, sc, color);
        System.out.println("test");
    }

    private static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        //could do DFS or BFS

        int rows = image.length;
        int cols = image[0].length;
        int initialColor = image[sr][sc];

        //change the first pixel
        image[sr][sc] = color;

        Pair p = new Pair(sr, sc);

        Stack<Pair> stack = new Stack<>();
        stack.push(p);

        boolean[][] visited = new boolean[rows][cols];
        visited[p.x][p.y] = true;

        while (!stack.isEmpty()) {
            p = stack.pop();

            //check the neighbors
            //they need to be in bounds and have the initial color
            //up
            if (p.x - 1 >=0 && visited[p.x - 1][p.y] == false && image[p.x - 1][p.y] == initialColor) {
                //change the color
                image[p.x - 1][p.y] = color;
                //add to the stack
                Pair up = new Pair(p.x - 1, p.y);
                stack.push(up);
                visited[p.x - 1][p.y] = true;
            }
            //down
            if (p.x + 1 < rows && visited[p.x + 1][p.y] == false && image[p.x + 1][p.y] == initialColor) {
                //change the color
                image[p.x + 1][p.y] = color;
                //add to the stack
                Pair down = new Pair(p.x + 1, p.y);
                stack.push(down);
                visited[p.x + 1][p.y] = true;
            }
            //left
            if (p.y - 1 >=0 && visited[p.x][p.y - 1] == false && image[p.x][p.y - 1] == initialColor) {
                //change the color
                image[p.x][p.y - 1] = color;
                //add to the stack
                Pair left = new Pair(p.x, p.y - 1);
                stack.push(left);
                visited[p.x][p.y - 1] = true;
            }
            //right
            if (p.y + 1 < cols && visited[p.x][p.y + 1] == false && image[p.x][p.y + 1] == initialColor) {
                //change the color
                image[p.x][p.y + 1] = color;
                //add to the stack
                Pair right = new Pair(p.x, p.y + 1);
                stack.push(right);
                visited[p.x][p.y + 1] = true;
            }
        }

        return image;
    }

    public static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX(Pair p) {
            return p.x;
        }

        public int getY(Pair p) {
            return p.y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

}
