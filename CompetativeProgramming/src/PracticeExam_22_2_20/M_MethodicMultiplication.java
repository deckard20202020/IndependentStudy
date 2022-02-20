package PracticeExam_22_2_20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class M_MethodicMultiplication {

    public static void main(String[]args) throws FileNotFoundException {

    //Didn't fail any test
        //time limit exceeded
        //isn't this linear time?

//        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\PracticeExam_22_2_20\\test.txt");
//        Scanner scanner = new Scanner((file));

        Scanner scanner = new Scanner(System.in);

        // number input
//        Integer n = Integer.parseInt(scanner.nextLine());

        //String input
        String string1 = scanner.nextLine();
        String string2 = scanner.nextLine();

//        //split the strings
//        String[] strings = string.split("\\s+");
        int sInFirstString = 0;
        //count the number of "s" in string1
        for (int i = 0; i < string1.length(); i++) {
            if (string1.charAt(i) == 'S') {
                sInFirstString++;
            }
        }

        int sInSecondString = 0;
        //count the number of "s" in string2
        for (int i = 0; i < string2.length(); i++) {
            if (string2.charAt(i) == 'S') {
                sInSecondString++;
            }
        }

        String result = "";

        result = createAnswerString(sInFirstString, sInSecondString);

        System.out.println(result);

    }

    private static String createAnswerString(int sInFirstString, int sInSecondString) {
        String answer = "";

        if (sInFirstString == 0 || sInSecondString == 0) {
            return "0";
        }

        int totalS = (sInFirstString * sInSecondString);

        //add all the leading
        for (int i = 0; i < totalS; i++) {
            answer = answer + "S(";
        }

        //add the 0
        answer = answer + "0";

        //add all the last )
        for (int i = 0; i < totalS; i++) {
            answer = answer + ")";
        }

        return answer;
    }
}
