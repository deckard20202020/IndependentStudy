package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph_Medium_797_AllPathsFromSourceToTarget {

    public static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {

        int[][] graph = {{1,2},{3},{3},{}};
        result = allPathsSourceTarget(graph);
        for (int i = 0; i < result.size(); i++) {
            List<Integer> path = result.get(i);
            for (int j = 0; j < path.size(); j++) {
                System.out.print(path.get(j) + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//
//        //make our graph
//        HashMap<Integer, List<Integer>> g = makeGraph(graph);
//
//        int target = graph.length - 1;
//        int source = 0;
//        List<Integer> path = new ArrayList<>();
//        //path.add(source);
//
//        //dfs
//        //acyclic so we don't have to worry about visited
//        result = dfs(g, source, target, path);
//
//        return result;

        List<Integer> tmp = new ArrayList<>();
        dfs(graph, 0, tmp);
        return result;
    }

    public static void dfs(int[][] graph, int a, List<Integer> tmp) {
        tmp.add(a);
        if(a == graph.length-1) {
            result.add(new ArrayList<Integer>(tmp)); //Imp : create a new object everytime you push in ans list. If not done, the same instance(tmp) gets updated later and changes the ans's content.
        }
        for(int c : graph[a]) {
            dfs(graph, c, tmp);
            tmp.remove(tmp.size()-1);
        }
        return;
    }

//    public static List<List<Integer>> dfs(HashMap<Integer, List<Integer>> graph, int source, int target, List<Integer> path) {
//
//        path.add(source);
//        if (source == target) {
//            result.add(new ArrayList<Integer>(path));
//            return result;
//        }
//
//        List<Integer> neighbors = graph.get(source);
//        for (Integer neighbor : neighbors) {
//            dfs(graph, neighbor, target, path);
//        }
//
//        return result;
//    }

//    private static HashMap<Integer, List<Integer>> makeGraph(int[][] graph) {
//
//        HashMap<Integer, List<Integer>> g = new HashMap<>();
//        //add the nodes with empty lists
//        for (int i = 0; i < graph.length; i++) {
//            List<Integer> list = new ArrayList<>();
//            g.put(i, list);
//        }
//        //put all the edges in
//        for (int i = 0; i < graph.length; i++) {
//            int[] edges = graph[i];
//            int from = i;
//            for (int j = 0; j < edges.length; j++) {
//                int to = edges[j];
//                List<Integer> e = g.get(from);
//                e.add(to);
//                g.put(from, e);
//            }
//
//        }
//
//        return g;
//    }


}
