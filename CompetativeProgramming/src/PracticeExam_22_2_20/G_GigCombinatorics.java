package PracticeExam_22_2_20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class G_GigCombinatorics {
    public static void main(String[]args) throws FileNotFoundException {

        //works for
//        9
//        1 1 1 2 2 2 3 3 3
//            correct answer = 63

//        //doesn't work for
//        8
//        1 2 1 2 3 1 2 3
//            correct answer 15-not sure why
//        Tóti also wants to play the songs in the same order he wrote them.
//        Given the hype rating of each of Tóti’s songs in the order he wrote them, how many setlists can he make?



                File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\PracticeExam_22_2_20\\test.txt");
        Scanner scanner = new Scanner((file));

//        Scanner scanner = new Scanner(System.in);

        // number input
//        Integer n = Integer.parseInt(scanner.nextLine());

        //String input
        String firstString = scanner.nextLine();
        String secondString = scanner.nextLine();

//        //split the strings
        String[] firstStringArr = firstString.split("\\s+");
        String[] secondStringArr = secondString.split("\\s+");

        int numOfSongs = Integer.parseInt(firstStringArr[0]);
        int numOfOnes = 0;
        int numOfTwos = 0;
        int numOfThrees = 0;

        for (int i = 0; i < secondStringArr.length; i++) {
            if (Integer.parseInt(secondStringArr[i]) == 1) {
                numOfOnes++;
            }
            if (Integer.parseInt(secondStringArr[i]) == 2) {
                numOfTwos++;
            }
            if (Integer.parseInt(secondStringArr[i]) == 3) {
                numOfThrees++;
            }
        }

        //our answer will be numones * numThrees * all the choose for numTwos
        int totalTwos = 0;
//        int totalTwosFact = factorial(totalTwos);
        for (int i = 1 ; i < numOfTwos; i++) {
            int n = factorial(numOfTwos);
            int m = factorial(i);
            int factOfTop = n-m;
            int k = i;
            int factOfBottom = factorial(k);
            totalTwos = totalTwos + (factOfTop/factOfBottom);
        }

        int answer = numOfOnes * numOfThrees * totalTwos;

        System.out.println(answer);

    }

    private static int factorial(int n) {
        int answer = 1;

        for (int i=1; i <= n; i++) {
            answer = answer * i;
        }

        return answer;
    }

}
