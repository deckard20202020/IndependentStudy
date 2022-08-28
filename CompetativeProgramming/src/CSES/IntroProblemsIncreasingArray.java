//package CSES;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IntroProblemsIncreasingArray {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\CSES\\test.txt");
        //Scanner scanner = new Scanner(file);
        Scanner scanner = new Scanner(System.in);

        int length = Integer.valueOf(scanner.nextLine());
        String[] a = scanner.nextLine().split("\\s+");
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.valueOf(a[i]);
        }

        int counter = 0;

        for (int i = 1; i < length; i++) {
            while (arr[i] < arr[i - 1]) {
                arr[i]++;
                counter++;
            }
        }

        System.out.println(counter);
    }
}
