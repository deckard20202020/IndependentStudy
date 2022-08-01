package Optiver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Question2 {
    public static void main(String[] args) throws Exception {

        //Question 1 was difference between dates

        //Before your interview review how you check for duplicate pairs
        //E1 Invalid Type Format
        //E2 Duplicate Pair
        //E3 Parent Has More than Two Children
        //E4 Multiple Roots
        //E5 Input Contains Cycle

        //Notes:
        //I was a bit confused by the errors.  In order to make sure the graph is a valid binary tree, the code as written
        //performs two separate DFS's.  One DFS to see if the graph is connected and another DFS to make sure there are no cycles.
        //This might be able to be combined into a single DFS in a single method.
        //Merging the two DFS's into a single DFS would improve runtime.
        //I left it as is in order to be on the safe side.

        //we want to print lexigraphically, "smaller" child should print first


        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\Optiver\\Question2.txt");
        Scanner scanner = new Scanner(file);

//        Scanner scanner = new Scanner(System.in);

        //read our input
        String input = scanner.nextLine();
        //separate our nodes
        String[] inputArray = input.split(" ");

        //validate our input
        boolean validated = false;
        try {
            validated = validateInput(input);
        } catch (Exception e) {
//            System.out.println(e);
            System.out.println("E1");
        }

        if (validated) {
            //create our graph
            HashMap<String, List<String>> graph = new HashMap<>();
            boolean isGraph = true;
            try {
                graph = createGraph(inputArray);
            } catch (Exception e) {
//                System.out.println(e);
                isGraph = false;
                System.out.println("E3");
            }

            if (isGraph) {
                //find the head of our graph
                Set<String> nodes = graph.keySet();
                String head = "";
                boolean hasProperRoot = true;
                try {
                    head = findHead(inputArray);
                } catch (Exception e) {
//                System.out.println(e);
                    System.out.println("E4");
                    hasProperRoot = false;
                }

                if (hasProperRoot) {
                    //Validate our graph is a binary tree
                    //Don't need to make sure it is a binary search tree
                    //check connected
                    //is this our valid input check?
                    boolean isConnect = false;
                    try {
                        isConnect = isConnected(head, graph);
                    } catch (Exception e) {
//                      System.out.println(e);
                        System.out.println("E1");
                    }


                    //check for cycles
                    boolean noCycles = false;
                    try {
                        noCycles = hasNoCycles(head, graph);
                    } catch (Exception e) {
//                      System.out.println(e);
                        System.out.println("E5");
                    }


                    //print out our graph
                    String output = "";
                    Set<String> visited = new HashSet<>();
                    if (isConnect && noCycles) {
                        output = printGraph(head, graph, output, visited);
                        //String output = printGraph(head, graph,);
                        System.out.println(output);
                    }
                }


            }
        }

    }

    //validate our input data
    private static boolean validateInput(String inputArray) throws Exception {

        Exception e = new Exception("E1");

        //add an additional space on the end for the last condition on the last iteration
        inputArray = inputArray + " ";

        for (int i = 0; i < inputArray.length(); i+=6) {
            if (!inputArray.substring(i, i + 1).equals("(") ||
                    !isCapitalLetter(inputArray.substring(i + 1, i + 2)) ||
                    !inputArray.substring(i + 2, i + 3).equals(",") ||
                    !isCapitalLetter(inputArray.substring(i + 3, i + 4)) ||
                    !inputArray.substring(i + 4, i + 5).equals(")") ||
                    !inputArray.substring(i + 5, i + 6).equals(" ")) {
                throw e;
            }
        }

        return true;
    }

    //used for checking if entry is capital letter
    private static boolean isCapitalLetter(String substring) {
        return substring.matches("[A-Z]");
    }

    //this dfs we will do recursively
    //easier to print
    private static String printGraph(String head, HashMap<String, List<String>> graph, String result, Set<String> visited) {

        visited.add(head);
        result = result + "(" + head;
        List<String> neighbors = graph.get(head);
        //sort the neighbors properly
        if (neighbors.size() > 1){
            java.util.Collections.sort(neighbors);
        }
        for (String neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                result = printGraph(neighbor,graph,result, visited);
            }
        }

        //add the last ")"
        result = result + ")";
        return result;

    }

    private static boolean hasNoCycles(String head, HashMap<String, List<String>> graph) throws Exception {

        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();

        stack.add(head);

        while(!stack.isEmpty()) {
            String n = stack.pop();
            if (visited.contains(n)) {
                Exception e = new Exception("E5");
                throw e;
            }
            visited.add(n);
            List<String> neighbors = graph.get(n);
            for (String neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    stack.add(neighbor);
                }
            }
        }

        return true;
    }

    //checks to see if the graph is connected
    private static boolean isConnected(String head, HashMap<String, List<String>> graph) throws Exception {

        int count = 0;

        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();

        for (String node : graph.keySet()) {
            if (!visited.contains(node)) {
                stack.add(node);
                count++;

                if (count > 1) {
                    Exception e = new Exception("E1");
                    throw e;
                }

                while(!stack.isEmpty()) {
                    String n = stack.pop();
                    visited.add(n);
                    List<String> neighbors = graph.get(n);
                    for (String neighbor : neighbors) {
                        if (!visited.contains(neighbor)) {
                            stack.add(neighbor);
                        }
                    }
                }

            }

        }

        return true;
    }

    //finds the head of the binary tree
    private static String findHead(String[] inputArray) throws Exception {

        //idea
        //make two sets, one set all the parents, the other set all the children from the input
        //remove all the children from the parents.  Whatever is left is the head
        //if there is more than one element in the remaining set
            //we have more than one root-throw an error

        Set<String> parents = new HashSet<>();
        Set<String> children = new HashSet<>();

        for (int i = 0; i < inputArray.length; i++) {
            parents.add(inputArray[i].substring(1,2));
            children.add(inputArray[i].substring(3,4));

        }

        for (String node : children) {
            parents.remove(node);
        }

        Exception e = new Exception("E4");
        if (parents.size() > 1) {
            throw e;
        }
        String[] headArray = parents.toArray(new String[0]);

        return headArray[0];
    }

      private static HashMap<String, List<String>> createGraph (String[] inputArray) throws Exception {

        //I also need to check for duplicate pairs
        HashMap<String, List<String>> graph = new HashMap<>();

        for (int i = 0; i < inputArray.length; i++) {

            String node1 = inputArray[i].substring(1,2);
            String node2 = inputArray[i].substring(3,4);

            //add node1 to node 2 edge
            if (graph.containsKey(node1)) {
                //check to see if we have too many children
                if (graph.get(node1).size() > 1) {
                    Exception e = new Exception("E3");
                    throw e;
                } else {
                    //put the edge in the graph
                    List<String> edges = graph.get(node1);
                    edges.add(node2);
                }
            } else {
                List<String> edges = new ArrayList<>();
                edges.add(node2);
                graph.put(node1, edges);
            }
            //add node2 to node 1 edge
            if (graph.containsKey(node2)) {
                //check to see if we have too many children
                if (graph.get(node1).size() > 1) {
                    Exception e = new Exception("E3");
                    throw e;
                } else {
                    //put the edge in the graph
                    List<String> edges = graph.get(node2);
                    edges.add(node1);
                }
            } else {
                List<String> edges = new ArrayList<>();
                edges.add(node1);
                graph.put(node2, edges);
            }
        }

        return graph;
    }

}
