package GoogleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Round1AProblem2 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\GoogleCodeJam\\testing.txt");

        Scanner scanner = new Scanner(file);

//        Scanner scanner = new Scanner(System.in);

        int numberOfTestCases = Integer.parseInt(scanner.nextLine());

        int caseNumber = 1;

        for (int i = 0; i < numberOfTestCases; i++) {
            int numberOfIntegers = Integer.parseInt(scanner.nextLine());

            //make a list of integers
            int[] array = new int[numberOfIntegers];
            for (int j = 0; j < numberOfIntegers; j++) {
                array[j] = j+1;
            }

            int integer = 1;
            //print your answer except l last integer
            for (int m = 0; m < numberOfIntegers -1; m++) {
                System.out.print(integer + " ");
                integer++;
            }
            //print the last integer in your list
            System.out.println(integer);

            //read the next line
            String nextLine = scanner.nextLine();
            String[] nextLineArray = nextLine.split("\\s+");

            //convert them to numbers
            int[] input = new int[numberOfIntegers];
            for (int j = 0; j < numberOfIntegers; j++) {
                input[j] = Integer.parseInt(nextLineArray[j]);
            }

            int[] answer = findFirstHalf(array, input, numberOfIntegers);
            System.out.println("test");

        }
    }

    private static int[] findFirstHalf(int[] array, int[] input, int numberOfIntegers) {

        int[] answer = new int[array.length];

        //base case check
        if ( array.length == 1) {
            answer[0] = array[0];
            return answer;
        }

        int target = 0;
        for (int i = 0; i < numberOfIntegers; i++) {
            target = target + array[i] + input[i];
        }
        target = target/2;

        //create a list of both arrays
        List<Integer> listOfAllNums = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            listOfAllNums.add(i, array[i]);
            listOfAllNums.add(i + 1, input[i]);
        }

        Collections.sort(listOfAllNums);

//        //create a boolean array
//        boolean[][] dp = new boolean[numberOfIntegers + 1][ target + 1];
//
//        //initialize the array
//        for (int i = 0; i <= numberOfIntegers) {
//            dp[i][0] = true;
//        }
//        for (int i = 0; i <=target; i++) {
//            dp[0][i] = false;
//        }
//
//        //do our dynammic programming
//        for (int i = 1; i <= numberOfIntegers; i++) {
//            for (int j = 1; j <=target; j++) {
//
//            }
//        }

        //pick the largest integer in the array
        int n = listOfAllNums.get(listOfAllNums.size()-1);
        listOfAllNums.remove(listOfAllNums.size() - 1);

        return answer;

    }
}
