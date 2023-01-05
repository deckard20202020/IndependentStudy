//package Cisco;
//
//import java.util.*;
//
//public class MailRoomsForOfficeBuildings {
//    public static void main(String[] args) {
//
//        int numBuildings = 6;
//        int numEdges = 5;
//        int[] buildingX = {1,2,2,4,5};
//        int[] buildingY = {2,3,5,5,6};
////        int[] buildingX = {0,1,1,3,4};
////        int[] buildingY = {1,2,4,4,5};
//
//        int answer = numberOfMailRooms(numBuildings, numEdges, buildingX, buildingY);
//        System.out.println(answer);
//    }
//
//    #include <bits/stdc++.h>
//
//    using namespace std;
//
//    class Graph {
//
//        int V;
//
//        // Pointer to an array containing adjacency lists
//
//        list<int>* adj;

//        // A function used by DFS
//
//        void DFSUtil(int v, bool visited[]);
//
//        public:
//
//        Graph(int V);
//
//        void addEdge(int v, int w);
//
//        int NumberOfconnectedComponents();
//
//    };
//
//// Function to return the number of connected components in an undirected graph
//
//    int Graph::NumberOfconnectedComponents()
//
//    {
//
//        bool* visited = new bool[V];
//
//        int count = 0;
//
//        for (int v = 0; v < V; v++)
//
//            visited[v] = false;
//
//        for (int v = 0; v < V; v++) {
//
//            if (visited[v] == false) {
//
//                DFSUtil(v, visited);
//
//                count += 1;
//
//            }
//
//        }
//
//        return count;
//
//    }
//
//    void Graph::DFSUtil(int v, bool visited[])
//
//    {
//
//        visited[v] = true;
//
//
//
//        adjacent to this vertex
//
//        list<int>::iterator i;
//
//
//
//        for (i = adj[v].begin(); i != adj[v].end(); ++i)
//
//            if (!visited[*i])
//
//        DFSUtil(*i, visited);
//
//    }
//
//
//
//    Graph::Graph(int V)
//
//    {
//
//        this->V = V;
//
//        adj = new list<int>[V];
//
//    }
//
//
//
//// Add an undirected edge
//
//    void Graph::addEdge(int v, int w)
//
//    {
//
//        adj[v].push_back(w);
//
//        adj[w].push_back(v);
//
//    }
//    private static int numberOfMailRooms(int numBuildings, int numConnections, int[] buildingX, int[] buildingY) {
//
//        //for each connected component, we need to find the longest path,
//        //and sum them together
//        //for each longest path, we should get ciel(pathlength / 2)
//            //if longest path is even = pathLength / 2
//            //if path length is odd = (pathLength / 2) + 1
//
//        //create an ajacency list for the nodes
//        HashMap<Integer, List<Integer>> graph = makeGraph(numBuildings, buildingX, buildingY);
//
//
//        List<List<Integer>> longestPaths = longestPaths(graph);
//
//        int total = 0;
//
//        //scroll through the list of longest paths
//        for (List<Integer> path : longestPaths) {
//            int length = path.size();
//            if (length % 2 == 0) {
//                total = total + length / 2;
//            } else {
//                total = total + (length / 2) + 1;
//            }
//        }
//
//        return total;
//
//    }
//
//
//
//    private static HashMap<Integer, List<Integer>> makeGraph(int numBuildings, int[] buildingX, int[] buildingY) {
//
//        HashMap<Integer, List<Integer>> graph = new HashMap<>();
//        for (int i = 1; i <= numBuildings; i++) {
//            List<Integer> list = new ArrayList<>();
//            graph.put(i, list);
//        }
//
//        for (int i = 0; i < buildingX.length; i++) {
//            int leftNode = buildingX[i];
//
//            List<Integer> leftEdges = graph.get(leftNode);
//
//            int rightNode = buildingY[i];
//            leftEdges.add(rightNode);
//            graph.put(leftNode, leftEdges);
//
//
//            List<Integer> rightEdges = graph.get(rightNode);
//            rightEdges.add(leftNode);
//            graph.put(rightNode, rightEdges);
//
//        }
//
//        return graph;
//    }




//
//}
