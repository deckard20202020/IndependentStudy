package PracticeExam_22_5_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\PracticeExam_22_5_1\\tests.txt");
        Scanner scanner = new Scanner((file));
//
//        Scanner scanner = new Scanner(System.in);
//
        // number of test cases
        Integer numberOfTestCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfTestCases; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            System.out.println(n);

        }
    }
}
