//package CSES;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IntroProblems_WeirdAlgorithm {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\CSES\\test.txt");

        Scanner scanner = new Scanner(file);

        String nString = scanner.nextLine();

        int n = Integer.valueOf(nString);

        List<Integer> answer = findPath(n);

        for (Integer num : answer) {
            System.out.print(num + " ");
        }
    }

    private static List<Integer> findPath(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(n);

        while (n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
                list.add(n);
            } else {
                n = (n * 3) + 1;
                list.add(n);
            }
        }

        return list;
    }
}
