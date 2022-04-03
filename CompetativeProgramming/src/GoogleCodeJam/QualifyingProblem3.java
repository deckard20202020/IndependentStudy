package GoogleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class QualifyingProblem3 {
    public static void main(String[] args) throws FileNotFoundException {

//        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\GoogleCodeJam\\testing.txt");
//
//        Scanner scanner = new Scanner(file);

        Scanner scanner = new Scanner(System.in);

        int numberOfTestCases = Integer.parseInt(scanner.nextLine());
        int caseNumber = 1;

        for (int i = 0; i < numberOfTestCases; i++) {

            int numOfDice = Integer.parseInt(scanner.nextLine());

            String nextLine = scanner.nextLine();
            String[] dv = nextLine.split("\\s+");

//            //array of all the dicevalues
//            int[] diceValues = new int[dv.length];
//            for (int j = 0; j < dv.length; j++) {
//                diceValues[i] = Integer.parseInt(dv[i]);
//            }

            //put the dicevalues in a pq
            PriorityQueue<Integer> dicevalues = new PriorityQueue<>();
            for (int j = 0; j < dv.length; j++) {
                dicevalues.add(Integer.parseInt(dv[j]));
            }

            int strightValue = 1;
            while (!dicevalues.isEmpty()) {
                int value = dicevalues.poll();
                if (strightValue <= value) {
                    strightValue++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + (strightValue - 1));
            caseNumber++;
        }

    }

}
