package Graph;

import java.util.*;

public class Graph_Medium_207_CourseSchedule {
    public static void main (String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        //here 0 is a prerequisite of 1

        boolean answer = canFinish(numCourses, prerequisites);
        System.out.println(answer);
    }

    private static boolean canFinish(int numCourses, int[][] prerequisites) {

        //idea
        //This is a directed acyclic graph problem DAG
        //just need to determine if the graph has a cycle
            //if a cycle exists-> false
            //else true
        //we can use kahn's algorithm

        //base case
        if (prerequisites.length == 0) {
            return true;
        }

        //we will make an ajacency list for our graph
        HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        //put all the edges in our ajacency list
        //key will be prerequisite
        //0 is prerequisite
        //1 is value
        //
        for (int j = 0; j < prerequisites.length; j++) {
            int[] array = prerequisites[j];
            int key = array[1];
            graph.get(key).add(array[0]);
        }

        //calculate in-degree for each vertex in the graph
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            int length = graph.get(i).size();
            for (int j = 0; j < length; j++) {
                int toIncrement = graph.get(i).get(j);
                inDegree[toIncrement]++;
            }
        }

        int visitedNodes = 0;

        //create a queue for verticies with in-degree 0
        Queue<Integer> q = new ArrayDeque<>();

        //fill the queue
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        //check to see if we have at least 1 vertex with in degree 0
        //all DAGS have at least one vertex with in degree = 0
        //and at least one vertex with out degree = 0
        if (q.size() == 0) {
            return false;
        }

        while(!q.isEmpty()) {
            //remove a node from the queue
            int curr = q.poll();
            //increment the count of visited nodes
            visitedNodes++;
            //decrease in-degree by 1 for all it's neighbors
            for (Integer node : graph.get(curr)) {
                inDegree[node]--;
                //if in-degree of neighboring nodes is reduced to 0 add it to the queue
                if (inDegree[node] == 0) {
                    q.add(node);
                }
            }


        }

        //if count of visited nodes is NOT equal to the number of nodes in the graph
        if (visitedNodes != numCourses) {
            //then the topological sort is not possible
            return false;
        }

        return true;
    }
}
