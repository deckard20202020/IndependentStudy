package GoogleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class QualifyingProblem4 {
    public static void main(String[] args) throws FileNotFoundException {

        //ListNodes Will not work here.
        //is this dp or dykstras?

        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\GoogleCodeJam\\testing.txt");

        Scanner scanner = new Scanner(file);

//        Scanner scanner = new Scanner(System.in);

        int numberOfTestCases = Integer.parseInt(scanner.nextLine());
        int caseNumber = 1;

        for (int i = 0; i < numberOfTestCases; i++) {

            int numOfNodes = Integer.parseInt(scanner.nextLine());

            String nextLine = scanner.nextLine();
            String[] values = nextLine.split("\\s+");
            int[] nodeValues = new int[values.length];
            for (int j = 0; j < values.length; j++) {
                nodeValues[j] = Integer.parseInt(values[j]);
            }

            //create a head node
            ListNode abyss = new ListNode();

            //hashmap to store the nodes
            HashMap<Integer, Integer> nodeValuesAndPointers = new HashMap<>();

            //priority queue to store the pairs
            PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());

//            //read the line of pointers and put them in the hashmap with thier associated values.
//            String p = scanner.nextLine();
//            String [] point = p.split("\\s+");
//            for (int k = 0; k < point.length; k++) {
//                nodeValuesAndPointers.put(nodeValues[k], Integer.parseInt(point[k]));
//            }

            //read the line of pointers and put them in the hashmap with thier associated values.
            String p = scanner.nextLine();
            String [] point = p.split("\\s+");
            for (int k = 0; k < point.length; k++) {
                Pair pair = new Pair(nodeValues[k], Integer.parseInt(point[k]));
                pq.add(pair);
            }

            //empty the pq to create our ListNodes
            while (!pq.isEmpty()) {
                ListNode listNode = new ListNode(pq.peek().nodeValue, abyss);
                abyss = listNode;
            }



            System.out.println("test");
        }


    }

}

class Pair implements Comparable<Pair> {
    int nodeValue;
    int pointsTo;

    Pair(int nodeValue, int pointsTo) {
        this.nodeValue = nodeValue;
        this.pointsTo = pointsTo;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.pointsTo < o.pointsTo) {
            return 1;
        }else {
            return -1;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
