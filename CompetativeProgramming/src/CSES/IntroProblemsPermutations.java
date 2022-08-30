//package CSES;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IntroProblemsPermutations {
    public static void main(String[] args) throws FileNotFoundException {

        //File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\CSES\\test.txt");

        //Scanner scanner = new Scanner(file);
        Scanner scanner = new Scanner(System.in);

        int n = Integer.valueOf(scanner.nextLine());

        List<Integer> list = new ArrayList<>();
        if (n == 0) {
            System.out.println();
        } else {
            list = findPermutation(n);
            if (list.size() == 0) {
                System.out.println("NO SOLUTION");
            } else {
                for (Integer num : list) {
                    System.out.print(num + " ");
                }
            }
        }
    }

    private static List<Integer> findPermutation(int n) {
        List<Integer> list = new ArrayList<>();

        if (n == 1) {
            list.add(1);
            return list;
        }
        if (n == 2 || n == 3) {
            return list;
        }

        //idea is to add the odd numbers to the right side
        //add even numbers to the left
        int o = 1;
        while (o <= n ) {
            list.add(o);
            o++;
            o++;
        }
        int e = 2;
        while (e <= n) {
            list.add(e);
            e++;
            e++;
        }


        return list;
    }
}
