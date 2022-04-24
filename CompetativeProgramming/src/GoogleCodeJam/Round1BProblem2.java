package GoogleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Round1BProblem2 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\GoogleCodeJam\\testing.txt");

        Scanner scanner = new Scanner(file);

//        Scanner scanner = new Scanner(System.in);

        int numberOfTestCases = Integer.parseInt(scanner.nextLine());

        int caseNumber = 1;

        for (int i = 0; i < numberOfTestCases; i++) {

            String nextLine = scanner.nextLine();
            String[] numbers = nextLine.split("\\s+");

            int numOfCust = Integer.parseInt(numbers[0]);
            int numOfItems = Integer.parseInt(numbers[1]);

            int[][] balls = new int[numOfCust][numOfItems];

            for (int j = 0; j < numOfCust; j++) {
                nextLine = scanner.nextLine();
                String[] items = nextLine.split("\\s+");
                for(int k = 0; k < numOfItems; k++) {
                    balls[j][k] = Integer.parseInt(items[k]);
                }

            }

            long answer = findNumber(numOfCust, numOfItems, balls);

            System.out.println("Case #" + caseNumber + ":");
            caseNumber++;



        }
    }

    private static long findNumber(int numOfCust, int numOfItems, int[][] balls) {
        long count = 0;

        c



        return count;
    }


}
