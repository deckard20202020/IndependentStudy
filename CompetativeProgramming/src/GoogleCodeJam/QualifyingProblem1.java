package GoogleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QualifyingProblem1 {
    public static void main(String[] args) throws FileNotFoundException {

//        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\GoogleCodeJam\\testing.txt");
//
//        Scanner scanner = new Scanner(file);

        Scanner scanner = new Scanner(System.in);

        int numberOfTestCases = Integer.parseInt(scanner.nextLine());

        int caseNumber = 1;

        for (int i = 0; i < numberOfTestCases; i++) {

            System.out.println("Case #" + caseNumber + ":");
            caseNumber++;

            String nextLine = scanner.nextLine();
            String[] numbers = nextLine.split("\\s+");

            int numRows = Integer.parseInt(numbers[0]);
            int numCol = Integer.parseInt(numbers[1]);

            int numMatrixRow = numRows * 2 + 1;
            int numMatrixCol = numCol * 2 + 1;

            String s = "";

            for (int row = 0; row < numMatrixRow; row++) {
                for (int col = 0; col < numMatrixCol; col++) {

                    //cases
                    if (row == 0 && col == 0 ||
                            row == 1 && col == 1 ||
                        row == 0 && col == 1 ||
                        row == 1 && col == 0) {
                        //top corner
                        s = ".";
                    } else if (row%2 == 0 && col%2 == 0) {
                        //even row even col
                        s = "+";
                    }  else if (row%2 == 0 && col%2 != 2) {
                        //even row odd col
                        s = "-";
                    } else if (row%2 != 0 && col%2 == 0) {
                        //odd row even col
                        s = "|";
                    } else if (row%2 != 0 && col%2 != 0) {
                        //odd row odd col
                        s = ".";
                    }

                    System.out.print(s);
                }
                System.out.println();
            }

        }
    }
}
