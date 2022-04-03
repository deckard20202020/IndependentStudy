package InClassProblems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LightOJ1269 {
    public static void main(String[] args) throws FileNotFoundException {

        //I am solving the wrong problem here.
            //it would be a good interview question,
            //but it's not the question they are asking
        //Need to revisit the problem question
            //use exclusive or here
            //then use tree structure

        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\InClassProblems\\testing.txt");

        Scanner scanner = new Scanner(file);

//        Scanner scanner = new Scanner(System.in);

        int numberOfTestCases = Integer.parseInt(scanner.nextLine());

        int caseNumber = 1;

        for(int i = 0; i < numberOfTestCases; i++) {
            //read the length of the array and number of queries
            String nextLine = scanner.nextLine();
            String[] input = nextLine.split("\\s+");
            int[] numbers = new int[input.length];
            int lengthOfArray = Integer.parseInt(input[0]);

            //read the numbers in the array
            nextLine = scanner.nextLine();
            String[] input2 = nextLine.split("\\s+");
            int[] array = new int[input2.length];
            for (int j = 0; j < lengthOfArray; j++) {
                array[j] = Integer.parseInt(input2[j]);
            }

            int[] cumSum = cummulativeSum(array);

            //call our solution method
            int min = findMinSubset(cumSum);
            int max = findMaxSubset(cumSum);

            System.out.println("Case " + caseNumber + ": " + max + " " + min);
            caseNumber++;

        }

    }

    private static int[] cummulativeSum(int[] array) {
        int[] cumSum = new int[array.length];
        int sum = array[0];

        //initialize the array
        cumSum[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] >= array[i-1]) {
                sum = sum + array[i];
                cumSum[i] = sum;
            } else {
                sum = array[i];
                cumSum[i] = sum;
            }

        }

        return cumSum;
    }

    private static int findMaxSubset(int[] array) {

        int max = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    private static int findMinSubset(int[] array) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

}
