package GoogleKickStart;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RoundBProblem1 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\GoogleKickStart\\testing.txt");

        Scanner scanner = new Scanner(file);

//        Scanner scanner = new Scanner(System.in);

        int numberOfTestCases = Integer.parseInt(scanner.nextLine());

        int caseNumber = 1;

        for(int i = 0; i<numberOfTestCases; i++) {
            //read the first line
            String nextLine = scanner.nextLine();
            String[] numbers = nextLine.split("\\s+");

            int R = Integer.parseInt(numbers[0]);
            int A = Integer.parseInt(numbers[1]);
            int B = Integer.parseInt(numbers[2]);

            double answer = findAreaOfCircles(R,A,B);

            System.out.println("Case #" + caseNumber + ": " + answer);
            caseNumber++;
        }
    }

    private static double findAreaOfCircles(int r, int a, int b) {

        double area = 0;
        final double pi = 3.1415927;

        area = area + pi * Math.pow(r,2);

        int radius = r;
        while (radius > 0) {
            if ( radius > 0) {
                radius = radius*a;
                area = area + (pi * Math.pow(radius, 2));

            }
            radius = radius/b;

            if (radius > 0) {
                area = area + (pi * Math.pow(radius, 2));
            }
//            radius = radius * a;
        }

        return area;

    }
}
