package InClassProblems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LightOJ1277 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\InClassProblems\\testing.txt");

        Scanner scanner = new Scanner(file);

//        Scanner scanner = new Scanner(System.in);

        int numberOfTestCases = Integer.parseInt(scanner.nextLine());

        int caseNumber = 1;

        int lengthOfSubarray = 0;

        for(int i = 0; i < numberOfTestCases; i++) {
            //read the length of the array and number of queries
            String nextLine = scanner.nextLine();
            String[] input = nextLine.split("\\s+");
            int[] numbers = new int[input.length];
            int lengthOfArray = numbers[0];
            int numberOfQueries = numbers[1];

            //read the numbers in the array
            nextLine = scanner.nextLine();
            String[] input2 = nextLine.split("\\s+");
            int[] array = new int[input2.length];
            for (int j = 0; j < lengthOfArray; j++) {
                array[j] = Integer.parseInt(input2[j]);
            }

            //read the next three lines and find an answer
            for (int k = 0; k < numberOfQueries; k++) {
                nextLine = scanner.nextLine();
                lengthOfSubarray = Integer.parseInt(nextLine);

                //call our solution method
                int[] answer = findSubset(lengthOfArray, array, lengthOfSubarray);

            }
        }
    }

    private static int[] findSubset(int lengthOfArray, int[] array, int lengthOfSubarray) {

        int[] answer = new int[lengthOfSubarray];

        return answer;
    }
}
