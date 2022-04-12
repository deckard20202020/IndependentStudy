package ISU_CSE_Contest_2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\ISU_CSE_Contest_2022\\testing.txt");

        Scanner scanner = new Scanner(file);

//        Scanner scanner = new Scanner(System.in);

        int numberOfTestCases = Integer.parseInt(scanner.nextLine());

        //used for printing output-feel free to delete
        int caseNumber = 1;

        for (int i = 0; i < numberOfTestCases; i++) {

            //could be useful for lines of numbers
            //feel free to delete

            //String input
            String string = scanner.nextLine();
            //split them by spaces
            String[] arrayOfIntsAsStrings = string.split("\\s+");
            //convert them to an array of ints
            int[] numbers = new int[arrayOfIntsAsStrings.length];
            for (int j = 0; j < numbers.length; j++) {
                numbers[j] = Integer.parseInt(arrayOfIntsAsStrings[j]);
            }

            System.out.println(caseNumber);
            caseNumber++;

        }
    }
}
