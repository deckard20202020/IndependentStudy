package GoogleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class Round1BProblem1 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\GoogleCodeJam\\testing.txt");

        Scanner scanner = new Scanner(file);

//        Scanner scanner = new Scanner(System.in);

        int numberOfTestCases = Integer.parseInt(scanner.nextLine());

        int caseNumber = 1;

        for (int i = 0; i < numberOfTestCases; i++) {

            String nextLine = scanner.nextLine();
            int numberOfPancakes = Integer.parseInt(nextLine);

            nextLine = scanner.nextLine();
            String[] pancakeValues = nextLine.split("\\s+");
            ArrayList<Integer> values = new ArrayList<>();
            for(int j = 0; j < pancakeValues.length; j++) {
                values.add(Integer.parseInt(pancakeValues[j]));
            }

            int answer = numberOfPayingCustomers(numberOfPancakes, values);

            System.out.println("Case #" + caseNumber + ": " + answer);
            caseNumber++;



        }
    }

    private static int numberOfPayingCustomers(int numberOfPancakes, ArrayList<Integer> values) {

        int count = 0;

        int left = 0;
        int right = 0;
        int min = 0;

        while(!values.isEmpty()) {
            left = values.get(0);
            right = values.get(values.size()-1);
            if (left <= right) {
                if ( left >= min) {
                    min = left;
                    count++;
                }
                values.remove(0);
            } else {
                if ( right >= min) {
                    min = right;
                    count++;
                }
                values.remove(values.size()-1);
            }

        }

        return count;
    }
}
