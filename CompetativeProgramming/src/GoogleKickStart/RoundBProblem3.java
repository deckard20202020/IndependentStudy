package GoogleKickStart;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class RoundBProblem3 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\GoogleKickStart\\testing.txt");

        Scanner scanner = new Scanner(file);

//        Scanner scanner = new Scanner(System.in);

        int numberOfTestCases = Integer.parseInt(scanner.nextLine());

        int caseNumber = 1;


        for (int i = 0; i < numberOfTestCases; i++) {
            int count = 0;

            String dialsAndValues = scanner.nextLine();
            String[] dv = dialsAndValues.split("\\s+");
            int numDials = Integer.parseInt(dv[0]);
            int values = Integer.parseInt(dv[1]);


            String nextLine = scanner.nextLine();
            String[] n = nextLine.split("\\s+");

            int[] numbers = new int[n.length];
            for (int j = 0; j < numbers.length; j++) {
                numbers[j] = Integer.parseInt(n[j]);
            }

            //will only work for test cases 1
//            int answer = numberOfIslands(numbers);

            int answer = testCase2Solution(numbers);


            System.out.println("Case #" + caseNumber + ": " + answer);
            caseNumber++;

        }
    }

    private static int testCase2Solution(int[] numbers) {
        int count = 0;

        while (!isAllZeros(numbers)) {
            int[] sif0 = smallestIslandFarthestFrom0(numbers);
            if (sif0[0] <=5) {
                for (int i = sif0[0]; i <=sif0[1]; i++) {
                    numbers[i]--;
                }
                count++;
            } else {
                for (int i = sif0[0]; i <=sif0[1]; i++) {
                    numbers[i]++;
                }
                count++;

            }
        }

        return count;
    }

    private static int[] smallestIslandFarthestFrom0(int[] numbers) {
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = numbers.length-1;
        for (int i = 0; i< numbers.length; i++) {
            int start = i;
            int end;
            int difference = 9;
            for (int j = i; j < numbers.length; j++) {
                if(numbers[i] == numbers[j]) {
                    continue;
                } else {
                    end = j;
                    i=j-1;
                }
                int lengthOfSegment = end - start;
                int difFromNeigh = differenceFromNeighbor(numbers, start, end);

                if( lengthOfSegment < answer[1]-answer[0] ||
                    difFromNeigh < difference) {
                    difference = difFromNeigh;
                    answer[0] = start;
                    answer[1] = end;
                }

            }

        }

        return answer;
    }

    private static int differenceFromNeighbor(int[] numbers, int start, int end) {
        if (start > 0) {
            return Math.abs(numbers[start] - numbers[start-1]);
        } else if(end < numbers.length-2){
            return Math.abs(numbers[end] - numbers[end+1]);
        }
        return 0;
    }

    private static boolean isAllZeros(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] !=0) {
                return false;
            }
        }

        return true;
    }

    private static int numberOfIslands(int[] numbers) {
        int count = 0;
        boolean onOne = false;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 && !onOne) {
                onOne = true;
                count++;
            } else if( numbers[i] == 1 && onOne) {
                continue;
            } else if(numbers[i] == 0) {
                onOne = false;
            }
        }

        return count;
    }
}
