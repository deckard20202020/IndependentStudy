package GoogleKickStart;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RoundFProblem2 {
    public static void main(String[] args) throws FileNotFoundException {

        //not complete
        //Timed out on first try
        //wrong answers on test cases for second try

        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\GoogleKickStart\\testing.txt");

        Scanner scanner = new Scanner(file);
//        Scanner scanner = new Scanner(System.in);

        int numOfTestCases = Integer.valueOf(scanner.nextLine());

        //should be able to just look at the total amount of water
        //put into the system and size of the system

        int caseNumber = 1;
        for (int i = 0; i < numOfTestCases; i++) {
            double counter = 0;

            String line1 = scanner.nextLine();
            String[] line1arr = line1.split("\\s+");
            int numContainers = Integer.valueOf(line1arr[0]);
            int numQueries = Integer.valueOf(line1arr[1]);

            for (int j = 0; j < numContainers - 1; j++) {
                String line2 = scanner.nextLine();
            }

            //read more
            for (int q = 0; q < numQueries; q++) {
                int c = Integer.valueOf(scanner.nextLine());
            }

            //
//            if (numQueries >= numContainers) {
//                counter = numContainers;
//            } else {
//                int numberOfLevels = (int)(Math.log(numContainers) / Math.log(2)) + 1;
//                int test = 3;
//                int tmp = numContainers;
////                for (int j = 0; j < numberOfLevels; j++) {
////
////                }
//                int j = 0;
//                double totalContSoFar = 0;
//                double countAtLevel = Math.pow(2, j);
//                totalContSoFar = totalContSoFar + countAtLevel;
//                while (totalContSoFar < numContainers ) {
//                    j++;
//                    countAtLevel = Math.pow(2, j);
//
//                }
//                int temp = Math.pow(2, i);
//                counter = numberOfLevels;
//            }

            if (numQueries >= numContainers) {
                counter = numContainers;
            } else {
                int numberOfLevels = (int)(Math.log(numContainers) / Math.log(2)) + 1;
                for (int l = 0; l < numberOfLevels; l++) {
                    double numberContAtThisLevel = Math.pow(2, l);
                    numQueries = numQueries - (int) numberContAtThisLevel;
                    if (numQueries > 0) {
                        counter = counter + numberContAtThisLevel;
                    }

//                    counter = counter + temp;
                }
            }


            System.out.println("Case #" + caseNumber + ": " + (int) counter);
            caseNumber++;
        }

//        for (int i = 0; i < numOfTestCases; i++) {
//            String line1 = scanner.nextLine();
//            String[] line1arr = line1.split("\\s+");
//            int numContainers = Integer.valueOf(line1arr[0]);
//            int numQueries = Integer.valueOf(line1arr[1]);
//
//            //create our graph
//            //nodes mapped to list of children
//            HashMap<Node, Set<Integer>> graph = new HashMap<>();
//            Node head = new Node(Integer.MAX_VALUE);
//
//            //create the containers
//            for (int m = 1; m <= numContainers; m++) {
//                Node node = new Node(m);
//                Set<Integer> list = new HashSet<>();
//                graph.put(node, list);
//                if (m == 1) {
//                    head = node;
//                }
//            }
//
//            //connect the containers
//            for (int j = 0; j < numContainers - 1; j++) {
//                String line2 = scanner.nextLine();
//                String[] line2arr = line2.split("\\s++");
//                int parent = Integer.valueOf(line2arr[0]);
//                int child = Integer.valueOf(line2arr[1]);
//                for (Node n : graph.keySet()) {
//                    if (n.name == parent) {
//                        Set<Integer> set = graph.get(parent);
//                        if (set == null) {
//                            Set<Integer> nset = new HashSet<>();
//                            nset.add(child);
//                            graph.put(n, nset);
//                        } else {
//                            set.add(child);
//                            graph.put(n, set);
//                        }
//
//                    }
//                }
//            }
//
//            //add the water
//            for (int q = 0; q < numQueries; q++) {
//                int c = Integer.valueOf(scanner.nextLine());
//                for (Node n : graph.keySet()) {
//                    if (n.name == c) {
//                        addWater(graph, head, 1);
//                    }
//                }
//            }
//
//            int counter = 0;
//            //check which containers are full
//            for (Node n : graph.keySet()) {
//                if (n.level >= 1) {
//                    counter++;
//                }
//            }
//
//            System.out.println("Case #" + caseNumber + ": " + counter);
//            caseNumber++;
//        }

    }

    private static void addWater(HashMap<Node, Set<Integer>> graph, Node head, double amount) {
        //check to see if the head is full
        if (head.level == 0) {
            head.level = amount;
            if (head.level >= 1) {
                head.full = true;
            }
        } else if ( head.level <= 1) {
            amount = amount - (1 - head.level);
            head.level = 1;
            head.full = true;
            Set<Integer> neighbors = graph.get(head);
            for (Integer i : neighbors){
                for (Node n : graph.keySet()) {
                    if (n.name == i) {
                        addWater(graph, n, amount/2);
                    }
                }
            }

        }


    }


    private static class Node {
        int name;
        double level;
        boolean full;

        public Node(int name) {
            this.name = name;
            this.level = 0;
            this.full = false;
        }


    }
}
