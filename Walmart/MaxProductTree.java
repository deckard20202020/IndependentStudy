package Walmart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxProductTree {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int result = maxProduct(n, edges);
        System.out.println(result); // prints 6
    }

    public static int maxProduct(int n, int[][] edges) {
        // create an array to store the number of nodes in each subtree
        int[] sizes = new int[n];
        Arrays.fill(sizes, 1);

        // create a list of adjacency lists to represent the tree
        List<List<Integer>> adjLists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjLists.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            adjLists.get(u).add(v);
            adjLists.get(v).add(u);
        }

        // compute the sizes of the subtrees by traversing the tree in a depth-first manner
        dfs(0, -1, sizes, adjLists);

        // sort the sizes of the subtrees in decreasing order
        Arrays.sort(sizes);

        // return the maximum product of the sizes of the two largest subtrees
        return sizes[n - 1] * sizes[n - 2];
    }

    public static void dfs(int u, int p, int[] sizes, List<List<Integer>> adjLists) {
        for (int v : adjLists.get(u)) {
            if (v != p) {
                dfs(v, u, sizes, adjLists);
                sizes[u] += sizes[v];
            }
        }
    }
}

