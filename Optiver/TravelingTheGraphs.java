package Optiver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.util.Collections.reverse;

public class TravelingTheGraphs {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\Optiver\\TravelingTheGraphs.txt");
        Scanner scanner = new Scanner(file);

        String answer = "";

        //Initialize the graph
        HashMap<String, List<Edge>> graph = new HashMap<>();

        //read the data
        String firstLine = scanner.nextLine();
        String[] stringEdges = firstLine.split(" ");
        for (int i = 0; i < stringEdges.length; i++) {
            String stringEdge = stringEdges[i];
            String u = stringEdge.substring(1,2);
            String v = stringEdge.substring(3,4);
            String stringWeight = stringEdge.substring(5,6);
            int weight = Integer.valueOf(stringWeight);

            //u to v
            if (!graph.containsKey(u)) {
                List<Edge> edges = new ArrayList<>();
                Edge edge = new Edge(v, weight);
                edges.add(edge);
                graph.put(u, edges);
            } else {
                List<Edge> edges = graph.get(u);
                //check to see if the edge was already defined
                Edge edge = new Edge(v, weight);
//                if (alreadyDefined(edges, edge)) {
//                    System.out.println("E2");
//                    System.exit(1);
//                }
                edges.add(edge);
                graph.put(u, edges);
            }

            //v to u
            if (!graph.containsKey(v)) {
                List<Edge> edges = new ArrayList<>();
                Edge edge = new Edge(u, weight);
                edges.add(edge);
                graph.put(v, edges);
            } else {
                List<Edge> edges = graph.get(v);
                Edge edge = new Edge(u, weight);
//                if (alreadyDefined(edges, edge)) {
//                    System.out.println("E2");
//                    System.exit(1);
//                }
                edges.add(edge);
                graph.put(v, edges);
            }
        }

        String lastLine = scanner.nextLine();
        String source = lastLine.substring(0,1);
        String dest = lastLine.substring(3,4);
        int max = Integer.valueOf(lastLine.substring(5));

        //initialize data structure to keep track of distances
        HashMap<String, Integer> distance = new HashMap<>();
        for (String key : graph.keySet()) {
            distance.put(key, Integer.MAX_VALUE);
        }
        distance.put(source, 0);

        //initialize our visited set
        Set<String> visited = new HashSet<>();

        //initialize our pq
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        Pair p = new Pair(source, 0);
        pq.add(p);

        //initialize our path
        HashMap<String, String> path = new HashMap<>();


        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            visited.add(pair.node);
            List<Edge> neighbors = graph.get(pair.node);
            for (Edge neighbor : neighbors) {
                if (visited.contains(neighbor.dest)) {
                    continue;
                }
                int d = neighbor.weight;
                String n = neighbor.dest;
                int newDist = d + distance.get(pair.node);
                if (distance.get(n) > newDist) {
                    distance.put(n,newDist);
                    pq.add(new Pair(n, newDist));
                    String parent = pair.node;
                    String child = n;
                    path.put(child, parent);
                }
            }
        }

        int min = distance.get(dest);

        List<String> finalPath = new ArrayList<>();
        String start = dest;
        while (start != source) {
            finalPath.add(start);
            start = path.get(start);
        }
        finalPath.add(start);
        reverse(finalPath);

        for (int i = 0; i < finalPath.size() - 1; i++) {
            answer = answer + finalPath.get(i) + "->";
        }
        answer = answer + finalPath.get(finalPath.size() - 1);

        System.out.println(answer);

    }

    private static boolean alreadyDefined(List<Edge> edges, Edge edge) {
        for (Edge e : edges) {
            if (e.dest == edge.dest) {
                return true;
            }
        }

        return false;
    }

    public static class Edge{
        String dest;
        int weight;

        public Edge(String dest, int weight) {
            this.dest = dest;
            this.weight =weight;
        }
    }

    public static class Pair implements Comparable<Pair>{

        String node;
        int dist;

        public Pair(String node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair p) {
            if (this.dist > p.dist) {
                return 1;
            } else if (this.dist < p.dist) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
