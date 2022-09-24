package IMC;

import java.util.*;

public class Question1 {
    public static void main(String[] args) {
        int c = 1;
        int x1 = 1;
        int y1 = 4;
        int x2 = 7;
        int y2 = 6;

        String answer = canReach(c, x1, y1, x2, y2);
        System.out.println(answer);
    }

    private static String canReach(int c, int x1, int y1, int x2, int y2) {

        //movement is always up, right, or both up and right

        //dest is to the left or below start
        if (x1 > x2 || y1 > y2) {
            return "No";
        }

//        int[][] cache = new int[1001][1001];
//        for (int[] array : cache) {
//            Arrays.fill(array, -1);
//        }

//        boolean canReach = findPath(c, x1, x2, y1, y2, cache);
        boolean canReach = findPath(c, x1, x2, y1, y2);
        if (canReach) {
            return "Yes";
        }

        return "No";
    }

    private static boolean findPath(int c, int x1, int x2, int y1, int y2) {
//    private static boolean findPath(int c, int x1, int x2, int y1, int y2, int[][] cache) {

        if (x1 > x2 || y1 > y2) {
            return false;
        }
        if (x1 == x2 && y1 == y2) {
            return true;
        }

//        if (dfs(c, x1, x2, y1, y2, cache) != -1) {
//            return true;
//        }
//
//        return false;

        Set<Pair> visited = new HashSet<>();
        Stack<Pair> stack = new Stack<>();
        Pair pair = new Pair(x1, y1);
        stack.push(pair);

        while (!stack.isEmpty()) {
            Pair p = stack.pop();

            if (p.x == x2 && p.y == y2) {
                return true;
            }

            if (p.x > x2 || p.y > y2) {
                visited.add(p);
                continue;
            }

            if (!visited.contains(p)) {
                //find the neighbors
                addNeighbors(stack, p, c, x2, y2);
            }

            visited.add(p);
        }

        return false;
    }

    private static void addNeighbors(Stack<Pair> stack, Pair p, int c, int x2, int y2) {

        boolean perfectSquare = false;
        double number = 0;
        //right
        Pair p1 = new Pair(p.x + p.y, p.y);
        number = p1.x + p1.y;
        perfectSquare = isPerfect(number);
        if (!perfectSquare) {
            if (p1.x <= x2 && p1.y <= y2) {
                stack.add(p1);
            }
        }

        //up
        Pair p2 = new Pair(p.x, p.x + p.y);
        number = p2.x + p2.y;
        perfectSquare = isPerfect(number);
        if (!perfectSquare) {
            if (p2.x <= x2 && p2.y <= y2) {
                stack.add(p2);
            }
        }

        //constant
        Pair p3 = new Pair(p.x + c, p.y + c);
        number = p3.x + p3.y;
        perfectSquare = isPerfect(number);
        if (!perfectSquare) {
            if (p3.x <= x2 && p3.y <= y2) {
                stack.add(p3);
            }
        }
    }

    private static boolean isPerfect(double number) {

        double sqareRoot = Math.sqrt(number);

        return((sqareRoot - Math.floor(sqareRoot)) == 0);
    }

    private static class Pair {

        int x;
        int y;
        int hashCode;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
            this.hashCode = Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) {
                return true;
            }

            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Pair p = (Pair) o;
            if (this.x == p.x && this.y == p.y) {
                return true;
            }

            return false;
        }

        @Override
        public int hashCode() {
            return this.hashCode;
        }
    }

//    private static int dfs(int c, int x1, int x2, int y1, int y2, int[][] cache) {
//
//        if (cache[x1][y1] != -1) {
//            return cache[x1][y1];
//        }
//
//        if (Math.sqrt(x1 + y1) % 1 == 0) {
//            return 0;
//        }
//        if (x1 > x2 || y1 > y2) {
//            return 0;
//        }
//
//        int constant = dfs(c, x1 + c, y1 + c, x2, y2, cache);
//        int right = dfs(c, x1 + y1, y1, x2, y2, cache);
//        int up = dfs(c, x1, y1 + x1, x2, y2, cache);
//
//        if (constant == 1 || right == 1 || up == 1) {
//            cache[x1][y1] = 1;
//        } else {
//            cache[x1][y1] = 0;
//        }
//
//        return cache[x1][y1];
//    }
}
