package Graph;

import java.util.*;

public class Graph_Medium_133_CloneGraph {
    public static void main(String[] args) {

        //create node
        Node node = new Node(1);
        //add it's two neighbors
        node.neighbors.add(new Node(2));
        node.neighbors.add(new Node(4));
        //add neighbors of 2
        //1
        node.neighbors.get(0).neighbors.add(node);
        //4
        node.neighbors.get(0).neighbors.add(node.neighbors.get(1));
        //add neighbors of 4
        //1
        node.neighbors.get(1).neighbors.add(node);
        //3
        node.neighbors.get(1).neighbors.add(new Node(3));
        //add neighbors of 3
        //2
        node.neighbors.get(1).neighbors.get(1).neighbors.add(node.neighbors.get(0));
        //4
        node.neighbors.get(1).neighbors.get(1).neighbors.add(node.neighbors.get(1));

        Node answer = cloneGraph(node);
        System.out.println(node.val);


    }

    private static Node cloneGraph(Node node) {

        //there is a faster way to do this
        //see https://www.youtube.com/watch?v=mQeF6bN8hMk
        
        //idea
        //we will use a DFS to traverse the graph and make a copy
        //we will need a way to keep track of the visited nodes
            //nodes have unique values
            //number of nodes is <=100
            //we will make an array of size 101 where the index
            //of the array represents the node/value
        //graph is connected and no self loops

        //base case
        if (node == null) {
            return null;
        }

        //make a copy of the root
        Node copy = new Node(node.val);
        Node[] visited = new Node[101];
        Arrays.fill(visited, null);
        dfs(node, copy, visited);

        return copy;

    }

    private static void dfs(Node node, Node copy, Node[] visited) {

        //register the node as visited
        visited[node.val] = copy;

        //traverse the neighbors of the root node
        for(Node n : node.neighbors) {
            //check whether we have visited the node
            if(visited[n.val] == null) {
                //create a new node
                Node newNode = new Node(n.val);
                //add this node as a neighbor of the prev copied node
                copy.neighbors.add(newNode);
                // make dfs call on this unvisited node
                dfs(n, newNode, visited);
            } else {
                //we have already visited this node
                //so we don't need to make a copy
                //it is already in our visited array
                copy.neighbors.add(visited[n.val]);
            }
        }

    }

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
