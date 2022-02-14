package PracticeExam_22_2_13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A_BicycleCodes {
    public static void main(String[]args) throws FileNotFoundException {

//        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\PracticeExam_22_2_13\\test.txt");
//        Scanner scanner = new Scanner((file));

        //sum of all numbers between 1 and n
        Scanner scanner = new Scanner(System.in);

        // number input
        Integer firstLockCombo = Integer.parseInt(scanner.nextLine());
        Integer secondLockCombo = Integer.parseInt(scanner.nextLine());
//        0001
//        0000
//        Integer firstLockCombo = 0002;
//        Integer secondLockCombo = 0001;

        //is number odd?
        Boolean isFirstOdd = isThisOdd(firstLockCombo);
        Boolean isSecondOdd = isThisOdd(secondLockCombo);

        if (!isFirstOdd || isSecondOdd){
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }

    private static Boolean isThisOdd(Integer firstLockCombo) {
        if (firstLockCombo%2 == 0) {
            return false;
        }
        return true;
    }
}
