//package CSES;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IntroProblemsRepetitions {
    public static void main(String[] args) throws FileNotFoundException {

        //File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\CSES\\test.txt");

        //Scanner scanner = new Scanner(file);
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();

        char curr = string.charAt(0);
        int max = 0;
        int counter = 1;

        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) == curr) {
                counter++;
                max = Math.max(max, counter);
            } else {
                max = Math.max(max, counter);
                curr = string.charAt(i);
                counter = 1;
            }
        }

        System.out.println(max);
    }
}
