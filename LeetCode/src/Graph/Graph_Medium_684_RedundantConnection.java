package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Graph_Medium_684_RedundantConnection {
    public static void main(String[] args) {

        int[][] edges = {{1,2},{1,3},{2,3}};
        int[] answer = findRedundantConnection(edges);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + ", ");
        }
    }

    private static int[] findRedundantConnection(int[][] edges) {

        //this is an example of UnionFind Algorithm
        //O(n)

        //make a parent array
        //this will represent the parent of the node as we construct our tree
        //initially the parent will be itself
        int[] parent = new int[edges.length + 1];

        //make a rank array
        //this will represent the size of the graphs as we construct them
        //start with n graphs of size 1
        int[] rank = new int[edges.length + 1];

        //initialize our values
        for (int i = 0; i < edges.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            //we are guaranteed to have at lease one edge that makes a cycle
            if (!union(edge[0], edge[1], parent, rank)) {
                return edge;
            }
        }

        return new int[]  {0,1};

    }

    public static int find(int n, int[] parent) {
        int p = parent[n];

        while (p != parent[p]) {
            //This speeds up the operations
            parent[p] = parent[parent[p]];
            p = parent[p];
        }

        return p;
    }

    public static boolean union (int n1, int n2, int[] parent, int[] rank) {
        int p1 = find(n1, parent);
        int p2 = find(n2, parent);

        if (p1 == p2) {
            //we have found our cycle
            return false;
        }

        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] = rank[p1] + rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] = rank[p2] + rank[p1];
        }
        return true;
    }

}
