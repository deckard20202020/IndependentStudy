package Graph;

import java.util.*;

public class Graph_Easy_FindIfPathexistsInGraph {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1},{1,2},{2,0}};
        int source = 0;
        int destination = 2;

        boolean answer = validPath(n, edges, source, destination);
        System.out.println(answer);
    }

    private static boolean validPath(int n, int[][] edges, int source, int destination) {


        //just do a dfs

        //make the graph
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        //put all the nodes in the graph with an empty list of edges
        for (int i = 0; i < n; i++) {
            List<Integer> e = new ArrayList<>();
            graph.put(i, e);
        }
        //add the edges to our graph
        int numEdges = edges.length;
        for (int i = 0; i < numEdges; i++) {
            int[] edge = edges[i];
            //put first direction in graph
            int from = edge[0];
            int to = edge[1];
            List<Integer> toEdges = graph.get(from);
            toEdges.add(to);
            graph.put(from, toEdges);
            //put second direction in graph
            from = edge[1];
            to = edge[0];
            toEdges = graph.get(from);
            toEdges.add(to);
            graph.put(from, toEdges);
        }

        //now we can do our dfs
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        stack.push(source);
        visited.add(source);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            visited.add(current);

            //check to see if we have reached our destination
            if (current == destination) {
                return true;
            }

            List<Integer> neighbors = graph.get(current);
            for (Integer neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                }
            }
        }

        return false;
    }
}
