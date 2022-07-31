package Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Graph_NumberOfConnectedComponents {
    public static void main(String[] args) throws FileNotFoundException {

//        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\LeetCode\\src\\Graph\\Graph_NumberOfConnectedComponents.txt");
//        Scanner scanner = new Scanner(file);

        Scanner scanner = new Scanner(System.in);

        String info = scanner.nextLine();
        String[] infoArray = info.split(" ");
        int[] array = new int[infoArray.length];
        for (int i = 0; i < infoArray.length; i++) {
            array[i] = Integer.valueOf(infoArray[i]);
        }

        int numVert = array[0];
        int numEdges = array[1];

        //make our graph
        HashMap<Integer, List<Integer>> graph = initializeGraph(numVert);
        for (int i = 0; i < numEdges; i++) {
            String s = scanner.nextLine();
            String[] stringArray = s.split(" ");
            int[] edge = new int[stringArray.length];
            for (int j = 0; j < edge.length; j++) {
                edge[j] = Integer.valueOf(stringArray[j]);
            }

            int from = edge[0];
            int to = edge[1];
            List<Integer> list = graph.get(from);
            list.add(to);
            graph.put(from, list);
            from = edge[1];
            to = edge[0];
            list = graph.get(from);
            list.add(to);
            graph.put(from, list);
        }

        int count = findNumberOfConnectedComponents(graph);
        System.out.println(count);
    }

    private static int findNumberOfConnectedComponents(HashMap<Integer, List<Integer>> graph) {

        int count = dfs(graph);

        return count;
    }

    private static int dfs(HashMap<Integer, List<Integer>> graph) {

        int count = 0;

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for (Integer node : graph.keySet()) {
            if (!visited.contains(node)) {
                stack.add(node);
                count++;

                while(!stack.isEmpty()) {
                    int n = stack.pop();
                    visited.add(n);
                    List<Integer> neighbors = graph.get(n);
                    for (Integer neighbor : neighbors) {
                        if (!visited.contains(neighbor)) {
                            stack.add(neighbor);
                        }
                    }
                }

            }

        }

        return count;

    }

    private static HashMap<Integer, List<Integer>> initializeGraph(int numVert) {

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numVert; i++) {
            List<Integer> edges = new ArrayList<>();
            graph.put(i + 1, edges);
        }

        return graph;
    }
}
