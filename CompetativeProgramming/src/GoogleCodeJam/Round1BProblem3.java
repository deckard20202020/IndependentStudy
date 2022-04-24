package GoogleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Round1BProblem3 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\GoogleCodeJam\\testing.txt");

        Scanner scanner = new Scanner(file);

//        Scanner scanner = new Scanner(System.in);

        int numberOfTestCases = Integer.parseInt(scanner.nextLine());

        int caseNumber = 1;

        for (int i = 0; i < numberOfTestCases; i++) {

            String nextLine = scanner.nextLine();
            String[] numbers = nextLine.split("\\s+");

            System.out.println("Case #" + caseNumber + ":");
            caseNumber++;

        }
    }
}
