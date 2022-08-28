//package CSES;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class IntroProblemsMissingNumber {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\CSES\\test.txt");

        Scanner scanner = new Scanner(file);
        //Scanner scanner = new Scanner(System.in);

        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();

        int n = Integer.valueOf(line1);
        String[] arr = line2.split("\\s+");

        Set<Integer> set = new HashSet<>();
        for (String s : arr) {
            int num = Integer.valueOf(s);
            set.add(num);
        }

        for (int i = 1; i <=n; i++) {
            if (!set.contains(i)) {
                System.out.println(i);
            }
        }

    }
}
